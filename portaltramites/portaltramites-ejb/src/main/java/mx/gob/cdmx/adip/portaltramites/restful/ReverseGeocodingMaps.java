package mx.gob.cdmx.adip.portaltramites.restful;

import java.io.Serializable;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import mx.gob.cdmx.adip.portaltramites.common.infra.Environment;
import mx.gob.cdmx.adip.portaltramites.dto.GeocoderReverseMapsDTO;

public class ReverseGeocodingMaps implements Serializable{

    private static final long serialVersionUID = 6320767609075524467L;
    private static final Logger LOGGER = LoggerFactory.getLogger(ReverseGeocodingMaps.class);
    private String url;
    
    public ReverseGeocodingMaps() {}
    
    public GeocoderReverseMapsDTO obtenDireccion(String latitud, String longuitud) {
        url = "https://maps.googleapis.com/maps/api/geocode/json?latlng="+latitud+","+longuitud+"&key="+Environment.getApiKeyGoogleMapsGeocoding();
        
        GeocoderReverseMapsDTO dto= new GeocoderReverseMapsDTO();
        try {
            Client restClient = Client.create();    
            WebResource webResource = restClient.resource(url);
            ClientResponse resp = webResource.accept("application/json").get(ClientResponse.class);
            String output = resp.getEntity(String.class);
            
            //LOGGER.info("DATOSSSS "+output);
            JSONObject jsonObj = new JSONObject(output);
            
            //RESULT
            String results= jsonObj.get("results").toString();
            
            try {
                if(!jsonObj.get("error_message").toString().isEmpty()) {
                    LOGGER.error("INFORMACION RECIBIDA POR GEOCODER:"+jsonObj.toString());
                    throw new Exception(jsonObj.toString());
                }
            } catch (JSONException e) {
                // Si la llave "error_message" no se encuentra va a marcar una JSONException, entonces, de forma segura se omite la excepción
                LOGGER.debug("Excepción oculta de manera premeditada");
            }
            
            LOGGER.debug("INFORMACION CORRECTA GEOCODER "+results);
             
            JSONArray array = new JSONArray(results);  
            for (int i = 0; i < array.length(); i++) {  
                String data = array.getString(i);   
                JSONObject jsonClimaToObj =  new JSONObject(data);
                
                String formatted_address = jsonClimaToObj.get("address_components").toString();         
            }
            
            if(array.length()>0) {
                for (int i = 0; i < 1; i++) {   
                    String data = array.getString(i);   
                    JSONObject jsonClimaToObj =  new JSONObject(data);              
                    
                    String formatted_address = jsonClimaToObj.get("formatted_address").toString();      
                
                    dto.setDireccion(formatted_address); 
                }
            }
            
            dto.setCodeStatus(200);
        
            LOGGER.debug("INFORMACION CORRECTA GEOCODER");
            
        } catch (JSONException e) {
//            e.printStackTrace();
            LOGGER.error("Ocurrió un error", e);
            dto.setCodeStatus(400);
        }catch(Exception e) {
//            e.printStackTrace();
            LOGGER.error("error geocoder ", e);
            dto.setCodeStatus(500);
        }
        return dto;
    }
    
    
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    
//  public static void main(String[] args) {
//      ReverseGeocodingMaps reverse = new ReverseGeocodingMaps();
//      reverse.obtenDireccion("19.3944068", "-99.1940911");
//  }
}
