package com.educandoweb.course.services;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;

@Service // Indica que esta classe é um componente de serviço do Spring
public class OrderService {

	@Autowired
	private OrderRepository repository;

	 // Método para buscar todos os usuários no banco de dados
	public List<Order> findAll() {
		return repository.findAll();  // Chama o método findAll() do UserRepository para obter todos os usuários
	}
	
	 // Método para buscar um usuário por ID no banco de dados
	public Order findById(long id)
	{
		java.util.Optional<Order> obj = repository.findById(id); // Busca um usuário pelo ID no OrderRepository
		return obj.get(); // Retorna o usuário encontrado (ou lança uma exceção se não for encontrado)
	}
}
