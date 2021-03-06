package com.sulcacorp.farmacia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sulcacorp.farmacia.model.ComprobanteDetalle;

@Repository
public interface IComprobanteDetalleDAO extends JpaRepository<ComprobanteDetalle, Long>{

}
