package com.sulcacorp.farmacia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sulcacorp.farmacia.model.generic.GenericModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ESTADO_CIVIL")
@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"id", "descripcion", "estado"})
public class EstadoCivil extends GenericModel{
	
	@Id
	@Column(name = "ID_ESTADO_CIVIL")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeqEstadoCivil")
	@SequenceGenerator(name = "SeqEstadoCivil", sequenceName = "SEQ_ESTADO_CIVIL", allocationSize = 1)
	private Long id=0L;
	
	@Size(min = 3, max = 30, message = "La especialidad es requerida y debe tener minimo 3 y maximo  30 caracteres")
	@Column(name = "DESCRIPCION", nullable = false, length = 30)
	private String descripcion;
	

}
