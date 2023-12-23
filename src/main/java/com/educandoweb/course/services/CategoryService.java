package com.educandoweb.course.services;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;

@Service // Indica que esta classe é um componente de serviço do Spring
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	 
	public List<Category> findAll() {
		return repository.findAll();  // Chama o método findAll() do UserRepository para obter todos as categorias
	}
	
	 // Método para buscar uma category por ID no banco de dados
	public Category findById(long id)
	{
		java.util.Optional<Category> obj = repository.findById(id); // Busca um usuário pelo ID no CategoryRepository
		return obj.get(); // Retorna a categoria encontrado (ou lança uma exceção se não for encontrado)
	}
}
