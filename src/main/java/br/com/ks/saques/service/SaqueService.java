package br.com.ks.saques.service;

import java.util.List;

import br.com.ks.saques.model.Cliente;
import br.com.ks.saques.util.Notas;

public interface SaqueService {

	public List<Notas> executaSaque(Cliente cliente, Double valorSaque);

	public Boolean validarCliente(Double valorDisponivel, Long id);
	
	public List<Notas> recuperaNotas(Double valorSaque);

}
