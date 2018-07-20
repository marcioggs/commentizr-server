package com.commentizr.dto;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.DateTime;

/**
 * Classe responsável pelas informações da senha do usuário.
 */
public class SenhaUsuarioDTO extends BaseDTO {
	
	private Integer idSenhaUsuario;
	private TipoSenhaDTO tipoSenha;
	private String dscSenha;
	private String dscConfirmacaoSenha;
	private String dscSaltSenha;
	private String dscHashSenha;
	private DateTime datCriacaoSenha;
	private Boolean flgSenhaExpirada;
	
	public static Integer TAMANHO_SALT_SENHA = 16;
	public static Integer TAMANHO_SENHA_GERADA = 8;
	
	/**
	 * Inicializa com os valores de uma nova senha.
	 */
	public void inicializarNovaSenha() {
		this.setDatCriacaoSenha(new DateTime());
		this.setFlgSenhaExpirada(false);
	}
	
	/**
	 * Gera o salt da senha.
	 */
	public void gerarSaltSenha() {
		String saltSenha = RandomStringUtils.randomAlphanumeric(SenhaUsuarioDTO.TAMANHO_SALT_SENHA);
		this.setDscSaltSenha(saltSenha);
	}
	
	/**
	 * Criptografa a senha.
	 */
	public void criptografarSenha() {
		String hashSenha = DigestUtils.sha256Hex(this.getDscSenha().concat(this.getDscSaltSenha()));
		this.setDscHashSenha(hashSenha);
	}
	
	/**
	 * Obtém o campo idSenhaUsuario.
	 * @return idSenhaUsuario
	 */
	public Integer getIdSenhaUsuario() {
		return this.idSenhaUsuario;
	}
	
	/**
	 * Especificao o campo idSenhaUsuario.
	 * @param idSenhaUsuario idSenhaUsuario
	 */
	public void setIdSenhaUsuario(Integer idSenhaUsuario) {
		this.idSenhaUsuario = idSenhaUsuario;
	}
	
	/**
	 * Obtém o campo tipoSenha.
	 * @return tipoSenha
	 */
	public TipoSenhaDTO getTipoSenha() {
		return this.tipoSenha;
	}
	
	/**
	 * Especificao o campo tipoSenha.
	 * @param tipoSenha tipoSenha
	 */
	public void setTipoSenha(TipoSenhaDTO tipoSenha) {
		this.tipoSenha = tipoSenha;
	}
	
	/**
	 * Obtém o campo dscSenha.
	 * @return dscSenha
	 */
	public String getDscSenha() {
		return this.dscSenha;
	}
	
	/**
	 * Especificao o campo dscSenha.
	 * @param dscSenha dscSenha
	 */
	public void setDscSenha(String dscSenha) {
		this.dscSenha = dscSenha;
	}
	
	/**
	 * Obtém o campo dscConfirmacaoSenha.
	 * @return dscConfirmacaoSenha
	 */
	public String getDscConfirmacaoSenha() {
		return this.dscConfirmacaoSenha;
	}
	
	/**
	 * Especificao o campo dscConfirmacaoSenha.
	 * @param dscConfirmacaoSenha dscConfirmacaoSenha
	 */
	public void setDscConfirmacaoSenha(String dscConfirmacaoSenha) {
		this.dscConfirmacaoSenha = dscConfirmacaoSenha;
	}
	
	/**
	 * Obtém o campo dscSaltSenha.
	 * @return dscSaltSenha
	 */
	public String getDscSaltSenha() {
		return this.dscSaltSenha;
	}
	
	/**
	 * Especificao o campo dscSaltSenha.
	 * @param dscSaltSenha dscSaltSenha
	 */
	public void setDscSaltSenha(String dscSaltSenha) {
		this.dscSaltSenha = dscSaltSenha;
	}
	
	/**
	 * Obtém o campo dscHashSenha.
	 * @return dscHashSenha
	 */
	public String getDscHashSenha() {
		return this.dscHashSenha;
	}
	
	/**
	 * Especificao o campo dscHashSenha.
	 * @param dscHashSenha dscHashSenha
	 */
	public void setDscHashSenha(String dscHashSenha) {
		this.dscHashSenha = dscHashSenha;
	}
	
	/**
	 * Obtém o campo datCriacaoSenha.
	 * @return datCriacaoSenha
	 */
	public DateTime getDatCriacaoSenha() {
		return this.datCriacaoSenha;
	}
	
	/**
	 * Especificao o campo datCriacaoSenha.
	 * @param datCriacaoSenha datCriacaoSenha
	 */
	public void setDatCriacaoSenha(DateTime datCriacaoSenha) {
		this.datCriacaoSenha = datCriacaoSenha;
	}
	
	/**
	 * Obtém o campo flgSenhaExpirada.
	 * @return flgSenhaExpirada
	 */
	public Boolean getFlgSenhaExpirada() {
		return this.flgSenhaExpirada;
	}
	
	/**
	 * Especificao o campo flgSenhaExpirada.
	 * @param flgSenhaExpirada flgSenhaExpirada
	 */
	public void setFlgSenhaExpirada(Boolean flgSenhaExpirada) {
		this.flgSenhaExpirada = flgSenhaExpirada;
	}
	
}
