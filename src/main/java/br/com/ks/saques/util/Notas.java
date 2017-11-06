package br.com.ks.saques.util;

public enum Notas {
	
	NOTA100(100D), NOTA50(50D), NOTA20(20D), NOTA10(10D);

	private double valor;

	Notas(double valor) {
		this.valor = valor;
	}

	public double valor() {
		return valor;
	}

}
