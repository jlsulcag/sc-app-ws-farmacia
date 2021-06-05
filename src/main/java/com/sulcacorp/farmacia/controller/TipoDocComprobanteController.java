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
import com.sulcacorp.farmacia.model.TipoDocComprobante;
import com.sulcacorp.farmacia.service.ITipoDocComprobanteService;
import com.sulcacorp.farmacia.service.exception.CustomServiceException;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/tipoDocComprobante")
@Slf4j
public class TipoDocComprobanteController extends GenericController {

	@Autowired
	private ITipoDocComprobanteService service;

	@GetMapping(value = "/findAll")
	public ResponseEntity<ResponseRest> findAll() {
		log.info(">>> init findAll");
		try {
			List<TipoDocComprobante> list = service.findAllAct();
			if (list.isEmpty()) {
				return this.getNotFoundRequest();
			}
			return this.getOkResponseConsulta(list);

		} catch (CustomServiceException e) {
			log.error(">>> Error tipoDocComprobanteController findAll :\n {}", e.getMessage());
			return this.getInternalServerError();
		}
	}

	@GetMapping(value = "/findById/{id}")
	public ResponseEntity<ResponseRest> findById(@PathVariable("id") Long id) {
		log.info(">>> init findById");
		TipoDocComprobante tipoDocComprobante = new TipoDocComprobante();
		try {
			tipoDocComprobante = service.findById(id);
			if (tipoDocComprobante == null) {
				return this.getNotFoundRequest();
			}
			return getOkResponseConsulta(tipoDocComprobante);
		} catch (CustomServiceException e) {
			log.error(">>> Error tipoDocComprobante findById :\n {}", e.getMessage());
			return this.getInternalServerError();
		}

	}

	@PostMapping(value = "/save")
	public ResponseEntity<ResponseRest> save(@Validated @RequestBody TipoDocComprobante tipoDocComprobante,
			BindingResult result) {
		log.info(">>> init save");
		if (result.hasErrors()) {
			return this.getBadRequest(result);
		}
		try {
			TipoDocComprobante tipoDoc = service.save(tipoDocComprobante);
			return this.getCreatedResponse(tipoDoc, result);
		} catch (CustomServiceException e) {
			log.error(">>> Error tipoDocComprobante save :\n {}", e.getMessage());
			return this.getInternalServerError();
		}
	}

	@PutMapping(value = "/update")
	public ResponseEntity<ResponseRest> update(@Validated @RequestBody TipoDocComprobante tipoDocComprobante,
			BindingResult result) {
		log.info(">>> init update");
		try {
			TipoDocComprobante tipoDoc = service.update(tipoDocComprobante);
			return this.getOkResponseRegistro(tipoDoc, result);
		} catch (CustomServiceException e) {
			log.error(">>> Error tipoDocComprobante update : {}", e.getMessage());
			return this.getInternalServerError();
		}
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<ResponseRest> delete(@PathVariable("id") Long id) {
		log.info(">>> init delete");
		TipoDocComprobante obj = new TipoDocComprobante();
		try {
			obj = service.findById(id);
			if (obj != null && obj.getId() != null) {
				service.delete(id);
				return this.getOkResponseConsulta(obj);
			}
			return this.getNotFoundRequest();
		} catch (CustomServiceException e) {
			log.error(">>> Error tipoDocComprobante delete : {}", e.getMessage());
			return this.getInternalServerError();
		}

	}
}
