package com.commentizr.dto;

/**
 * Classe responsável pelas informações do like da mensagem.
 */
public class LikeMensagemDTO extends BaseDTO {
	
	private Integer idLikeMensagem;
	private AcaoUsuarioDTO acaoUsuario;
	private Integer idMensagem;
	
	/**
	 * Obtém o campo idLikeMensagem.
	 * @return idLikeMensagem
	 */
	public Integer getIdLikeMensagem() {
		return this.idLikeMensagem;
	}
	
	/**
	 * Especificao o campo idLikeMensagem.
	 * @param idLikeMensagem idLikeMensagem
	 */
	public void setIdLikeMensagem(Integer idLikeMensagem) {
		this.idLikeMensagem = idLikeMensagem;
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
		return idMensagem;
	}

	/**
	 * Especificao o campo idMensagem.
	 * @param idMensagem idMensagem
	 */
	public void setIdMensagem(Integer idMensagem) {
		this.idMensagem = idMensagem;
	}
	
}
