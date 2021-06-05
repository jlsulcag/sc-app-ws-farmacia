package com.sulcacorp.farmacia.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sulcacorp.farmacia.model.Producto;

@Repository
public interface IProductoDAO extends JpaRepository<Producto, Long>{

	@Query("From Producto a where a.estado = '1' order by a.descProd asc")
	List<Producto> findAllAct();

}
