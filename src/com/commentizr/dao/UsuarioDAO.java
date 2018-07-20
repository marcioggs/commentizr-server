package com.commentizr.dao;

import com.commentizr.dto.SenhaUsuarioDTO;
import com.commentizr.dto.UsuarioDTO;

/**
 * Interface responsável pelas operações de peristência do usuário.
 */
public interface UsuarioDAO {
	
	/**
	 * Obtém o usuário pelo seu id.
	 * @param idUsuario Id
	 * @return UsuarioDTO
	 */
	UsuarioDTO obterUsuario(Integer idUsuario);
	
	/**
	 * Obtém o id do usuário pelo nome de conta.
	 * @param nmeConta Nome da conta
	 * @return Id do usuário
	 */
	Integer obterIdUsuarioPorNomeConta(String nmeConta);
	
	/**
	 * Obtém o id do usuário pelo email.
	 * @param dscEmail Email
	 * @return Id do usuário
	 */
	Integer obterIdUsuarioPorEmail(String dscEmail);
	
	/**
	 * Cria um usuário.
	 * @param usuario Usuário
	 */
	void criarUsuario(UsuarioDTO usuario);
	
	/**
	 * Cria a senha do usuário.
	 * @param idUsuario Id do usuário
	 * @param senha Senha
	 */
	void criarSenhaUsuario(Integer idUsuario, SenhaUsuarioDTO senha);
	
	/**
	 * Obtém a senha ativa do usuário de um determinado tipo.
	 * @param idUsuario Id do usuário
	 * @param idTipoSenha Id do tipo da senha
	 * @return SenhaUsuarioDTO
	 */
	SenhaUsuarioDTO obterSenhaAtivaUsuario(Integer idUsuario, Integer idTipoSenha);
	
	/**
	 * Expira uma senha do usuário.
	 * @param idSenhaUsuario Id da senha do usuário
	 */
	void expirarSenhaUsuario(Integer idSenhaUsuario);
	
	/**
	 * Confirma a conta do usuário.
	 * @param idUsuario Id do usuário
	 */
	void confirmarContaUsuario(Integer idUsuario);
	
	/**
	 * Expira as senhas antigas de um determinado tipo de um usuário.
	 * @param idUsuario Id do usuário
	 * @param idTipoSenha Id do tipo da senha
	 */
	void expirarSenhasAntigas(Integer idUsuario, Integer idTipoSenha);
	
}
