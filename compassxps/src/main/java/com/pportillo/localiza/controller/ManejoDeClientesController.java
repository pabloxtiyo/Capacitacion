package com.pportillo.localiza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.pportillo.localiza.model.Persona;
import com.pportillo.localiza.service.PersonaService;

@Controller
@RequestMapping("/Clientes")
public class ManejoDeClientesController 
{
	@Autowired
	private PersonaService PersonaServiceImpl;
	
	@RequestMapping(value="/Lista",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Persona> obtenerList()
	{
		return PersonaServiceImpl.findAll();
	}
	
}
