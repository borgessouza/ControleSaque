package br.com.ks.saques.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Saque {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Double valor;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataSaque;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}


	public Calendar getDataSaque() {
		return dataSaque;
	}

	public void setDataSaque(Calendar dataSaque) {
		this.dataSaque = dataSaque;
	}

}
