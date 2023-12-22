package com.educandoweb.course.resources;

import java.security.Provider.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;

@RestController // Anotação indicando que esta classe é um controlador REST do Spring
@RequestMapping(value = "/users") // Mapeia o caminho base para todas as requisições HTTP para este controlador
public class UserResource {
	
	
	@Autowired
	private UserService service;
	@GetMapping //esta anotação indica que o método findAll()responderá às solicitações HTTP GET 
	                                             //direcionadas à raiz do endpoint associado a este controlador.
	public ResponseEntity<List<User>> findAll(){
     
		List<User> list = service.findAll(); // Chama o método findAll() do UserService para obter todos os usuários
		
		return ResponseEntity.ok().body(list);
}
	@GetMapping(value = "/{id}") //esta anotação indica que o método findById()responderá às solicitações HTTP GET direcionadas a um endpoint que espera um parâmetro idna URL.
	public ResponseEntity<User> findById(@PathVariable  Long id) //Este método é responsável por pesquisar um usuário pelo seu ID. 
	{
		User obj = service.findById(id); // Aqui é chamado o método findById()de serviço UserService, passando o ID obtido como parâmetro, para buscar um usuário específico.
		return ResponseEntity.ok().body(obj); //O corpo da resposta contém o usuário encontrado pelo seu ID.
	}
}
