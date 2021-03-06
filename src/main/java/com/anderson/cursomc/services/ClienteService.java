package com.anderson.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anderson.cursomc.domain.Cliente;
import com.anderson.cursomc.repositories.ClienteRepository;
import com.anderson.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Obejto não encontrado! Id:  " + id + ", Tipo: " + Cliente.class.getName()));
	}
}
