package com.gvendas.gestaovendas.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gvendas.gestaovendas.entidades.Cliente;
import com.gvendas.gestaovendas.excecao.RegraDeNegocioException;
import com.gvendas.gestaovendas.repositorio.ClienteRepositorio;

@Service
public class ClienteServico {

	@Autowired
	private ClienteRepositorio clienteRepositorio;

	public List<Cliente> listarTodos() {
		return clienteRepositorio.findAll();
	}

	public Optional<Cliente> buscarPorCodigo(Long codigo) {
		return clienteRepositorio.findById(codigo);
	}

	public Cliente salvar(Cliente cliente) {
		validarClienteDuplicado(cliente);
		return clienteRepositorio.save(cliente);
	}

	public Cliente atualizar(Long codigo, Cliente cliente) {
		Cliente clienteAtualizar = validarClienteExiste(codigo);
		validarClienteDuplicado(cliente);
		BeanUtils.copyProperties(cliente, clienteAtualizar, "codigo");
		return clienteRepositorio.save(clienteAtualizar);
	}

	public void deletar(Long codigo) {
		clienteRepositorio.deleteById(codigo);;
	}
	private void validarClienteDuplicado(Cliente cliente) {
		Cliente clientePorNome = clienteRepositorio.findByNome(cliente.getNome());
		if (clientePorNome != null && clientePorNome.getCodigo() != cliente.getCodigo()) {
			throw new RegraDeNegocioException(
					String.format("O Cliente de nome %s já esta cadastrado.", cliente.getNome().toUpperCase()));
		}
	}

	private Cliente validarClienteExiste(Long codigo) {
		Optional<Cliente> cliente = buscarPorCodigo(codigo);
		if (cliente.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return cliente.get();
	}
}
