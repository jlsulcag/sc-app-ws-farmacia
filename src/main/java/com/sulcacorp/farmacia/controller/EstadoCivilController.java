package com.sulcacorp.farmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sulcacorp.farmacia.controller.commons.ResponseRest;
import com.sulcacorp.farmacia.controller.generic.GenericController;
import com.sulcacorp.farmacia.model.EstadoCivil;
import com.sulcacorp.farmacia.service.IEstadoCivilService;
import com.sulcacorp.farmacia.service.exception.CustomServiceException;
import com.sulcacorp.farmacia.util.Constant;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/estadoCivil")
@Slf4j
public class EstadoCivilController extends GenericController{
	
	@Autowired
	private IEstadoCivilService service;
	
	@GetMapping(value = "/findAll")
	public ResponseEntity<ResponseRest> findAll() {
		log.info(">>> execute findAll ...");
		try {
			List<EstadoCivil> list = service.findAllAct();
			if(list.isEmpty()) {
				return this.getNotFoundRequest();
			}
			return this.getOkResponseConsulta(list);
		} catch (CustomServiceException e) {
			log.error(">>> Error findAll... {}", e.getMessage());
			return this.getInternalServerError();
		}
		
	}
	
	@GetMapping(value = "/findById/{id}")
	public ResponseEntity<ResponseRest> findById(@PathVariable("id") Long id) {
		log.info(">>> execute findById");
		EstadoCivil estadoCivil = new EstadoCivil();
		try {
			estadoCivil = service.findById(id);
			if (estadoCivil == null) {
				return this.getNotFoundRequest();
			}
			return getOkResponseConsulta(estadoCivil);
		} catch (CustomServiceException e) {
			log.error(">>> Error estadoCivil findById :\n {}", e.getMessage());
			return this.getInternalServerError();
		}

	}

	@PostMapping(value = "/save")
	public ResponseEntity<ResponseRest> save(@Validated @RequestBody EstadoCivil estadoCivil,
			BindingResult result) {
		log.info(">>> execute save");
		if (result.hasErrors()) {
			return this.getBadRequest(result);
		}
		try {
			EstadoCivil obj = service.save(estadoCivil);
			return this.getCreatedResponse(obj, result);
		} catch (CustomServiceException e) {
			log.error(">>> Error estadoCivil save :\n {}", e.getMessage());
			return this.getInternalServerError();
		}
	}

	@PutMapping(value = "/update")
	public ResponseEntity<ResponseRest> update(@Validated @RequestBody EstadoCivil estadoCivil,
			BindingResult result) {
		log.info(">>> execute update");
		try {
			EstadoCivil obj = service.update(estadoCivil);
			return this.getOkResponseRegistro(obj, result);
		} catch (CustomServiceException e) {
			log.error(">>> Error estadoCivil update : {}", e.getMessage());
			return this.getInternalServerError();
		}
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<ResponseRest> delete(@PathVariable("id") Long id) {
		log.info(">>> execute delete");
		EstadoCivil obj = new EstadoCivil();
		try {
			obj = service.findById(id);
			if (obj != null && obj.getId() != null) {
				obj.setEstado(Constant.STATUS_DISABLE);
				service.update(obj);
				return this.getOkResponseConsulta(obj);
			}
			return this.getNotFoundRequest();
		} catch (CustomServiceException e) {
			log.error(">>> Error estadoCivil delete : {}", e.getMessage());
			return this.getInternalServerError();
		}

	}

}
