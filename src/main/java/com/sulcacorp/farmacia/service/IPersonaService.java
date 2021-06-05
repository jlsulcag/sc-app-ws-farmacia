package com.sulcacorp.farmacia.service;

import java.util.List;

import com.sulcacorp.farmacia.model.Persona;
import com.sulcacorp.farmacia.service.exception.CustomServiceException;
import com.sulcacorp.farmacia.service.generic.IGenericService;

public interface IPersonaService extends IGenericService<Persona, Long>{

	List<Persona> findByFullname(String upperCase) throws CustomServiceException;

	Persona findByDocNumber(String numDoc) throws CustomServiceException;

	Persona findByTypeAndDocNumber(long parseLong, String numDoc) throws CustomServiceException;


}
