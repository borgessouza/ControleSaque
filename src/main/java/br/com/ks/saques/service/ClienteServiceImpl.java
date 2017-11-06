package br.com.ks.saques.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ks.saques.DTO.ClienteDTO;
import br.com.ks.saques.model.Cliente;
import br.com.ks.saques.repositories.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<ClienteDTO> recuperarTodosClientes() {

		List<ClienteDTO> clientes = new ArrayList<>();
		for (Cliente cliente : clienteRepository.findAll()) {
			clientes.add(new ClienteDTO(cliente.getId(), cliente.getUsuario(), cliente.getNome(), cliente.getValor()));
		}
		return clientes;
	}

	@Override
	public ClienteDTO inserirCliente(ClienteDTO clienteDTO) {
		Cliente cliente =  clienteRepository.save(new Cliente(clienteDTO.getUsuario(), clienteDTO.getNome(), clienteDTO.getValor()));
		return new ClienteDTO(cliente.getId(), cliente.getUsuario(),cliente.getNome(), cliente.getValor());
	}

	@Override
	public void removerCliente(Long id) {
		Cliente cliente = new Cliente();
		cliente.setId(id);
		clienteRepository.delete(cliente);
	}

	@Override
	public ClienteDTO atualizarCliente(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();
		cliente.setId(clienteDTO.getId());

		clienteRepository.findOne(cliente.getId());
		cliente.setUsuario(clienteDTO.getUsuario());
		cliente.setNome(clienteDTO.getNome());
		cliente.setValor(clienteDTO.getValor());
		clienteRepository.save(cliente);
		return new ClienteDTO(cliente.getId(), cliente.getUsuario(), cliente.getNome(),cliente.getValor());

	}

	@Override
	public ClienteDTO encontrarCliente(String usuarioCliente) {

		Cliente cliente = clienteRepository.findByUsuarioContainingIgnoreCase(usuarioCliente);

		if (cliente != null) {
			return new ClienteDTO(cliente.getId(), cliente.getUsuario(), cliente.getNome(), cliente.getValor());
		}
		return null;
	}

	@Override
	public Cliente encontrarCliente(Long id) {
		return clienteRepository.findOne(id);
		
	}

}
