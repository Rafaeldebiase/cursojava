package com.rafaelbiase.cursojava.services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafaelbiase.cursojava.domain.Pedido;
import com.rafaelbiase.cursojava.repositories.PedidoRepository;
import com.rafaelbiase.cursojava.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> 
		new ObjectNotFoundException("Objeto não encontrado id: " + id 
				+ "Tipo: " + Pedido.class.getName()));
	}
	
	
}
