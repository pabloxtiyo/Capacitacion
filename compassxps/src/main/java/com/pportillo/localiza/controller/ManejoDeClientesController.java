package com.pportillo.localiza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.pportillo.localiza.model.Persona;
import com.pportillo.localiza.model.Telefono;
import com.pportillo.localiza.service.PersonaService;

@Controller
@RequestMapping("/Clientes")
public class ManejoDeClientesController 
{
	@Autowired()
	@Qualifier("PersonaServiceImpl")
	private PersonaService PersonaServiceImpl;
	
	@RequestMapping(value="/Lista",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Persona> obtenerList()
	{
		return PersonaServiceImpl.findAll();
	}
	
	@RequestMapping(value="/Guardar",method=RequestMethod.POST)
	public @ResponseBody String save(@RequestParam("nombre") String name)
	{
		Persona per = new Persona();
		per.setNombre("prueba3");
		per.setApellido("prueba3");
		Telefono tel = new Telefono();
		tel.setNumero("1111");
		tel.setTipo("phone2");
		per.setTelefono(tel);
		PersonaServiceImpl.save(per);
		return "ok";
	}
	

	@RequestMapping(value="/Buscar",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Persona buscarNombre(@RequestParam("tel") String tel)
	{
		return PersonaServiceImpl.buscarPersonaPorTelefono(tel);				
	}
	
}
