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
import com.sulcacorp.farmacia.model.TipoDocIdentidad;
import com.sulcacorp.farmacia.service.ITipoDocIdentidadService;
import com.sulcacorp.farmacia.service.exception.CustomServiceException;
import lombok.extern.slf4j.Slf4j;

//@Validated
@RestController
@RequestMapping("/api/tipoDocIdentidad")
@Slf4j
public class TipoDocIdentidadController extends GenericController{
	
	@Autowired
	private ITipoDocIdentidadService service;
	
	@GetMapping(value = "/findAll")
	public ResponseEntity<ResponseRest> findAll(){
		log.info(">>> execute findAll");
		try {
			List<TipoDocIdentidad> list = service.findAllAct();
			if(list.isEmpty()) {
				return this.getNotFoundRequest();
			}	
			return this.getOkResponseConsulta(list);
			
		} catch (CustomServiceException e) {
			log.error(">>> Error TipoDocIdentidadController findAll :\n {}", e.getMessage());
			return this.getInternalServerError();
		}
	}
	
	@GetMapping(value = "/findById/{id}")
	public ResponseEntity<ResponseRest> findById(@PathVariable("id") Long id){
		log.info(">>> execute findById");
		TipoDocIdentidad tipoDocIdentidad = new TipoDocIdentidad();
		try {
			tipoDocIdentidad = service.findById(id);
			if(tipoDocIdentidad == null) {
				return this.getNotFoundRequest();
			}
			return getOkResponseConsulta(tipoDocIdentidad);
		} catch (CustomServiceException e) {
			log.error(">>> Error TipoDocIdentidadController findById :\n {}", e.getMessage());
			return this.getInternalServerError();
		}
		
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<ResponseRest> save(@Validated @RequestBody TipoDocIdentidad tipoDocIdentidad, BindingResult result){
		log.info(">>> execute save");
		if(result.hasErrors()) {
			return this.getBadRequest(result);
		}
		try {
			TipoDocIdentidad tipoDoc = service.save(tipoDocIdentidad);			
			return this.getCreatedResponse(tipoDoc,result);
		} catch (CustomServiceException e) {
			log.error(">>> Error TipoDocIdentidadController save :\n {}", e.getMessage());
			return this.getInternalServerError();
		}
	}
	
	@PutMapping(value = "/update")
	public ResponseEntity<ResponseRest> update(@Validated @RequestBody TipoDocIdentidad tipoDocIdentidad, BindingResult result){
		log.info(">>> execute update");
		try {
			TipoDocIdentidad tipoDoc = service.update(tipoDocIdentidad);
			return this.getOkResponseRegistro(tipoDoc, result);
		} catch (CustomServiceException e) {
			log.error(">>> Error TipoDocIdentidadController update : {}", e.getMessage());
			return this.getInternalServerError();
		}
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<ResponseRest> delete(@PathVariable("id") Long id) {
		log.info(">>> execute delete");
		TipoDocIdentidad obj = new TipoDocIdentidad();
		try {
			obj = service.findById(id);
			if(obj != null && obj.getId() != null) {
				service.delete(id);
				return this.getOkResponseConsulta(obj);
			}
			return this.getNotFoundRequest();
		} catch (CustomServiceException e) {
			log.error(">>> Error TipoDocIdentidadController delete : {}", e.getMessage());
			return this.getInternalServerError();
		}
		
	}
	
	@PutMapping(value = "/updateStatus")
	public ResponseEntity<ResponseRest> updateStatus(@Validated @RequestBody TipoDocIdentidad tipoDocIdentidad) {
		log.info(">>> execute updateStatus");
		TipoDocIdentidad obj = new TipoDocIdentidad();
		try {
			obj = service.findById(tipoDocIdentidad.getId());
			obj.setEstado(tipoDocIdentidad.getEstado());
			if(obj != null && obj.getId() != null) {
				service.updateStatus(obj);
				return this.getOkResponseConsulta(obj);
			}
			return this.getNotFoundRequest();
		} catch (CustomServiceException e) {
			log.error(">>> Error TipoDocIdentidadController delete : {}", e.getMessage());
			return this.getInternalServerError();
		}
		
	}
	
}
