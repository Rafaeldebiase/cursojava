package com.rafaelbiase.cursojava.services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafaelbiase.cursojava.domain.Cliente;
import com.rafaelbiase.cursojava.repositories.ClienteRepository;
import com.rafaelbiase.cursojava.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> 
		new ObjectNotFoundException("Objeto não encontrado id: " + id 
				+ "Tipo: " + Cliente.class.getName()));
	}
	
	
}
