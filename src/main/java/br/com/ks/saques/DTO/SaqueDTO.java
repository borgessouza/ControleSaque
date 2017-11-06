package br.com.ks.saques.DTO;

import java.util.ArrayList;
import java.util.List;

import br.com.ks.saques.util.Notas;

public class SaqueDTO {

	private List<Double> notas100 = new ArrayList<Double>();

	private List<Double> notas50 = new ArrayList<Double>();

	private List<Double> notas20 = new ArrayList<Double>();

	private List<Double> notas10 = new ArrayList<Double>();

	private String RetornoNegativo;

	private SaqueDTO() {
	}

	public SaqueDTO(String retornoNegativo) {
		super();
		RetornoNegativo = retornoNegativo;
	}

	public SaqueDTO(List<Notas> notas) {
		for (Notas nota : notas) {
			if (nota.equals(Notas.NOTA100)) {
				notas100.add(nota.valor());
			} else if (nota.equals(Notas.NOTA50)) {
				notas50.add(nota.valor());
			} else if (nota.equals(Notas.NOTA20)) {
				notas20.add(nota.valor());
			} else if (nota.equals(Notas.NOTA10)) {
				notas10.add(nota.valor());
			}
		}
	}

	public String getNotas100() {
		StringBuilder notas = new StringBuilder();
		if (!notas100.isEmpty()) {
			notas.append("Recebendo: ");
			notas.append(notas100.size());
			notas.append(" nota(s) de ");
			notas.append(Notas.NOTA100.valor());
		}
		return notas.toString();
	}

	public void setNotas100(List<Double> notas100) {
		this.notas100 = notas100;
	}

	public String getNotas50() {
		StringBuilder notas = new StringBuilder();
		if (!notas50.isEmpty()) {
			notas.append("Recebendo: ");
			notas.append(notas50.size());
			notas.append(" nota(s) de ");
			notas.append(Notas.NOTA50.valor());
		}
		return notas.toString();
	}

	public void setNotas50(List<Double> notas50) {
		this.notas50 = notas50;
	}

	public String getNotas20() {
		StringBuilder notas = new StringBuilder();
		if (!notas20.isEmpty()) {
			notas.append("Recebendo: ");
			notas.append(notas20.size());
			notas.append(" nota(s) de ");
			notas.append(Notas.NOTA20.valor());
		}
		return notas.toString();
	}

	public void setNotas20(List<Double> notas20) {
		this.notas20 = notas20;
	}

	public String getNotas10() {
		StringBuilder notas = new StringBuilder();
		if (!notas10.isEmpty()) {
			notas.append("Recebendo: ");
			notas.append(notas10.size());
			notas.append(" nota(s) de ");
			notas.append(Notas.NOTA10.valor());
		}
		return notas.toString();
	}

	public void setNotas10(List<Double> notas10) {
		this.notas10 = notas10;
	}

	public String getRetornoNegativo() {
		return RetornoNegativo;
	}

}
