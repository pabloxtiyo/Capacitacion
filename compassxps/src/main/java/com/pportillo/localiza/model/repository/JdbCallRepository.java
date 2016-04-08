package com.pportillo.localiza.model.repository;


import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository
public class JdbCallRepository {
	
	private SimpleJdbcCall getLogin;
	
	@Autowired
	public void setDataSourse(DataSource dataSource)
	{
		this.getLogin = new SimpleJdbcCall(dataSource)
		.withProcedureName("login_user");
		
	}	
	
	public Integer getValue(String usuario, String contrasena)
	{
		SqlParameterSource in = new MapSqlParameterSource().addValue("sts_username",usuario);
		Map<String, Object> out = getLogin.execute(in);
		Object outs = out.get("#result-set-1");
		String valoresArr = outs.toString();
		String values = valoresArr.substring(9, 10);
		return Integer.valueOf(values);
		
	}

}
