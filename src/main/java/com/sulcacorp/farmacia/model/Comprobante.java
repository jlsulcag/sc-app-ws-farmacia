package com.sulcacorp.farmacia.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "COMPROBANTE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comprobante {
	
	@Id
	@Column(name = "ID_COMPROBANTE", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqComprobante")
	@SequenceGenerator(name = "seqComprobante", sequenceName = "SEQ_COMPROBANTE", allocationSize = 1)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "ID_TIPO_DOC_COMPROBANTEE", nullable = false)
	private TipoDocComprobante tipoDocComprobante;
	
	@ManyToOne
	@JoinColumn(name = "ID_PERSONA", nullable = false)
	private Persona persona;
	
	@ManyToOne
	@JoinColumn(name = "ID_EMISOR", nullable = false)
	private Emisor emisor;
	
	@Column(name = "ID_TIPO_MONEDA", nullable = false)
	private Integer tipoModeda;
	
	@Column(name = "CORR_SERIE", nullable = false)
	private String corrSerie;
	
	@Column(name = "CORR_NUMERO", nullable = false)
	private Long corrNumeracion;
	
	@Column(name = "FECHA_EMISION", nullable = false)
	private LocalDate fechaEmision;
	
	@Column(name = "HORA_EMISION", nullable = false)
	private String horaEmision;
	
	@Column(name = "FIRMA_DIGITAL", nullable = true)
	private String firmaDigital;
	
	@Column(name = "TOT_VAL_VENT_OPE_GRAV", nullable = true)
	private BigDecimal totValventOpeGrav;
	
	@Column(name = "TOT_VAL_VENT_OPE_INAF", nullable = true)
	private BigDecimal totValventOpeInaf;
	
	@Column(name = "TOT_VAL_VENT_OPE_EXO", nullable = true)
	private BigDecimal totValventOpeExo;
	
	@Column(name = "TOT_VAL_VENT_OPE_GRAT", nullable = true)
	private BigDecimal totValVentOpeGrat;
	
	@Column(name = "TOT_DESC", nullable = true)
	private BigDecimal totDesc;
	
	@Column(name = "TOT_SUM_IGV", nullable = true)
	private BigDecimal totSumIgv;
	
	@Column(name = "TOT_SUM_ISC", nullable = true)
	private BigDecimal totSumIsc;
	
	@Column(name = "TOT_SUM_OTROS_TRIB", nullable = true)
	private BigDecimal totSumOtrosTrib;
	
	@Column(name = "TOT_DESC_GLOB", nullable = true)
	private BigDecimal tot_desc_global;
	
	@Column(name = "TOT_SUM_OTROS_CARG", nullable = true)
	private BigDecimal totSumOtrosCarg;
	
	@Column(name = "TOT_IMPORTE_VENTA", nullable = false)
	private BigDecimal totImporteVenta;
	
	@Column(name = "COD_INTER_FACT", nullable = true)
	private String codInterFact;
	
	@Column(name = "TIPO_OPER", nullable = true)
	private  String tipoOper;
	
	@Column(name = "LEYENDA", nullable = true)
	private String leyenda;
	
	@Column(name = "COD_RESP_HASH", nullable = true)
	private String codRespHash;
	
	@Column(name = "COD_RESP_CDR", nullable = true)
	private String codRespCdr;
	
	@Column(name = "COD_RESP_CDR_DESC", nullable = true)
	private String codRespCdrDesc;
	
	@Column(name = "COD_ENVIA_SUNAT", nullable = false)
	private String codEnviaSunat;
	
	@Column(name = "COD_RESP_ENVIO", nullable = true)
	private String codRespEnvio;
	
	@Column(name = "MOTIVO_ANULACION", nullable = true)
	private String motivoAnulacion;
	
	@Column(name = "ESTADO", nullable = false)
	private String estado;
	
	@OneToMany(mappedBy = "comprobante", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Where(clause = "estado='1'")
	private List<ComprobanteDetalle> items;
	

}
