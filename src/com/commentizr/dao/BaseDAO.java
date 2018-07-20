package com.commentizr.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Classe responsável por padronização das classes DAO.
 */
abstract class BaseDAO {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	protected NamedParameterJdbcTemplate getJdbc() {
		return this.jdbc;
	}
	
	protected SqlParameterSource nullParam = null;
	
}
