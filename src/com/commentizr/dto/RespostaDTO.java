package com.commentizr.dto;

/**
 * Classe responsável pelas informações da resposta.
 */
public class RespostaDTO extends MensagemDTO {
	
	private Integer idResposta;
	private Integer idComentario;
	
	/**
	 * Obtém o campo idResposta.
	 * @return idResposta
	 */
	public Integer getIdResposta() {
		return this.idResposta;
	}
	
	/**
	 * Especificao o campo idResposta.
	 * @param idResposta idResposta
	 */
	public void setIdResposta(Integer idResposta) {
		this.idResposta = idResposta;
	}
	
	/**
	 * Obtém o campo idComentario.
	 * @return idComentario
	 */
	public Integer getIdComentario() {
		return this.idComentario;
	}
	
	/**
	 * Especificao o campo idComentario.
	 * @param idComentario idComentario
	 */
	public void setIdComentario(Integer idComentario) {
		this.idComentario = idComentario;
	}
	
}
