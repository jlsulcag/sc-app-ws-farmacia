package com.sulcacorp.farmacia.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "COMPROBANTE_DETALLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComprobanteDetalle {
	
	@Id
	@Column(name = "ID_COMPROBANTE_DETALLE", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqComprobanteDetalle")
	@SequenceGenerator(name = "seqComprobanteDetalle", sequenceName = "SEQ_COMPROBANTE_DETALLE", allocationSize = 1)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_COMPROBANTE", nullable = false)
	@JsonIgnore //Evitar redundancia ciclica
	private Comprobante comprobante;
	
	@ManyToOne
	@JoinColumn(name = "ID_PRODUCTO", nullable = false)
	private Producto producto;
	
	@Column(name = "ID_UNIDAD_MEDIDA", nullable = false)
	private Integer unidadMedida;
	
	@Column(name = "ID_TIPO_AFECTACION_IGV", nullable = false)
	private Integer tipoAfectacionIgv;
	
	@Column(name = "NRO_ORDEN_ITEM", nullable = false)
	private Integer nroOrdenItem;
	
	@Column(name = "CANT_ITEM", nullable = false)
	private BigDecimal cantItem;
	
	@Column(name = "VALOR_UNIT_ITEM", nullable = false)
	private BigDecimal valorUnitItem;
	
	@Column(name = "PRECIO_UNIT_ITEM", nullable = false)
	private BigDecimal precioUnitItem;
	
	@Column(name = "IGV_ITEM", nullable = false)
	private BigDecimal igvItem;
	
	@Column(name = "ISC_ITEM", nullable = false)
	private BigDecimal iscItem;
	
	@Column(name = "DESC_ITEM", nullable = false)
	private BigDecimal descItem;
	
	@Column(name = "VALOR_VENTA_TOTAL_ITEM", nullable = false)
	private BigDecimal valorVentaTotalItem;
	
	@Column(name = "ESTADO", nullable = false)
	private String estado;

}
