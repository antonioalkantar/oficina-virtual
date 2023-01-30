package mx.gob.cdmx.adip.portaltramites.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.gob.cdmx.adip.portaltramites.dao.ServicioSemaforoEpDAO;
import mx.gob.cdmx.adip.widget.dto.ServicioSemaforoEpDTO;

@Named("semaforoBean")
@ViewScoped
public class AdministraSemaforoBean implements Serializable {

	private static final long serialVersionUID = -7614088037494368343L;

	private static final Logger LOGGER = LoggerFactory.getLogger(AdministraSemaforoBean.class);

	@Inject
	private ServicioSemaforoEpDAO servicioSemaforoEpDAO;

	private List<ServicioSemaforoEpDTO> listSemaforoDTO;
	private ServicioSemaforoEpDTO semaforoDTOSelect;

	public AdministraSemaforoBean() {
		listSemaforoDTO = new ArrayList<>();
	}
	
	@PostConstruct
	private void init(){
		consultaSemaforo();
	}

	public void consultaSemaforo() {
		listSemaforoDTO = servicioSemaforoEpDAO.buscarTodos();
	}
	
	public void editarSemaforo(ServicioSemaforoEpDTO semaforo) {
		semaforo.setColor(semaforo.getColor().contains("#") ? semaforo.getColor().replace("#", ""): semaforo.getColor());
		semaforoDTOSelect = semaforo;
	}
	
	public void guardaSemaforoEp(ServicioSemaforoEpDTO semaforo) {
		semaforo.setColor("#" + semaforo.getColor());
		try{
			servicioSemaforoEpDAO.actualizar(semaforo);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Semáforo actualizado correctamente"));
		}catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}

	public List<ServicioSemaforoEpDTO> getListSemaforoDTO() {
		return listSemaforoDTO;
	}

	public void setListSemaforoDTO(List<ServicioSemaforoEpDTO> listSemaforoDTO) {
		this.listSemaforoDTO = listSemaforoDTO;
	}

	public ServicioSemaforoEpDTO getSemaforoDTOSelect() {
		return semaforoDTOSelect;
	}

	public void setSemaforoDTOSelect(ServicioSemaforoEpDTO semaforoDTOSelect) {
		this.semaforoDTOSelect = semaforoDTOSelect;
	}

}
