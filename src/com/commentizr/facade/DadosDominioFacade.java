package com.commentizr.facade;

import com.commentizr.dto.AplicacaoOrigemDTO;
import com.commentizr.dto.TipoAcaoMensagemDTO;
import com.commentizr.dto.TipoSenhaDTO;

/**
 * Interface responsável pelos dados de domínio.
 */
public interface DadosDominioFacade {
	
	/**
	 * Obtém o TipoSenhaDTO.
	 * @param chvTipoSenha Chave do tipo de senha
	 * @return TipoSenhaDTO
	 */
	TipoSenhaDTO obterTipoSenha(String chvTipoSenha);
	
	/**
	 * Obtém o AplicacaoOrigemDTO
	 * @param chvAplicacaoOrigem Chave da aplicação origem
	 * @return AplicacaoOrigemDTO
	 */
	AplicacaoOrigemDTO obterAplicacaoOrigem(String chvAplicacaoOrigem);
	
	/**
	 * Obtém o TipoAcaoMensagemDTO.
	 * @param chvTipoAcaoMensagem Chave do tipo da ação
	 * @return TipoAcaoMensagemDTO
	 */
	TipoAcaoMensagemDTO obterTipoAcaoMensagem(String chvTipoAcaoMensagem);
}