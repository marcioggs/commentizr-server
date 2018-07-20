package com.commentizr.dto;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

/**
 * Classe responsável pelas informações da ação do usuário.
 */
public class AcaoUsuarioDTO extends BaseDTO {
	
	private Integer idAcaoUsuario;
	private Integer idUsuario;
	private UsuarioDTO usuario;
	private DateTime datAcaoUsuario;
	private Integer idAplicacaoOrigem;
	private AplicacaoOrigemDTO aplicacaoOrigem;
	
	public String getDatAcaoUsuarioFormatada() {
		return DateTimeFormat.forPattern("MM/dd/yyyy HH:mm").print(this.getDatAcaoUsuario());
	}
	
	/**
	 * Obtém o campo idAcaoUsuario.
	 * @return idAcaoUsuario
	 */
	public Integer getIdAcaoUsuario() {
		return this.idAcaoUsuario;
	}
	
	/**
	 * Especificao o campo idAcaoUsuario.
	 * @param idAcaoUsuario idAcaoUsuario
	 */
	public void setIdAcaoUsuario(Integer idAcaoUsuario) {
		this.idAcaoUsuario = idAcaoUsuario;
	}
	
	/**
	 * Obtém o campo idUsuario.
	 * @return idUsuario
	 */
	public Integer getIdUsuario() {
		return this.idUsuario;
	}
	
	/**
	 * Especificao o campo idUsuario.
	 * @param idUsuario idUsuario
	 */
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	/**
	 * Obtém o campo usuario.
	 * @return usuario
	 */
	public UsuarioDTO getUsuario() {
		return this.usuario;
	}
	
	/**
	 * Especificao o campo usuario.
	 * @param usuario usuario
	 */
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	
	/**
	 * Obtém o campo datAcaoUsuario.
	 * @return datAcaoUsuario
	 */
	public DateTime getDatAcaoUsuario() {
		return this.datAcaoUsuario;
	}
	
	/**
	 * Especificao o campo datAcaoUsuario.
	 * @param datAcaoUsuario datAcaoUsuario
	 */
	public void setDatAcaoUsuario(DateTime datAcaoUsuario) {
		this.datAcaoUsuario = datAcaoUsuario;
	}
	
	/**
	 * Obtém o campo idAplicacaoOrigem.
	 * @return idAplicacaoOrigem
	 */
	public Integer getIdAplicacaoOrigem() {
		return this.idAplicacaoOrigem;
	}
	
	/**
	 * Especificao o campo idAplicacaoOrigem.
	 * @param idAplicacaoOrigem idAplicacaoOrigem
	 */
	public void setIdAplicacaoOrigem(Integer idAplicacaoOrigem) {
		this.idAplicacaoOrigem = idAplicacaoOrigem;
	}
	
	/**
	 * Obtém o campo aplicacaoOrigem.
	 * @return aplicacaoOrigem
	 */
	public AplicacaoOrigemDTO getAplicacaoOrigem() {
		return this.aplicacaoOrigem;
	}
	
	/**
	 * Especificao o campo aplicacaoOrigem.
	 * @param aplicacaoOrigem aplicacaoOrigem
	 */
	public void setAplicacaoOrigem(AplicacaoOrigemDTO aplicacaoOrigem) {
		this.aplicacaoOrigem = aplicacaoOrigem;
	}
	
}
