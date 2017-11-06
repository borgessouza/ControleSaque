package br.com.ks.saques.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ks.saques.DTO.ClienteDTO;
import br.com.ks.saques.service.ClienteService;

/**
 * @author cassiano
 *
 */

@RestController
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	/**
	 * @return
	 */
	@RequestMapping(value = "recuperarTodos", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<ClienteDTO>> recuperarTodosClientes() {
		return new ResponseEntity<>(clienteService.recuperarTodosClientes(),HttpStatus.OK);
	}

	/**
	 * @param cliente
	 * @return
	 */
	@RequestMapping(value = "cadastroCliente", method = RequestMethod.POST)
	public ResponseEntity<ClienteDTO> cadastroCliente(@RequestBody ClienteDTO cliente) {
		return new ResponseEntity<>(clienteService.inserirCliente(cliente),HttpStatus.OK);
	}

	@RequestMapping(value = "removerCliente/{id}", method = RequestMethod.DELETE)
	public ResponseEntity removerCliente(@PathVariable("id") Long id) {
			clienteService.removerCliente(id);
			return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value = "atualizarCliente", method = RequestMethod.PATCH)
	public ResponseEntity<ClienteDTO> atualizarCliente(@RequestBody ClienteDTO cliente) {
		return new ResponseEntity<>(clienteService.atualizarCliente(cliente),HttpStatus.OK);
		
	}

}
