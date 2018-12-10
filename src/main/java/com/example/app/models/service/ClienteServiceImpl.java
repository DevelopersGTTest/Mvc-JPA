package com.example.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.models.dao.IClienteDao;
import com.example.app.models.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService  {
	
	@Autowired
	private IClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Cliente> findAll() {
		return clienteDao.findAll();	
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		 clienteDao.save(cliente);
	}

	@Override
	@Transactional(readOnly=true)
	public Cliente finOne(Long id) {
		return clienteDao.finOne(id);
	}

	@Override
	@Transactional
	public void eliminar(Long id) {
		clienteDao.eliminar(id);
	}

}
