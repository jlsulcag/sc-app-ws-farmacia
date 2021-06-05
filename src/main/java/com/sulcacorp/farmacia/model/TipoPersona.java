package com.sulcacorp.farmacia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sulcacorp.farmacia.model.generic.GenericModel;

@Entity
@Table(name = "TIPO_PERSONA")
public class TipoPersona extends GenericModel{

	@Id
	@Column(name = "ID_TIPO_PERSONA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeqTipoPersona")
	@SequenceGenerator(name = "SeqTipoPersona", allocationSize = 1, sequenceName = "SEQ_TIPO_PERSONA")
	private Long id;
	
	@Size(min = 5, max = 100, message = "Descripción es requerido y debe tener mínimo 1 y máximo 100 caracteres")
	@Column(name = "DESCRIPCION", nullable = false, length = 100)
	private String descripcion;
	
}
