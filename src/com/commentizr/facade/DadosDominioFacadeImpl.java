package com.commentizr.facade;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commentizr.dao.DadosDominioDAO;
import com.commentizr.dto.AplicacaoOrigemDTO;
import com.commentizr.dto.TipoAcaoMensagemDTO;
import com.commentizr.dto.TipoSenhaDTO;

/**
 * Classe responsável pelos dados de domínio.
 */
@Service
public class DadosDominioFacadeImpl implements DadosDominioFacade {
	
	@Autowired
	private DadosDominioDAO dao;
	
	private static List<TipoSenhaDTO> tiposSenha;
	private static List<AplicacaoOrigemDTO> aplicaoesOrigem;
	private static List<TipoAcaoMensagemDTO> tiposAcoesMensagem;
	
	@PostConstruct
	private void inicializarListas() {
		DadosDominioFacadeImpl.tiposSenha = this.getDao().obterTiposSenha();
		DadosDominioFacadeImpl.aplicaoesOrigem = this.getDao().obterAplicacoesOrigem();
		DadosDominioFacadeImpl.tiposAcoesMensagem = this.getDao().obterTiposAcoesMensagem();
	}
	
	@Override
	public TipoSenhaDTO obterTipoSenha(String chvTipoSenha) {
		return TipoSenhaDTO.obterTipoSenha(DadosDominioFacadeImpl.tiposSenha, chvTipoSenha);
	}
	
	@Override
	public AplicacaoOrigemDTO obterAplicacaoOrigem(String chvAplicacaoOrigem) {
		return AplicacaoOrigemDTO.obterAplicacaoOrigem(DadosDominioFacadeImpl.aplicaoesOrigem, chvAplicacaoOrigem);
	}
	
	@Override
	public TipoAcaoMensagemDTO obterTipoAcaoMensagem(String chvTipoAcaoMensagem) {
		return TipoAcaoMensagemDTO
				.obterTipoAcaoMensagem(DadosDominioFacadeImpl.tiposAcoesMensagem, chvTipoAcaoMensagem);
	}
	
	/**
	 * Obtém o campo dao.
	 * @return dao
	 */
	protected DadosDominioDAO getDao() {
		return this.dao;
	}
	
}
