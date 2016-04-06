package com.pportillo.localiza.service;


import java.util.List;

import com.pportillo.localiza.framework.GenericService;
import com.pportillo.localiza.model.entity.Persona;

public interface PersonaService extends GenericService<Persona>
{
	
	Persona buscarPersonaPorNombre(String nombre);
	List<Persona> buscarListaPersonaPorNombre(String nombre);
	Persona buscarPersonaPorNombreYApellido(String nombre,String apellido);
	Persona buscarPersonaPorTelefono(String phone);

}
