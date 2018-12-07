package com.example.app.models.dao;

import java.util.List;
import com.example.app.models.entity.Cliente;

public interface IClienteDao {

	public List<Cliente> findAll();
}
