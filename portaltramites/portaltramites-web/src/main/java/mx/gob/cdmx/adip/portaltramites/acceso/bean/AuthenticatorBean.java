package mx.gob.cdmx.adip.portaltramites.acceso.bean;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.gob.cdmx.adip.portaltramites.util.WebResources;
import mx.gob.cdmx.adip.portaltramites.client.OAuth2CdmxClient;
import mx.gob.cdmx.adip.portaltramites.common.infra.Environment;
import mx.gob.cdmx.adip.portaltramites.common.util.BeanUtils;
import mx.gob.cdmx.adip.portaltramites.oauth.dto.PersonaDTO;
import mx.gob.cdmx.adip.portaltramites.oauth.dto.RolesUsuarioDTO;
import mx.gob.cdmx.adip.portaltramites.commons.utils.Constantes;
import mx.gob.cdmx.adip.portaltramites.commons.utils.Utils;
import mx.gob.cdmx.adip.portaltramites.oauth.dto.RequestRolesDTO;
import mx.gob.cdmx.adip.portaltramites.oauth.dto.RequestTokenDTO;

/**
 * @autor Raúl Soto
 */
@Named
@SessionScoped
public class AuthenticatorBean implements Serializable {

	private static final long serialVersionUID = 6048100734819950909L;	
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticatorBean.class);
	
	private static final String PARAM_LISTLLAVE = "listllave";  
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
	private HttpServletRequest request;
	
	private String codeOauth;
	private String tokenOauth;
	private String stateOauth2 = Constantes.EMPTY_STRING;
	private PersonaDTO usuarioLogueado;
	private boolean rolAdministrador;
	private boolean ingresaDesdeLlave;

	public void inicializar() {
		usuarioLogueado =  new PersonaDTO();
		ingresaDesdeLlave = false;
	}
	/**
	 * Método inicial que construye la ULR con la que se solicitará a Llave el acceso
	 */
	public void redirectUrlLoginCDMX() {		
		StringBuilder urlLoginLlaveCDMx = new StringBuilder();
		stateOauth2 = Utils.randomChars().toString();
		try {
			urlLoginLlaveCDMx.append(Environment.getUrlLoginCdmx()).append("?")
				.append(Constantes.PARAM_CLIENT_ID).append("=").append(Environment.getAppId()).append("&")
				.append(Constantes.PARAM_REDIRECT_URL).append("=").append(URLEncoder.encode(Environment.getUrlRedirectLoginCdmx(), "UTF-8")).append("&")
				.append(Constantes.PARAM_STATE).append("=").append(stateOauth2).toString();
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("Ocurrio un error al realizar el encode de :", e);
		}
		try {
			facesContext.getExternalContext().redirect(urlLoginLlaveCDMx.toString());
		} catch (IOException e) {
			LOGGER.error("Ocurrio un error al generar el redirect al Login CDMX:", e);
		}
	}	
	
	public void revisaRespuestaLoginCdmx() {
		Map<String, String> params = facesContext.getExternalContext().getRequestParameterMap();
		if (!FacesContext.getCurrentInstance().isPostback() && params != null && !params.isEmpty()) {
				
			if (!validaRespuestaLoginCdmx()) {
				//usuarioLogueado = new PersonaDTO();
				WebResources.addValidationMessage("login.code_incorrecto", true);
				LOGGER.info("Code incorrecto:" + params.get(Constantes.PARAM_CODE));
				try {
					facesContext.getExternalContext().redirect(facesContext.getExternalContext().getRequestContextPath() + Constantes.RETURN_BACKOFFICE);
				} catch (IOException e) {
					LOGGER.error("Error al redireccionar al index.");
				}
			} else {
				try {
					codeOauth = params.get(Constantes.PARAM_CODE);
					tokenOauth = cambiaCodePorToken(codeOauth);
					LOGGER.debug("Token recibido de Llave CDMX:" + tokenOauth);
					if (tokenOauth != null && !codeOauth.isEmpty()) {
						usuarioLogueado = cambiarTokenPorDatosUsuario(tokenOauth);
						if(usuarioLogueado != null) {	
							ingresaDesdeLlave = false;
							rolAdministrador = false;
							obtenerRolesUsuario(usuarioLogueado.getIdPersona(), Long.parseLong(Environment.getAppId()), tokenOauth);
							crearSesionUsuario(tokenOauth);
							LOGGER.debug("Usuario recibido de Llave:" + usuarioLogueado.getNombre());
							LOGGER.debug("usuario id: " + usuarioLogueado.getIdPersona());
							if (rolAdministrador) {
								facesContext.getExternalContext().redirect(facesContext.getExternalContext().getRequestContextPath() + Constantes.RETURN_BACKOFFICE + Constantes.JSF_REDIRECT);
							}
							else {
								facesContext.getExternalContext().redirect(facesContext.getExternalContext().getRequestContextPath() + Constantes.RETURN_OFICINA_DIGITAL + Constantes.JSF_REDIRECT);
							}
						}
					} else {
						facesContext.getExternalContext().redirect(facesContext.getExternalContext().getRequestContextPath() + Constantes.RETURN_BACKOFFICE + Constantes.JSF_REDIRECT);
						WebResources.addValidationMessage("login.token_incorrecto", true);
					}					
				} catch (Exception e) {
					WebResources.addValidationMessage("msj_error_general_llavecdmx", false);
					LOGGER.error("Ocurrio un error al iniciar sesión: ", e);
				}
			}
		}
	}
	
	/**
	 * Método que obtiene un token mediante el code generado
	 * @param code
	 * @return
	 */
	private String cambiaCodePorToken(final String code) {
		RequestTokenDTO requestToken = new RequestTokenDTO();
		requestToken.setClientId(Environment.getAppId());
		requestToken.setClientSecret(Environment.getSecretKey());
		requestToken.setCode(code);
		requestToken.setGrantType(Constantes.GRANT_TYPE_AUTHORIZATION_CODE);
		requestToken.setRedirectUri(Environment.getUrlRedirectLoginCdmx());
		LOGGER.info("Request Token:"+requestToken);
		
		OAuth2CdmxClient oautCdmxClient = new OAuth2CdmxClient();
		String token = oautCdmxClient.obtenerToken(requestToken);
		return token;
	}
	
	/**
	 * Método que obtiene la información del usuario logueado para el 
	 * inicio de la sesión
	 * @param token
	 * @return
	 */
	private PersonaDTO cambiarTokenPorDatosUsuario(final String token) {
		String strToken = "";
		if(token != null) {
			try {
				JSONObject tokenObj = new JSONObject(token);
				strToken = tokenObj.get("accessToken").toString();
			} catch (JSONException e) {
				LOGGER.error("Error al crear el json del token");
			}
		}
		OAuth2CdmxClient oauthCdmxClient = new OAuth2CdmxClient();
		
		return oauthCdmxClient.obtenerDatosUsuarioPorToken(strToken);
	}

	private void obtenerRolesUsuario(long idPersona, long idSistema, String token) {
		String strToken = "";
		if(token != null) {
			try {
				JSONObject tokenObj = new JSONObject(token);
				strToken = tokenObj.get("accessToken").toString();
			} catch (JSONException e) {
				LOGGER.error("Error al crear el json del token");
			}
		}
		RequestRolesDTO requestRolesDTO =  new RequestRolesDTO(idPersona, idSistema);
		OAuth2CdmxClient oauthCdmxClient = new OAuth2CdmxClient();
		List<RolesUsuarioDTO> lstRolesUsuario = oauthCdmxClient.obtenerRolesUsuario(requestRolesDTO, strToken);
		if(BeanUtils.isNotNull(lstRolesUsuario)) {
			usuarioLogueado.setLstRoles(lstRolesUsuario);
			verificarRoles(lstRolesUsuario);
			LOGGER.debug("Roles: " + usuarioLogueado.getLstRoles().get(0).getRol());
		}
	}
	
	public void verificarRoles(List<RolesUsuarioDTO> lstRolesUsuario) {
		if(lstRolesUsuario != null) {
			for (RolesUsuarioDTO rolesUsuarioDTO : lstRolesUsuario) {
				LOGGER.info("ROL: " + rolesUsuarioDTO.getIdRol());
				if(rolesUsuarioDTO.getIdRol() == Constantes.ROL_ADMINISTRADOR || Environment.getAppProfile().compareTo("local") == 0 ) {
					rolAdministrador = true;
				}
			}
		}
	}

	
	/**
	 * Método que crea la sesión del usuario con la información recuperada de Llave CDMX
	 * @param token
	 */
	private void crearSesionUsuario(final String token) {	
		// Invalidar cualquier sesión que tenga el usuario.
//		HttpSession oldSession = request.getSession(false);
//		if (oldSession != null) {
//			LOGGER.debug("Invalidar sesión en caso de que exista...");
//			oldSession.invalidate();
//		}
		// Generar nueva sesión de usuario
		HttpSession newSession = request.getSession(true);
		newSession.setAttribute(Constantes.TOKEN_SESSION, token);
		// Guardar token en cookie para Single SignOn
		Cookie message = new Cookie("idCDMX", token);
		((javax.servlet.http.HttpServletResponse) facesContext.getExternalContext().getResponse()).addCookie(message);
	}
	
	/**
	 * Método que realiza el cierre del aplicativo.
	 * @return
	 */
	public String cerrarSesionUsuario() {		
		OAuth2CdmxClient clienteOAuth2Cdmx = new OAuth2CdmxClient();
		try {
			if(tokenOauth != null) {
				JSONObject tokenObj = new JSONObject(tokenOauth);
				String strToken = tokenObj.get("accessToken").toString();
				clienteOAuth2Cdmx.cerrarSesionConLlaveCDMX(strToken);
			}
		} catch (URISyntaxException | NoSuchAlgorithmException e) {
			LOGGER.warn("Problemas el servicio logout de Llave CDMX: ", e);
		} catch (JSONException e) {
			LOGGER.error("Error al crear el json del token");
		} 
		String respuesta = "";
		HttpSession cerrarSesion = request.getSession(false);
		cerrarSesion.invalidate();
		respuesta = Constantes.RETURN_HOME_PAGE + Constantes.JSF_REDIRECT;
		return respuesta;
	}

	/**
	 * Método que inicializa la vista del Home.
	 * @return
	 */
	public String incializarHome() {
		return Constantes.RETURN_HOME_PAGE + Constantes.JSF_REDIRECT;
	}
	
	private boolean validaRespuestaLoginCdmx() {
		boolean respuestaCorrecta = false;
		Map<String, String> params = facesContext.getExternalContext().getRequestParameterMap();
		if (params.get(Constantes.PARAM_STATE) == null
				|| params.get(Constantes.PARAM_STATE).compareTo(Constantes.EMPTY_STRING) == 0
				|| params.get(Constantes.PARAM_STATE).compareTo(stateOauth2) != 0) {
			WebResources.addValidationMessage("login.state_incorrecto", true);
		} else if (params.get(Constantes.PARAM_CODE) == null
				|| params.get(Constantes.PARAM_CODE).compareTo(Constantes.EMPTY_STRING) == 0) {
			WebResources.addValidationMessage("login.code_incorrecto", true);
		} else {
			respuestaCorrecta = true;
		}
		return respuestaCorrecta;
	}
	
	/**
	 * Método que se utiliza para validar si la URL de inicio cuenta con el parámetro 
	 * listllave, lo que identifica que viene redireccionado desde llave.
	 */
	public void revisaRedirectUrlInicio() {
		Map<String, String> params = facesContext.getExternalContext().getRequestParameterMap();
		if(!FacesContext.getCurrentInstance().isPostback() && params != null && !params.isEmpty()) {
			setIngresaDesdeLlave(false);
			if(usuarioLogueado == null) {
				usuarioLogueado = new PersonaDTO();
			}
			if(params.get(PARAM_LISTLLAVE) == null 
					|| params.get(PARAM_LISTLLAVE).trim().compareTo(Constantes.EMPTY_STRING) == 0) {
				setIngresaDesdeLlave(false);
			} else {
				if(params.get(PARAM_LISTLLAVE).compareToIgnoreCase("true") == 0 
						|| params.get(PARAM_LISTLLAVE).compareToIgnoreCase("false") == 0) {
					try {
						setIngresaDesdeLlave(Boolean.parseBoolean(params.get(PARAM_LISTLLAVE)));
					} catch (Exception e) {
						setIngresaDesdeLlave(false);
					}
				}
			}
		}
	}
	
	/**
	 * Método que se utiliza para que se pinte el meta de noindex.
	 * @return
	 */
	public String parametroMetaRobots() {
		return Environment.getAppProfile().compareTo("dev") == 0 ? "noindex" : "all";
	}
	
	/**
	 * @return the usuarioLogueado
	 */
	public PersonaDTO getUsuarioLogueado() {
		return usuarioLogueado;
	}
	public boolean isRolAdministrador() {
		return rolAdministrador;
	}
	public void setRolAdministrador(boolean rolAdministrador) {
		this.rolAdministrador = rolAdministrador;
	}
	/**
	 * @return the stateOauth2
	 */
	public String getStateOauth2() {
		return stateOauth2;
	}
	/**
	 * @param stateOauth2 the stateOauth2 to set
	 */
	public void setStateOauth2(String stateOauth2) {
		this.stateOauth2 = stateOauth2;
	}
	/**
	 * @return the ingresaDesdeLlave
	 */
	public boolean isIngresaDesdeLlave() {
		return ingresaDesdeLlave;
	}
	/**
	 * @param ingresaDesdeLlave the ingresaDesdeLlave to set
	 */
	public void setIngresaDesdeLlave(boolean ingresaDesdeLlave) {
		this.ingresaDesdeLlave = ingresaDesdeLlave;
	}

	
}
