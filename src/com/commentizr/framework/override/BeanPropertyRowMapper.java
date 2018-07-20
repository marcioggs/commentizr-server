package com.commentizr.framework.override;

import java.beans.PropertyEditorSupport;

import org.joda.time.DateTime;
import org.springframework.beans.BeanWrapper;

/**
 * Classe responsável por adicioanr funcionalidades à classe BeanPropertyRowMapper do Spring.
 */
public class BeanPropertyRowMapper<T> extends org.springframework.jdbc.core.BeanPropertyRowMapper<T> {

	public BeanPropertyRowMapper() {
		super();
	}

	public BeanPropertyRowMapper(Class<T> mappedClass, boolean checkFullyPopulated) {
		super(mappedClass, checkFullyPopulated);
	}

	public BeanPropertyRowMapper(Class<T> mappedClass) {
		super(mappedClass);
	}

	@Override
	public void initBeanWrapper(BeanWrapper bw) {
		bw.registerCustomEditor(DateTime.class, new JodaDateTimeEditor());
	}

	/**
	 * Classe responsável por converter DateTime para uso pelo JdbcTemplate.
	 */
	private class JodaDateTimeEditor extends PropertyEditorSupport {

		/**
		 * Construtor padrão.
		 */
		public JodaDateTimeEditor() {
		}

		@Override
		public void setAsText(final String text) throws IllegalArgumentException {
			this.setValue(new DateTime(text));
		}

		@Override
		public void setValue(final Object value) {
			super.setValue((value == null) || (value instanceof DateTime) ? value
					: new DateTime(value));
		}

		@Override
		public DateTime getValue() {
			return (DateTime) super.getValue();
		}

		@Override
		public String getAsText() {
			return this.getValue().toString();
		}
	}
}
