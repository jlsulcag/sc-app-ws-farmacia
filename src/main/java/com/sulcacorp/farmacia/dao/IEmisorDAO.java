package com.sulcacorp.farmacia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sulcacorp.farmacia.model.Emisor;

@Repository
public interface IEmisorDAO extends JpaRepository<Emisor, Long>{

}
