package com.sulcacorp.farmacia.service.generic;

import java.io.Serializable;
import java.util.List;

import com.sulcacorp.farmacia.service.exception.CustomServiceException;

public interface IGenericService<T, ID extends Serializable> {

	T save(T entity) throws CustomServiceException;
	T update(T entity) throws CustomServiceException;
	T findById(ID id) throws CustomServiceException;
	List<T> findAllAct() throws CustomServiceException;
	void delete(ID id) throws CustomServiceException;
	T updateStatus(T entity) throws CustomServiceException;
}
