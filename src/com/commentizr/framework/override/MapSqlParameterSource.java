package com.commentizr.framework.override;

import org.joda.time.DateTime;

/**
 * * Classe responsável por adicionar funcionalidades à classe MapSqlParameterSource do Spring.
 */
public class MapSqlParameterSource extends org.springframework.jdbc.core.namedparam.MapSqlParameterSource {

	/**
	 * Construtor padrão.
	 */
	public MapSqlParameterSource() {
		super();
	}

	@Override
	public org.springframework.jdbc.core.namedparam.MapSqlParameterSource addValue(String paramName, Object value) {

		if (value instanceof DateTime) {
			DateTime dateTime = (DateTime) value;
			return super.addValue(paramName, dateTime.toDate());
		}

		return super.addValue(paramName, value);
	}
}
