package com.sulcacorp.farmacia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "EMISOR")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emisor {

	@Id
	@Column(name = "ID_EMISOR", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEmisor")
	@SequenceGenerator(name = "seqEmisor", sequenceName = "SEQ_EMISOR", allocationSize = 1)
	private Long id;
	
	@Column(name = "NUMERO_RUC", nullable = false)
	private String numeroRuc;
	
	@Column(name = "NOMBRE_COMERCIAL", nullable = true)
	private String nombreComercial;
	
	@Column(name = "RAZON_SOCIAL", nullable = false)
	private String razonSocial;
	
	@Column(name = "VERS_UBL", nullable = false)
	private String versionUbl;
	
	@Column(name = "VERS_ESTRUC_DOC", nullable = true)
	private String versionEstrucDoc;
	
	@Column(name = "DOMICILIO_FISCAL", nullable = true)
	private String domicilioFiscal;
	
	@Column(name = "ESTADO", nullable = false)
	private String estado;
}
