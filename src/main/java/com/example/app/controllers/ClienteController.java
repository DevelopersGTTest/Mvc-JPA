package com.example.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.example.app.models.dao.IClienteDao;
import com.example.app.models.entity.Cliente;

@Controller
public class ClienteController {
	
	@Autowired
	private IClienteDao clienteDao;
	
	@RequestMapping(value="listar" , method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "listado clientes");
		model.addAttribute("clientes", clienteDao.findAll());
		return "listar";
	}
	
	//Procesando los datos del formulario
	@RequestMapping(value="/form")
	public String crear(Map<String, Object> model ) {
		
		Cliente cliente = new Cliente();
		model.put("cliente", cliente);
		model.put("titulo", "Formulario para insertar");
		return "form";
	}
	
	
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String guardar(Cliente cliente) {
		clienteDao.save(cliente);
		return "redirect:listar";
	}
}