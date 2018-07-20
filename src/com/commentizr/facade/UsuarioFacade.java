package com.commentizr.facade;

import com.commentizr.dto.UsuarioDTO;

/**
 * Interface responsável pela lógica das operações de usuário.
 */
public interface UsuarioFacade {
	
	/**
	 * Cria um usuário.
	 * @param usuario Usuário
	 * @param urlBase URL base da aplicação
	 */
	void criarUsuario(UsuarioDTO usuario, String urlBase);
	
	/**
	 * Confirma a conta do usuário.
	 * @param usuario Usuário
	 */
	void confirmarConta(UsuarioDTO usuario);
	
	/**
	 * Autentica um usuário.
	 * @param nomeConta Nome da conta
	 * @param dscSenha Senha
	 */
	void autenticarUsuario(String nomeConta, String dscSenha);
	
	/**
	 * Envia email para recuperação de acesso a conta.
	 * @param dscEmail Email
	 * @param urlBase URL base da aplicação
	 */
	void enviarEmailRecuperacaoConta(String dscEmail, String urlBase);
	
	/**
	 * Troca a senha através da recuperação de conta.
	 * @param usuario Usuário
	 */
	void trocarSenhaRecuperacaoConta(UsuarioDTO usuario);
	
	/**
	 * Obtém o usuário pelo nome da conta.
	 * @param nomeConta Nome da conta
	 * @return UsuarioDTO
	 */
	UsuarioDTO obterUsuarioPorNomeConta(String nomeConta);
	
	/**
	 * Obtém o usuário.
	 * @param idUsuario Id do usuário
	 * @return UsuarioDTO
	 */
	UsuarioDTO obterUsuario(Integer idUsuario);
	
}