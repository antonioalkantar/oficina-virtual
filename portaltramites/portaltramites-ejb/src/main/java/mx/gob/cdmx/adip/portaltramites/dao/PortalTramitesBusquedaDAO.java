package mx.gob.cdmx.adip.portaltramites.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.dto.PortalTramitesBusquedaDTO;

@Stateless
@LocalBean
public class PortalTramitesBusquedaDAO  extends IBaseDAO<PortalTramitesBusquedaDTO, Integer> {

	@Override
	public PortalTramitesBusquedaDTO buscarPorId(Integer id) {
		return null;
	}

	@Override
	public List<PortalTramitesBusquedaDTO> buscarTodos() {
		// TODO Auto-generated method stub
		StringBuilder strQuery = new StringBuilder();
		strQuery.append(" SELECT ts.id as id_tramite");
		strQuery.append(" ,CASE ");
		strQuery.append(" WHEN cet.id = 2");
		strQuery.append(" AND cett.es_proceso_final = false");
		strQuery.append(" AND (tsh.id IS NOT NULL)");
		strQuery.append(" THEN tsh.homoclave");
		strQuery.append(" ELSE ts.homoclave");
		strQuery.append(" END as homoclave");
		strQuery.append(" ,CASE ");
		strQuery.append(" WHEN cet.id = 2");
		strQuery.append(" AND cett.es_proceso_final = false");
		strQuery.append(" AND (tsh.id IS NOT NULL)");
		strQuery.append(" THEN tsh.nombre_oficial");
		strQuery.append(" ELSE ts.nombre_oficial");
		strQuery.append(" END as nombre_oficial");
		strQuery.append(" ,cev.id as id_cev");
		strQuery.append(" ,cev.descripcion as desc_cev");
		strQuery.append(" ,cd.id_dependencia");
		strQuery.append(" ,cd.abreviatura");
		strQuery.append(" ,cd.nombre_dependencia");
		strQuery.append(" ,cm.id as id_cm");
		strQuery.append(" ,cm.descripcion as desc_cm");
		strQuery.append(" ,dca.id as id_dca");
		strQuery.append(" ,CASE ");
		strQuery.append(" WHEN cet.id = 2");
		strQuery.append(" AND cett.es_proceso_final = false");
		strQuery.append(" AND (dcah.id IS NOT NULL)");
		strQuery.append(" THEN dcah.puede_realizarse_digitalmente");
		strQuery.append(" ELSE dca.puede_realizarse_digitalmente");
		strQuery.append(" END as puede_realizarse_digitalmente");
		strQuery.append(" ,dca.tramite_con_llave");
		strQuery.append(" ,CASE");
		strQuery.append(" WHEN cet.id = 2");
		strQuery.append(" AND cett.es_proceso_final = false");
		strQuery.append(" AND (dcah.id IS NOT NULL)");
		strQuery.append(" THEN dcah.puede_realizarse_presencialmente");
		strQuery.append(" ELSE dca.puede_realizarse_presencialmente");
		strQuery.append(" END as puede_realizarse_presencialmente");
		strQuery.append(" ,CASE");
		strQuery.append(" WHEN cet.id = 2");
		strQuery.append(" AND cett.es_proceso_final = false");
		strQuery.append(" AND (dcah.id IS NOT NULL)");
		strQuery.append(" THEN dcah.puede_realizarse_telefonicamente");
		strQuery.append(" ELSE dca.puede_realizarse_telefonicamente");
		strQuery.append(" END as puede_realizarse_telefonicamente");
		strQuery.append(" ,ts.tiene_modalidades");
		strQuery.append(" ,1");
		strQuery.append(" ,CASE"); 
		strQuery.append(" WHEN cet.id = 2");
		strQuery.append(" AND cett.es_proceso_final = false");
		strQuery.append(" AND (ddth.id IS NOT NULL)");
		strQuery.append(" THEN ddth.sinonimos_busqueda");
		strQuery.append(" ELSE ddt.sinonimos_busqueda");
		strQuery.append(" END as sinonimos_busqueda");
		strQuery.append(" ,CASE ");
		strQuery.append(" WHEN cet.id = 2");
		strQuery.append(" AND cett.es_proceso_final = false");
		strQuery.append(" AND (ddth.id IS NOT NULL)");
		strQuery.append(" THEN ddth.descripcion_tramite");
		strQuery.append(" ELSE ddt.descripcion_tramite");
		strQuery.append(" END as descripcion_tramite");
		strQuery.append(" ,ddt.descripcion_usuario");
		strQuery.append(" ,ddt.descripcion_cuidadana");
		strQuery.append(" ,CASE ");
		strQuery.append(" WHEN cet.id = 2");
		strQuery.append(" AND cett.es_proceso_final = false");
		strQuery.append(" AND (tsh.id IS NOT NULL)");
		strQuery.append(" THEN cua.nombre");
		strQuery.append(" ELSE cuad.nombre");
		strQuery.append(" END as nombre_cuad");
		strQuery.append(" ,(select durr.url ");
		strQuery.append(" from retys_v2.tramite_servicio tss");
		strQuery.append(" INNER JOIN retys_v2.det_canal_atencion dcaa ON tss.id = dcaa.id_tramite_servicio");
		strQuery.append(" INNER JOIN retys_v2.det_url_registrado durr ON dcaa.id = durr.id_canal_atencion ");
		strQuery.append(" where tss.id = ts.id AND (durr.situacion IS null OR durr.situacion = true)");
		strQuery.append(" limit 1");
		strQuery.append(" ) as url");
		strQuery.append(" FROM retys_v2.tramite_servicio ts");
		strQuery.append(" INNER JOIN retys_v2.cat_etapa_de_vida cev ON ts.id_etapa_de_vida = cev.id");
		strQuery.append(" INNER JOIN retys_v2.cat_dependencia cd ON ts.id_dependencia = cd.id_dependencia");
		strQuery.append(" INNER JOIN retys_v2.cat_es_tramite_servicio cets ON ts.id_es_tramite_servicio = cets.id");
		strQuery.append(" INNER JOIN retys_v2.det_descripcion_tramite ddt ON ts.id = ddt.id_tramite_servicio");
		strQuery.append(" INNER JOIN retys_v2.cat_materia cm ON ddt.id_materia = cm.id");
		strQuery.append(" INNER JOIN retys_v2.det_canal_atencion dca ON ts.id = dca.id_tramite_servicio");
		strQuery.append(" INNER JOIN retys_v2.cat_unidades_administrativas cuad ON ts.id_area_administrativa = cuad.id");
		strQuery.append(" LEFT OUTER JOIN retys_v2.tramite_servicio_hist tsh ON ts.id = tsh.id");
		strQuery.append(" LEFT OUTER JOIN retys_v2.cat_unidades_administrativas cua ON tsh.id_area_administrativa = cua.id");
		strQuery.append(" LEFT OUTER JOIN retys_v2.det_descripcion_tramite_hist ddth ON ts.id = ddth.id_tramite_servicio");
		strQuery.append(" LEFT OUTER JOIN retys_v2.det_canal_atencion_hist dcah ON ts.id = dcah.id_tramite_servicio");
		strQuery.append(" INNER JOIN retys_v2.crc_flujo_tramite cft ON ts.id = cft.id_tramite_servicio");
		strQuery.append(" INNER JOIN retys_v2.cat_etapas_tramite cett ON cft.id_etapa_tramite = cett.id");
		strQuery.append(" INNER JOIN retys_v2.cat_estatus_tramite cet ON cft.id_estatus_tramite = cet.id");
		strQuery.append(" INNER JOIN retys_v2.cat_tipo_solicitud cts ON cft.id_tipo_solicitud = cts.id");
		strQuery.append(" WHERE ts.situacion = true");
		strQuery.append(" AND cet.id = 2");
		strQuery.append(" AND cets.id <> 3");
		
		List<PortalTramitesBusquedaDTO> lstDetalle = new ArrayList<PortalTramitesBusquedaDTO>();		
		Query query = em.createNativeQuery(strQuery.toString());
		List<Object[]> lstDetalleObj = query.getResultList();
		
		for (Object[] temp : lstDetalleObj) {
			PortalTramitesBusquedaDTO portal = new PortalTramitesBusquedaDTO();
			portal.setId(temp[0] == null ? null : Long.parseLong(temp[0].toString()));
			portal.setHomoclave(temp[1] == null ? null : temp[1].toString());
			portal.setNombreOficial(temp[2] == null ? null : temp[2].toString());
			portal.setIdEtapaDeVida(temp[3] == null ? null : Long.parseLong(temp[3].toString()));
			portal.setDescripcionEtapaDeVida(temp[4] == null ? null : temp[4].toString());
			portal.setIdDependencia(temp[5] == null ? null : Integer.parseInt(temp[5].toString()));
			portal.setAbreviaturaDependencia(temp[6] == null ? null : temp[6].toString());
			portal.setNombreDependencia(temp[7] == null ? null : temp[7].toString());
			portal.setIdMateria(temp[8] == null ? null : Long.parseLong(temp[8].toString()));
			portal.setDescripcionMateria(temp[9] == null ? null : temp[9].toString());
			portal.setIdCanalAtencion(temp[10] == null ? null : Long.parseLong(temp[10].toString()));
			portal.setPuedeRealizarseDigitalmente(temp[11] == null ? null : Boolean.parseBoolean(temp[11].toString()));
			portal.setTramiteConLlave(temp[12] == null ? null : Boolean.parseBoolean(temp[12].toString()));
			portal.setPuedeRealizarsePresencialmente(temp[13] == null ? null : Boolean.parseBoolean(temp[13].toString()));
			portal.setPuedeRealizarseTelefonicamente(temp[14] == null ? null : Boolean.parseBoolean(temp[14].toString()));
			portal.setTieneModalidades(temp[15] == null ? null : Boolean.parseBoolean(temp[15].toString()));
			portal.setIdEsTramiteServicio(temp[16] == null ? null : Long.parseLong(temp[16].toString()));
			portal.setSinonimoBusqueda(temp[17] == null ? null : temp[17].toString());
			portal.setDescripcionUsuario(temp[18] == null ? null : temp[18].toString());
			portal.setDescripcionCuidadana(temp[19] == null ? null : temp[19].toString());
			portal.setAreaAdministrativa(temp[20] == null ? null : temp[20].toString());
			portal.setLink(temp[21] == null ? null : temp[21].toString());
			
			lstDetalle.add(portal);
		}
		return lstDetalle;
		//return em.createNamedQuery("TramiteServicio.findSearch",PortalTramitesBusquedaDTO.class).getResultList();
	}

	@Override
	public List<PortalTramitesBusquedaDTO> buscarPorCriterios(PortalTramitesBusquedaDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(PortalTramitesBusquedaDTO e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardar(PortalTramitesBusquedaDTO e) {
		// TODO Auto-generated method stub
		
	}
	
	public PortalTramitesBusquedaDTO buscarPorIdTramite(Long id) {
		List<PortalTramitesBusquedaDTO> lst = em.createNamedQuery("TramiteServicio.findByIdTramite", PortalTramitesBusquedaDTO.class)
				.setParameter("idTramite", id).getResultList();
		if (lst.size() > 0)
			return lst.get(0);
		else
			return null;
	}

}
