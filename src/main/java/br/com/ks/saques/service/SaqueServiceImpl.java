package br.com.ks.saques.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ks.saques.model.Cliente;
import br.com.ks.saques.repositories.ClienteRepository;
import br.com.ks.saques.util.Notas;

@Service
public class SaqueServiceImpl implements SaqueService {

	@Autowired
	private ClienteRepository clienteRepository;

	public double calculaDivisao(double dividendo, double divisor) {
		return dividendo / divisor;
	}

	public double calculaResto(double dividendo, double divisor) {
		return dividendo % divisor;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public List<Notas> executaSaque(Cliente cliente, Double valorSaque) {

		Double valorAtual = cliente.getValor();
		cliente.setValor(valorAtual - valorSaque);
		clienteRepository.save(cliente);

		return recuperaNotas(valorSaque);

	}
	
	
	@Override
	public List<Notas> recuperaNotas(Double valorSaque) {
		List<Notas> notas = new ArrayList<Notas>();
		Double divisao = 0D;
		Double resto = 0D;

		for (Notas nota : Notas.values()) {

			divisao = calculaDivisao(valorSaque, nota.valor());
			resto = calculaResto(valorSaque, nota.valor());
			if (resto == 0) {
				for (int i = 0; i < divisao.intValue(); i++)
					notas.add(nota);
				break;
			} else {
				for (int i = 0; i < divisao.intValue(); i++)
					notas.add(nota);
			}
			valorSaque = resto;
		}

		return notas;
	}

	/**
	 * Metodo responsavel por validar cliente antes do saque
	 */
	@Override
	public Boolean validarCliente(Double valorDisponivel, Long id) {
		Cliente clienteValidacao = clienteRepository.findOne(id);

		/**
		 * Realiza validacao do valor disponivel com o valor enviado pela tela
		 */
		if (clienteValidacao != null && clienteValidacao.getValor().equals(valorDisponivel)) {
			return true;
		}
		return false;
	}
}
