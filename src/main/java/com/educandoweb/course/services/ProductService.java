package com.educandoweb.course.services;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;

@Service // Indica que esta classe é um componente de serviço do Spring
public class ProductService {

	@Autowired
	private ProductRepository repository;

	 // Método para buscar todos os usuários no banco de dados
	public List<Product> findAll() {
		return repository.findAll();  // Chama o método findAll() do ProductRepository para obter todos os usuários
	}
	
	 // Método para buscar um usuário por ID no banco de dados
	public Product findById(long id)
	{
		java.util.Optional<Product> obj = repository.findById(id); // Busca um usuário pelo ID no ProductRepository
		return obj.get(); // Retorna o usuário encontrado (ou lança uma exceção se não for encontrado)
	}
}
