package com.commentizr.dto;

/**
 * Classe responsável pelas informações do domínio da URL.
 */
public class DominioUrlDTO extends BaseDTO {
	
	private Integer idDominioUrl;
	private String dscDominioUrl;
	
	/**
	 * Construtor padrão.
	 */
	public DominioUrlDTO() {
		super();
	}
	
	/**
	 * Construtor com o domínio..
	 */
	public DominioUrlDTO(String dscDominioUrl) {
		super();
		this.dscDominioUrl = dscDominioUrl;
	}
	
	/**
	 * Obtém o campo idDominioUrl.
	 * @return idDominioUrl
	 */
	public Integer getIdDominioUrl() {
		return this.idDominioUrl;
	}
	
	/**
	 * Especificao o campo idDominioUrl.
	 * @param idDominioUrl idDominioUrl
	 */
	public void setIdDominioUrl(Integer idDominioUrl) {
		this.idDominioUrl = idDominioUrl;
	}
	
	/**
	 * Obtém o campo dscDominioUrl.
	 * @return dscDominioUrl
	 */
	public String getDscDominioUrl() {
		return this.dscDominioUrl;
	}
	
	/**
	 * Especificao o campo dscDominioUrl.
	 * @param dscDominioUrl dscDominioUrl
	 */
	public void setDscDominioUrl(String dscDominioUrl) {
		this.dscDominioUrl = dscDominioUrl;
	}
	
}
