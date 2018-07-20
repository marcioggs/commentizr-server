package com.commentizr.dao;

import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.commentizr.dto.SenhaUsuarioDTO;
import com.commentizr.dto.UsuarioDTO;
import com.commentizr.framework.override.BeanPropertyRowMapper;
import com.commentizr.framework.override.BeanPropertySqlParameterSource;
import com.commentizr.framework.override.MapSqlParameterSource;

/**
 * Classe responsável pelas operações de peristência do usuário.
 */
@Repository
public class UsuarioDAOImpl extends BaseDAO implements UsuarioDAO {
	
	@Override
	public UsuarioDTO obterUsuario(Integer idUsuario) {
		String sql = "SELECT 	id_usuario as idUsuario, " +
				"		nme_conta as nmeConta, " +
				"		dsc_email as dscEmail," +
				"		nme_exibicao as nmeExibicao, " +
				"		dat_criacao_usuario as datCriacaoUsuario, " +
				"		flg_conta_confirmada as flgContaConfirmada" +
				"  FROM	ow_commentizr.usuario " +
				" WHERE  id_usuario = :idUsuario ";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idUsuario", idUsuario);
		
		return this.getJdbc().queryForObject(sql, params, new BeanPropertyRowMapper<>(UsuarioDTO.class));
	}
	
	@Override
	public Integer obterIdUsuarioPorNomeConta(String nmeConta) {
		String sql = "SELECT id_usuario " +
				"  FROM ow_commentizr.usuario " +
				" WHERE nme_conta = :nmeConta ";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("nmeConta", nmeConta);
		
		return this.getJdbc().queryForObject(sql, params, Integer.class);
	}
	
	@Override
	public Integer obterIdUsuarioPorEmail(String dscEmail) {
		String sql = "SELECT id_usuario " +
				"  FROM ow_commentizr.usuario " +
				" WHERE dsc_email = :dscEmail ";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("dscEmail", dscEmail);
		
		return this.getJdbc().queryForObject(sql, params, Integer.class);
	}
	
	@Override
	public void criarUsuario(UsuarioDTO usuario) {
		String sql = "INSERT INTO ow_commentizr.usuario " +
				"(nme_conta, " +
				" dsc_email, " +
				" nme_exibicao, " +
				" dat_criacao_usuario, " +
				" flg_conta_confirmada) " +
				"VALUES " +
				"(:nmeConta, :dscEmail, :nmeExibicao, :datCriacaoUsuario, :flgContaConfirmada) ";
		
		String[] keys = { "id_usuario" };
		
		KeyHolder kh = new GeneratedKeyHolder();
		this.getJdbc().update(sql, new BeanPropertySqlParameterSource(usuario), kh, keys);
		
		usuario.setIdUsuario(kh.getKey().intValue());
	}
	
	@Override
	public void criarSenhaUsuario(Integer idUsuario, SenhaUsuarioDTO senha) {
		String sql =
				"INSERT INTO ow_commentizr.senha_usuario " +
						"(id_usuario, " +
						" id_tipo_senha, " +
						" dsc_salt_senha, " +
						" dsc_hash_senha, " +
						" dat_criacao_senha, " +
						" flg_senha_expirada) " +
						"VALUES " +
						"(:idUsuario, :idTipoSenha, :dscSaltSenha, :dscHashSenha, :datCriacaoSenha, :flgSenhaExpirada)";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idUsuario", idUsuario);
		params.addValue("idTipoSenha", senha.getTipoSenha().getIdTipoSenha());
		params.addValue("dscSaltSenha", senha.getDscSaltSenha());
		params.addValue("dscHashSenha", senha.getDscHashSenha());
		params.addValue("datCriacaoSenha", senha.getDatCriacaoSenha());
		params.addValue("flgSenhaExpirada", senha.getFlgSenhaExpirada());
		
		String[] keys = { "id_senha_usuario" };
		
		KeyHolder kh = new GeneratedKeyHolder();
		this.getJdbc().update(sql, params, kh, keys);
		
		senha.setIdSenhaUsuario(kh.getKey().intValue());
	}
	
	@Override
	public SenhaUsuarioDTO obterSenhaAtivaUsuario(Integer idUsuario, Integer idTipoSenha) {
		String sql =
				"SELECT id_senha_usuario as idSenhaUsuario, " +
						" dsc_salt_senha as dscSaltSenha, " +
						" dsc_hash_senha as dscHashSenha, " +
						" dat_criacao_senha as datCriacaoSenha, " +
						" flg_senha_expirada as flgSenhaExpirada " +
						"  FROM ow_commentizr.senha_usuario " +
						" WHERE id_usuario = :idUsuario " +
						"   AND id_tipo_senha = :idTipoSenha " +
						"   AND flg_senha_expirada = false";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idUsuario", idUsuario);
		params.addValue("idTipoSenha", idTipoSenha);
		
		return this.getJdbc().queryForObject(sql, params, new BeanPropertyRowMapper<>(SenhaUsuarioDTO.class));
	}
	
	@Override
	public void expirarSenhaUsuario(Integer idSenhaUsuario) {
		String sql =
				"UPDATE ow_commentizr.senha_usuario " +
						" SET flg_senha_expirada = true " +
						" WHERE id_senha_usuario = :idSenhaUsuario ";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idSenhaUsuario", idSenhaUsuario);
		
		this.getJdbc().update(sql, params);
	}
	
	@Override
	public void confirmarContaUsuario(Integer idUsuario) {
		String sql =
				"UPDATE ow_commentizr.usuario " +
						" SET flg_conta_confirmada = true " +
						" WHERE id_usuario = :idUsuario ";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idUsuario", idUsuario);
		
		this.getJdbc().update(sql, params);
	}
	
	@Override
	public void expirarSenhasAntigas(Integer idUsuario, Integer idTipoSenha) {
		String sql = "UPDATE ow_commentizr.senha_usuario " +
				" SET flg_senha_expirada = true " +
				" WHERE id_usuario = :idUsuario " +
				" AND id_tipo_senha = :idTipoSenha";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idUsuario", idUsuario);
		params.addValue("idTipoSenha", idTipoSenha);
		
		this.getJdbc().update(sql, params);
	}
}
