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
import com.sulcacorp.farmacia.model.Producto;
import com.sulcacorp.farmacia.service.IProductoService;
import com.sulcacorp.farmacia.service.exception.CustomServiceException;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/producto")
@Slf4j
public class ProductoController extends GenericController{

	@Autowired
	private IProductoService service;

	@GetMapping(value = "/findAll")
	public ResponseEntity<ResponseRest> findAll() {
		log.info(">>> init findAll");
		try {
			List<Producto> list = service.findAllAct();
			if (list.isEmpty()) {
				return this.getNotFoundRequest();
			}
			return this.getOkResponseConsulta(list);

		} catch (CustomServiceException e) {
			log.error(">>> Error productoController findAll :\n {}", e.getMessage());
			return this.getInternalServerError();
		}
	}

	@GetMapping(value = "/findById/{id}")
	public ResponseEntity<ResponseRest> findById(@PathVariable("id") Long id) {
		log.info(">>> init findById");
		Producto producto = new Producto();
		try {
			producto = service.findById(id);
			if (producto == null) {
				return this.getNotFoundRequest();
			}
			return getOkResponseConsulta(producto);
		} catch (CustomServiceException e) {
			log.error(">>> Error producto findById :\n {}", e.getMessage());
			return this.getInternalServerError();
		}

	}

	@PostMapping(value = "/save")
	public ResponseEntity<ResponseRest> save(@Validated @RequestBody Producto producto,
			BindingResult result) {
		log.info(">>> init save");
		if (result.hasErrors()) {
			return this.getBadRequest(result);
		}
		try {
			Producto obj = service.save(producto);
			return this.getCreatedResponse(obj, result);
		} catch (CustomServiceException e) {
			log.error(">>> Error producto save :\n {}", e.getMessage());
			return this.getInternalServerError();
		}
	}

	@PutMapping(value = "/update")
	public ResponseEntity<ResponseRest> update(@Validated @RequestBody Producto producto,
			BindingResult result) {
		log.info(">>> init update");
		try {
			Producto obj = service.update(producto);
			return this.getOkResponseRegistro(obj, result);
		} catch (CustomServiceException e) {
			log.error(">>> Error producto update : {}", e.getMessage());
			return this.getInternalServerError();
		}
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<ResponseRest> delete(@PathVariable("id") Long id) {
		log.info(">>> init delete");
		Producto obj = new Producto();
		try {
			obj = service.findById(id);
			if (obj != null && obj.getId() != null) {
				service.delete(id);
				return this.getOkResponseConsulta(obj);
			}
			return this.getNotFoundRequest();
		} catch (CustomServiceException e) {
			log.error(">>> Error producto delete : {}", e.getMessage());
			return this.getInternalServerError();
		}

	}
}
