package com.sulcacorp.farmacia.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sulcacorp.farmacia.dao.ITipoDocIdentidadDAO;
import com.sulcacorp.farmacia.model.TipoDocIdentidad;
import com.sulcacorp.farmacia.service.ITipoDocIdentidadService;
import com.sulcacorp.farmacia.service.exception.CustomServiceException;

@Service
public class TipoDocIdentidadService implements ITipoDocIdentidadService{
	
	@Autowired
	private ITipoDocIdentidadDAO dao;
	
	@Override
	public TipoDocIdentidad save(TipoDocIdentidad t) throws CustomServiceException {
		return dao.saveAndFlush(t);
	}

	@Override
	public TipoDocIdentidad update(TipoDocIdentidad t) throws CustomServiceException {
		return dao.saveAndFlush(t);
	}

	@Override
	public TipoDocIdentidad findById(Long id) throws CustomServiceException {
		Optional<TipoDocIdentidad> op = dao.findById(id);
		return op.isPresent()?op.get(): null;
	}

	@Override
	public List<TipoDocIdentidad> findAllAct() throws CustomServiceException {
		return dao.findAllAct();
	}

	@Override
	public void delete(Long id) throws CustomServiceException {
		dao.deleteById(id);
	}

	@Override
	public TipoDocIdentidad updateStatus(TipoDocIdentidad t) throws CustomServiceException {
		return dao.save(t);
	}
	

}
