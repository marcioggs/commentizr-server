package com.commentizr.dto;

/**
 * Classe responsável pelas informações do histórico da mensagem.
 */
public class HistoricoMensagemDTO extends BaseDTO {
	
	private Integer idHistoricoMensagem;
	private Integer idMensagem;
	private Integer idAcaoUsuario;
	private AcaoUsuarioDTO acaoUsuario;
	private Integer idTipoAcaoUsuario;
	private TipoAcaoMensagemDTO tipoAcaoMensagem;
	private String dscTextoMensagem;
	
	/**
	 * Obtém o campo idHistoricoMensagem.
	 * @return idHistoricoMensagem
	 */
	public Integer getIdHistoricoMensagem() {
		return this.idHistoricoMensagem;
	}
	
	/**
	 * Especificao o campo idHistoricoMensagem.
	 * @param idHistoricoMensagem idHistoricoMensagem
	 */
	public void setIdHistoricoMensagem(Integer idHistoricoMensagem) {
		this.idHistoricoMensagem = idHistoricoMensagem;
	}
	
	/**
	 * Obtém o campo idMensagem.
	 * @return idMensagem
	 */
	public Integer getIdMensagem() {
		return this.idMensagem;
	}
	
	/**
	 * Especificao o campo idMensagem.
	 * @param idMensagem idMensagem
	 */
	public void setIdMensagem(Integer idMensagem) {
		this.idMensagem = idMensagem;
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
	 * Obtém o campo acaoUsuario.
	 * @return acaoUsuario
	 */
	public AcaoUsuarioDTO getAcaoUsuario() {
		return this.acaoUsuario;
	}
	
	/**
	 * Especificao o campo acaoUsuario.
	 * @param acaoUsuario acaoUsuario
	 */
	public void setAcaoUsuario(AcaoUsuarioDTO acaoUsuario) {
		this.acaoUsuario = acaoUsuario;
	}
	
	/**
	 * Obtém o campo idTipoAcaoUsuario.
	 * @return idTipoAcaoUsuario
	 */
	public Integer getIdTipoAcaoUsuario() {
		return this.idTipoAcaoUsuario;
	}
	
	/**
	 * Especificao o campo idTipoAcaoUsuario.
	 * @param idTipoAcaoUsuario idTipoAcaoUsuario
	 */
	public void setIdTipoAcaoUsuario(Integer idTipoAcaoUsuario) {
		this.idTipoAcaoUsuario = idTipoAcaoUsuario;
	}
	
	/**
	 * Obtém o campo tipoAcaoMensagem.
	 * @return tipoAcaoMensagem
	 */
	public TipoAcaoMensagemDTO getTipoAcaoMensagem() {
		return this.tipoAcaoMensagem;
	}
	
	/**
	 * Especificao o campo tipoAcaoMensagem.
	 * @param tipoAcaoMensagem tipoAcaoMensagem
	 */
	public void setTipoAcaoMensagem(TipoAcaoMensagemDTO tipoAcaoMensagem) {
		this.tipoAcaoMensagem = tipoAcaoMensagem;
	}
	
	/**
	 * Obtém o campo dscTextoMensagem.
	 * @return dscTextoMensagem
	 */
	public String getDscTextoMensagem() {
		return this.dscTextoMensagem;
	}
	
	/**
	 * Especificao o campo dscTextoMensagem.
	 * @param dscTextoMensagem dscTextoMensagem
	 */
	public void setDscTextoMensagem(String dscTextoMensagem) {
		this.dscTextoMensagem = dscTextoMensagem;
	}
	
}
