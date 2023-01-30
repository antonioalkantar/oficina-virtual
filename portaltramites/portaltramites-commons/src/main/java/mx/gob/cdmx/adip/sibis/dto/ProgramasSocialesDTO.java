package mx.gob.cdmx.adip.sibis.dto;

import java.io.Serializable;

public class ProgramasSocialesDTO implements Serializable {

	private static final long serialVersionUID = 4990932016679187794L;

	private int anio;
	private long id;
	private String clave;
	private String description;
	private String abreviatura;
	private String palabrasClave;
	private Boolean esDigital;
	private ResponsibleUnitsDTO responsibleUnitsDTO;
	private CategoriasDTO categoriasDTO;
	private ResumenesProgramasDTO resumenesProgramasDTO;
	private Boolean activo;
	private String nombreDependencia;
	private CatDependenciaRetysDTO catDependenciaRetysDTO;

	public ProgramasSocialesDTO() {
		responsibleUnitsDTO = new ResponsibleUnitsDTO();
		categoriasDTO = new CategoriasDTO();
		resumenesProgramasDTO = new ResumenesProgramasDTO();
		catDependenciaRetysDTO = new CatDependenciaRetysDTO();
	}

	public ProgramasSocialesDTO(int anio, long id, String clave, String description, String abreviatura,
			Long idDependencia, long idCategorias, String descCategoria, String palabrasClave, Boolean esDigital,
			String urlPrograma, Boolean activo, String nombreDependencia) {
		this.anio = anio;
		this.id = id;
		this.clave = clave;
		this.description = description;
		this.abreviatura = abreviatura;
		this.catDependenciaRetysDTO = new CatDependenciaRetysDTO(idDependencia, nombreDependencia);
		this.categoriasDTO = new CategoriasDTO(idCategorias, descCategoria);
		this.palabrasClave = palabrasClave;
		this.esDigital = esDigital;
		this.resumenesProgramasDTO = new ResumenesProgramasDTO(urlPrograma);
		this.activo = activo;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public ResponsibleUnitsDTO getResponsibleUnitsDTO() {
		return responsibleUnitsDTO;
	}

	public void setResponsibleUnitsDTO(ResponsibleUnitsDTO responsibleUnitsDTO) {
		this.responsibleUnitsDTO = responsibleUnitsDTO;
	}

	public String getPalabrasClave() {
		return palabrasClave;
	}

	public void setPalabrasClave(String palabrasClave) {
		this.palabrasClave = palabrasClave;
	}

	public Boolean getEsDigital() {
		return esDigital;
	}

	public void setEsDigital(Boolean esDigital) {
		this.esDigital = esDigital;
	}

	public CategoriasDTO getCategoriasDTO() {
		return categoriasDTO;
	}

	public void setCategoriasDTO(CategoriasDTO categoriasDTO) {
		this.categoriasDTO = categoriasDTO;
	}

	public ResumenesProgramasDTO getResumenesProgramasDTO() {
		return resumenesProgramasDTO;
	}

	public void setResumenesProgramasDTO(ResumenesProgramasDTO resumenesProgramasDTO) {
		this.resumenesProgramasDTO = resumenesProgramasDTO;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getNombreDependencia() {
		return nombreDependencia;
	}

	public void setNombreDependencia(String nombreDependencia) {
		this.nombreDependencia = nombreDependencia;
	}

	public CatDependenciaRetysDTO getCatDependenciaRetysDTO() {
		return catDependenciaRetysDTO;
	}

	public void setCatDependenciaRetysDTO(CatDependenciaRetysDTO catDependenciaRetysDTO) {
		this.catDependenciaRetysDTO = catDependenciaRetysDTO;
	}

}
