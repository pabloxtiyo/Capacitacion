package com.pportillo.localiza.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pportillo.localiza.model.Persona;
import com.pportillo.localiza.model.repository.PersonaRepository;
import com.pportillo.localiza.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService
{

	@Autowired
	private PersonaRepository personaRepository;
	
	@Override
	public Persona save(Persona entity) {
		// TODO Auto-generated method stub
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

}
