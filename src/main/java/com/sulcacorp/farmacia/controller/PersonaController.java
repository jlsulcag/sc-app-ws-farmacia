package com.sulcacorp.farmacia.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
import com.sulcacorp.farmacia.model.Persona;
import com.sulcacorp.farmacia.service.IPersonaService;
import com.sulcacorp.farmacia.service.exception.CustomServiceException;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/persona")
@Slf4j
public class PersonaController extends GenericController {

	@Autowired
	private IPersonaService service;

	@GetMapping(value = "/findAll")
	public ResponseEntity<ResponseRest> findAll() {
		log.info(">>> init findAll");
		try {
			List<Persona> list = service.findAllAct();
			if (list.isEmpty()) {
				return this.getNotFoundRequest();
			}
			return this.getOkResponseConsulta(list);

		} catch (CustomServiceException e) {
			log.error(">>> Error personaController findAll :\n {}", e.getMessage());
			return this.getInternalServerError();
		}
	}

	@GetMapping(value = "/findById/{id}")
	public ResponseEntity<ResponseRest> findById(@PathVariable("id") Long id) {
		log.info(">>> init findById");
		Persona persona = new Persona();
		try {
			persona = service.findById(id);
			if (persona == null) {
				return this.getNotFoundRequest();
			}
			return getOkResponseConsulta(persona);
		} catch (CustomServiceException e) {
			log.error(">>> Error persona findById :\n {}", e.getMessage());
			return this.getInternalServerError();
		}

	}

	@PostMapping(value = "/save")
	public ResponseEntity<ResponseRest> save(@Validated @RequestBody Persona persona, BindingResult result) {
		log.info(">>> init save");
		if (result.hasErrors()) {
			return this.getBadRequest(result);
		}
		try {
			Persona obj = service.save(persona);
			return this.getCreatedResponse(obj, result);
		} catch (CustomServiceException e) {
			log.error(">>> Error persona save :\n {}", e.getMessage());
			return this.getInternalServerError();
		}
	}

	@PutMapping(value = "/update")
	public ResponseEntity<ResponseRest> update(@Validated @RequestBody Persona persona, BindingResult result) {
		log.info(">>> init update");
		try {
			Persona obj = service.update(persona);
			return this.getOkResponseRegistro(obj, result);
		} catch (CustomServiceException e) {
			log.error(">>> Error persona update : {}", e.getMessage());
			return this.getInternalServerError();
		}
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<ResponseRest> delete(@PathVariable("id") Long id) {
		log.info(">>> init delete");
		Persona obj = new Persona();
		try {
			obj = service.findById(id);
			if (obj != null && obj.getId() != null) {
				service.delete(id);
				return this.getOkResponseConsulta(obj);
			}
			return this.getNotFoundRequest();
		} catch (CustomServiceException e) {
			log.error(">>> Error persona delete : {}", e.getMessage());
			return this.getInternalServerError();
		}

	}

	@GetMapping(value = "/findByDocNumber/{numDoc}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseRest> findByDocNumber(@PathVariable("numDoc") String numDoc) {
		log.info(">>> execute findByDocNumber");
		Persona persona = new Persona();
		try {
			persona = service.findByDocNumber(numDoc);
			if (persona == null) {
				return this.getNotFoundRequest();
			}
			return getOkResponseConsulta(persona);
		} catch (CustomServiceException e) {
			log.error(">>> Error findByDocNumber:\n {}", e.getMessage());
			return this.getInternalServerError();
		}
	}

	@GetMapping(value = "/findByFullname/{fullName}")
	public ResponseEntity<ResponseRest> findByFullname(@PathVariable("fullName") String fullName) {
		log.info(">>> Execute findByFullname()");
		List<Persona> list = new LinkedList<>();
		try {
			list = service.findByFullname(fullName.toUpperCase());
			if (list.isEmpty()) {
				return this.getNotFoundRequest();
			}
			return this.getOkResponseConsulta(list);
		} catch (CustomServiceException e) {
			log.error(">>> Error findByFullname:\n {}", e.getMessage());
			return this.getInternalServerError();
		}
	}

	@GetMapping(value = "/findByTypeAndDocNumber/{typeDoc}/{numDoc}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseRest> findByTypeAndDocNumber(@PathVariable("typeDoc") String typeDoc,
			@PathVariable("numDoc") String numDoc) {
		log.info(">>> execute findByTypeAndDocNumber() ");
		Persona persona = new Persona();
		try {
			persona = service.findByTypeAndDocNumber(Long.parseLong(typeDoc), numDoc);
			if (persona == null) {
				return this.getNotFoundRequest();
			}
			return this.getOkResponseConsulta(persona);
		} catch (CustomServiceException e) {
			log.error(">>> Error findByTypeAndDocNumber:\n {}", e.getMessage());
			return this.getInternalServerError();
		}	
	}

}
