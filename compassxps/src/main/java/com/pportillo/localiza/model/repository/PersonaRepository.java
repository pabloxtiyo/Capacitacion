package com.pportillo.localiza.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pportillo.localiza.model.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> 
{

	/*Convenciones SPRING DATA*/
	
	Persona findOneBynombre(String nombre);
	List<Persona> findAllBynombre(String nombre);
	Persona findOneByNombreAndApellido(String nombre,String apellido);
	Persona findOneBytelefono_numero(String numero);
	
	@Query("select p from Persona p where p.nombre = (:nombre)")
	Persona findOneByNombreJPQL(@Param("nombre")String nombre);
	
	@Query("select p from Persona p where p.telefono.numero = (:tel)")
	Persona findOneByTelefonoJPQL(@Param("tel")String tel);
	
}
