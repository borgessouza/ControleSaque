package br.com.ks.saques.controllers.rest;

import br.com.ks.saques.DTO.ClienteDTO;
import br.com.ks.saques.DTO.SaqueDTO;
import br.com.ks.saques.service.ClienteService;
import br.com.ks.saques.service.SaqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SaqueController {

	private static final int maxUsuariosLogados = 5;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private SaqueService saqueService;
	
	private static List<String> logados = new ArrayList<String>(); 

	@RequestMapping(value = "login2", method = RequestMethod.GET)
	public ResponseEntity<ClienteDTO> login(@RequestParam("id") String usuario) {

		ClienteDTO clienteDTO = clienteService.encontrarCliente(usuario);
		if ( logados.size() >= maxUsuariosLogados ) {
			return new ResponseEntity<ClienteDTO>(new ClienteDTO("Quantidade Maxima de Usuários alcançada"), HttpStatus.UNAUTHORIZED);
		}  else if ( clienteDTO != null) {
			logados.add(usuario.toUpperCase());
			return new ResponseEntity<ClienteDTO>(clienteDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<ClienteDTO>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "realSaque", method = RequestMethod.PATCH)
	public ResponseEntity<SaqueDTO> realizarSaque(@RequestParam("valorSaque") Double valorSaque,
			@RequestParam("valorDisponivel") Double valorDisponivel, @RequestParam("id") Long id) {

		if (!saqueService.validarCliente(valorDisponivel, id)) {
			return new ResponseEntity<SaqueDTO>(new SaqueDTO("Cliente Invalido"), HttpStatus.UNAUTHORIZED);
		}

		if (valorSaque <= valorDisponivel) {
			return new ResponseEntity<SaqueDTO>(new SaqueDTO(saqueService.executaSaque(clienteService.encontrarCliente(id),valorSaque)), HttpStatus.OK);
		} else {
			return new ResponseEntity<SaqueDTO>(new SaqueDTO("Recursos Insuficientes"), HttpStatus.UNAUTHORIZED);
		}
	}
	
	@RequestMapping(value = "deslogar", method = RequestMethod.POST)
	public void deslogar(@RequestParam("usuario") String usuario) {
		logados.remove(usuario.toUpperCase());
	}

}
