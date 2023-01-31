package mx.gob.cdmx.adip.portaltramites.common.infra;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.gob.cdmx.adip.portaltramites.commons.utils.Constantes;

/**
 * Clase utilizada para poder tener valores del profile en codigo Java. Tiene
 * Dependencia del archivo META-INF/env.properties
 * 
 * @author raul.soto
 *
 */
public final class Environment {

	/**
     * Logger de la clase
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Environment.class);
    
    /**
     * Indica el profile utilizado para la construccion de la aplicacion
     */
    private static String appProfile = "";
    
    /**
     * Indica si mostrara los mensajes de tiempo de respuesta de los EJB
     * Stateless
     */
    private static boolean ejbLog = false;   
    
    /**
     * Indica si esta habilitado la escritura de fases JSF
     */
    private static boolean jsfLifeCycle = false;

    /**
     * Indica si mostrara los mensajes de tiempo de respuesta de las peticiones HTTP
     */
    private static boolean webLog = false;
    
    /**
     * Indica la URL a la cual este sistema redireccionará para que la autenticación se realice mediante Llave CDMX
     */
    private static String urlLoginCdmx = "";
    
	/**
     * Indica la URL a la cual el SDK de Autenticación de la CDMX debe redireccionar trás haber iniciado sesión el usuario.
     */
    private static String urlRedirectLoginCdmx = "";
    
    private static String appId = "";
    
    private static String secretKey = "";
    		
    private static String userHttpBasicAuth = "";
    
    private static String passwordHttpBasicAuth = "";
    
    private static String urlServiceGetToken;
    
    private static String urlServiceGetDatosUsuario;
    
    private static String urlServiceGetRolesUsuario;
    
    /**
     * Se carga la url del servicio del clima
     * */
    private static String urlServicioClima = "";
    
    /***
     *  Se carga rl del servicio del no Circula
     * 
     * */
    private static String urlHoyNoCircula = "";
    
    /***
     *  Se carga rl del servicio del no Circula
     * 
     * */
    private static String urlServicioClimaOpen = "";
    
    private static String pathDocumentosUsuarios = "";
    
    private static String urlHomeRedirectLlave = "";
    
    private static String apiKeyGoogleMaps = "";
    
    private static String apiKeyGoogleMapsGeocoding = "";

    private static String urlServicioNotificaciones;
    
    private static String urlPortal = "";
    
    /***
     *  Se carga url del servicio del no Circula CDMX
     * 
     * */
    private static String urlHoyNoCirculaCDMX = "";
    
    private static String pathImgFondo = "";
    
    private static String urlServiceLogout;
    
  //Ruta para guardar Imagenes de Tarjetas de Anuncios
    private static String pathImgTargetaAnuncios;
    /**
     * Se carga la url del servicio de SUAC 311
     * */
	private static String urlServicioSuac = "";

	private static String userSuacBasicAuth = "";

	private static String passworSuacBasicAuth = "";
    
    /**
     * Se carga la url del servicio de CITAS
     * */
	private static String urlServicioCitas = "";

	private static String userCitasBasicAuth = "";

	private static String passworCitasBasicAuth = "";
	
	/**
     * Se carga la url del servicio de SACMEX
     * */
	private static String urlServicioSacmex = "";

	private static String userSacmexBasicAuth = "";

	private static String passworSacmexBasicAuth = "";
	
	/**
     * Se carga la url del servicio de MIBECA
     * */
	private static String urlServicioMiBeca = "";

	private static String userMiBecaBasicAuth = "";

	private static String passworMiBecaBasicAuth = "";

    /**
     * Se carga la url del servicio de REFRENDO TARJETA CIRCULACIÓN
     * */
	private static String urlServicioRefrendoTC = "";

	private static String userRefrendoTCBasicAuth = "";

	private static String passworRefrendoTCBasicAuth = "";
	
	private static String clientIDRefrendoTC = "";

	private static String urlServicioDoctoRefrendoTC = "";

	/**
     * Se carga la url del servicio de REFRENDO TARJETA CIRCULACIÓN
     * */
	private static String urlServicioActa = "";

	private static String userActaBasicAuth = "";

	private static String passworActaBasicAuth = "";
	
	/**
     * Se carga la url del servicio de NO ANTECEDENTES PENALES
     * */
	private static String urlServicioNoAntecedentes = "";

	private static String userNoAntecedentesBasicAuth = "";

	private static String passworNoAntecedentesBasicAuth = "";
	
	/**
     * Se carga la url del servicio de LICENCIA
     * */
	private static String urlServicioLicencia = "";
	
	private static String userLicenciaBasicAuth = "";

	private static String passworLicenciaBasicAuth = "";
	
	private static String urlServicioDocLicencia = "";
	
	private static String userDocLicenciaBasicAuth = "";

	private static String passworDocLicenciaBasicAuth = "";
	
	/**
	 * Se cargan datos del servicio de SEGURO DE DESEMPLEO
	 * */
	private static String urlServicioSeguroDes = "";
	private static String userSeguroDesBasicAuth = "";
	private static String passwordSeguroDesBasicAuth = "";
	
	/**
	 * Se cargan datos del servicio de SISTEMA ELECTRICO
	 * */
	private static String urlServicioSistemaElectrico = "";
	private static String userSistemaElectricoBasicAuth = "";
	private static String passwordSistemaElectricoBasicAuth = "";
	
	/**
	 * Se cargan datos del servicio de PROTESTA CIUDADANA
	 * */
	private static String urlServicioProtestaCiudadana = "";
	private static String userProtestaCiudadanaBasicAuth = "";
	private static String passwordProtestaCiudadanaBasicAuth = "";
	
	/**
	 * Se cargan datos del servicio de  VENTANILLA UNICA DE CONSTRUCCION
	 * */
	private static String urlServicioVentanillaUnicaConstruccion = "";
	private static String userVentanillaUnicaConstruccionBasicAuth = "";
	private static String passwordVentanillaUnicaConstruccionBasicAuth = "";
	
	/**
	 * Se cargan datos del servicio de PERMISOS PARA RESIDENTES
	 * */
	private static String urlServicioPermisoParaResidentes = "";
	private static String userPermisoParaResidentesBasicAuth = "";
	private static String passwordPermisoParaResidentesBasicAuth = "";
	private static String urlDocServicioPermisoParaResidentes = "";
	
	/**
	 * Se cargan datos del servicio de VENTANILLA DE CONTROL VEHICULAR
	 * */
	private static String urlServicioVentanillaControlVehicular = "";
	private static String userVentanillaControlVehicularBasicAuth = "";
	private static String passwordVentanillaControlVehicularBasicAuth = "";
	
	/**
	 * Se cargan datos del servicio de CORTESIAS URBANAS
	 * */
	private static String urlServicioCortesiasUrbanas = "";
	private static String userCortesiasUrbanasBasicAuth = "";
	private static String passwordCortesiasUrbanasBasicAuth = "";
	
	/**
	 * Se cargan datos del servicio de JURIDICO LABORAL
	 * */
	private static String urlServicioJuridicoLaboral = "";
	private static String userJuridicoLaboralBasicAuth = "";
	private static String passwordJuridicoLaboralBasicAuth = "";
	
	

	/**
     * Inicializacion de variables utilizando como entrada el archivo
     * "META-INF/env.properties"
     */
    static {
        final Properties properties = new Properties();
        try {
            LOGGER.info(":: E n v i r o n m e n t  C o n f i g ::\n");
            properties.load(Environment.class.getClassLoader().getResourceAsStream("META-INF/env.properties"));
            
            appProfile = properties.getProperty("app.profile", "dev");
            LOGGER.info("ENV [appProfile:\t{}]", appProfile);
            
            ejbLog = Boolean.valueOf(properties.getProperty("ejb.log", Constantes.FALSE));
            LOGGER.info("ENV [ejbLog:\t\t{}]", ejbLog);
            
            jsfLifeCycle = Boolean.valueOf(properties.getProperty("jsf.lifeCycle", Constantes.FALSE));
            LOGGER.info("ENV [jsfLifeCycle:\t{}]", jsfLifeCycle);
            
            webLog = Boolean.valueOf(properties.getProperty("web.log", "true"));
            LOGGER.info("ENV [webLog:\t\t{}]", webLog);            
            
            urlLoginCdmx = properties.getProperty("login.urlLoginCdmx");
            LOGGER.info("ENV [login.urlLoginCdmx:\t\t{}]", urlLoginCdmx);
            
            urlRedirectLoginCdmx = properties.getProperty("login.urlRedirectLoginCdmx");
            LOGGER.info("ENV [login.urlRedirectLoginCdmx:\t\t{}]", urlRedirectLoginCdmx);
            
            appId = properties.getProperty("login.appId");
            LOGGER.info("ENV [login.appId:\t\t{}]", appId);
            
            secretKey = properties.getProperty("login.secretKey");
            LOGGER.info("ENV [login.secretKey:\t\t{}]", secretKey);
            
            userHttpBasicAuth = properties.getProperty("login.userHttpBasicAuth");
            LOGGER.info("ENV [login.userHttpBasicAuth:\t\t{}]", userHttpBasicAuth);
            
            passwordHttpBasicAuth = properties.getProperty("login.passwordHttpBasicAuth");
            LOGGER.info("ENV [login.passwordHttpBasicAuth:\t\t{}]", passwordHttpBasicAuth);
            
            urlServiceGetToken = properties.getProperty("services.cdmx.getToken");
            LOGGER.info("ENV [services.cdmx.getToken:\t\t{}]", urlServiceGetToken);
            
            urlServiceGetDatosUsuario = properties.getProperty("services.cdmx.getDatosUsuario");
            LOGGER.info("ENV [services.cdmx.getDatosUsuario:\t\t{}]", urlServiceGetDatosUsuario);
            
            urlServiceGetRolesUsuario = properties.getProperty("services.cdmx.getRolesUsuario");
            LOGGER.info("ENV [services.cdmx.getRolesUsuario:\t\t{}]", urlServiceGetRolesUsuario);            
            
            urlServicioClima = properties.getProperty("servicio.clima.url");
            LOGGER.info("ENV [servicio.clima.url:\t\t{}]", urlServicioClima);
            
            urlHoyNoCircula = properties.getProperty("servicio.hoynocircula.url");
            LOGGER.info("ENV [servicio.hoynocircula.url:\t\t{}]", urlServicioClima);
            
            urlServicioClimaOpen = properties.getProperty("servicio.climaopen.url");
            LOGGER.info("ENV [servicio.climaopen.url:\t\t{}]", urlServicioClimaOpen);
            
            pathDocumentosUsuarios = properties.getProperty("perfil.pathDocumentosUsuario");
            LOGGER.info("ENV [perfil.pathDocumentosUsuario:\t\t{}]", pathDocumentosUsuarios);
            
            urlHomeRedirectLlave = properties.getProperty("home.redirect.llave");
            LOGGER.info("ENV [home.redirect.llave:\t\t{}]", urlHomeRedirectLlave);
            
            apiKeyGoogleMaps = properties.getProperty("googlemaps.api.key");
            LOGGER.info("ENV [googlemaps.api.key:\t\t{}]", apiKeyGoogleMaps);
            
            apiKeyGoogleMapsGeocoding = properties.getProperty("googlemaps.api.key.geocoding");
            LOGGER.info("ENV [googlemaps.api.key.geocoding:\t\t{}]", apiKeyGoogleMapsGeocoding);
            
            urlServicioNotificaciones = properties.getProperty("services.cdmx.notificaciones.url");
            LOGGER.info("ENV [services.cdmx.notificaciones.url:\t\t{}]", urlServicioNotificaciones);
            
            urlPortal = properties.getProperty("perfil.url.portal");
            LOGGER.info("ENV [perfil.url.portal:\t\t{}]", urlPortal);
            
            urlHoyNoCirculaCDMX = properties.getProperty("servicio.cdmx.hoynocircula.url");
            LOGGER.info("ENV [servicio.cdmx.hoynocircula.url:\t\t{}]", urlHoyNoCirculaCDMX);
            
            pathImgFondo = properties.getProperty("path.img.fondo");
            LOGGER.info("ENV [path.img.fondo:\t\t{}]", pathImgFondo);
            
            /*Ruta Documentos*/
            pathImgTargetaAnuncios = properties.getProperty("path.img.anuncios");
            LOGGER.info("ENV [path.img.anuncios:\t\t{}]", pathImgTargetaAnuncios);
            
            urlServiceLogout = properties.getProperty("services.cdmx.logout");
            LOGGER.info("ENV [services.cdmx.logout:\t\t{}]", urlServiceLogout);
            
            /**
             * SERVICIO SUAC
             */
            urlServicioSuac = properties.getProperty("services.cdmx.suac.url");
            LOGGER.info("ENV [services.cdmx.suac.url:\t\t{}]", urlServicioSuac);
            
            userSuacBasicAuth = properties.getProperty("services.cdmx.suac.user");
            LOGGER.info("ENV [services.cdmx.suac.user:\t\t{}]", userSuacBasicAuth);
            
            passworSuacBasicAuth = properties.getProperty("services.cdmx.suac.password");
            LOGGER.info("ENV [services.cdmx.suac.password:\t\t{}]", passworSuacBasicAuth);
            
            /**
             * SERVICIO CITAS
             */
            urlServicioCitas = properties.getProperty("services.cdmx.citas.url");
            LOGGER.info("ENV [services.cdmx.citas.url:\t\t{}]", urlServicioCitas);
            
            userCitasBasicAuth = properties.getProperty("services.cdmx.citas.user");
            LOGGER.info("ENV [services.cdmx.citas.user:\t\t{}]", userCitasBasicAuth);
            
            passworCitasBasicAuth = properties.getProperty("services.cdmx.citas.password");
            LOGGER.info("ENV [services.cdmx.citas.password:\t\t{}]", passworCitasBasicAuth);
            
            /**
             * SERVICIO SACMEX
             */
            urlServicioSacmex = properties.getProperty("services.cdmx.sacmex.url");
            LOGGER.info("ENV [services.cdmx.sacmex.url:\t\t{}]", urlServicioSacmex);
            
            userSacmexBasicAuth = properties.getProperty("services.cdmx.sacmex.user");
            LOGGER.info("ENV [services.cdmx.sacmex.user:\t\t{}]", userSacmexBasicAuth);
            
            passworSacmexBasicAuth = properties.getProperty("services.cdmx.sacmex.password");
            LOGGER.info("ENV [services.cdmx.sacmex.password:\t\t{}]", passworSacmexBasicAuth);

            /**
             * SERVICIO MIBECA
             */
            urlServicioMiBeca = properties.getProperty("services.cdmx.mibeca.url");
            LOGGER.info("ENV [services.cdmx.mibeca.url:\t\t{}]", urlServicioMiBeca);
            
            userMiBecaBasicAuth = properties.getProperty("services.cdmx.mibeca.user");
            LOGGER.info("ENV [services.cdmx.mibeca.user:\t\t{}]", userMiBecaBasicAuth);
            
            passworMiBecaBasicAuth = properties.getProperty("services.cdmx.mibeca.password");
            LOGGER.info("ENV [services.cdmx.mibeca.password:\t\t{}]", passworMiBecaBasicAuth);
            
            /**
             * SERVICIO REFRENDO TARJETA CIRCULACIÓN
             */
            urlServicioRefrendoTC = properties.getProperty("services.cdmx.refrendotc.url");
            LOGGER.info("ENV [services.cdmx.refrendotc.url:\t\t{}]", urlServicioRefrendoTC);
            
            userRefrendoTCBasicAuth = properties.getProperty("services.cdmx.refrendotc.user");
            LOGGER.info("ENV [services.cdmx.refrendotc.user:\t\t{}]", userRefrendoTCBasicAuth);
            
            passworRefrendoTCBasicAuth = properties.getProperty("services.cdmx.refrendotc.password");
            LOGGER.info("ENV [services.cdmx.refrendotc.password:\t\t{}]", passworRefrendoTCBasicAuth);            
            
            clientIDRefrendoTC = properties.getProperty("services.cdmx.refrendotc.client.id");
            LOGGER.info("ENV [services.cdmx.refrendotc.client.id:\t\t{}]", clientIDRefrendoTC);            

            urlServicioDoctoRefrendoTC = properties.getProperty("services.cdmx.doctoRefrendotc.url");
            LOGGER.info("ENV [services.cdmx.doctoRefrendotc.url:\t\t{}]", urlServicioDoctoRefrendoTC);

            /**
             * SERVICIO ACTAS DIGITALES
             */
            urlServicioActa = properties.getProperty("services.cdmx.acta.url");
            LOGGER.info("ENV [services.cdmx.acta.url:\t\t{}]", urlServicioActa);
            
            userActaBasicAuth = properties.getProperty("services.cdmx.acta.user");
            LOGGER.info("ENV [services.cdmx.acta.user:\t\t{}]", userActaBasicAuth);
            
            passworActaBasicAuth = properties.getProperty("services.cdmx.acta.password");
            LOGGER.info("ENV [services.cdmx.acta.password:\t\t{}]", passworActaBasicAuth);
            
            /**
             * SERVICIO NO ANTECEDENTES
             */
            urlServicioNoAntecedentes = properties.getProperty("services.cdmx.noantecedentes.url");
            LOGGER.info("ENV [services.cdmx.noantecedentes.url:\t\t{}]", urlServicioNoAntecedentes);
            
            userNoAntecedentesBasicAuth = properties.getProperty("services.cdmx.noantecedentes.user");
            LOGGER.info("ENV [services.cdmx.noantecedentes.user:\t\t{}]", userNoAntecedentesBasicAuth);
            
            passworNoAntecedentesBasicAuth = properties.getProperty("services.cdmx.noantecedentes.password");
            LOGGER.info("ENV [services.cdmx.noantecedentes.password:\t\t{}]", passworNoAntecedentesBasicAuth);
            
            /**
             * SERVICIO LICENCIA
             */
            urlServicioLicencia = properties.getProperty("services.cdmx.licencia.url");
            LOGGER.info("ENV [services.cdmx.licencia.url:\t\t{}]", urlServicioLicencia);
            
            userLicenciaBasicAuth = properties.getProperty("services.cdmx.licencia.user");
            LOGGER.info("ENV [services.cdmx.licencia.user:\t\t{}]", userLicenciaBasicAuth);
            
            passworLicenciaBasicAuth = properties.getProperty("services.cdmx.licencia.password");
            LOGGER.info("ENV [services.cdmx.licencia.password:\t\t{}]", passworLicenciaBasicAuth);
            
            urlServicioDocLicencia = properties.getProperty("services.cdmx.doc.licencia.url");
            LOGGER.info("ENV [services.cdmx.doc.licencia.url:\t\t{}]", urlServicioDocLicencia);
            
            userDocLicenciaBasicAuth = properties.getProperty("services.cdmx.doc.licencia.user");
            LOGGER.info("ENV [services.cdmx.doc.licencia.user:\t\t{}]", userDocLicenciaBasicAuth);
            
            passworDocLicenciaBasicAuth = properties.getProperty("services.cdmx.doc.licencia.password");
            LOGGER.info("ENV [services.cdmx.doc.licencia.password:\t\t{}]", passworDocLicenciaBasicAuth);
            
            /**
             * SERVICIO SEGURO DESEMPLEO
             */
            urlServicioSeguroDes = properties.getProperty("services.cdmx.segurodes.url");
            LOGGER.info("ENV [services.cdmx.segurodes.url:\t\t{}]", urlServicioSeguroDes);
            
            userSeguroDesBasicAuth = properties.getProperty("services.cdmx.segurodes.user");
            LOGGER.info("ENV [services.cdmx.segurodes.user:\t\t{}]", userSeguroDesBasicAuth);
            
            passwordSeguroDesBasicAuth = properties.getProperty("services.cdmx.segurodes.password");
            LOGGER.info("ENV [services.cdmx.segurodes.password:\t\t{}]", passwordSeguroDesBasicAuth);
            
            /**
             * SERVICIO SISTEMA ELECTRICO
             */
            urlServicioSistemaElectrico = properties.getProperty("services.cdmx.sistemaelectrico.url");
            LOGGER.info("ENV [services.cdmx.sistemaelectrico.url:\t\t{}]", urlServicioSistemaElectrico);
            
            userSistemaElectricoBasicAuth = properties.getProperty("services.cdmx.sistemaelectrico.user");
            LOGGER.info("ENV [services.cdmx.sistemaelectrico.user:\t\t{}]", userSistemaElectricoBasicAuth);
            
            passwordSistemaElectricoBasicAuth = properties.getProperty("services.cdmx.sistemaelectrico.password");
            LOGGER.info("ENV [services.cdmx.sistemaelectrico.password:\t\t{}]", passwordSistemaElectricoBasicAuth);
            
            /**
             * SERVICIO PROTESTA CIUDADANA
             */
            urlServicioProtestaCiudadana = properties.getProperty("services.cdmx.protestaciud.url");
            LOGGER.info("ENV [services.cdmx.protestaciud.url:\t\t{}]", urlServicioProtestaCiudadana);
            
            userProtestaCiudadanaBasicAuth = properties.getProperty("services.cdmx.protestaciud.user");
            LOGGER.info("ENV [services.cdmx.protestaciud.user:\t\t{}]", userProtestaCiudadanaBasicAuth);
            
            passwordProtestaCiudadanaBasicAuth = properties.getProperty("services.cdmx.protestaciud.password");
            LOGGER.info("ENV [services.cdmx.protestaciud.password:\t\t{}]", passwordProtestaCiudadanaBasicAuth);

            
            /**
             * SERVICIO VENTANILLA UNICA DE CONSTRUCCION
             */
            urlServicioVentanillaUnicaConstruccion = properties.getProperty("services.cdmx.ventanillauniconstruccion.url");
            LOGGER.info("ENV [services.cdmx.ventanillauniconstruccion.url:\t\t{}]", urlServicioVentanillaUnicaConstruccion);
            
            userVentanillaUnicaConstruccionBasicAuth = properties.getProperty("services.cdmx.ventanillauniconstruccion.user");
            LOGGER.info("ENV [services.cdmx.ventanillauniconstruccion.user:\t\t{}]", userVentanillaUnicaConstruccionBasicAuth);
            
            passwordVentanillaUnicaConstruccionBasicAuth = properties.getProperty("services.cdmx.ventanillauniconstruccion.password");
            LOGGER.info("ENV [services.cdmx.ventanillauniconstruccion.password:\t\t{}]", passwordVentanillaUnicaConstruccionBasicAuth);
            
            /**
             * SERVICIO PERMISOS PARA RESIDENTES
             */
            urlServicioPermisoParaResidentes = properties.getProperty("services.cdmx.permisoresidentes.url");
            LOGGER.info("ENV [services.cdmx.permisoresidentes.url:\t\t{}]", urlServicioPermisoParaResidentes);
            
            userPermisoParaResidentesBasicAuth = properties.getProperty("services.cdmx.permisoresidentes.user");
            LOGGER.info("ENV [services.cdmx.permisoresidentes.user:\t\t{}]", userPermisoParaResidentesBasicAuth);
            
            passwordPermisoParaResidentesBasicAuth = properties.getProperty("services.cdmx.permisoresidentes.password");
            LOGGER.info("ENV [services.cdmx.permisoresidentes.password:\t\t{}]", passwordPermisoParaResidentesBasicAuth);
            
            urlDocServicioPermisoParaResidentes = properties.getProperty("services.cdmx.permisoresidentes.doc.url");
            LOGGER.info("ENV [services.cdmx.permisoresidentes.doc.url:\t\t{}]", urlDocServicioPermisoParaResidentes);
            
            /**
             * SERVICIO VENTANILLA CONTROL VEHICULAR
             */
            urlServicioVentanillaControlVehicular = properties.getProperty("services.cdmx.ventanillacontrolvehicular.url");
            LOGGER.info("ENV [services.cdmx.ventanillacontrolvehicular.url:\t\t{}]", urlServicioVentanillaControlVehicular);
            
            userVentanillaControlVehicularBasicAuth = properties.getProperty("services.cdmx.ventanillacontrolvehicular.user");
            LOGGER.info("ENV [services.cdmx.ventanillacontrolvehicular.user:\t\t{}]", userVentanillaControlVehicularBasicAuth);
            
            passwordVentanillaControlVehicularBasicAuth = properties.getProperty("services.cdmx.ventanillacontrolvehicular.password");
            LOGGER.info("ENV [services.cdmx.ventanillacontrolvehicular.password:\t\t{}]", passwordVentanillaControlVehicularBasicAuth);
            
            /**
             * SERVICIO CORTESIAS URBANAS
             */
            urlServicioCortesiasUrbanas = properties.getProperty("services.cdmx.cortesiasurbanas.url");
            LOGGER.info("ENV [services.cdmx.cortesiasurbanas.url:\t\t{}]", urlServicioCortesiasUrbanas);
            
            userCortesiasUrbanasBasicAuth = properties.getProperty("services.cdmx.cortesiasurbanas.user");
            LOGGER.info("ENV [services.cdmx.cortesiasurbanas.user:\t\t{}]", userCortesiasUrbanasBasicAuth);
            
            passwordCortesiasUrbanasBasicAuth = properties.getProperty("services.cdmx.cortesiasurbanas.password");
            LOGGER.info("ENV [services.cdmx.cortesiasurbanas.password:\t\t{}]", passwordCortesiasUrbanasBasicAuth);
            
            
            /**
             * SERVICIO JURIDICO LABORAL
             */
            urlServicioJuridicoLaboral = properties.getProperty("services.cdmx.juridicolaboral.url");
            LOGGER.info("ENV [services.cdmx.juridicolaboral.url:\t\t{}]", urlServicioJuridicoLaboral);
            
            userJuridicoLaboralBasicAuth = properties.getProperty("services.cdmx.juridicolaboral.user");
            LOGGER.info("ENV [services.cdmx.juridicolaboral.user:\t\t{}]", userJuridicoLaboralBasicAuth);
            
            passwordJuridicoLaboralBasicAuth = properties.getProperty("services.cdmx.juridicolaboral.password");
            LOGGER.info("ENV [services.cdmx.juridicolaboral.password:\t\t{}]", passwordJuridicoLaboralBasicAuth);


        } catch (IOException e) {
            LOGGER.error("No se pueden cargar los valores de entorno de ejecución:", e);
        }
    }

    /**
     * Constructor privado para que no se instancíe esta clase desde afuera
     */
    private Environment() {
    }
    
    public static String getAppProfile() {
        return appProfile;
    }

    public static boolean isEJBLog() {
        return ejbLog;
    }

    public static boolean isJSFLifeCycle() {
        return jsfLifeCycle;
    }

    public static boolean isWEBLog() {
        return webLog;
    }

	public static String getUrlRedirectLoginCdmx() {
		return urlRedirectLoginCdmx;
	}

	public static String getUrlLoginCdmx() {
		return urlLoginCdmx;
	}

	public static String getUrlServiceGetToken() {
		return urlServiceGetToken;
	}
	
	public static String getUrlServiceGetDatosUsuario() {
		return urlServiceGetDatosUsuario;
	}
	
	public static String getUrlServiceGetRolesUsuario() {
		return urlServiceGetRolesUsuario;
	}
	
	public static String getAppId() {
		return appId;
	}

	public static String getSecretKey() {
		return secretKey;
	}

	public static String getUserHttpBasicAuth() {
		return userHttpBasicAuth;
	}

	public static String getPasswordHttpBasicAuth() {
		return passwordHttpBasicAuth;
	}

	public static String getUrlServicioClima() {
		return urlServicioClima;
	}

	public static String getUrlHoyNoCircula() {
		return urlHoyNoCircula;
	}

	public static String getUrlServicioClimaOpen() {
		return urlServicioClimaOpen;
	}

	public static String getPathDocumentosUsuarios() {
		return pathDocumentosUsuarios;
	}

	public static String getUrlHomeRedirectLlave() {
		return urlHomeRedirectLlave;
	}

	public static String getApiKeyGoogleMaps() {
		return apiKeyGoogleMaps;
	}

	public static String getUrlServicioNotificaciones() {
		return urlServicioNotificaciones;
	}

	public static String getUrlPortal() {
		return urlPortal;
	}

	public static String getApiKeyGoogleMapsGeocoding() {
		return apiKeyGoogleMapsGeocoding;
	}

	public static String getUrlHoyNoCirculaCDMX() {
		return urlHoyNoCirculaCDMX;
	}

	public static String getPathImgFondo() {
		return pathImgFondo;
	}
	
	public static String getPathImgTargetaAnuncios() {
		return pathImgTargetaAnuncios;
	}

	public static String getUrlServiceLogout() {
		return urlServiceLogout;
	}

	public static String getUrlServicioSuac() {
		return urlServicioSuac;
	}

	public static String getUserSuacBasicAuth() {
		return userSuacBasicAuth;
	}

	public static String getPassworSuacBasicAuth() {
		return passworSuacBasicAuth;
	}

	public static String getUrlServicioCitas() {
		return urlServicioCitas;
	}

	public static String getUserCitasBasicAuth() {
		return userCitasBasicAuth;
	}

	public static String getPassworCitasBasicAuth() {
		return passworCitasBasicAuth;
	}

	public static String getUrlServicioSacmex() {
		return urlServicioSacmex;
	}

	public static String getUserSacmexBasicAuth() {
		return userSacmexBasicAuth;
	}

	public static String getPassworSacmexBasicAuth() {
		return passworSacmexBasicAuth;
	}

	public static String getUrlServicioMiBeca() {
		return urlServicioMiBeca;
	}

	public static String getUserMiBecaBasicAuth() {
		return userMiBecaBasicAuth;
	}

	public static String getPassworMiBecaBasicAuth() {
		return passworMiBecaBasicAuth;
	}

	public static String getUrlServicioRefrendoTC() {
		return urlServicioRefrendoTC;
	}

	public static String getUserRefrendoTCBasicAuth() {
		return userRefrendoTCBasicAuth;
	}

	public static String getPassworRefrendoTCBasicAuth() {
		return passworRefrendoTCBasicAuth;
	}

	public static String getClientIDRefrendoTC() {
		return clientIDRefrendoTC;
	}

	public static String getUrlServicioActa() {
		return urlServicioActa;
	}

	public static String getUserActaBasicAuth() {
		return userActaBasicAuth;
	}

	public static String getPassworActaBasicAuth() {
		return passworActaBasicAuth;
	}

	public static String getUrlServicioDoctoRefrendoTC() {
		return urlServicioDoctoRefrendoTC;
	}

	public static String getUrlServicioNoAntecedentes() {
		return urlServicioNoAntecedentes;
	}

	public static String getUserNoAntecedentesBasicAuth() {
		return userNoAntecedentesBasicAuth;
	}

	public static String getPassworNoAntecedentesBasicAuth() {
		return passworNoAntecedentesBasicAuth;
	}
	
	public static String getUrlServicioLicencia() {
		return urlServicioLicencia;
	}
	
	public static String getUserLicenciaBasicAuth() {
		return userLicenciaBasicAuth;
	}

	public static String getPassworLicenciaBasicAuth() {
		return passworLicenciaBasicAuth;
	}

	public static String getUrlServicioDocLicencia() {
		return urlServicioDocLicencia;
	}

	public static String getUserDocLicenciaBasicAuth() {
		return userDocLicenciaBasicAuth;
	}

	public static String getPassworDocLicenciaBasicAuth() {
		return passworDocLicenciaBasicAuth;
	}

	public static String getUrlServicioSeguroDes() {
		return urlServicioSeguroDes;
	}

	public static String getUserSeguroDesBasicAuth() {
		return userSeguroDesBasicAuth;
	}

	public static String getPasswordSeguroDesBasicAuth() {
		return passwordSeguroDesBasicAuth;
	}

	public static String getUrlServicioSistemaElectrico() {
		return urlServicioSistemaElectrico;
	}

	public static String getUserSistemaElectricoBasicAuth() {
		return userSistemaElectricoBasicAuth;
	}

	public static String getPasswordSistemaElectricoBasicAuth() {
		return passwordSistemaElectricoBasicAuth;
	}

	public static String getUrlServicioProtestaCiudadana() {
		return urlServicioProtestaCiudadana;
	}

	public static String getUserProtestaCiudadanaBasicAuth() {
		return userProtestaCiudadanaBasicAuth;
	}

	public static String getPasswordProtestaCiudadanaBasicAuth() {
		return passwordProtestaCiudadanaBasicAuth;
	}

	public static String getUrlServicioVentanillaUnicaConstruccion() {
		return urlServicioVentanillaUnicaConstruccion;
	}

	public static String getUserVentanillaUnicaConstruccionBasicAuth() {
		return userVentanillaUnicaConstruccionBasicAuth;
	}

	public static String getPasswordVentanillaUnicaConstruccionBasicAuth() {
		return passwordVentanillaUnicaConstruccionBasicAuth;
	}

	public static String getUrlServicioPermisoParaResidentes() {
		return urlServicioPermisoParaResidentes;
	}

	public static String getUserPermisoParaResidentesBasicAuth() {
		return userPermisoParaResidentesBasicAuth;
	}

	public static String getPasswordPermisoParaResidentesBasicAuth() {
		return passwordPermisoParaResidentesBasicAuth;
	}

	public static String getUrlDocServicioPermisoParaResidentes() {
		return urlDocServicioPermisoParaResidentes;
	}

	public static String getUrlServicioVentanillaControlVehicular() {
		return urlServicioVentanillaControlVehicular;
	}

	public static String getUserVentanillaControlVehicularBasicAuth() {
		return userVentanillaControlVehicularBasicAuth;
	}

	public static String getPasswordVentanillaControlVehicularBasicAuth() {
		return passwordVentanillaControlVehicularBasicAuth;
	}

	public static String getUrlServicioCortesiasUrbanas() {
		return urlServicioCortesiasUrbanas;
	}

	public static String getUserCortesiasUrbanasBasicAuth() {
		return userCortesiasUrbanasBasicAuth;
	}

	public static String getPasswordCortesiasUrbanasBasicAuth() {
		return passwordCortesiasUrbanasBasicAuth;
	}

	public static String getUrlServicioJuridicoLaboral() {
		return urlServicioJuridicoLaboral;
	}

	public static String getUserJuridicoLaboralBasicAuth() {
		return userJuridicoLaboralBasicAuth;
	}

	public static String getPasswordJuridicoLaboralBasicAuth() {
		return passwordJuridicoLaboralBasicAuth;
	}
	
	
	
}