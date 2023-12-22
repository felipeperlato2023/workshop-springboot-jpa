package com.educandoweb.course.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user") //indica que deve ser criado essa classe em tabela de bd.
public class User implements Serializable {  //Isso indica que a classe `User` pode ser serializada
	                                         //ou seja, seus objetos podem ser convertidos em uma sequência de bytes para serem armazenados ou transferidos.

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //define o atributo id com chave primaria
	private Long id;
	private String name;
	private String email;
	private String password;
	private String phone;
	
	@JsonIgnore //Anotação para ignorar a serialização/desserialização do campo "orders" ao converter objetos para JSON
	@OneToMany(mappedBy = "Client") // "Client": este atributo mappedByespecifica o nome do campo na classe Order que representa o relacionamento inverso (ou seja, a referência à entidade atual).
	private List<Order> orders = new ArrayList<>(); // Esta lista representa o  conjunto de pedidos associados a esta entidade. A anotação @OneToManyindica que esta lista conterá vários objetos do tipo Order.

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Order> getOrders() {
		return orders;

	}

	public User() {
		super();
	}

	public User(Long id, String name, String email, String password, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

}
