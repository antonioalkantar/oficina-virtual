package mx.gob.cdmx.adip.widget.client;

import java.io.Serializable;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import mx.gob.cdmx.adip.portaltramites.common.infra.Environment;
import mx.gob.cdmx.adip.portaltramites.util.BeanUtils;
import mx.gob.cdmx.adip.widget.dto.ServicioCalAireClienteDTO;
import mx.gob.cdmx.adip.widget.dto.ServicioClimaClienteDTO;
import mx.gob.cdmx.adip.widget.dto.ServicioGralClimaDTO;
import mx.gob.cdmx.adip.widget.dto.ServicioIUVClienteDTO;

public class ServicioClimaCliente implements Serializable{
	
	private static final long serialVersionUID = -2668728909205968885L;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ServicioClimaCliente.class);
	
	public ServicioClimaCliente() {
		
	}
	
	public ServicioGralClimaDTO consultarClima() {
		ServicioGralClimaDTO servicio = new ServicioGralClimaDTO();
		String output = null;
		try {
			Client restClient = Client.create();
			restClient.setConnectTimeout(3000);
			restClient.setReadTimeout(3000);
			
			WebResource webResource = restClient.resource(Environment.getUrlServicioClima());
			ClientResponse resp = webResource.accept("application/json").get(ClientResponse.class);
			
			output = resp.getEntity(String.class);
		     
		    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder builder = factory.newDocumentBuilder();
		    InputSource is = new InputSource(new StringReader(output));
		    Document doc = builder.parse(is);
		    doc.getDocumentElement().normalize();
		    Node carsNode = doc.getFirstChild();	     
		     
		    //LOGGER.info("Root element :" +  carsNode.getTextContent());
		     
		    String dataFromXML = carsNode.getTextContent();
		 	JSONObject jsonObj = new JSONObject(dataFromXML);
		 	 
		 	//MEASUREMENTS
		 	String measurements= jsonObj.get("Measurements").toString();
		 	JSONObject jsonMeasurementToObj =  new JSONObject(measurements);
		 	
		 	//Meteorologia
		 	String meteorologia =   jsonMeasurementToObj.get("meteorologia").toString();
		 	JSONObject jsonMeteorologiaToObj =  new JSONObject(meteorologia);
		 	 
		 	//Clima
		 	String clima =   jsonMeteorologiaToObj.get("clima").toString();
		 	JSONArray array = new JSONArray(clima);  
		 	ServicioClimaClienteDTO  climaDTO = new ServicioClimaClienteDTO();	 
		 	for (int i = 0; i < array.length(); i++) {
		 		
		 		String data = array.getString(i);
		 		
		 		//LOGGER.info("dataASDASDASDASDS "+data);
		 		JSONObject jsonClimaToObj =  new JSONObject(data);
		 		String tmpp = jsonClimaToObj.get("tmpp").toString();
		 		
		 		//LOGGER.info("CLIMAAAAA "+tmpp);
				String tmpmax = jsonClimaToObj.get("tmpmax").toString();
				String tmpmin = jsonClimaToObj.get("tmpmin").toString();
				String msjhoy = jsonClimaToObj.get("msjhoy").toString();
				
				climaDTO.setMensajeHoy(msjhoy);
				climaDTO.setTemperaturaMax(tmpmax);
				climaDTO.setTemperaturaMin(tmpmin);
				climaDTO.setTemperaturaProm(tmpp);
		 	}
		 	
		 	//Indice UV
			String indiceUV =jsonMeteorologiaToObj.get("IUV").toString(); 
			JSONArray arrayUv = new JSONArray(indiceUV);  
			ServicioIUVClienteDTO uvDTO = new ServicioIUVClienteDTO();
			for (int i = 0; i < arrayUv.length(); i++) {
				String data = arrayUv.getString(i);
		 		JSONObject jsonUvToObj =  new JSONObject(data);
		 		String ivmsg = jsonUvToObj.get("iuv").toString();
		 		if(ivmsg.equals("") || ivmsg.equals(null)) {
		 			ivmsg ="0";
		 		}else {
		 			ivmsg = ivmsg.replace("gif", "");
			 		ivmsg = ivmsg.replace(".", "");
			 		ivmsg = ivmsg.trim();
			 		ivmsg =  String.valueOf( Integer.parseInt(ivmsg));
		 		}
		 		
				uvDTO.setiUV(ivmsg);
			}		
			
			//CALIDAD DEL AIRE		 
			String calidadAire =   jsonMeasurementToObj.get("IAS_entidades").toString();
			JSONObject jsonCalidadAireToObj =  new JSONObject(calidadAire);		
			String CdmxAire =   jsonCalidadAireToObj.get("IAS_cdmx").toString();
			ServicioCalAireClienteDTO aireDTO = new ServicioCalAireClienteDTO();
			JSONArray arrayAire = new JSONArray(CdmxAire);  
			for (int i = 0; i < arrayAire.length(); i++) {
				String data = arrayAire.getString(i);
				JSONObject jsonAireToObj =  new JSONObject(data);
				String riesgo = jsonAireToObj.get("riesgo").toString();
				String Nriesgo = jsonAireToObj.get("Nriesgo").toString();
				String recomendacion_1 = jsonAireToObj.get("recomendacion_1").toString();
				String recomendacion_2 = jsonAireToObj.get("recomendacion_2").toString();
				aireDTO.setNriesgo(Nriesgo);
				aireDTO.setRiesgo(riesgo);
				aireDTO.setRecomendacion_1( BeanUtils.capitalizeFirstLetter(recomendacion_1));
				aireDTO.setRecomendacion_2(BeanUtils.capitalizeFirstLetter(recomendacion_2));
			}
			
			servicio.setCodigo(200);
			servicio.setServCalAireDTO(aireDTO);
			servicio.setServClimaDTO(climaDTO);
			servicio.setServIuvDTO(uvDTO);
		
		}catch(JSONException e) {
			servicio.setCodigo(400);
			LOGGER.error("Ocurrió un error al consultar el JSON del servicio de clima de la SEDEMA:", e);
			LOGGER.error("JSON Obtenido:" + output);
		}catch(Exception e) {
			servicio.setCodigo(500);
			LOGGER.error("Ocurrió un error al consultar el servicio de clima de la SEDEMA:", e);
		}
		return servicio;
	}
}
