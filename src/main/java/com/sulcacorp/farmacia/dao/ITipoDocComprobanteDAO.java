package com.sulcacorp.farmacia.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sulcacorp.farmacia.model.TipoDocComprobante;

@Repository
public interface ITipoDocComprobanteDAO extends JpaRepository<TipoDocComprobante, Long>{

	@Query("from TipoDocComprobante a where a.estado = '1' order by descripcion asc")
	List<TipoDocComprobante> findAllAct();

}
