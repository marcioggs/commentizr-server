package com.commentizr.dto;

import java.util.List;

/**
 * Classe responsável pelas informações do comentário.
 */
public class ComentarioDTO extends MensagemDTO {
	
	private Integer idComentario;
	private UrlDTO url;
	private List<RespostaDTO> respostas;
	
	private Integer qtdRespostas;
	
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
	
	/**
	 * Obtém o campo url.
	 * @return url
	 */
	public UrlDTO getUrl() {
		return this.url;
	}
	
	/**
	 * Especificao o campo url.
	 * @param url url
	 */
	public void setUrl(UrlDTO url) {
		this.url = url;
	}
	
	/**
	 * Obtém o campo respostas.
	 * @return respostas
	 */
	public List<RespostaDTO> getRespostas() {
		return this.respostas;
	}
	
	/**
	 * Especificao o campo respostas.
	 * @param respostas respostas
	 */
	public void setRespostas(List<RespostaDTO> respostas) {
		this.respostas = respostas;
	}
	
	/**
	 * Obtém o campo qtdRespostas.
	 * @return qtdRespostas
	 */
	public Integer getQtdRespostas() {
		return this.qtdRespostas;
	}
	
	/**
	 * Especificao o campo qtdRespostas.
	 * @param qtdRespostas qtdRespostas
	 */
	public void setQtdRespostas(Integer qtdRespostas) {
		this.qtdRespostas = qtdRespostas;
	}
	
}
