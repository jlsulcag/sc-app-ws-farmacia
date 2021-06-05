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
import com.sulcacorp.farmacia.model.Comprobante;
import com.sulcacorp.farmacia.service.IComprobanteService;
import com.sulcacorp.farmacia.service.exception.CustomServiceException;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class ComprobanteController extends GenericController{

	@Autowired
	private IComprobanteService service;

	@GetMapping(value = "/comprobante/findAll")
	public ResponseEntity<ResponseRest> findAll() {
		log.info(">>> init findAll");
		try {
			List<Comprobante> list = service.findAllAct();
			if (list.isEmpty()) {
				return this.getNotFoundRequest();
			}
			return this.getOkResponseConsulta(list);

		} catch (CustomServiceException e) {
			log.error(">>> Error comprobanteController findAll :\n {}", e.getMessage());
			return this.getInternalServerError();
		}
	}

	@GetMapping(value = "/comprobante/findById/{id}")
	public ResponseEntity<ResponseRest> findById(@PathVariable("id") Long id) {
		log.info(">>> init findById");
		Comprobante comprobante = new Comprobante();
		try {
			comprobante = service.findById(id);
			if (comprobante == null) {
				return this.getNotFoundRequest();
			}
			return getOkResponseConsulta(comprobante);
		} catch (CustomServiceException e) {
			log.error(">>> Error comprobante findById :\n {}", e.getMessage());
			return this.getInternalServerError();
		}

	}

	@PostMapping(value = "/comprobante/save")
	public ResponseEntity<ResponseRest> save(@Validated @RequestBody Comprobante comprobante,
			BindingResult result) {
		log.info(">>> init save");
		if (result.hasErrors()) {
			return this.getBadRequest(result);
		}
		try {
			Comprobante obj = service.registrarTransac(comprobante);
			return this.getCreatedResponse(obj, result);
		} catch (CustomServiceException e) {
			log.error(">>> Error comprobante save :\n {}", e.getMessage());
			return this.getInternalServerError();
		}
	}

	@PutMapping(value = "/comprobante/update")
	public ResponseEntity<ResponseRest> update(@Validated @RequestBody Comprobante comprobante,
			BindingResult result) {
		log.info(">>> init update");
		try {
			Comprobante obj = service.update(comprobante);
			return this.getOkResponseRegistro(obj, result);
		} catch (CustomServiceException e) {
			log.error(">>> Error comprobante update : {}", e.getMessage());
			return this.getInternalServerError();
		}
	}

	@DeleteMapping(value = "/comprobante/delete/{id}")
	public ResponseEntity<ResponseRest> delete(@PathVariable("id") Long id) {
		log.info(">>> init delete");
		Comprobante obj = new Comprobante();
		try {
			obj = service.findById(id);
			if (obj != null && obj.getId() != null) {
				service.delete(id);
				return this.getOkResponseConsulta(obj);
			}
			return this.getNotFoundRequest();
		} catch (CustomServiceException e) {
			log.error(">>> Error comprobante delete : {}", e.getMessage());
			return this.getInternalServerError();
		}

	}
}
