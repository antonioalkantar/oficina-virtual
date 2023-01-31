package mx.gob.cdmx.adip.portaltx.dto;

import java.io.Serializable;

public class TarjetaVentanillaControlVehicularDTO implements Serializable {



	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private CatSistemaDTO catSistemaDTO;
	private String folioTramite;
	private String tipo;
	private String modelo;
	private String placaAnterior;
	private String estatusTramite;
	private String pathImagen;

	public String getFolioTramite() {
		return folioTramite;
	}

	public void setFolioTramite(String folioTramite) {
		this.folioTramite = folioTramite;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlacaAnterior() {
		return placaAnterior;
	}

	public void setPlacaAnterior(String placaAnterior) {
		this.placaAnterior = placaAnterior;
	}

	public String getEstatusTramite() {
		return estatusTramite;
	}

	public void setEstatusTramite(String estatusTramite) {
		this.estatusTramite = estatusTramite;
	}

	public String getPathImagen() {
		return pathImagen;
	}

	public void setPathImagen(String pathImagen) {
		this.pathImagen = pathImagen;
	}

	public CatSistemaDTO getCatSistemaDTO() {
		return catSistemaDTO;
	}

	public void setCatSistemaDTO(CatSistemaDTO catSistemaDTO) {
		this.catSistemaDTO = catSistemaDTO;
	}
	
}
