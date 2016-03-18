package com.pportillo.localiza.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pportillo.localiza.model.Telefono;

@Repository
public interface TelefonoRepository extends JpaRepository<Telefono,Integer>{

}
