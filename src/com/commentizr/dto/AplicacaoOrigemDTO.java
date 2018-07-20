package com.commentizr.dto;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Classe responsável pelas informações da aplicação origem.
 */
public class AplicacaoOrigemDTO extends BaseDTO {
	
	private Integer idAplicacaoOrigem;
	private String chvAplicacaoOrigem;
	private String dscAplicacaoOrigem;
	
	public static String CHV_EXTENSAO_CHROME = "CHROME_EXT";
	
	/**
	 * Construtor padrão.
	 */
	public AplicacaoOrigemDTO() {
		super();
	}
	
	/**
	 * Construtor com a chave da aplicação origem.
	 */
	public AplicacaoOrigemDTO(String chvAplicacaoOrigem) {
		this();
		this.chvAplicacaoOrigem = chvAplicacaoOrigem;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(this.getChvAplicacaoOrigem())
				.toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != this.getClass()) {
			return false;
		}
		AplicacaoOrigemDTO ins = (AplicacaoOrigemDTO) obj;
		return new EqualsBuilder().append(this.getChvAplicacaoOrigem(),
				ins.getChvAplicacaoOrigem()).isEquals();
	}
	
	/**
	 * Obtém a aplicação origem em uma lista.
	 * @param aplicacoesOrigem Lista de aplicações
	 * @param chvAplicacaoOrigem Chave da aplicação
	 * @return SourceAppDTO
	 */
	public static AplicacaoOrigemDTO obterAplicacaoOrigem(
			List<AplicacaoOrigemDTO> aplicacoesOrigem, String chvAplicacaoOrigem) {
		AplicacaoOrigemDTO aplicacaoOrigem = null;
		
		int i = aplicacoesOrigem.indexOf(new AplicacaoOrigemDTO(chvAplicacaoOrigem));
		if (i != -1) {
			aplicacaoOrigem = aplicacoesOrigem.get(i);
		}
		
		return aplicacaoOrigem;
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
	 * Obtém o campo chvAplicacaoOrigem.
	 * @return chvAplicacaoOrigem
	 */
	public String getChvAplicacaoOrigem() {
		return this.chvAplicacaoOrigem;
	}
	
	/**
	 * Especificao o campo chvAplicacaoOrigem.
	 * @param chvAplicacaoOrigem chvAplicacaoOrigem
	 */
	public void setChvAplicacaoOrigem(String chvAplicacaoOrigem) {
		this.chvAplicacaoOrigem = chvAplicacaoOrigem;
	}
	
	/**
	 * Obtém o campo dscAplicacaoOrigem.
	 * @return dscAplicacaoOrigem
	 */
	public String getDscAplicacaoOrigem() {
		return this.dscAplicacaoOrigem;
	}
	
	/**
	 * Especificao o campo dscAplicacaoOrigem.
	 * @param dscAplicacaoOrigem dscAplicacaoOrigem
	 */
	public void setDscAplicacaoOrigem(String dscAplicacaoOrigem) {
		this.dscAplicacaoOrigem = dscAplicacaoOrigem;
	}
	
}
