package com.sulcacorp.farmacia.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sulcacorp.farmacia.dao.IProductoDAO;
import com.sulcacorp.farmacia.model.Producto;
import com.sulcacorp.farmacia.service.IProductoService;
import com.sulcacorp.farmacia.service.exception.CustomServiceException;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoDAO dao;

	@Override
	public Producto save(Producto entity) throws CustomServiceException {
		return dao.saveAndFlush(entity);
	}

	@Override
	public Producto update(Producto entity) throws CustomServiceException {
		return dao.saveAndFlush(entity);
	}

	@Override
	public Producto findById(Long id) throws CustomServiceException {
		Optional<Producto> op = dao.findById(id);
		return op.isPresent()?op.get(): null;
	}

	@Override
	public List<Producto> findAllAct() throws CustomServiceException {
		return dao.findAllAct();
	}

	@Override
	public void delete(Long id) throws CustomServiceException {
		dao.deleteById(id);
	}

	@Override
	public Producto updateStatus(Producto entity) throws CustomServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
