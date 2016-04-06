package com.pportillo.localiza.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pportillo.localiza.model.entity.Persona;
import com.pportillo.localiza.model.entity.Telefono;
import com.pportillo.localiza.model.repository.PersonaRepository;
import com.pportillo.localiza.model.repository.TelefonoRepository;
import com.pportillo.localiza.service.PersonaService;

@Service(value="PersonaServiceImpl")
@Transactional
public class PersonaServiceImpl implements PersonaService
{

	@Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private TelefonoRepository telefonoRepository;
	
	@Override
	@Transactional(rollbackFor = Exception.class,readOnly=true)
	public Persona save(Persona entity) 
	{
		// TODO Auto-generated method stub
		Telefono tel = telefonoRepository.save(entity.getTelefono());
		entity.setTelefono(tel);
		return personaRepository.save(entity);
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		if(personaRepository.exists(id))
		{
			personaRepository.delete(id);
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public List<Persona> findAll() {
		// TODO Auto-generated method stub
		return personaRepository.findAll();
	}

	@Override
	public Persona buscarPersonaPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return personaRepository.findOneByNombreJPQL(nombre);
	}

	@Override
	public List<Persona> buscarListaPersonaPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return personaRepository.findAllBynombre(nombre);
	}

	@Override
	public Persona buscarPersonaPorNombreYApellido(String nombre, String apellido) {
		// TODO Auto-generated method stub
		return personaRepository.findOneByNombreAndApellido(nombre, apellido);
	}

	@Override
	public Persona buscarPersonaPorTelefono(String phone) {
		// TODO Auto-generated method stub
		return personaRepository.findOneByTelefonoJPQL(phone);
	}

}
