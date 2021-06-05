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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TIPO_DOC_IDENTIDAD")
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class TipoDocIdentidad extends GenericModel{

	@Id
	@Column(name = "ID_TIPO_DOC_IDENTIDAD", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqTipoDocidentidad")
	@SequenceGenerator(name = "seqTipoDocidentidad", sequenceName = "SEQ_TIPO_DOC_IDENTIDAD", allocationSize = 1)
	private Long id;
	
	@Size(min = 1, max = 2, message = "Código Sunat es requerido y debe tener mínimo 1 y máximo 2 caracteres")
	@Column(name = "CODIGO_SUNAT", nullable = false, length = 2)
	private String codigoSunat;
	
	@Size(min = 5, max = 50, message = "Tipo Documento de Identidad es requerido y debe tener mínimo 5 y máximo 50 caracteres")
	@Column(name = "DESCRIPCION", nullable = false, length = 50)
	private String descripcion;
	
	@Size(min = 2, max = 20, message = "Abreviatura es requerido y debe tener mínimo 2 y máximo 20 caracteres")
	@Column(name = "ABREVIATURA", nullable = false, length = 20)
	private String abreviatura;
	
}
