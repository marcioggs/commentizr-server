package com.commentizr.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.validator.GenericValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.commentizr.dao.UsuarioDAO;
import com.commentizr.dto.SenhaUsuarioDTO;
import com.commentizr.dto.TipoSenhaDTO;
import com.commentizr.dto.UsuarioDTO;
import com.commentizr.framework.exception.BusinessException;
import com.commentizr.framework.message.Message;

/**
 * Classe responsável pela lógica das operações de usuário.
 */
@Service
public class UsuarioFacadeImpl extends BaseFacade implements UsuarioFacade {
	
	@Autowired
	private UsuarioDAO dao;
	
	@Value("${email.confirmacao.conta.assunto}")
	private String assuntoEmailConfirmacao;
	@Value("${email.confirmacao.remetente}")
	private String remetenteEmailConfirmacao;
	
	@Value("${email.recuperacao.conta.assunto}")
	private String assuntoEmailRecuperacao;
	@Value("${email.recuperacao.conta.remetente}")
	private String remetenteEmailRecuperacao;
	
	private static final String PASSWORD_SPECIAL_CHAR = "`!@#$%^&*()-_+={}[]|]\\;:\"<>,./?";
	
	private static final String PASSWORD_FORMAT_REGEX = "((?=.*\\d)" + // deve conter um dígito
			"(?=.*[a-z])" + // deve conter um caractere minúsculo
			"(?=.*[A-Z])" + // deve contar um caractere maiúsculo
			"(?=.*[" + Pattern.quote(UsuarioFacadeImpl.PASSWORD_SPECIAL_CHAR) + "])" + // deve conter um destes
																						// caracteres especiais
			"." + // bate com as condições anteriores
			"{7,})"; // deve conter pelo menos 7 caracteres
	
	@Override
	public void criarUsuario(UsuarioDTO usuario, String urlBase) {
		this.validarNovoUsuario(usuario);
		usuario.inicializarNovoUsuario();
		this.getDao().criarUsuario(usuario);
		this.gravarNovaSenhaConta(usuario.getIdUsuario(), usuario.getSenhaConta());
		this.enviarEmailConfirmacaoConta(usuario, urlBase);
	}
	
	/**
	 * Valida os dados do novo usuário.
	 * @param usuario Usuário
	 */
	private void validarNovoUsuario(UsuarioDTO usuario) {
		// TODO: Falta tratar quando já usaram o nome ou email em outra conta, mas não confirmaram.
		List<Message> msgs = new ArrayList<>();
		
		if (GenericValidator.isBlankOrNull(usuario.getNmeConta())) {
			msgs.add(new Message("erro.campo.obrigatorio", "nome da conta"));
		} else {
			if (this.isNomeContaEmUso(usuario.getNmeConta())) {
				msgs.add(new Message("erro.campo.em.uso", "nome da conta"));
			}
		}
		
		if (GenericValidator.isBlankOrNull(usuario.getDscEmail())) {
			msgs.add(new Message("erro.campo.obrigatorio", "email"));
		} else {
			if (!GenericValidator.isEmail(usuario.getDscEmail())) {
				msgs.add(new Message("erro.campo.formato.invalido", "email"));
			} else if (this.isEmailEmUso(usuario.getDscEmail())) {
				msgs.add(new Message("erro.campo.em.uso", "email"));
			}
		}
		
		try {
			this.validarNovaSenhaConta(usuario.getSenhaConta());
		} catch (BusinessException e) {
			msgs.addAll(e.getMessages());
		}
		
		if (!msgs.isEmpty()) {
			throw new BusinessException(msgs);
		}
	}
	
	/**
	 * Indica se um email está em uso.
	 * @param dscEmail Email
	 * @return true - está em uso; false - não está em uso
	 */
	private boolean isEmailEmUso(String dscEmail) {
		return this.getDao().obterIdUsuarioPorEmail(dscEmail) != null;
	}
	
	/**
	 * Indica se um nome de conta está em uso.
	 * @param nmeConta Nome da conta
	 * @return true - está em uso; false - não está em uso
	 */
	private boolean isNomeContaEmUso(String nmeConta) {
		return this.getDao().obterIdUsuarioPorNomeConta(nmeConta) != null;
	}
	
	/**
	 * Valida a nova senha da conta.
	 * @param senha Senha
	 */
	private void validarNovaSenhaConta(SenhaUsuarioDTO senha) {
		// TODO: Tratar nome do usuário e senha, pois vão ser usadas em query string de confirmação de conta.
		List<Message> msgs = new ArrayList<>();
		boolean isSenhaValida = false;
		
		boolean isSenhaPreenchida = !GenericValidator.isBlankOrNull(senha.getDscSenha());
		if (!isSenhaPreenchida) {
			msgs.add(new Message("erro.campo.obrigatorio", "senha"));
		} else {
			isSenhaValida = senha.getDscSenha().matches(UsuarioFacadeImpl.PASSWORD_FORMAT_REGEX);
			if (!isSenhaValida) {
				msgs.add(new Message("erro.campo.senha.politica.seguranca"));
			}
		}
		
		boolean isConfirmacaoSenhaPreenchida = !GenericValidator.isBlankOrNull(senha.getDscConfirmacaoSenha());
		if (!isConfirmacaoSenhaPreenchida) {
			msgs.add(new Message("erro.campo.obrigatorio", "confirmação de senha"));
		}
		
		if (isSenhaPreenchida && isConfirmacaoSenhaPreenchida && isSenhaValida
				&& !senha.getDscSenha().equals(senha.getDscConfirmacaoSenha())) {
			msgs.add(new Message("erro.campo.confirmacao.senha.diferente"));
		}
		
		if (!msgs.isEmpty()) {
			throw new BusinessException(msgs);
		}
	}
	
	/**
	 * Envia email para confirmação da conta criada.
	 * @param urlBase URL base da aplicação
	 * @param usuario Endereço de email do destinatário
	 */
	private void enviarEmailConfirmacaoConta(UsuarioDTO usuario, String urlBase) {
		SenhaUsuarioDTO senha = this.gravarNovaSenhaConfirmacaoConta(usuario.getIdUsuario());
		
		Message msgCorpoEmail = new Message("email.confirmacao.conta.corpo", urlBase, usuario.getNmeConta(),
				senha.getDscSenha());
		this.getMessageResolver().resolveMessage(msgCorpoEmail);
		
		super.enviarEmail(this.remetenteEmailConfirmacao, usuario.getDscEmail(), this.assuntoEmailConfirmacao,
				msgCorpoEmail.getMessage());
	}
	
	@Override
	public void confirmarConta(UsuarioDTO usuario) {
		this.validarConfirmacaoConta(usuario);
		this.getDao().confirmarContaUsuario(usuario.getIdUsuario());
	}
	
	/**
	 * Valida os dados da confirmação de conta.
	 * @param usuario Usuário
	 */
	private void validarConfirmacaoConta(UsuarioDTO usuario) {
		List<Message> msgs = new ArrayList<>();
		
		if (GenericValidator.isBlankOrNull(usuario.getNmeConta())) {
			msgs.add(new Message("erro.campo.obrigatorio", "nome da conta"));
		} else {
			Integer idUsuario = this.getDao().obterIdUsuarioPorNomeConta(usuario.getNmeConta());
			if (idUsuario == null) {
				msgs.add(new Message("erro.confirmacao.conta.conta.inexistente", usuario.getNmeConta()));
			} else {
				usuario.setIdUsuario(idUsuario);
				if (this.getDao().obterUsuario(idUsuario).getFlgContaConfirmada()) {
					msgs.add(new Message("erro.confirmacao.conta.conta.confirmada"));
				}
			}
		}
		
		if ((usuario.getSenhaConfirmacaoConta() == null)
				|| GenericValidator.isBlankOrNull(usuario.getSenhaConfirmacaoConta().getDscSenha())) {
			msgs.add(new Message("erro.campo.obrigatorio", "senha de confirmação da conta"));
		}
		
		if (msgs.isEmpty()) {
			usuario.getSenhaConfirmacaoConta().setTipoSenha(
					super.getDominioFacade().obterTipoSenha(TipoSenhaDTO.CHV_CONFIRMACAO_CONTA));
			
			try {
				this.validarSenhaUsuario(usuario.getIdUsuario(), usuario.getSenhaConfirmacaoConta());
			} catch (BusinessException e) {
				msgs.addAll(e.getMessages());
			}
		}
		
		if (!msgs.isEmpty()) {
			throw new BusinessException(msgs);
		}
	}
	
	/**
	 * Valida a senha do usuário.
	 * @param idUsuario Id do usuário
	 * @param senhaInformada Senha informada
	 */
	private void validarSenhaUsuario(Integer idUsuario, SenhaUsuarioDTO senhaInformada) {
		SenhaUsuarioDTO senhaArmazenada = this.getDao().obterSenhaAtivaUsuario(idUsuario,
				senhaInformada.getTipoSenha().getIdTipoSenha());
		
		senhaInformada.setDscSaltSenha(senhaArmazenada.getDscSaltSenha());
		senhaInformada.criptografarSenha();
		
		if (!senhaArmazenada.getDscHashSenha().equals(senhaInformada.getDscHashSenha())) {
			throw new BusinessException(new Message("erro.senha.invalida"));
		}
		
		if (!TipoSenhaDTO.CHV_SENHA_DA_CONTA.equals(senhaInformada.getTipoSenha().getChvTipoSenha())) {
			this.getDao().expirarSenhaUsuario(senhaArmazenada.getIdSenhaUsuario());
		}
	}
	
	/**
	 * Obtém o campo dao.
	 * @return dao
	 */
	private UsuarioDAO getDao() {
		return this.dao;
	}
	
	@Override
	public void autenticarUsuario(String nomeConta, String dscSenha) {
		UsuarioDTO usuario = this.obterUsuarioPorNomeConta(nomeConta);
		if (usuario == null) {
			throw new BusinessException(new Message("erro.confirmacao.conta.conta.inexistente", nomeConta));
		}
		
		if (!usuario.getFlgContaConfirmada()) {
			throw new BusinessException(new Message("erro.confirmacao.conta.conta.inexistente", nomeConta));
		}
		
		SenhaUsuarioDTO senha = new SenhaUsuarioDTO();
		senha.setDscSenha(dscSenha);
		usuario.setSenhaConta(senha);
		
		usuario.getSenhaConta().setTipoSenha(
				super.getDominioFacade().obterTipoSenha(TipoSenhaDTO.CHV_SENHA_DA_CONTA));
		
		this.validarSenhaUsuario(usuario.getIdUsuario(), usuario.getSenhaConta());
	}
	
	@Override
	public UsuarioDTO obterUsuarioPorNomeConta(String nomeConta) {
		UsuarioDTO usuario = null;
		Integer idUsuario = this.getDao().obterIdUsuarioPorNomeConta(nomeConta);
		
		if (idUsuario != null) {
			usuario = this.getDao().obterUsuario(idUsuario);
		}
		
		return usuario;
	}
	
	@Override
	public void enviarEmailRecuperacaoConta(String dscEmail, String urlBase) {
		UsuarioDTO usuario = this.obterUsuarioPorEmail(dscEmail);
		if ((usuario == null) || !usuario.getFlgContaConfirmada()) {
			throw new BusinessException(new Message("erro.email.nao.cadastrado"));
		}
		SenhaUsuarioDTO senha = this.gravarNovaSenhaRecuperacaoConta(usuario.getIdUsuario());
		
		Message msgCorpoEmail = new Message("email.recuperacao.conta.corpo", urlBase, usuario.getNmeConta(),
				senha.getDscSenha());
		this.getMessageResolver().resolveMessage(msgCorpoEmail);
		
		super.enviarEmail(this.remetenteEmailRecuperacao, usuario.getDscEmail(), this.assuntoEmailRecuperacao,
				msgCorpoEmail.getMessage());
	}
	
	/**
	 * Grava nova senha de recuperação de conta.
	 * @param idUsuario Id do usuário.
	 * @return SenhaUsuarioDTO
	 */
	public SenhaUsuarioDTO gravarNovaSenhaRecuperacaoConta(Integer idUsuario) {
		return this.gravarNovaSenhaGerada(idUsuario,
				super.getDominioFacade().obterTipoSenha(TipoSenhaDTO.CHV_RECUPERACAO_CONTA));
	}
	
	/**
	 * Grava nova senha de confirmação de conta.
	 * @param idUsuario Id do usuário.
	 * @return SenhaUsuarioDTO
	 */
	public SenhaUsuarioDTO gravarNovaSenhaConfirmacaoConta(Integer idUsuario) {
		return this.gravarNovaSenhaGerada(idUsuario,
				super.getDominioFacade().obterTipoSenha(TipoSenhaDTO.CHV_CONFIRMACAO_CONTA));
	}
	
	/**
	 * Grava a nova senha da conta.
	 * @param idUsuario Id do usuário
	 * @param senha Senha
	 * @return SenhaUsuarioDTO
	 */
	private SenhaUsuarioDTO gravarNovaSenhaGerada(Integer idUsuario, TipoSenhaDTO tipoSenha) {
		SenhaUsuarioDTO senha = new SenhaUsuarioDTO();
		
		senha.setTipoSenha(tipoSenha);
		senha.setDscSenha(RandomStringUtils.randomAlphanumeric(SenhaUsuarioDTO.TAMANHO_SENHA_GERADA));
		senha.inicializarNovaSenha();
		
		this.gravarNovaSenha(idUsuario, senha);
		
		return senha;
	}
	
	/**
	 * Grava a nova senha da conta.
	 * @param idUsuario Id do usuário
	 * @param senha Senha
	 */
	private void gravarNovaSenhaConta(Integer idUsuario, SenhaUsuarioDTO senha) {
		senha.setTipoSenha(super.getDominioFacade().obterTipoSenha(TipoSenhaDTO.CHV_SENHA_DA_CONTA));
		this.gravarNovaSenha(idUsuario, senha);
	}
	
	/**
	 * Grava a nova senha.
	 * @param idUsuario Id do usuário
	 * @param senha Senha
	 */
	private void gravarNovaSenha(Integer idUsuario, SenhaUsuarioDTO senha) {
		senha.inicializarNovaSenha();
		senha.gerarSaltSenha();
		senha.criptografarSenha();
		
		this.getDao().expirarSenhasAntigas(idUsuario, senha.getTipoSenha().getIdTipoSenha());
		this.getDao().criarSenhaUsuario(idUsuario, senha);
	}
	
	/**
	 * Obtém o usuário pelo email.
	 * @param dscEmail Email
	 * @return UsuarioDTO
	 */
	private UsuarioDTO obterUsuarioPorEmail(String dscEmail) {
		UsuarioDTO usuario = null;
		Integer idUsuario = this.getDao().obterIdUsuarioPorEmail(dscEmail);
		
		if (idUsuario != null) {
			usuario = this.getDao().obterUsuario(idUsuario);
		}
		
		return usuario;
	}
	
	@Override
	public void trocarSenhaRecuperacaoConta(UsuarioDTO usuario) {
		UsuarioDTO usuarioObtido = this.obterUsuarioPorNomeConta(usuario.getNmeConta());
		if ((usuarioObtido == null) || !usuarioObtido.getFlgContaConfirmada()) {
			throw new BusinessException(new Message("erro.confirmacao.conta.conta.inexistente", usuario.getNmeConta()));
		}
		usuario.getSenhaRecuperacaoConta().setTipoSenha(
				super.getDominioFacade().obterTipoSenha(TipoSenhaDTO.CHV_RECUPERACAO_CONTA));
		this.validarSenhaUsuario(usuarioObtido.getIdUsuario(), usuario.getSenhaRecuperacaoConta());
		
		this.validarNovaSenhaConta(usuario.getSenhaConta());
		
		this.gravarNovaSenhaConta(usuarioObtido.getIdUsuario(), usuario.getSenhaConta());
	}
	
	@Override
	public UsuarioDTO obterUsuario(Integer idUsuario) {
		return this.getDao().obterUsuario(idUsuario);
	}
	
}
