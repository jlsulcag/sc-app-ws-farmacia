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
import com.sulcacorp.farmacia.model.Emisor;
import com.sulcacorp.farmacia.service.IEmisorService;
import com.sulcacorp.farmacia.service.exception.CustomServiceException;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class EmisorController extends GenericController{

	@Autowired
	private IEmisorService service;

	@GetMapping(value = "/emisor/findAll")
	public ResponseEntity<ResponseRest> findAll() {
		log.info(">>> init findAll");
		try {
			List<Emisor> list = service.findAllAct();
			if (list.isEmpty()) {
				return this.getNotFoundRequest();
			}
			return this.getOkResponseConsulta(list);

		} catch (CustomServiceException e) {
			log.error(">>> Error emisorController findAll :\n {}", e.getMessage());
			return this.getInternalServerError();
		}
	}

	@GetMapping(value = "/emisor/findById/{id}")
	public ResponseEntity<ResponseRest> findById(@PathVariable("id") Long id) {
		log.info(">>> init findById");
		Emisor emisor = new Emisor();
		try {
			emisor = service.findById(id);
			if (emisor == null) {
				return this.getNotFoundRequest();
			}
			return getOkResponseConsulta(emisor);
		} catch (CustomServiceException e) {
			log.error(">>> Error emisor findById :\n {}", e.getMessage());
			return this.getInternalServerError();
		}

	}

	@PostMapping(value = "/emisor/save")
	public ResponseEntity<ResponseRest> save(@Validated @RequestBody Emisor emisor,
			BindingResult result) {
		log.info(">>> init save");
		if (result.hasErrors()) {
			return this.getBadRequest(result);
		}
		try {
			Emisor obj = service.save(emisor);
			return this.getCreatedResponse(obj, result);
		} catch (CustomServiceException e) {
			log.error(">>> Error emisor save :\n {}", e.getMessage());
			return this.getInternalServerError();
		}
	}

	@PutMapping(value = "/emisor/update")
	public ResponseEntity<ResponseRest> update(@Validated @RequestBody Emisor emisor,
			BindingResult result) {
		log.info(">>> init update");
		try {
			Emisor obj = service.update(emisor);
			return this.getOkResponseRegistro(obj, result);
		} catch (CustomServiceException e) {
			log.error(">>> Error emisor update : {}", e.getMessage());
			return this.getInternalServerError();
		}
	}

	@DeleteMapping(value = "/emisor/delete/{id}")
	public ResponseEntity<ResponseRest> delete(@PathVariable("id") Long id) {
		log.info(">>> init delete");
		Emisor obj = new Emisor();
		try {
			obj = service.findById(id);
			if (obj != null && obj.getId() != null) {
				service.delete(id);
				return this.getOkResponseConsulta(obj);
			}
			return this.getNotFoundRequest();
		} catch (CustomServiceException e) {
			log.error(">>> Error emisor delete : {}", e.getMessage());
			return this.getInternalServerError();
		}

	}
}
