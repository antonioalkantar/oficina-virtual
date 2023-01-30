package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the det_telefonos_registrados database table.
 * 
 */
@Entity
@Table(name="det_telefonos_registrados", schema = "retys_v2")
@NamedQueries({
	@NamedQuery(name="DetTelefonosRegistrado.findAll", query="SELECT d FROM DetTelefonosRegistrado d"),
	@NamedQuery(name="DetTelefonosRegistrado.buscarPorCanalAtencion", query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetTelefonosRegistradosDTO"
			+ " ("
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and dtrhist.id is not null then dtrhist.id else d.id end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and dtrhist.extensionTel is not null then dtrhist.extensionTel else d.extensionTel end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and dtrhist.numTelefono is not null then dtrhist.numTelefono else d.numTelefono end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and dtrhist.situacion is not null then dtrhist.situacion else d.situacion end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and canalhist.id is not null then canalhist.id else canal.id end, "
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and tramhist.id is not null then tramhist.id else tram.id end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and canalhist.id is not null then canalhist.id else canal.id end, "
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and tramhist.id is not null then tramhist.id else tram.id end " 
			
//			+ " d.id,"
//			+ " d.extensionTel, "
//			+ " d.numTelefono,"
//			+ " d.situacion , "
//			+ " canal.id, "
//			+ " tram.id , "
//			+ " canal.id, "
//			+ " tram.id "			
			
			+ " ) "
			+ "FROM DetTelefonosRegistrado d"
			+ " JOIN d.detCanalAtencion canal"
			+ " JOIN d.crcFlujoTramite tram"
			
			
			+ " left join d.detTelefonosRegistradosHist dtrhist "
//			+ " join dtrhist.canalAtencionHist canalhist "
			+ " join dtrhist.detCanalAtencionHist canalhist "
			+ " join dtrhist.crcFlujoTramite tramhist "
			
			+ " join tram.catEtapasTramite cet "
			+ " join tram.catEstatusTramite cestt "	
			
			+ " WHERE canal.id=:idcanal ORDER BY d.id ASC"),
})


public class DetTelefonosRegistrado implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long extensionTel;
	private Long numTelefono;
	private Boolean situacion;
	private List<DetHorariosTelefono> detHorariosTelefonos;
	private CrcFlujoTramite crcFlujoTramite;
	private DetCanalAtencion detCanalAtencion;
	private DetCanalAtencionHist detCanalAtencionHist;
	private DetTelefonosRegistradosHist detTelefonosRegistradosHist;

	public DetTelefonosRegistrado() {
	}
	
	public DetTelefonosRegistrado(Long id) {
		this.id = id;
	}
	
	
	public DetTelefonosRegistrado( Long extensionTel, Long numTelefono, Boolean situacion,
			List<DetHorariosTelefono> detHorariosTelefonos, CrcFlujoTramite crcFlujoTramite,
			DetCanalAtencion detCanalAtencion) {	
		
		this.extensionTel = extensionTel;
		this.numTelefono = numTelefono;
		this.situacion = situacion;
		this.detHorariosTelefonos = detHorariosTelefonos;
		this.crcFlujoTramite = crcFlujoTramite;
		this.detCanalAtencion = detCanalAtencion;
	}

	public DetTelefonosRegistrado(Long id, Long extensionTel, Long numTelefono, Boolean situacion,
			List<DetHorariosTelefono> detHorariosTelefonos, CrcFlujoTramite crcFlujoTramite,
			DetCanalAtencion detCanalAtencion) {
	
		this.id = id;
		this.extensionTel = extensionTel;
		this.numTelefono = numTelefono;
		this.situacion = situacion;
		this.detHorariosTelefonos = detHorariosTelefonos;
		this.crcFlujoTramite = crcFlujoTramite;
		this.detCanalAtencion = detCanalAtencion;
	}
	public DetTelefonosRegistrado(Long id, Long extensionTel, Long numTelefono, Boolean situacion,
			List<DetHorariosTelefono> detHorariosTelefonos, CrcFlujoTramite crcFlujoTramite,
			DetCanalAtencionHist detCanalAtencionHist) {
		
		this.id = id;
		this.extensionTel = extensionTel;
		this.numTelefono = numTelefono;
		this.situacion = situacion;
		this.detHorariosTelefonos = detHorariosTelefonos;
		this.crcFlujoTramite = crcFlujoTramite;
		this.detCanalAtencionHist = detCanalAtencionHist;
	}




	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Column(name="extension_tel")
	public Long getExtensionTel() {
		return this.extensionTel;
	}

	public void setExtensionTel(Long extensionTel) {
		this.extensionTel = extensionTel;
	}


	@Column(name="num_telefono")
	public Long getNumTelefono() {
		return this.numTelefono;
	}

	public void setNumTelefono(Long numTelefono) {
		this.numTelefono = numTelefono;
	}


	public Boolean getSituacion() {
		return this.situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}


	//bi-directional many-to-one association to DetHorariosTelefono
	@OneToMany(mappedBy="detTelefonosRegistrado")
	public List<DetHorariosTelefono> getDetHorariosTelefonos() {
		return this.detHorariosTelefonos;
	}

	public void setDetHorariosTelefonos(List<DetHorariosTelefono> detHorariosTelefonos) {
		this.detHorariosTelefonos = detHorariosTelefonos;
	}

	public DetHorariosTelefono addDetHorariosTelefono(DetHorariosTelefono detHorariosTelefono) {
		getDetHorariosTelefonos().add(detHorariosTelefono);
		detHorariosTelefono.setDetTelefonosRegistrado(this);

		return detHorariosTelefono;
	}

	public DetHorariosTelefono removeDetHorariosTelefono(DetHorariosTelefono detHorariosTelefono) {
		getDetHorariosTelefonos().remove(detHorariosTelefono);
		detHorariosTelefono.setDetTelefonosRegistrado(null);

		return detHorariosTelefono;
	}


	//bi-directional many-to-one association to CrcFlujoTramite
	@ManyToOne
	@JoinColumn(name="id_flujo_tramitre")
	public CrcFlujoTramite getCrcFlujoTramite() {
		return this.crcFlujoTramite;
	}

	public void setCrcFlujoTramite(CrcFlujoTramite crcFlujoTramite) {
		this.crcFlujoTramite = crcFlujoTramite;
	}


	//bi-directional many-to-one association to DetCanalAtencion
	@ManyToOne
	@JoinColumn(name="id_canal_atencion", insertable = false, updatable = false)
	public DetCanalAtencion getDetCanalAtencion() {
		return this.detCanalAtencion;
	}

	public void setDetCanalAtencion(DetCanalAtencion detCanalAtencion) {
		this.detCanalAtencion = detCanalAtencion;
	}
	
	@OneToOne
	@JoinColumn(name="id")
	public DetTelefonosRegistradosHist getDetTelefonosRegistradosHist() {
		return detTelefonosRegistradosHist;
	}

	public void setDetTelefonosRegistradosHist(DetTelefonosRegistradosHist detTelefonosRegistradosHist) {
		this.detTelefonosRegistradosHist = detTelefonosRegistradosHist;
	}
	//bi-directional many-to-one association to DetCanalAtencion
		@ManyToOne
		@JoinColumn(name="id_canal_atencion", insertable = false, updatable = false)
	public DetCanalAtencionHist getDetCanalAtencionHist() {
		return detCanalAtencionHist;
	}

	public void setDetCanalAtencionHist(DetCanalAtencionHist detCanalAtencionHist) {
		this.detCanalAtencionHist = detCanalAtencionHist;
	}

}