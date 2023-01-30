package mx.gob.cdmx.adip.portaltramites.commons.utils;

public final class Constantes {
	
	/**
	 * Constructor por defecto de la clase
	 */
	private Constantes() {
		/** Constructor vacío para que no se pueda instanciar la clase **/
	}
	
	//Constantes utilizadas en el acceso de Llave
	public static final String CONTENT_TYPE = "application/json;charset=utf-8";
	public static final String GRANT_TYPE_AUTHORIZATION_CODE = "authorization_code";
	public final static String STATE_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_-";
	public static final String PARAM_CLIENT_ID = "client_id";
	public static final String PARAM_REDIRECT = "redirect_uri";
	public static final String PARAM_REDIRECT_URL = "redirect_url";
	public static final String PARAM_CODE = "code";
	public static final String PARAM_STATE = "state";
	public static final String PARAM_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64) ADIP(CDMX)/Endpoint Client";
	
    public static final String TOKEN_SESSION = "token";
	
	//Constantes de uso general
    public static final String SEPARADOR = System.getProperty("file.separator");
	public static final String SEPARADOR_RUTA = "/";
    public static final String RETURN_SAME_PAGE = "";    
    public static final String JSF_REDIRECT =  "?faces-redirect=true"; //"?idTramite=";
    public static final String RETURN_HOME_PAGE = "/home.xhtml";
    public static final String RETURN_WELCOME_PAGE = "/welcome.xhtml";
    public static final String RETURN_INDEX_PAGE = "/index.xhtml";
    public static final String REDIRECT_BUSCADOR = "/public/resultadoBuscador.xhtml";
    
	//Rutas de la administración del perfil de usuario
    public static final String RETURN_ADMIN_PERFIL_PAGE = "/protected/PerfilUsuario.xhtml"; 
    public static final String RETURN_DETALLE_TRAMITE_PAGE = "/public/InformacionTramite.xhtml"; 
    public static final String RETURN_RESULTADO_BUSCADOR = "/public/resultadoBuscador.xhtml"; 
    
    //Rutas backoffice
    public static final String RETURN_BACKOFFICE = "/backoffice.xhtml";
    public static final String RETURN_LOGIN = "/login";
    public static final String RETURN_ADMIN_ENCABEZADO = "/protected/administrarEncabezado.xhtml";
    public static final String RETURN_ADMIN_ENLACES = "/protected/administrarEnlaces.xhtml";
    public static final String RETURN_ADMIN_SEMAFORO = "/protected/administrarSemaforo.xhtml";
    public static final String RETURN_ADMIN_TAGS = "/protected/administrarTags.xhtml"; 
    public static final String RETURN_ADMIN_ANUNCIOS = "/protected/administrarAnuncios.xhtml"; 
    public static final String RETURN_ADMIN_CONTENIDO_MANUAL = "/protected/administrarContenidoManual.xhtml";
    public static final String RETURN_ADMIN_IMG_FONDO = "/protected/administrarImagenFondo.xhtml";
    public static final String RETURN_OFICINA_DIGITAL = "/protected/OficinaDigital.xhtml";
    
    public static final int MENU_ENCABEZADO = 1;
    public static final int MENU_ENLACES = 2;
    public static final int MENU_SEMAFORO = 3;
    public static final int MENU_TAGS = 4;
    public static final int MENU_ANUNCIOS = 5;
    public static final int MENU_CONTENIDO = 6;  
    public static final int MENU_IMG_FONDO = 7; 
	
    public static final int FIRST_INDEX_LIST = 0;
    public static final int INT_VALOR_CERO = 0;
	public static final int SIZE_ARRAY_EMPTY = 0;
	public static final String EMPTY_STRING = "";
    public static final String ESPACIO = " ";
    public static final int COMBO_OPCION_SELECCIONAR = 0;
    
    public static final Object OBJETO_NULO = null;
    public static final Object NULL = null;
    public static final String STRING_NULO = null;
            
    public static final int MAX_RESULT = 50;
    public static final int TAMAÑO_BUFFER = 1024;
    
    public static final String FALSE= "false";
    
    public static final String PATH_FONDO_DEFAULT = "/resources/img/fondo-header.jpg";
    public static final String PATH_FONDO_MOBILE_DEFAULT = "/resources/img/background-angel-mobile.jpg";
    
    
    public static final int ROL_ADMINISTRADOR = 302; 
    public static final long VALOR_04_MB = 4194304; 
    public static final long VALOR_01_MB = 1048576;  
    public static final long VALOR_500_KB = 6291456;
    public static final String RUTA_TARJETA_ANUNCIOS = "TarjetaAnuncios";
    public static final String RUTA_FONDOS = "FONDOS";
    
    //Menu Home    
    public static final int MENU_INDICADORES = 1;
    public static final int MENU_BUSCADOR = 2;
    
  //Resultado busqueda
    //Menu
    public static final Long CLASIFICACION_TRAMITES = 1L;
    public static final Long CLASIFICACION_SERVICIOS = 2L;
    public static final Long CLASIFICACION_PROGRAMAS_SOCIALES = 3L;
    public static final Long CLASIFICACION_TRAMITES_DIGITALES = 4L;
    public static final Long CLASIFICACION_SITIOS_INTERES = 5L;
    public static final String CLASIFICACION_TRAMITES_DESC = "Trámites";
    public static final String CLASIFICACION_SERVICIOS_DESC = "Servicios";
    public static final String CLASIFICACION_PROGRAMAS_SOCIALES_DESC = "Programas sociales";
    public static final String CLASIFICACION_TRAMITES_DIGITALES_DESC = "Trámites digitales";
    public static final String CLASIFICACION_SITIOS_INTERES_DESC = "Sitios de interés";
    

    
    public static final int OPCION_TRAMITES = 1;
    public static final int OPCION_SERVICIOS = 2;
    public static final int OPCION_PROGRAMAS = 3;
    public static final int OPCION_TODOS = 0;
    
    public static final int ID_TIPO_TRAMITE = 1;
    public static final int ID_TIPO_SERVICIO = 2;
    public static final int ID_TIPO_REPORTE = 3;
    public static final int ID_TIPO_PROGRAMA = 4;
    
    public static final int ID_ESTATUS_RECIBIDO = 1;
    public static final int ID_ESTATUS_EN_PROCESO = 2;
    public static final int ID_ESTATUS_ESPERA_TURNADO = 3;
    public static final int ID_ESTATUS_ESPERA_PAGO = 4;
    public static final int ID_ESTATUS_PAGADO = 5;
    public static final int ID_ESTATUS_RECHAZADO = 6;
    public static final int ID_ESTATUS_APROBADO = 7;
    public static final int ID_ESTATUS_FINALIZADO = 8;
    
    //SUAC
    public static final int ID_SISTEMA_SUAC = 1;
    public static final int ID_ESTATUS_SUAC_RECIBIDO = 1;
    public static final int ID_ESTATUS_SUAC_TURNADO = 2;
    public static final int ID_ESTATUS_SUAC_CANCELADO = 3;
    public static final int ID_ESTATUS_SUAC_ATENDIDO = 4;
    public static final int ID_ESTATUS_SUAC_CERRADO = 19;
    
    public static final String RETURN_URL_SUAC_DEV = "https://dev-suac311.cdmx.gob.mx/public/ConsultaEstatusSolicitudPortal.xhtml?idFolioSuac=";
    public static final String RETURN_URL_SUAC_PROD = "https://311locatel.cdmx.gob.mx/public/ConsultaEstatusSolicitudPortal.xhtml?idFolioSuac=";
    
    //REFRENDO TARJETA CIRCULACIÓN
    public static final int ID_SISTEMAS_REFRENDO_TARJETA_CIRCULACION = 2;
    public static final String RETURN_URL_REFRENDO_TARJETA_CIRCULACION_DEV = "https://tramites-dev.cdmx.gob.mx/tarjeta-circulacion/public/expediente/consulta?t=";
    public static final String RETURN_URL_REFRENDO_TARJETA_CIRCULACION_PROD = "https://tramites.cdmx.gob.mx/tarjeta-circulacion/public/expediente/consulta?t=";
    public static final String RETURN_COMP_URL_REFRENDOTC = "&startpage=expediente.consulta";

    //LICENCIA
    public static final int ID_SISTEMA_LICENCIA = 3;
    public static final String CONTENT_TYPE_PDF = ".pdf";
    public static final String RETURN_URL_LICENCIA_DEV = "https://licencias-dev.cdmx.gob.mx/public/ConsultaDetalleSolicitud.xhtml?idSolicitud=";
    public static final String RETURN_URL_LICENCIA_PROD = "https://licencias.cdmx.gob.mx/public/ConsultaDetalleSolicitud.xhtml?idSolicitud=";
    
    //SACMEX
    public static final int ID_SISTEMA_SACMEX = 4;
    public static final int ID_ESTATUS_PENDIENTE_SACMEX = 1;
    public static final int ID_ESTATUS_APROBADO_SACMEX = 2;
    public static final int ID_ESTATUS_RECHAZADO_SACMEX = 3;
    public static final int ID_ESTATUS_VIGENTE_SACMEX = 4;
    public static final int ID_ESTATUS_VENCIDO_SACMEX = 5;
    public static final int ID_ESTATUS_ENVIADO_SISCOMSE_SACMEX = 6;
    public static final int ID_ESTATUS_REVISION_SACMEX = 7;
    
    public static final String RETURN_URL_SACMEX_DEV = "https://www.dev-reduccionderechosagua.cdmx.gob.mx/public/ConsultaEstatusSolicitudPortal.xhtml?idFolioSacmex=";
    public static final String RETURN_URL_SACMEX_PROD = "https://www.reduccionderechosagua.cdmx.gob.mx/public/ConsultaEstatusSolicitudPortal.xhtml?idFolioSacmex=";
    public static final String STR_NO_APLICA = "No aplica"; 
    
    //ACTAS DIGITALES
    public static final int ID_SISTEMA_ACTA_DIGITAL= 5;
    public static final String RETURN_URL_ACTAS_DIGITALES_DEV = "https://actas-dev.cdmx.gob.mx/rest/foliosTramites/consultarFoliosPortal?idSolicitud=";
    public static final String RETURN_URL_ACTAS_DIGITALES_PROD = "https://actas.cdmx.gob.mx/rest/foliosTramites/consultarFoliosPortal?idSolicitud=";
    
    public static final int ID_ESTATUS_REGISTRADA_ACTAS = 1;
    public static final int ID_ESTATUS_PENDIENTE_ACTAS = 2;
    public static final int ID_ESTATUS_PAGADA_ACTAS = 3;
    public static final int ID_ESTATUS_PAGADA_PUNTO_ACTAS = 4;
   
    //CITAS
    public static final int ID_SISTEMA_CITAS = 6;    
    public static final String RETURN_URL_CITAS_DEV = "https://citascdmx-dev.cdmx.gob.mx/public/ConsultarEstatusSolicitudPortal.xhtml?id=";
    public static final String RETURN_URL_CITAS_PROD = "https://citas.cdmx.gob.mx/public/ConsultarEstatusSolicitudPortal.xhtml?id=";
    
    
    //MI BECA PARA EMPEZAR
    public static final int ID_SISTEMAS_MIBECA = 7;
    public static final String RETURN_URL_MIBECA_DEV = "https://registro.mibecaparaempezar-dev.cdmx.gob.mx/ConsultaSolicitudBeneficiario.xhtml?idSolicitud=";
    public static final String RETURN_URL_MIBECA_PROD = "https://registro.mibecaparaempezar.cdmx.gob.mx/ConsultaSolicitudBeneficiario.xhtml?idSolicitud=";
        
    //PROTESTA CIUDADANA
    public static final int ID_SISTEMA_PROTESTA_CIUDADANA = 8;    
    public static final String RETURN_URL_PROTESTA_CIUDADANA_DEV = "";
    public static final String RETURN_URL_PROTESTA_CIUDADANA_PROD = "";
    
    //VENTANILLA UNICA DE CONSTRUCCION
    public static final int ID_SISTEMA_VENTANILLA_UNICA_CONSTRUCCION = 9;    
    public static final String RETURN_URL_VENTANILLA_UNICA_CONSTRUCCION_DEV = "";
    public static final String RETURN_URL_VENTANILLA_UNICA_CONSTRUCCION_PROD = "";
    
    //SEGURO DESEMPLEO
    public static final int ID_SISTEMA_SEGURO_DESEMPLEO = 10;
    public static final String RETURN_URL_SEGURO_DESEMPLEO_DEV = "";
    public static final String RETURN_URL_SEGURO_DESEMPLEO_PROD = "";
    
    //SISTEMA ELECTRICO
    public static final int ID_SISTEMA_SISTEMA_ELECTRICO = 11;
    public static final String RETURN_URL_SISTEMA_ELECTRICO_DEV = "https://siapem-dev.cdmx.gob.mx/public/ConsultaTramitePortal.xhtml?idTramite=";
    public static final String RETURN_URL_SISTEMA_ELECTRICO_PROD = "https://siapem.cdmx.gob.mx/public/ConsultaTramitePortal.xhtml?idTramite=";
    
    //NO ANTECEDENTES PENALES 
    public static final int ID_SISTEMA_NO_ANTECEDENTES= 12;
    public static final String RETURN_URL_NO_ANTECEDENTES_DEV = "https://dev-antecedentespenales.cdmx.gob.mx/public/ConsultaEstatusSolicitudPortal.xhtml?idFolio=";
    public static final String RETURN_URL_NO_ANTECEDENTES_PROD = "https://noantecedentes.cdmx.gob.mx/public/ConsultaEstatusSolicitudPortal.xhtml?idFolio=";
    
    //PLATAFORMA PARA PERMISOS PARA RESIDENTES
    public static final int ID_SISTEMA_PERMISO_RESIDENTES = 13;
    public static final String RETURN_URL_PERMISO_RESIDENTES_DEV = "https://permisospar-dev.cdmx.gob.mx/public/ConsultaPermisoPortal.xhtml?idRegistro=";
    public static final String RETURN_URL_PERMISO_RESIDENTES_PROD = "https://permisosparquimetros.cdmx.gob.mx/public/ConsultaPermisoPortal.xhtml?idRegistro=";
    public static final int ID_ESTATUS_PPR_APROBADO_DIRECTOR = 4;
    public static final int ID_ESTATUS_PPR_BAJA = 15;
    
    //PLATAFORMA PARA ASISTENCIA JURIDICO LABORAL PARA LA POBLACION TRABAJADORA DE LA CIUDAD DE MEXICO
    public static final int ID_SISTEMA_JURIDICO_LABORAL = 14;
    public static final String RETURN_URL_JURIDICO_LABORAL_DEV = "";
    public static final String RETURN_URL_JURIDICO_LABORAL_PROD = "";
    
    //VENTANILLA DE CONTROL VEHICULAR
    public static final int ID_SISTEMA_VENTANILLA_CONTROL_VEHICULAR = 15;
    public static final String RETURN_URL_VENTANILLA_CONTROL_VEHICULAR_DEV = "";
    public static final String RETURN_URL_VENTANILLA_CONTROL_VEHICULAR_PROD = "";
    
    //CORTESIAS URBANAS
    public static final int ID_SISTEMA_CORTESIAS_URBANAS = 16;
    public static final String RETURN_URL_CORTESIAS_URBANAS_VEHICULAR_DEV = "";
    public static final String RETURN_URL_CORTESIAS_URBANAS_VEHICULAR_PROD = "";
    
}