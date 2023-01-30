package mx.gob.cdmx.adip.widget.dto;

import java.io.Serializable;
import java.util.*;
import java.util.logging.Logger;



public class HoyNoCirculaDTO implements Serializable {

	private static final long serialVersionUID = -1370320582210797261L;

	private String codigo;
	private Boolean hoyHayRestriccion;
	private String hoyEtiquetaColorNoCircula;
	private String hoyHexadecimalColorNoCircula;
	
	private String hoyTextoCorto;
	private String hoyTextoLargo;
	
	private String proximoSabadoTextoCorto;
	private String proximoSabadoTextoLargo;
	private String proximoSabadoColor;
	private String proximoSabadoHexadecimalColor;

	private HashMap<String, Integer>[] hoyIdHologramas;
	private HashMap<String, Integer>[] hoyUltimosDigitosH1;
	private HashMap<String, Integer>[] hoyUltimosDigitosH2;
	private HashMap<String, Integer>[] proximoSabadoUltimosDigitosH1;
	private HashMap<String, Integer>[] proximoSabadoUltimosDigitosH2;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Boolean getHoyHayRestriccion() {
		return hoyHayRestriccion;
	}

	public void setHoyHayRestriccion(Boolean hoyHayRestriccion) {
		this.hoyHayRestriccion = hoyHayRestriccion;
	}

	public String getHoyEtiquetaColorNoCircula() {
		return hoyEtiquetaColorNoCircula;
	}

	public void setHoyEtiquetaColorNoCircula(String hoyEtiquetaColorNoCircula) {
		this.hoyEtiquetaColorNoCircula = hoyEtiquetaColorNoCircula;
	}

	public String getHoyHexadecimalColorNoCircula() {
		return hoyHexadecimalColorNoCircula;
	}

	public void setHoyHexadecimalColorNoCircula(String hoyHexadecimalColorNoCircula) {
		this.hoyHexadecimalColorNoCircula = hoyHexadecimalColorNoCircula;
	}

	public HashMap<String, Integer>[] getHoyIdHologramas() {
		return hoyIdHologramas;
	}

	public void setHoyIdHologramas(HashMap<String, Integer>[] hoyIdHologramas) {
		this.hoyIdHologramas = hoyIdHologramas;
	}

	public HashMap<String, Integer>[] getHoyUltimosDigitosH1() {
		return hoyUltimosDigitosH1;
	}

	public void setHoyUltimosDigitosH1(HashMap<String, Integer>[] hoyUltimosDigitosH1) {
		this.hoyUltimosDigitosH1 = hoyUltimosDigitosH1;
	}

	public HashMap<String, Integer>[] getHoyUltimosDigitosH2() {
		return hoyUltimosDigitosH2;
	}

	public void setHoyUltimosDigitosH2(HashMap<String, Integer>[] hoyUltimosDigitosH2) {
		this.hoyUltimosDigitosH2 = hoyUltimosDigitosH2;
	}

	public HashMap<String, Integer>[] getProximoSabadoUltimosDigitosH1() {
		return proximoSabadoUltimosDigitosH1;
	}

	public void setProximoSabadoUltimosDigitosH1(HashMap<String, Integer>[] proximoSabadoUltimosDigitosH1) {
		this.proximoSabadoUltimosDigitosH1 = proximoSabadoUltimosDigitosH1;
	}

	public HashMap<String, Integer>[] getProximoSabadoUltimosDigitosH2() {
		return proximoSabadoUltimosDigitosH2;
	}

	public void setProximoSabadoUltimosDigitosH2(HashMap<String, Integer>[] proximoSabadoUltimosDigitosH2) {
		this.proximoSabadoUltimosDigitosH2 = proximoSabadoUltimosDigitosH2;
	}

	public int sizeProximoSabadoUltimosDigitosH1() {
		return proximoSabadoUltimosDigitosH1 != null ? proximoSabadoUltimosDigitosH1.length : 0;
	}
	
	public int sizeProximoSabadoUltimosDigitosH2() {
		return proximoSabadoUltimosDigitosH2 != null ? proximoSabadoUltimosDigitosH2.length :0;
	}
	
	public boolean esParH1() {
		try {
			if (proximoSabadoUltimosDigitosH2 != null &&proximoSabadoUltimosDigitosH2.length != 0
					&& proximoSabadoUltimosDigitosH2[0].get("ultimoDigito") % 2 == 0) {
				return true;
			}
		} catch (Exception e) {
			Logger.getLogger(e.getMessage());
			return false;
		}
		return false;
	}

	public String getHoyTextoCorto() {
		return hoyTextoCorto;
	}

	public void setHoyTextoCorto(String hoyTextoCorto) {
		this.hoyTextoCorto = hoyTextoCorto;
	}

	public String getHoyTextoLargo() {
		return hoyTextoLargo;
	}

	public void setHoyTextoLargo(String hoyTextoLargo) {
		this.hoyTextoLargo = hoyTextoLargo;
	}

	public String getProximoSabadoTextoCorto() {
		return proximoSabadoTextoCorto;
	}

	public void setProximoSabadoTextoCorto(String proximoSabadoTextoCorto) {
		this.proximoSabadoTextoCorto = proximoSabadoTextoCorto;
	}

	public String getProximoSabadoTextoLargo() {
		return proximoSabadoTextoLargo;
	}

	public void setProximoSabadoTextoLargo(String proximoSabadoTextoLargo) {
		this.proximoSabadoTextoLargo = proximoSabadoTextoLargo;
	}

	public String getProximoSabadoColor() {
		return proximoSabadoColor;
	}

	public void setProximoSabadoColor(String proximoSabadoColor) {
		this.proximoSabadoColor = proximoSabadoColor;
	}

	public String getProximoSabadoHexadecimalColor() {
		return proximoSabadoHexadecimalColor;
	}

	public void setProximoSabadoHexadecimalColor(String proximoSabadoHexadecimalColor) {
		this.proximoSabadoHexadecimalColor = proximoSabadoHexadecimalColor;
	}

	@Override
	public String toString() {
		return "HoyNoCirculaDTO [codigo=" + codigo + ", hoyHayRestriccion=" + hoyHayRestriccion
				+ ", hoyEtiquetaColorNoCircula=" + hoyEtiquetaColorNoCircula + ", hoyHexadecimalColorNoCircula="
				+ hoyHexadecimalColorNoCircula + ", hoyTextoCorto=" + hoyTextoCorto + ", hoyTextoLargo=" + hoyTextoLargo
				+ ", proximoSabadoTextoCorto=" + proximoSabadoTextoCorto + ", proximoSabadoTextoLargo="
				+ proximoSabadoTextoLargo + ", proximoSabadoColor=" + proximoSabadoColor
				+ ", proximoSabadoHexadecimalColor=" + proximoSabadoHexadecimalColor + ", hoyIdHologramas="
				+ Arrays.toString(hoyIdHologramas) + ", hoyUltimosDigitosH1=" + Arrays.toString(hoyUltimosDigitosH1)
				+ ", hoyUltimosDigitosH2=" + Arrays.toString(hoyUltimosDigitosH2) + ", proximoSabadoUltimosDigitosH1="
				+ Arrays.toString(proximoSabadoUltimosDigitosH1) + ", proximoSabadoUltimosDigitosH2="
				+ Arrays.toString(proximoSabadoUltimosDigitosH2) + "]";
	}
	
}
