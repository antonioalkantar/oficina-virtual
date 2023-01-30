package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;
import java.util.Date;
public class MetroRespuestaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 942625319559004197L;
	
	  private String ID  ;	
	  private String LINEA ;	
	  
	  private String DATATIME ;	
	  private String ESTACION ;	
	  private String DIRECCION ;	
	  private String TIEMPOARRIBO ;
	  private String VIA;	
	  private String ENMOVIMENTO;
	  
	  private String DATATIME2 ;	
	  private String ESTACION2 ;	
	  private String DIRECCION2 ;	
	  private String TIEMPOARRIBO2 ;			
	  private String VIA2;	
	  private String ENMOVIMENTO2;
	  
	  private Date fechaModificacion;
	  
	  public MetroRespuestaDTO() {}
	  
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getDATATIME() {
		return DATATIME;
	}
	public void setDATATIME(String dATATIME) {
		DATATIME = dATATIME;
	}
	public String getESTACION() {
		return ESTACION;
	}
	public void setESTACION(String eSTACION) {
		ESTACION = eSTACION;
	}
	public String getDIRECCION() {
		return DIRECCION;
	}
	public void setDIRECCION(String dIRECCION) {
		DIRECCION = dIRECCION;
	}
	public String getTIEMPOARRIBO() {
		return TIEMPOARRIBO;
	}
	public void setTIEMPOARRIBO(String tIEMPOARRIBO) {
		TIEMPOARRIBO = tIEMPOARRIBO;
	}
	public String getLINEA() {
		return LINEA;
	}
	public void setLINEA(String lINEA) {
		LINEA = lINEA;
	}
	public String getVIA() {
		return VIA;
	}
	public void setVIA(String vIA) {
		VIA = vIA;
	}
	public String getENMOVIMENTO() {
		return ENMOVIMENTO;
	}
	public void setENMOVIMENTO(String eNMOVIMENTO) {
		ENMOVIMENTO = eNMOVIMENTO;
	}

	public String getENMOVIMENTO2() {
		return ENMOVIMENTO2;
	}

	public void setENMOVIMENTO2(String eNMOVIMENTO2) {
		ENMOVIMENTO2 = eNMOVIMENTO2;
	}

	public String getDATATIME2() {
		return DATATIME2;
	}

	public void setDATATIME2(String dATATIME2) {
		DATATIME2 = dATATIME2;
	}

	public String getESTACION2() {
		return ESTACION2;
	}

	public void setESTACION2(String eSTACION2) {
		ESTACION2 = eSTACION2;
	}

	public String getDIRECCION2() {
		return DIRECCION2;
	}

	public void setDIRECCION2(String dIRECCION2) {
		DIRECCION2 = dIRECCION2;
	}

	public String getTIEMPOARRIBO2() {
		return TIEMPOARRIBO2;
	}

	public void setTIEMPOARRIBO2(String tIEMPOARRIBO2) {
		TIEMPOARRIBO2 = tIEMPOARRIBO2;
	}

	public String getVIA2() {
		return VIA2;
	}

	public void setVIA2(String vIA2) {
		VIA2 = vIA2;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}	
}
