package com.educandoweb.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service // Indica que esta classe é um componente de serviço do Spring
public class UserService {

	@Autowired
	private UserRepository repository;

	// Método para buscar todos os usuários no banco de dados
	public List<User> findAll() {
		return repository.findAll(); // Chama o método findAll() do UserRepository para obter todos os usuários
	}

	// Método para buscar um usuário por ID no banco de dados
	public User findById(long id) {
		java.util.Optional<User> obj = repository.findById(id); // Busca um usuário pelo ID no UserRepository
		return obj.orElseThrow(() -> new ResourceNotFoundException(id)); // Retorna o usuário encontrado (ou lança uma
																			// exceção se não for encontrado)
	}

	public User insert(User obj) {
		return repository.save(obj);
	}

	public void delete(Long id)
	{
		try{
		repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
		
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}  

	public User update(Long id, User obj) {
		try {
		User entity = repository.getReferenceById(id);

		update(entity, obj);

		return repository.save(entity);
		}catch(EntityNotFoundException e) {
		
			throw new ResourceNotFoundException(id);
		}
		
	}

	private void update(User entity, User obj) {
		// TODO Auto-generated method stub
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());

	}
}
