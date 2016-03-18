package com.pportillo.localiza.framework;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface GenericService <T> 
{

	
	public T save (T entity);
	public boolean delete (Integer id);
	public List<T> findAll();
	
}
