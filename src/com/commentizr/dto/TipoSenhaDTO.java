package com.commentizr.dto;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Classe responsável pelas informações do tipo da senha.
 */
public class TipoSenhaDTO extends BaseDTO {

	private Integer idTipoSenha;
	private String chvTipoSenha;
	private String dscTipoSenha;

	public static String CHV_SENHA_DA_CONTA = "ACC_PASS";
	public static String CHV_RECUPERACAO_CONTA = "ACC_RECV";
	public static String CHV_CONFIRMACAO_CONTA = "ACC_CONF";

	/**
	 * Construtor padrão.
	 */
	public TipoSenhaDTO() {
		super();
	}

	/**
	 * Construtor com a chave da senha.
	 */
	public TipoSenhaDTO(String chvTipoSenha) {
		this();
		this.chvTipoSenha = chvTipoSenha;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(48, 37).append(this.getChvTipoSenha()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != this.getClass()) {
			return false;
		}
		TipoSenhaDTO ins = (TipoSenhaDTO) obj;
		return new EqualsBuilder().append(this.getChvTipoSenha(), ins.getChvTipoSenha()).isEquals();
	}

	/**
	 * Obtém o tipo de senha em uma lista.
	 * @param tiposSenha Lista de tipos de senhas
	 * @param chvTipoSenha Chave do tipo da senha
	 * @return PasswordTypeDTO
	 */
	public static TipoSenhaDTO obterTipoSenha(List<TipoSenhaDTO> tiposSenha, String chvTipoSenha) {
		TipoSenhaDTO tipoSenha = null;

		int i = tiposSenha.indexOf(new TipoSenhaDTO(chvTipoSenha));
		if (i != -1) {
			tipoSenha = tiposSenha.get(i);
		}

		return tipoSenha;
	}

	/**
	 * Obtém o campo idTipoSenha.
	 * @return idTipoSenha
	 */
	public Integer getIdTipoSenha() {
		return this.idTipoSenha;
	}

	/**
	 * Especificao o campo idTipoSenha.
	 * @param idTipoSenha idTipoSenha
	 */
	public void setIdTipoSenha(Integer idTipoSenha) {
		this.idTipoSenha = idTipoSenha;
	}

	/**
	 * Obtém o campo chvTipoSenha.
	 * @return chvTipoSenha
	 */
	public String getChvTipoSenha() {
		return this.chvTipoSenha;
	}

	/**
	 * Especificao o campo chvTipoSenha.
	 * @param chvTipoSenha chvTipoSenha
	 */
	public void setChvTipoSenha(String chvTipoSenha) {
		this.chvTipoSenha = chvTipoSenha;
	}

	/**
	 * Obtém o campo dscTipoSenha.
	 * @return dscTipoSenha
	 */
	public String getDscTipoSenha() {
		return this.dscTipoSenha;
	}

	/**
	 * Especificao o campo dscTipoSenha.
	 * @param dscTipoSenha dscTipoSenha
	 */
	public void setDscTipoSenha(String dscTipoSenha) {
		this.dscTipoSenha = dscTipoSenha;
	}

}
