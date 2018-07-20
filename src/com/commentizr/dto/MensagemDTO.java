package com.commentizr.dto;

import java.util.List;

/**
 * Classe responsável pelas informações da mensagem.
 */
public abstract class MensagemDTO extends HistoricoMensagemDTO {
	
	private Integer idMensagem;
	private List<LikeMensagemDTO> likes;
	private List<DislikeMensagemDTO> dislikes;
	private List<HistoricoMensagemDTO> historico;
	
	private Integer qtdLikes;
	private Integer qtdDislikes;
	
	/**
	 * Inicializa os dados do histórico da mensagem.
	 * @param hist Histórico da mensagem
	 */
	public void setDadosHistoricoMensagem(HistoricoMensagemDTO hist) {
		this.setIdMensagem(hist.getIdMensagem());
		this.setIdAcaoUsuario(hist.getIdAcaoUsuario());
		this.setIdTipoAcaoUsuario(hist.getIdTipoAcaoUsuario());
		this.setDscTextoMensagem(hist.getDscTextoMensagem());
	}
	
	/**
	 * Obtém o campo idMensagem.
	 * @return idMensagem
	 */
	@Override
	public Integer getIdMensagem() {
		return this.idMensagem;
	}
	
	/**
	 * Especificao o campo idMensagem.
	 * @param idMensagem idMensagem
	 */
	@Override
	public void setIdMensagem(Integer idMensagem) {
		this.idMensagem = idMensagem;
	}
	
	/**
	 * Obtém o campo likes.
	 * @return likes
	 */
	public List<LikeMensagemDTO> getLikes() {
		return this.likes;
	}
	
	/**
	 * Especificao o campo likes.
	 * @param likes likes
	 */
	public void setLikes(List<LikeMensagemDTO> likes) {
		this.likes = likes;
	}
	
	/**
	 * Obtém o campo dislikes.
	 * @return dislikes
	 */
	public List<DislikeMensagemDTO> getDislikes() {
		return this.dislikes;
	}
	
	/**
	 * Especificao o campo dislikes.
	 * @param dislikes dislikes
	 */
	public void setDislikes(List<DislikeMensagemDTO> dislikes) {
		this.dislikes = dislikes;
	}
	
	/**
	 * Obtém o campo historico.
	 * @return historico
	 */
	public List<HistoricoMensagemDTO> getHistorico() {
		return this.historico;
	}
	
	/**
	 * Especificao o campo historico.
	 * @param historico historico
	 */
	public void setHistorico(List<HistoricoMensagemDTO> historico) {
		this.historico = historico;
	}
	
	/**
	 * Obtém o campo qtdLikes.
	 * @return qtdLikes
	 */
	public Integer getQtdLikes() {
		return this.qtdLikes;
	}
	
	/**
	 * Especificao o campo qtdLikes.
	 * @param qtdLikes qtdLikes
	 */
	public void setQtdLikes(Integer qtdLikes) {
		this.qtdLikes = qtdLikes;
	}
	
	/**
	 * Obtém o campo qtdDislikes.
	 * @return qtdDislikes
	 */
	public Integer getQtdDislikes() {
		return this.qtdDislikes;
	}
	
	/**
	 * Especificao o campo qtdDislikes.
	 * @param qtdDislikes qtdDislikes
	 */
	public void setQtdDislikes(Integer qtdDislikes) {
		this.qtdDislikes = qtdDislikes;
	}
	
}
