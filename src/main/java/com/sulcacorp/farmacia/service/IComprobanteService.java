package com.sulcacorp.farmacia.service;

import com.sulcacorp.farmacia.model.Comprobante;
import com.sulcacorp.farmacia.service.exception.CustomServiceException;
import com.sulcacorp.farmacia.service.generic.IGenericService;

public interface IComprobanteService extends IGenericService<Comprobante, Long>{

	Comprobante registrarTransac(Comprobante entity) throws CustomServiceException;
}
