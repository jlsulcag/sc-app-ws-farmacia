package com.sulcacorp.farmacia.dto;

import java.time.LocalDate;

import javax.validation.constraints.Size;

import com.sulcacorp.farmacia.model.TipoDocIdentidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO {

	private Long id;
	
	@Size(min = 3, max = 150, message = "La especialidad es requerida y debe tener minimo 3 y maximo  150 caracteres") 
	private Integer tipoPersona;
	
	private TipoDocIdentidad tipoDocIdentidad;
	
	private Integer estadoCivil;
	
	private String apePaterno;
	
	private String apeMaterno;
	
	private String nombres;
	
	private String numeroDoc;
	
	private LocalDate fecNacimiento;
	
	private String sexo;
	
	private String direccion;
	
	private String telefono;
	
	private String correoElet;
	
	private String estado;
	
}
