package com.commentizr.dto;

/**
 * Classe responsável pelas informações do dislike das mensagens.
 */
public class DislikeMensagemDTO extends BaseDTO {
	
	private Integer idDislikeMensagem;
	private AcaoUsuarioDTO acaoUsuario;
	private Integer idMensagem;
	
	/**
	 * Obtém o campo idDislikeMensagem.
	 * @return idDislikeMensagem
	 */
	public Integer getIdDislikeMensagem() {
		return this.idDislikeMensagem;
	}
	
	/**
	 * Especificao o campo idDislikeMensagem.
	 * @param idDislikeMensagem idDislikeMensagem
	 */
	public void setIdDislikeMensagem(Integer idDislikeMensagem) {
		this.idDislikeMensagem = idDislikeMensagem;
	}
	
	/**
	 * Obtém o campo acaoUsuario.
	 * @return acaoUsuario
	 */
	public AcaoUsuarioDTO getAcaoUsuario() {
		return this.acaoUsuario;
	}
	
	/**
	 * Especificao o campo acaoUsuario.
	 * @param acaoUsuario acaoUsuario
	 */
	public void setAcaoUsuario(AcaoUsuarioDTO acaoUsuario) {
		this.acaoUsuario = acaoUsuario;
	}
	
	/**
	 * Obtém o campo idMensagem.
	 * @return idMensagem
	 */
	public Integer getIdMensagem() {
		return this.idMensagem;
	}
	
	/**
	 * Especificao o campo idMensagem.
	 * @param idMensagem idMensagem
	 */
	public void setIdMensagem(Integer idMensagem) {
		this.idMensagem = idMensagem;
	}
	
}
