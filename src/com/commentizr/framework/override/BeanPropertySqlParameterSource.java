package com.commentizr.framework.override;

import org.joda.time.DateTime;

/**
 * Classe responsável por adicionar funcionalidades à classe BeanPropertySqlParameterSource do Spring.
 */
public class BeanPropertySqlParameterSource extends
		org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource {

	/**
	 * Construtor.
	 */
	public BeanPropertySqlParameterSource(Object object) {
		super(object);
	}

	@Override
	public Object getValue(String paramName) {
		Object result = super.getValue(paramName);

		if ((result != null) && (result instanceof DateTime)) {
			return ((DateTime) result).toDate();
		}

		return result;
	}
}
