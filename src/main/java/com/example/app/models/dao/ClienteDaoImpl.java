package com.example.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Repository;
import com.example.app.models.entity.Cliente;

@Repository
public class ClienteDaoImpl implements IClienteDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Cliente").getResultList();	
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		if(cliente.getId() != null && cliente.getId() >= 0  ) {
			em.merge(cliente);
		}else {
			em.persist(cliente);
		}
	}

	@Override
	public Cliente finOne(Long id) {
		return em.find(Cliente.class, id);
	}

	@Override
	@Transactional
	public void eliminar(Long id) {
		Cliente cliente = finOne(id);
		em.remove(cliente);
	}
	
}
