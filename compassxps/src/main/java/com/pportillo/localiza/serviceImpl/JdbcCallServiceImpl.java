package com.pportillo.localiza.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pportillo.localiza.model.repository.JdbCallRepository;
import com.pportillo.localiza.service.JdbCallService;

@Service
@Transactional
public class JdbcCallServiceImpl implements JdbCallService {
	@Resource
	private JdbCallRepository jdbCallRepository;

	@Override
	public Integer getValue(String usuario, String contrasena) throws Exception {
		// TODO Auto-generated method stub
		return jdbCallRepository.getValue(usuario, contrasena);
	}

}
