package com.commentizr.facade;

import java.util.List;

import com.commentizr.dto.ComentarioDTO;
import com.commentizr.dto.RespostaDTO;
import com.commentizr.dto.UrlDTO;
import com.commentizr.dto.UsuarioDTO;

/**
 * Interface responsável pelas operações de comentário.
 */
public interface ComentarioFacade {
	
	/**
	 * Insere o comentário.
	 * @param comentario Comentário
	 */
	void inserirComentario(ComentarioDTO comentario);
	
	/**
	 * Obtém os comentários de uma URL.
	 * @param url URL
	 * @return Comentários
	 */
	List<ComentarioDTO> obterComentarios(UrlDTO url);
	
	/**
	 * Likar o comentário.
	 * @param usuario Usuário
	 * @param idComentario Id do comentário
	 */
	void likarComentario(UsuarioDTO usuario, Integer idComentario);
	
	/**
	 * Dislikar o comentário.
	 * @param usuario Usuário
	 * @param idComentario Id do comentário
	 */
	void dislikarComentario(UsuarioDTO usuario, Integer idComentario);
	
	/**
	 * Insere a resposta
	 * @param resposta Resposta
	 */
	void inserirResposta(RespostaDTO resposta);
	
	/**
	 * Obtém as respostas de um comentário.
	 * @param idComentario Id do comentário
	 * @return Respostas
	 */
	List<RespostaDTO> obterRespostas(Integer idComentario);
	
	/**
	 * Lika a resposta.
	 * @param usuario Usuário
	 * @param idResposta Id a da resposta
	 */
	void likarResposta(UsuarioDTO usuario, Integer idResposta);
	
	/**
	 * Dislika a resposta.
	 * @param usuario Usuário
	 * @param idResposta Id a da resposta
	 */
	void dislikarResposta(UsuarioDTO usuario, Integer idResposta);
	
}
