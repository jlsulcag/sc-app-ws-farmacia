package com.sulcacorp.farmacia.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PERSONA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
	
	@Id
	@Column(name = "ID_PERSONA", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPersona")
	@SequenceGenerator(name = "seqPersona", sequenceName = "SEQ_PERSONA", allocationSize = 1)
	private Long id;
	
	@Column(name = "ID_TIPO_PERSONA", nullable = false)
	private Integer tipoPersona;
	
	@ManyToOne
	@JoinColumn(name = "ID_TIPO_DOC_IDENTIDAD", nullable = false)
	private TipoDocIdentidad tipoDocIdentidad;
	
	@Column(name = "ID_ESTADO_CIVIL", nullable = true)
	private Integer estadoCivil;
	
	@Column(name = "APE_PATERNO", nullable = false)
	private String apePaterno;
	
	@Column(name = "APE_MATERNO", nullable = false)
	private String apeMaterno;
	
	@Column(name = "NOMBRES", nullable = false)
	private String nombres;
	
	@Column(name = "NUMERO_DOC", nullable = false)
	private String numeroDoc;
	
	@Column(name = "FEC_NACIMIENTO", nullable = true)
	private LocalDate fecNacimiento;
	
	@Column(name = "SEXO", nullable = false)
	private String sexo;
	
	@Column(name = "DIRECCION", nullable = true)
	private String direccion;
	
	@Column(name = "TELEFONO", nullable = true)
	private String telefono;
	
	@Column(name = "CORREO_ELECT", nullable = true)
	private String correoElect;
	
	@Column(name = "ESTADO", nullable = false)
	private String estado;

}
