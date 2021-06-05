package com.sulcacorp.farmacia.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sulcacorp.farmacia.model.Comprobante;

public interface IComprobanteDAO  extends JpaRepository<Comprobante, Long>{

}
