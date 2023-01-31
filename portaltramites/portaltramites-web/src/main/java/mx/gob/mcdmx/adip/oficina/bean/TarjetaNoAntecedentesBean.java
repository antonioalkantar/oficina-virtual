package mx.gob.mcdmx.adip.oficina.bean;

import java.io.ByteArrayInputStream;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.bouncycastle.util.encoders.Base64;
import org.primefaces.model.DefaultStreamedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.gob.cdmx.adip.portaltramites.common.infra.Environment;
import mx.gob.cdmx.adip.portaltramites.commons.utils.Constantes;
import mx.gob.cdmx.adip.portaltx.client.NoAntecedentesRestClient;
import mx.gob.cdmx.adip.portaltx.dto.RegistroDTO;
import mx.gob.cdmx.adip.portaltx.dto.TarjetaNoAntecedentesDTO;

@Named("TarjetaNoAntecedentesBean")
@RequestScoped
public class TarjetaNoAntecedentesBean implements Serializable {
	private static final long serialVersionUID = 1258102050526093893L;
	private static final Logger LOGGER = LoggerFactory.getLogger(TarjetaNoAntecedentesBean.class);

	private RegistroDTO tarjetaNoAntecedentes;
	private TarjetaNoAntecedentesDTO tarjetaNoAntecedentesDTO;

	@Inject
	private tramitesOficinaBean tramitesOficinaBean;

	@Inject
	private NoAntecedentesRestClient antecedentesRestClient;

	public TarjetaNoAntecedentesBean() {
	}

	@PostConstruct
	public void init() {
		try {
			tarjetaNoAntecedentes = antecedentesRestClient.consultaRegistroNoAntecedentes(tramitesOficinaBean.getRegistroSelected());
			tarjetaNoAntecedentes.setPathImagen(tramitesOficinaBean.getRegistroSelected().getCatSistemaDTO().getPathImagen());
		} catch (Exception e) {
			LOGGER.error("Al consultar el servico de No Antecedentes:", e);
		}
	}

	public String urlAction() {
		if (tarjetaNoAntecedentes != null) {
			if (Environment.getAppProfile().compareTo("dev") == 0
					|| Environment.getAppProfile().compareTo("local") == 0) {
				return Constantes.RETURN_URL_NO_ANTECEDENTES_DEV + tarjetaNoAntecedentes.getIdRegistroOrigen();
			} else {
				return Constantes.RETURN_URL_NO_ANTECEDENTES_PROD + tarjetaNoAntecedentes.getIdRegistroOrigen();
			}
		}
		return "#";
	}
	
	public void descargarDocumento() {
		tramitesOficinaBean.setFile(null);
		try {
			TarjetaNoAntecedentesDTO tarjetaNoAntecedentesDTO = antecedentesRestClient.consultaDocumentoNoAntecedentes(tramitesOficinaBean.getRegistroSelected());
			
			tramitesOficinaBean.setFile(DefaultStreamedContent.builder().name("NoAntecetdentes" + tarjetaNoAntecedentesDTO.getExtension())
					.contentType("application/pdf").stream(() -> new ByteArrayInputStream(Base64.decode(tarjetaNoAntecedentesDTO.getDocumento()))).build());

		} catch (Exception e) {
			LOGGER.error("Error al descargar documento de No antecedentes: ", e);
		}

	}

	public RegistroDTO getTarjetaNoAntecedentes() {
		return tarjetaNoAntecedentes;
	}

	public void setTarjetaNoAntecedentes(RegistroDTO tarjetaNoAntecedentes) {
		this.tarjetaNoAntecedentes = tarjetaNoAntecedentes;
	}


}
