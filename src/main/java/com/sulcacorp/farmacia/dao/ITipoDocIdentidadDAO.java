package com.sulcacorp.farmacia.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sulcacorp.farmacia.model.TipoDocIdentidad;

@Repository
public interface ITipoDocIdentidadDAO extends JpaRepository<TipoDocIdentidad, Long>{

	@Query("from TipoDocIdentidad a where a.estado = '1' order by a.descripcion asc ")
	List<TipoDocIdentidad> findAllAct();
}
