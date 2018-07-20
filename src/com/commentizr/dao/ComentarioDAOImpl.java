package com.commentizr.dao;

import java.util.List;

import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.commentizr.dto.AcaoUsuarioDTO;
import com.commentizr.dto.ComentarioDTO;
import com.commentizr.dto.DislikeMensagemDTO;
import com.commentizr.dto.DominioUrlDTO;
import com.commentizr.dto.HistoricoMensagemDTO;
import com.commentizr.dto.LikeMensagemDTO;
import com.commentizr.dto.MensagemDTO;
import com.commentizr.dto.RespostaDTO;
import com.commentizr.dto.UrlDTO;
import com.commentizr.framework.override.BeanPropertyRowMapper;
import com.commentizr.framework.override.BeanPropertySqlParameterSource;
import com.commentizr.framework.override.MapSqlParameterSource;

/**
 * Classe responsável pelas operações de peristência do comentário.
 */
@Repository
public class ComentarioDAOImpl extends BaseDAO implements ComentarioDAO {
	
	@Override
	public DominioUrlDTO obterDominio(String dscDominioUrl) {
		String sql = "SELECT id_dominio_url as idDominioUrl, " +
				"       dsc_dominio_url as dscDominioUrl" +
				"  FROM ow_commentizr.dominio_url " +
				" WHERE dsc_dominio_url = :dscDominioUrl ";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("dscDominioUrl", dscDominioUrl);
		
		return this.getJdbc().queryForObject(sql, params, new BeanPropertyRowMapper<>(DominioUrlDTO.class));
	}
	
	@Override
	public void criarAcaoUsuario(AcaoUsuarioDTO acao) {
		String sql = "INSERT INTO ow_commentizr.acao_usuario " +
				"(id_usuario, " +
				" dat_acao_usuario, " +
				" id_aplicacao_origem) " +
				"VALUES " +
				"(:idUsuario, :datAcaoUsuario, :idAplicacaoOrigem) ";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idUsuario", acao.getUsuario().getIdUsuario());
		params.addValue("datAcaoUsuario", acao.getDatAcaoUsuario());
		params.addValue("idAplicacaoOrigem", acao.getAplicacaoOrigem().getIdAplicacaoOrigem());
		
		String[] keys = { "id_acao_usuario" };
		
		KeyHolder kh = new GeneratedKeyHolder();
		this.getJdbc().update(sql, params, kh, keys);
		
		acao.setIdAcaoUsuario(kh.getKey().intValue());
	}
	
	@Override
	public void criarMensagem(MensagemDTO mensagem) {
		String sql = "INSERT INTO ow_commentizr.mensagem " +
				"(id_mensagem) " +
				"VALUES " +
				"(nextval('ow_commentizr.mensagem_id_mensagem_seq')) ";
		
		String[] keys = { "id_mensagem" };
		
		KeyHolder kh = new GeneratedKeyHolder();
		this.getJdbc().update(sql, null, kh, keys);
		
		mensagem.setIdMensagem(kh.getKey().intValue());
	}
	
	@Override
	public void criarHistoricoMensagem(MensagemDTO mensagem) {
		String sql = "INSERT INTO ow_commentizr.historico_mensagem " +
				"(id_mensagem, " +
				" id_acao_usuario, " +
				" id_tipo_acao_mensagem, " +
				" dsc_texto_mensagem) " +
				"VALUES " +
				"(:idMensagem, :idAcaoUsuario, :idTipoAcaoMensagem, :dscTextoMensagem) ";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idMensagem", mensagem.getIdMensagem());
		params.addValue("idAcaoUsuario", mensagem.getAcaoUsuario().getIdAcaoUsuario());
		params.addValue("idTipoAcaoMensagem", mensagem.getTipoAcaoMensagem().getIdTipoAcaoMensagem());
		params.addValue("dscTextoMensagem", mensagem.getDscTextoMensagem());
		
		String[] keys = { "id_historico_mensagem" };
		
		KeyHolder kh = new GeneratedKeyHolder();
		this.getJdbc().update(sql, params, kh, keys);
		
		mensagem.setIdHistoricoMensagem(kh.getKey().intValue());
	}
	
	@Override
	public void criarDominio(DominioUrlDTO dominio) {
		String sql = "INSERT INTO ow_commentizr.dominio_url " +
				"(dsc_dominio_url) " +
				"VALUES " +
				"(:dscDominioUrl) ";
		
		String[] keys = { "id_dominio_url" };
		
		KeyHolder kh = new GeneratedKeyHolder();
		this.getJdbc().update(sql, new BeanPropertySqlParameterSource(dominio), kh, keys);
		
		dominio.setIdDominioUrl(kh.getKey().intValue());
	}
	
	@Override
	public UrlDTO obterUrl(Integer idDominioUrl, String dscCaminho) {
		String sql = "SELECT id_url as idUrl, " +
				"	   dsc_caminho as dscCaminho" +
				"  FROM ow_commentizr.url " +
				" WHERE id_dominio_url = :idDominioUrl" +
				"   AND dsc_caminho = :dscCaminho ";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idDominioUrl", idDominioUrl);
		params.addValue("dscCaminho", dscCaminho);
		
		return this.getJdbc().queryForObject(sql, params, new BeanPropertyRowMapper<>(UrlDTO.class));
	}
	
	@Override
	public void criarUrl(UrlDTO url) {
		String sql = "INSERT INTO ow_commentizr.url " +
				"(id_dominio_url, " +
				" dsc_caminho) " +
				"VALUES " +
				"(:idDominioUrl, :dscCaminho) ";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idDominioUrl", url.getDominio().getIdDominioUrl());
		params.addValue("dscCaminho", url.getDscCaminho());
		
		String[] keys = { "id_url" };
		
		KeyHolder kh = new GeneratedKeyHolder();
		this.getJdbc().update(sql, params, kh, keys);
		
		url.setIdUrl(kh.getKey().intValue());
	}
	
	@Override
	public void criarComentario(ComentarioDTO comentario) {
		String sql = "INSERT INTO ow_commentizr.comentario " +
				"(id_mensagem, " +
				" id_url) " +
				"VALUES " +
				"(:idMensagem, :idUrl) ";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idMensagem", comentario.getIdMensagem());
		params.addValue("idUrl", comentario.getUrl().getIdUrl());
		
		String[] keys = { "id_comentario" };
		
		KeyHolder kh = new GeneratedKeyHolder();
		this.getJdbc().update(sql, params, kh, keys);
		
		comentario.setIdComentario(kh.getKey().intValue());
	}
	
	@Override
	public List<ComentarioDTO> obterComentarios(UrlDTO url) {
		String sql = "SELECT id_comentario as idComentario, " +
				"       id_mensagem as idMensagem" +
				"  FROM ow_commentizr.comentario c " +
				" WHERE id_url = :idUrl ";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idUrl", url.getIdUrl());
		
		return this.getJdbc().query(sql, params, new BeanPropertyRowMapper<>(ComentarioDTO.class));
	}
	
	@Override
	public Integer obterQtdLikes(Integer idMensagem) {
		String sql = "SELECT COUNT(*) " +
				"  FROM ow_commentizr.like_mensagem " +
				" WHERE id_mensagem = :idMensagem ";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idMensagem", idMensagem);
		
		return this.getJdbc().queryForInt(sql, params);
	}
	
	@Override
	public Integer obterQtdDislikes(Integer idMensagem) {
		String sql = "SELECT COUNT(*) " +
				"  FROM ow_commentizr.dislike_mensagem " +
				" WHERE id_mensagem = :idMensagem ";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idMensagem", idMensagem);
		
		return this.getJdbc().queryForInt(sql, params);
	}
	
	@Override
	public Integer obterQtdRespostas(Integer idComentario) {
		String sql = "SELECT COUNT(*) " +
				"  FROM ow_commentizr.resposta " +
				" WHERE id_comentario = :idComentario ";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idComentario", idComentario);
		
		return this.getJdbc().queryForInt(sql, params);
	}
	
	@Override
	public HistoricoMensagemDTO obterHistoricoMensagem(Integer idMensagem) {
		String sql = "SELECT id_historico_mensagem as idHistoricoMensagem, " +
				"	   id_mensagem as idMensagem, " +
				"       id_acao_usuario as idAcaoUsuario, " +
				"	   id_tipo_acao_mensagem as idTipoAcaoUsuario, " +
				"	   dsc_texto_mensagem as dscTextoMensagem" +
				"  FROM ow_commentizr.historico_mensagem " +
				" WHERE id_mensagem = :idMensagem ";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idMensagem", idMensagem);
		
		return this.getJdbc().queryForObject(sql, params, new BeanPropertyRowMapper<>(HistoricoMensagemDTO.class));
	}
	
	@Override
	public AcaoUsuarioDTO obterAcaoUsuario(Integer idAcaoUsuario) {
		String sql = "SELECT id_acao_usuario as idAcaoUsuario, " +
				"       id_usuario as idUsuario, " +
				"       dat_acao_usuario as datAcaoUsuario, " +
				"       id_aplicacao_origem as idAplicacaoOrigem " +
				"  FROM ow_commentizr.acao_usuario " +
				" WHERE id_acao_usuario = :idAcaoUsuario ";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idAcaoUsuario", idAcaoUsuario);
		
		return this.getJdbc().queryForObject(sql, params, new BeanPropertyRowMapper<>(AcaoUsuarioDTO.class));
	}
	
	@Override
	public ComentarioDTO obterComentario(Integer idComentario) {
		String sql = "SELECT id_comentario as idComentario, " +
				"       id_mensagem as idMensagem" +
				"  FROM ow_commentizr.comentario c " +
				" WHERE id_comentario = :idComentario ";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idComentario", idComentario);
		
		return this.getJdbc().queryForObject(sql, params, new BeanPropertyRowMapper<>(ComentarioDTO.class));
	}
	
	@Override
	public void criarLikeMensagem(LikeMensagemDTO like) {
		String sql = "INSERT INTO ow_commentizr.like_mensagem " +
				"(id_mensagem, " +
				" id_acao_usuario) " +
				"VALUES " +
				"(:idMensagem, :idAcaoUsuario) ";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idMensagem", like.getIdMensagem());
		params.addValue("idAcaoUsuario", like.getAcaoUsuario().getIdAcaoUsuario());
		
		String[] keys = { "id_like_mensagem" };
		
		KeyHolder kh = new GeneratedKeyHolder();
		this.getJdbc().update(sql, params, kh, keys);
		
		like.setIdLikeMensagem(kh.getKey().intValue());
	}
	
	@Override
	public LikeMensagemDTO obterLikeMensagem(Integer idMensagem, Integer idUsuario) {
		String sql = "SELECT l.id_like_mensagem as idLikeMensagem, " +
				"       l.id_mensagem as idMensagem, " +
				"       l.id_acao_usuario as idAcaoUsuario" +
				"  FROM ow_commentizr.like_mensagem l, " +
				"       ow_commentizr.acao_usuario a " +
				" WHERE l.id_mensagem = :idMensagem " +
				"   AND a.id_acao_usuario = l.id_acao_usuario " +
				"   AND a.id_usuario = :idUsuario ";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idMensagem", idMensagem);
		params.addValue("idUsuario", idUsuario);
		
		return this.getJdbc().queryForObject(sql, params, new BeanPropertyRowMapper<>(LikeMensagemDTO.class));
	}
	
	@Override
	public DislikeMensagemDTO obterDislikeMensagem(Integer idMensagem, Integer idUsuario) {
		String sql = "SELECT d.id_dislike_mensagem as idDislikeMensagem, " +
				"       d.id_mensagem as idMensagem, " +
				"       d.id_acao_usuario as idAcaoUsuario" +
				"  FROM ow_commentizr.dislike_mensagem d, " +
				"       ow_commentizr.acao_usuario a " +
				" WHERE d.id_mensagem = :idMensagem " +
				"   AND a.id_acao_usuario = d.id_acao_usuario " +
				"   AND a.id_usuario = :idUsuario ";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idMensagem", idMensagem);
		params.addValue("idUsuario", idUsuario);
		
		return this.getJdbc().queryForObject(sql, params, new BeanPropertyRowMapper<>(DislikeMensagemDTO.class));
	}
	
	@Override
	public void removerLikeMensagem(Integer idLikeMensagem) {
		String sql = "DELETE FROM ow_commentizr.like_mensagem " +
				"WHERE id_like_mensagem = :idLikeMensagem ";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idLikeMensagem", idLikeMensagem);
		
		this.getJdbc().update(sql, params);
	}
	
	@Override
	public void removerDislikeMensagem(Integer idDislikeMensagem) {
		String sql = "DELETE FROM ow_commentizr.dislike_mensagem " +
				"WHERE id_dislike_mensagem = :idDislikeMensagem ";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idDislikeMensagem", idDislikeMensagem);
		
		this.getJdbc().update(sql, params);
	}
	
	@Override
	public void criarDislikeMensagem(DislikeMensagemDTO dislike) {
		String sql = "INSERT INTO ow_commentizr.dislike_mensagem " +
				"(id_mensagem, " +
				" id_acao_usuario) " +
				"VALUES " +
				"(:idMensagem, :idAcaoUsuario) ";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idMensagem", dislike.getIdMensagem());
		params.addValue("idAcaoUsuario", dislike.getAcaoUsuario().getIdAcaoUsuario());
		
		String[] keys = { "id_dislike_mensagem" };
		
		KeyHolder kh = new GeneratedKeyHolder();
		this.getJdbc().update(sql, params, kh, keys);
		
		dislike.setIdDislikeMensagem(kh.getKey().intValue());
	}
	
	@Override
	public void criarResposta(RespostaDTO resposta) {
		String sql = "INSERT INTO ow_commentizr.resposta " +
				"(id_comentario, " +
				" id_mensagem) " +
				"VALUES " +
				"(:idComentario, :idMensagem) ";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idComentario", resposta.getIdComentario());
		params.addValue("idMensagem", resposta.getIdMensagem());
		
		String[] keys = { "id_resposta" };
		
		KeyHolder kh = new GeneratedKeyHolder();
		this.getJdbc().update(sql, params, kh, keys);
		
		resposta.setIdResposta(kh.getKey().intValue());
	}
	
	@Override
	public List<RespostaDTO> obterRespostas(Integer idComentario) {
		String sql = "SELECT id_resposta as idResposta, " +
				"       id_comentario as idComentario," +
				"       id_mensagem as idMensagem" +
				"  FROM ow_commentizr.resposta " +
				" WHERE id_comentario = :idComentario";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idComentario", idComentario);
		
		return this.getJdbc().query(sql, params, new BeanPropertyRowMapper<>(RespostaDTO.class));
	}
	
	@Override
	public RespostaDTO obterResposta(Integer idResposta) {
		String sql = "SELECT id_resposta as idResposta, " +
				"       id_comentario as idComentario," +
				"       id_mensagem as idMensagem" +
				"  FROM ow_commentizr.resposta " +
				" WHERE id_resposta = :idResposta ";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idResposta", idResposta);
		
		return this.getJdbc().queryForObject(sql, params, new BeanPropertyRowMapper<>(RespostaDTO.class));
	}
}
