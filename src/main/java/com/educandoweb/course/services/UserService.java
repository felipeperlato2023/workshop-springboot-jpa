package com.educandoweb.course.services;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Service // Indica que esta classe é um componente de serviço do Spring
public class UserService {

	@Autowired
	private UserRepository repository;

	 // Método para buscar todos os usuários no banco de dados
	public List<User> findAll() {
		return repository.findAll();  // Chama o método findAll() do UserRepository para obter todos os usuários
	}
	
	 // Método para buscar um usuário por ID no banco de dados
	public User findById(long id)
	{
		java.util.Optional<User> obj = repository.findById(id); // Busca um usuário pelo ID no UserRepository
		return obj.get(); // Retorna o usuário encontrado (ou lança uma exceção se não for encontrado)
	}
	
	public User insert(User obj)
	{
		return repository.save(obj);
	}
	
	public void delete(Long id)
	{
		repository.deleteById(id);
	}
	
	public User update (Long id, User obj)
	{
		User entity = repository.getReferenceById(id);
		
		update(entity,obj);
		
		return repository.save(entity);
	}

	private void update(User entity, User obj) {
		// TODO Auto-generated method stub
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	
		
	}
}
