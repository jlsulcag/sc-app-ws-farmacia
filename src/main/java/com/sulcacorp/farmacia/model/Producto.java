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
@Table(name = "PRODUCTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
	
	@Id
	@Column(name = "ID_PRODUCTO", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqProducto")
	@SequenceGenerator(name = "seqProducto", sequenceName = "SEQ_PRODUCTO", allocationSize = 1)
	private Long id;
	
	@Column(name = "COD_PROD", nullable = true)
	private String codProd;
	
	@Column(name = "COD_PROD_SUNAT", nullable = true)
	private String codProdSunat;
	
	@Column(name = "DESC_PROD", nullable = false)
	private String descProd;
	
	@Column(name = "PRECIO", nullable = false)
	private String precio;
	
	@Column(name = "CANT_STOCK", nullable = false)
	private Integer cantStock;
	
	@Column(name = "ESTADO", nullable = false)
	private String estado;

}
