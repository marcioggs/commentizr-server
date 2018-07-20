package com.commentizr.dao;

import java.util.List;

import com.commentizr.dto.AplicacaoOrigemDTO;
import com.commentizr.dto.TipoAcaoMensagemDTO;
import com.commentizr.dto.TipoSenhaDTO;

/**
 * Interface responsável pelas operações de peristência dos dados de domínio.
 */
public interface DadosDominioDAO {
	
	/**
	 * Obtém os tipos de senha.
	 * @return Tipos de senha
	 */
	List<TipoSenhaDTO> obterTiposSenha();
	
	/**
	 * Obtém as aplicações origem.
	 * @return Aplicações origem
	 */
	List<AplicacaoOrigemDTO> obterAplicacoesOrigem();
	
	/**
	 * Obtém os tipos de ação de mensagem.
	 * @return Tipos de ação de mensagem
	 */
	List<TipoAcaoMensagemDTO> obterTiposAcoesMensagem();
}
