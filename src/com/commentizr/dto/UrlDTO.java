package com.commentizr.dto;

/**
 * Classe responsável pelas informações da URL.
 */
public class UrlDTO extends BaseDTO {
	
	private Integer idUrl;
	private DominioUrlDTO dominio;
	private String dscCaminho;
	public String urlCompleta;
	
	// TODO: Colocar no Facade
	/*	*//**
	 * Seta os atributos desta classe a partir da URL completa.
	 * @param urlCompleta URL completa
	 */
	/*
	 * public void setUrlCompleta(String urlCompleta) {
	 * URL url;
	 * try {
	 * url = new URL(urlCompleta);
	 * } catch (MalformedURLException e) {
	 * throw new BusinessException(e, new Message("url.invalida"));
	 * }
	 * this.setDominio(new DominioUrlDTO(url.getHost()));
	 * this.setDscCaminho(url.getPath());
	 * }
	 */
	
	/**
	 * Obtém o campo idUrl.
	 * @return idUrl
	 */
	public Integer getIdUrl() {
		return this.idUrl;
	}
	
	/**
	 * Especificao o campo idUrl.
	 * @param idUrl idUrl
	 */
	public void setIdUrl(Integer idUrl) {
		this.idUrl = idUrl;
	}
	
	/**
	 * Obtém o campo dominio.
	 * @return dominio
	 */
	public DominioUrlDTO getDominio() {
		return this.dominio;
	}
	
	/**
	 * Especificao o campo dominio.
	 * @param dominio dominio
	 */
	public void setDominio(DominioUrlDTO dominio) {
		this.dominio = dominio;
	}
	
	/**
	 * Obtém o campo dscCaminho.
	 * @return dscCaminho
	 */
	public String getDscCaminho() {
		return this.dscCaminho;
	}
	
	/**
	 * Especificao o campo dscCaminho.
	 * @param dscCaminho dscCaminho
	 */
	public void setDscCaminho(String dscCaminho) {
		this.dscCaminho = dscCaminho;
	}
	
	/**
	 * Obtém o campo urlCompleta.
	 * @return urlCompleta
	 */
	public String getUrlCompleta() {
		return this.urlCompleta;
	}
	
	/**
	 * Especificao o campo urlCompleta.
	 * @param urlCompleta urlCompleta
	 */
	public void setUrlCompleta(String urlCompleta) {
		this.urlCompleta = urlCompleta;
	}
	
}
