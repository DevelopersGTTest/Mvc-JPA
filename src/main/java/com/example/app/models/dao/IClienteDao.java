package com.example.app.models.dao;

import java.util.List;
import com.example.app.models.entity.Cliente;

public interface IClienteDao {
	
	//Listar los registros
	public List<Cliente> findAll();
	
	//Guardar un registo
	public void save(Cliente cliente);
	
	//Editar un registro
	public Cliente finOne(Long id);
	
}
