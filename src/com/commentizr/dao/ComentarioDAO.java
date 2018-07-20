package com.commentizr.dao;

import java.util.List;

import com.commentizr.dto.AcaoUsuarioDTO;
import com.commentizr.dto.ComentarioDTO;
import com.commentizr.dto.DislikeMensagemDTO;
import com.commentizr.dto.DominioUrlDTO;
import com.commentizr.dto.HistoricoMensagemDTO;
import com.commentizr.dto.LikeMensagemDTO;
import com.commentizr.dto.MensagemDTO;
import com.commentizr.dto.RespostaDTO;
import com.commentizr.dto.UrlDTO;

/**
 * Interface responsável pelas operações de peristência do comentário.
 */
public interface ComentarioDAO {
	
	/**
	 * Obtém o domínio de uma URL.
	 * @param dscDominioUrl
	 * @return DominioUrlDTO
	 */
	DominioUrlDTO obterDominio(String dscDominioUrl);
	
	/**
	 * Cria a ação do usuário.
	 * @param acao Ação
	 */
	void criarAcaoUsuario(AcaoUsuarioDTO acao);
	
	/**
	 * Cria a mensagem.
	 * @param mensagem Mensagem
	 */
	void criarMensagem(MensagemDTO mensagem);
	
	/**
	 * Cria o histórico da mensagem.
	 * @param mensagem Mensagem
	 */
	void criarHistoricoMensagem(MensagemDTO mensagem);
	
	/**
	 * Cria o domínio.
	 * @param dominio Domínio
	 */
	void criarDominio(DominioUrlDTO dominio);
	
	/**
	 * Cria a URL.
	 * @param url URL
	 */
	void criarUrl(UrlDTO url);
	
	/**
	 * Obtém a URL
	 * @param idDominioUrl Id do domínio da URL
	 * @param dscCaminho Caminho
	 * @return URL
	 */
	UrlDTO obterUrl(Integer idDominioUrl, String dscCaminho);
	
	/**
	 * Cria o comentário.
	 * @param comentario Comentário
	 */
	void criarComentario(ComentarioDTO comentario);
	
	/**
	 * Obtém os comentários de uma URL.
	 * @param url URL
	 * @return Comentários
	 */
	List<ComentarioDTO> obterComentarios(UrlDTO url);
	
	/**
	 * Obtém a quantidade de likes da mensagem.
	 * @param idMensagem Id da mensagem
	 * @return Quantidade de likes
	 */
	Integer obterQtdLikes(Integer idMensagem);
	
	/**
	 * Obtém a quantidade de dislikes da mensagem.
	 * @param idMensagem Id da mensagem
	 * @return Quantidade de dislikes
	 */
	Integer obterQtdDislikes(Integer idMensagem);
	
	/**
	 * Obtém a quantidade de respostas da mensagem.
	 * @param idMensagem Id da mensagem
	 * @return Quantidade de respostas
	 */
	Integer obterQtdRespostas(Integer idMensagem);
	
	/**
	 * Obtém o histórico da mensagem.
	 * @param idMensagem Id da mensagem
	 * @return HistoricoMensagemDTO
	 */
	HistoricoMensagemDTO obterHistoricoMensagem(Integer idMensagem);
	
	/**
	 * Obtém a ação do usuário.
	 * @param idAcaoUsuario Id da ação do usuário
	 * @return AcaoUsuarioDTO
	 */
	AcaoUsuarioDTO obterAcaoUsuario(Integer idAcaoUsuario);
	
	/**
	 * Obtém o comentário.
	 * @param idComentario Id do comentário
	 * @return ComentarioDTO
	 */
	ComentarioDTO obterComentario(Integer idComentario);
	
	/**
	 * Cria o like da mensagem.
	 * @param like Like
	 */
	void criarLikeMensagem(LikeMensagemDTO like);
	
	/**
	 * Obtém o like da mensagem de um usuário.
	 * @param idMensagem Id da mensagem
	 * @param idUsuario Id do usuário
	 * @return LikeMensagemDTO
	 */
	LikeMensagemDTO obterLikeMensagem(Integer idMensagem, Integer idUsuario);
	
	/**
	 * Obtém o dislike da mensagem.
	 * @param idMensagem Id da mensagem
	 * @param idUsuario Id do usuário
	 * @return DislikeMensagemDTO
	 */
	DislikeMensagemDTO obterDislikeMensagem(Integer idMensagem, Integer idUsuario);
	
	/**
	 * Remove o like da mensagem.
	 * @param idLikeMensagem Id do like da mensagem
	 */
	void removerLikeMensagem(Integer idLikeMensagem);
	
	/**
	 * Remove o dislike da mensagem.
	 * @param idDislikeMensagem Id do dislike da mensagem
	 */
	void removerDislikeMensagem(Integer idDislikeMensagem);
	
	/**
	 * Cria o dislike da mensagem.
	 * @param dislike Dislike
	 */
	void criarDislikeMensagem(DislikeMensagemDTO dislike);
	
	/**
	 * Cria a resposta.
	 * @param resposta Resposta
	 */
	void criarResposta(RespostaDTO resposta);
	
	/**
	 * Obtém as respostas de um comentário.
	 * @param idComentario Id do comentário
	 * @return Respostas
	 */
	List<RespostaDTO> obterRespostas(Integer idComentario);
	
	/**
	 * Obtém a resposta.
	 * @param idResposta Id da resposta
	 * @return RespostaDTO
	 */
	RespostaDTO obterResposta(Integer idResposta);
	
}
