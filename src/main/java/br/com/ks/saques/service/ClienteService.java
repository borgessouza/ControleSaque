package br.com.ks.saques.service;

import java.util.List;

import br.com.ks.saques.DTO.ClienteDTO;
import br.com.ks.saques.model.Cliente;

public interface ClienteService {

	public List<ClienteDTO> recuperarTodosClientes();

	public ClienteDTO inserirCliente(ClienteDTO cliente);

	public void removerCliente(Long id);
	
	public ClienteDTO atualizarCliente(ClienteDTO cliente);
	
	public ClienteDTO encontrarCliente(String cliente);
	
	public Cliente encontrarCliente(Long id);

}
