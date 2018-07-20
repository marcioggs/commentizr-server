package com.commentizr.dto;

import org.joda.time.DateTime;

/**
 * Classe responsável pelas informações do usuário.
 */
public class UsuarioDTO extends BaseDTO {

	private Integer idUsuario;
	private String nmeConta;
	private String dscEmail;
	private String nmeExibicao;
	private DateTime datCriacaoUsuario;
	private Boolean flgContaConfirmada;
	private SenhaUsuarioDTO senhaConta;
	private SenhaUsuarioDTO senhaConfirmacaoConta;
	private SenhaUsuarioDTO senhaRecuperacaoConta;

	/**
	 * Inicializa com os valores de um novo usuário.
	 */
	public void inicializarNovoUsuario() {
		this.setDatCriacaoUsuario(new DateTime());
		this.setFlgContaConfirmada(false);
	}

	/**
	 * Obtém o campo idUsuario.
	 * @return idUsuario
	 */
	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	/**
	 * Especificao o campo idUsuario.
	 * @param idUsuario idUsuario
	 */
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * Obtém o campo nmeConta.
	 * @return nmeConta
	 */
	public String getNmeConta() {
		return this.nmeConta;
	}

	/**
	 * Especificao o campo nmeConta.
	 * @param nmeConta nmeConta
	 */
	public void setNmeConta(String nmeConta) {
		this.nmeConta = nmeConta;
	}

	/**
	 * Obtém o campo dscEmail.
	 * @return dscEmail
	 */
	public String getDscEmail() {
		return this.dscEmail;
	}

	/**
	 * Especificao o campo dscEmail.
	 * @param dscEmail dscEmail
	 */
	public void setDscEmail(String dscEmail) {
		this.dscEmail = dscEmail;
	}

	/**
	 * Obtém o campo nmeExibicao.
	 * @return nmeExibicao
	 */
	public String getNmeExibicao() {
		return this.nmeExibicao;
	}

	/**
	 * Especificao o campo nmeExibicao.
	 * @param nmeExibicao nmeExibicao
	 */
	public void setNmeExibicao(String nmeExibicao) {
		this.nmeExibicao = nmeExibicao;
	}

	/**
	 * Obtém o campo datCriacaoUsuario.
	 * @return datCriacaoUsuario
	 */
	public DateTime getDatCriacaoUsuario() {
		return this.datCriacaoUsuario;
	}

	/**
	 * Especificao o campo datCriacaoUsuario.
	 * @param datCriacaoUsuario datCriacaoUsuario
	 */
	public void setDatCriacaoUsuario(DateTime datCriacaoUsuario) {
		this.datCriacaoUsuario = datCriacaoUsuario;
	}

	/**
	 * Obtém o campo flgContaConfirmada.
	 * @return flgContaConfirmada
	 */
	public Boolean getFlgContaConfirmada() {
		return this.flgContaConfirmada;
	}

	/**
	 * Especificao o campo flgContaConfirmada.
	 * @param flgContaConfirmada flgContaConfirmada
	 */
	public void setFlgContaConfirmada(Boolean flgContaConfirmada) {
		this.flgContaConfirmada = flgContaConfirmada;
	}

	/**
	 * Obtém o campo senhaConta.
	 * @return senhaConta
	 */
	public SenhaUsuarioDTO getSenhaConta() {
		return this.senhaConta;
	}

	/**
	 * Especificao o campo senhaConta.
	 * @param senhaConta senhaConta
	 */
	public void setSenhaConta(SenhaUsuarioDTO senhaConta) {
		this.senhaConta = senhaConta;
	}

	/**
	 * Obtém o campo senhaConfirmacaoConta.
	 * @return senhaConfirmacaoConta
	 */
	public SenhaUsuarioDTO getSenhaConfirmacaoConta() {
		return this.senhaConfirmacaoConta;
	}

	/**
	 * Especificao o campo senhaConfirmacaoConta.
	 * @param senhaConfirmacaoConta senhaConfirmacaoConta
	 */
	public void setSenhaConfirmacaoConta(SenhaUsuarioDTO senhaConfirmacaoConta) {
		this.senhaConfirmacaoConta = senhaConfirmacaoConta;
	}

	/**
	 * Obtém o campo senhaRecuperacaoConta.
	 * @return senhaRecuperacaoConta
	 */
	public SenhaUsuarioDTO getSenhaRecuperacaoConta() {
		return this.senhaRecuperacaoConta;
	}

	/**
	 * Especificao o campo senhaRecuperacaoConta.
	 * @param senhaRecuperacaoConta senhaRecuperacaoConta
	 */
	public void setSenhaRecuperacaoConta(SenhaUsuarioDTO senhaRecuperacaoConta) {
		this.senhaRecuperacaoConta = senhaRecuperacaoConta;
	}

}
