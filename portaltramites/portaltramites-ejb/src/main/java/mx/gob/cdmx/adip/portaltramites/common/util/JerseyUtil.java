package mx.gob.cdmx.adip.portaltramites.common.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.api.json.JSONConfiguration;

import mx.gob.cdmx.adip.portaltramites.common.infra.Environment;

public class JerseyUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(JerseyUtil.class);
	
	private static JerseyUtil instance;
	private Client client;
	private Client clientSDKCdmxWithAuth;
	private Client clientSDKSUACWithAuth;
	private Client clientSDKCitasWithAuth;
	private Client clientSDKSACMEXWithAuth;
	private Client clientSDKMiBecaWithAuth;
	private Client clientSDKRefrendoTCWithAuth;
	private Client clientSDKActaWithAuth;
	private Client clientSDKNoAntecedentesWithAuth;
	private Client clientSDKLicenciaWithAuth;
	private Client clientSDKSeguroDesWithAuth;
	private Client clientSDKSistemaElectricoWithAuth;
	private Client clientSDKProtestaCiudadanaWithAuth;
	private Client clientSDKVentanillaUnicaConstruccionWithAuth;
	private Client clientSDKPermisoResidentesWithAuth;
	private Client clientSDKVentanillaControlVehicularWithAuth;
	private Client clientSDKCortesiasUrbanasWithAuth;
	private Client clientSDKJuridicoLaboralWithAuth;
	
	private JerseyUtil() throws NoSuchAlgorithmException {
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getProperties().put(ClientConfig.PROPERTY_CONNECT_TIMEOUT, 30000); //3seg
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		
		confiarEnTodosLosCertificados();
		
		client = Client.create(clientConfig);
		client.setConnectTimeout(3000); // Establecer a 3 segundos
		
		clientSDKCdmxWithAuth = Client.create(clientConfig);
		clientSDKCdmxWithAuth.setConnectTimeout(3000); // Establecer a 3 segundos
		clientSDKCdmxWithAuth.addFilter(new HTTPBasicAuthFilter(Environment.getUserHttpBasicAuth(), Environment.getPasswordHttpBasicAuth()));
		
		clientSDKSUACWithAuth = Client.create(clientConfig);
		clientSDKSUACWithAuth.setConnectTimeout(3000); // Establecer a 3 segundos
		clientSDKSUACWithAuth.addFilter(new HTTPBasicAuthFilter(Environment.getUserSuacBasicAuth(), Environment.getPassworSuacBasicAuth()));
		
		clientSDKCitasWithAuth = Client.create(clientConfig);
		clientSDKCitasWithAuth.setConnectTimeout(3000); // Establecer a 3 segundos
		clientSDKCitasWithAuth.addFilter(new HTTPBasicAuthFilter(Environment.getUserCitasBasicAuth(), Environment.getPassworCitasBasicAuth()));
		
		clientSDKSACMEXWithAuth = Client.create(clientConfig);
		clientSDKSACMEXWithAuth.setConnectTimeout(3000); // Establecer a 3 segundos
		clientSDKSACMEXWithAuth.addFilter(new HTTPBasicAuthFilter(Environment.getUserSacmexBasicAuth(), Environment.getPassworSacmexBasicAuth()));
		
		clientSDKMiBecaWithAuth = Client.create(clientConfig);
		clientSDKMiBecaWithAuth.setConnectTimeout(3000); // Establecer a 3 segundos
		clientSDKMiBecaWithAuth.addFilter(new HTTPBasicAuthFilter(Environment.getUserMiBecaBasicAuth(), Environment.getPassworMiBecaBasicAuth()));

		clientSDKRefrendoTCWithAuth = Client.create(clientConfig);
		clientSDKRefrendoTCWithAuth.setConnectTimeout(3000); // Establecer a 3 segundos
		clientSDKRefrendoTCWithAuth.addFilter(new HTTPBasicAuthFilter(Environment.getUserRefrendoTCBasicAuth(), Environment.getPassworRefrendoTCBasicAuth()));
		
		clientSDKActaWithAuth = Client.create(clientConfig);
		clientSDKActaWithAuth.setConnectTimeout(3000); // Establecer a 3 segundos
		clientSDKActaWithAuth.addFilter(new HTTPBasicAuthFilter(Environment.getUserActaBasicAuth(), Environment.getPassworActaBasicAuth()));
		
		clientSDKNoAntecedentesWithAuth = Client.create(clientConfig);
		clientSDKNoAntecedentesWithAuth.setConnectTimeout(3000); // Establecer a 3 segundos
		clientSDKNoAntecedentesWithAuth.addFilter(new HTTPBasicAuthFilter(Environment.getUserNoAntecedentesBasicAuth(), Environment.getPassworNoAntecedentesBasicAuth()));
		
		clientSDKLicenciaWithAuth = Client.create(clientConfig);
		clientSDKLicenciaWithAuth.setConnectTimeout(3000); // Establecer a 3 segundos
		clientSDKLicenciaWithAuth.addFilter(new HTTPBasicAuthFilter(Environment.getUserLicenciaBasicAuth(), Environment.getPassworLicenciaBasicAuth()));
		
		clientSDKSeguroDesWithAuth = Client.create(clientConfig);
		clientSDKSeguroDesWithAuth.setConnectTimeout(3000); // Establecer a 3 segundos
		clientSDKSeguroDesWithAuth.addFilter(new HTTPBasicAuthFilter(Environment.getUserSeguroDesBasicAuth(), Environment.getPasswordSeguroDesBasicAuth()));
		
		clientSDKSistemaElectricoWithAuth = Client.create(clientConfig);
		clientSDKSistemaElectricoWithAuth.setConnectTimeout(3000); // Establecer a 3 segundos
		clientSDKSistemaElectricoWithAuth.addFilter(new HTTPBasicAuthFilter(Environment.getUserSistemaElectricoBasicAuth(), Environment.getPasswordSistemaElectricoBasicAuth()));
		
		clientSDKProtestaCiudadanaWithAuth = Client.create(clientConfig);
		clientSDKProtestaCiudadanaWithAuth.setConnectTimeout(3000); // Establecer a 3 segundos
		clientSDKProtestaCiudadanaWithAuth.addFilter(new HTTPBasicAuthFilter(Environment.getUserProtestaCiudadanaBasicAuth(), Environment.getPasswordProtestaCiudadanaBasicAuth()));
		
		clientSDKVentanillaUnicaConstruccionWithAuth = Client.create(clientConfig);
		clientSDKVentanillaUnicaConstruccionWithAuth.setConnectTimeout(3000); // Establecer a 3 segundos
		clientSDKVentanillaUnicaConstruccionWithAuth.addFilter(new HTTPBasicAuthFilter(Environment.getUserVentanillaUnicaConstruccionBasicAuth(), Environment.getPasswordVentanillaUnicaConstruccionBasicAuth()));
		
		clientSDKPermisoResidentesWithAuth = Client.create(clientConfig);
		clientSDKPermisoResidentesWithAuth.setConnectTimeout(3000); // Establecer a 3 segundos
		clientSDKPermisoResidentesWithAuth.addFilter(new HTTPBasicAuthFilter(Environment.getUserPermisoParaResidentesBasicAuth(), Environment.getPasswordPermisoParaResidentesBasicAuth()));
		
		
		clientSDKVentanillaControlVehicularWithAuth = Client.create(clientConfig);
		clientSDKVentanillaControlVehicularWithAuth.setConnectTimeout(3000); // Establecer a 3 segundos
		clientSDKVentanillaControlVehicularWithAuth.addFilter(new HTTPBasicAuthFilter(Environment.getUserVentanillaControlVehicularBasicAuth(), Environment.getPasswordVentanillaControlVehicularBasicAuth()));
		
		clientSDKCortesiasUrbanasWithAuth = Client.create(clientConfig);
		clientSDKCortesiasUrbanasWithAuth.setConnectTimeout(3000); // Establecer a 3 segundos
		clientSDKCortesiasUrbanasWithAuth.addFilter(new HTTPBasicAuthFilter(Environment.getUserCortesiasUrbanasBasicAuth(), Environment.getPasswordCortesiasUrbanasBasicAuth()));
		
		clientSDKJuridicoLaboralWithAuth = Client.create(clientConfig);
		clientSDKJuridicoLaboralWithAuth.setConnectTimeout(3000); // Establecer a 3 segundos
		clientSDKJuridicoLaboralWithAuth.addFilter(new HTTPBasicAuthFilter(Environment.getUserJuridicoLaboralBasicAuth(), Environment.getPasswordJuridicoLaboralBasicAuth()));
		
		LOGGER.debug("Environment.getUserHttpBasicAuth():"+Environment.getUserHttpBasicAuth());
		LOGGER.debug("Environment.getPasswordHttpBasicAuth():"+Environment.getPasswordHttpBasicAuth());
	}
		
	public static JerseyUtil getInstance() throws NoSuchAlgorithmException {
		if(instance == null) {
			instance = new JerseyUtil();
		}
		return instance;
	}
	
	public Client getClient() {
		return client;
	}

	public Client getClientSDKCdmxWithAuth() {
		return clientSDKCdmxWithAuth;
	}
	
	public Client getClientSDKSUACWithAuth() {
		return clientSDKSUACWithAuth;
	}
	
	public Client getClientSDKCitasWithAuth() {
		return clientSDKCitasWithAuth;
	}
	
	public Client getClientSDKSACMEXWithAuth() {
		return clientSDKSACMEXWithAuth;
	}
	
	public Client getClientSDKMiBecaWithAuth() {
		return clientSDKMiBecaWithAuth;
	}	

	public Client getClientSDKNoAntecedentesWithAuth() {
		return clientSDKNoAntecedentesWithAuth;
	}
	
	public Client getClientSDKLicenciaWithAuth() {
		return clientSDKLicenciaWithAuth;
	}

	/** 
	 * Este método lo que causa es que el cliente permita conectarse con servicios que están publicados en HTTPS 
	 * y que la JVM no tiene registrado en el cacerts el certificado de ese dominio donde se encuentra el servicio.
	 *  
	 * Por ejemplo, si no se invoca este método y en la cacerts no se agrega el certificado, marcará el error: 
	 * sun.security.validator.ValidatorException: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target
	 */
	private void confiarEnTodosLosCertificados() {
		TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager(){
		    public X509Certificate[] getAcceptedIssuers(){return null;}
		    public void checkClientTrusted(X509Certificate[] certs, String authType){}
		    public void checkServerTrusted(X509Certificate[] certs, String authType){}
		}};

		// Install the all-trusting trust manager
		try {
		    SSLContext sc = SSLContext.getInstance("TLS");
		    sc.init(null, trustAllCerts, new SecureRandom());
		    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (Exception e) {
			LOGGER.error("Ocurrio un error al hacer que se confie en todos los certificados en la JVM:", e);
		}
	}

	public Client getClientSDKRefrendoTCWithAuth() {
		return clientSDKRefrendoTCWithAuth;
	}

	public Client getClientSDKActaWithAuth() {
		return clientSDKActaWithAuth;
	}

	public Client getClientSDKSeguroDesWithAuth() {
		return clientSDKSeguroDesWithAuth;
	}

	public Client getClientSDKSistemaElectricoWithAuth() {
		return clientSDKSistemaElectricoWithAuth;
	}

	public Client getClientSDKProtestaCiudadanaWithAuth() {
		return clientSDKProtestaCiudadanaWithAuth;
	}

	public Client getClientSDKVentanillaUnicaConstruccionWithAuth() {
		return clientSDKVentanillaUnicaConstruccionWithAuth;
	}

	public Client getClientSDKPermisoResidentesWithAuth() {
		return clientSDKPermisoResidentesWithAuth;
	}

	public Client getClientSDKVentanillaControlVehicularWithAuth() {
		return clientSDKVentanillaControlVehicularWithAuth;
	}

	public Client getClientSDKCortesiasUrbanasWithAuth() {
		return clientSDKCortesiasUrbanasWithAuth;
	}

	public Client getClientSDKJuridicoLaboralWithAuth() {
		return clientSDKJuridicoLaboralWithAuth;
	}
}
