package br.com.ks.saques.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.ks.saques.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	
	public Cliente findByUsuarioContainingIgnoreCase(String usuario);

}
