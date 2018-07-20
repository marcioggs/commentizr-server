package com.commentizr.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.commentizr.dto.AplicacaoOrigemDTO;
import com.commentizr.dto.TipoAcaoMensagemDTO;
import com.commentizr.dto.TipoSenhaDTO;

/**
 * Classe responsável pelas operações de peristência dos dados de domínio.
 */
@Repository
public class DadosDominioDAOImpl extends BaseDAO implements DadosDominioDAO {
	
	@Override
	public List<TipoSenhaDTO> obterTiposSenha() {
		String sql =
				"SELECT id_tipo_senha as idTipoSenha, " +
						"		chv_tipo_senha as chvTipoSenha, " +
						"		dsc_tipo_senha as dscTipoSenha" +
						"  FROM ow_commentizr.tipo_senha ";
		
		return this.getJdbc().query(sql, this.nullParam, new BeanPropertyRowMapper<>(TipoSenhaDTO.class));
	}
	
	@Override
	public List<AplicacaoOrigemDTO> obterAplicacoesOrigem() {
		String sql =
				"SELECT id_aplicacao_origem as idAplicacaoOrigem, " +
						"		chv_aplicacao_origem as chvAplicacaoOrigem, " +
						"		dsc_aplicacao_origem as dscAplicacaoOrigem" +
						"  FROM ow_commentizr.aplicacao_origem ";
		
		return this.getJdbc().query(sql, this.nullParam, new BeanPropertyRowMapper<>(AplicacaoOrigemDTO.class));
	}
	
	@Override
	public List<TipoAcaoMensagemDTO> obterTiposAcoesMensagem() {
		String sql =
				"SELECT id_tipo_acao_mensagem as idTipoAcaoMensagem, " +
						"		chv_tipo_acao_mensagem as chvTipoAcaoMensagem, " +
						"		dsc_tipo_acao_mensagem as dscTipoAcaoMensagem " +
						"  FROM ow_commentizr.tipo_acao_mensagem ";
		
		return this.getJdbc().query(sql, this.nullParam, new BeanPropertyRowMapper<>(TipoAcaoMensagemDTO.class));
	}
	
}
