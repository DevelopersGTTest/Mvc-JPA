package com.example.app.models.service;

import java.util.List;

import com.example.app.models.entity.Cliente;

public interface IClienteService {
	
	//Listar los registros
		public List<Cliente> findAll();
		
		//Guardar un registo
		public void save(Cliente cliente);
		
		//Editar un registro
		public Cliente finOne(Long id);
		
		//Eliminar un registro
		public void eliminar(Long id);
}
