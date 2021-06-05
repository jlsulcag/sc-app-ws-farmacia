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

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TIPO_DOC_COMPROBANTE")
@Entity
public class TipoDocComprobante extends GenericModel{

	@Id
	@Column(name = "ID_TIPO_DOC_COMPROBANTE", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeqTipoDocComprobante")
	@SequenceGenerator(name = "SeqTipoDocComprobante", allocationSize = 1, sequenceName = "SEQ_TIPO_DOC_COMPROBANTE")
	private Long id;
	
	@Size(min = 1, max = 2, message = "El Código Sunat es requerido y debe tener minimo 1 y máximo  2 caracteres")
	@Column(name = "CODIGO_SUNAT", nullable = false, length = 2)
	private String codigoSunat;
	
	
	@Size(min = 2, max = 150, message = "El Tipo Comprobante es requerido y debe tener minimo 2 y maximo  150 caracteres")
	@Column(name = "DESCRIPCION", nullable = false, length = 150)
	private String descripcion;
	
	//@NotBlank(message = "El Grupo Numeración es requerido")
	@Column(name = "GRUPO_NUMERACION", nullable = false)
	private Integer grupoNumeracion;
	
}
