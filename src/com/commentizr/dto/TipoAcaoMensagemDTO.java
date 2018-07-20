package com.commentizr.dto;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Classe responsável pelas informações dos tipos de açãos realizada nas mensagem.
 */
public class TipoAcaoMensagemDTO extends BaseDTO {

	private Integer idTipoAcaoMensagem;
	private String chvTipoAcaoMensagem;
	private String dscTipoAcaoMensagem;

	public static String CHV_ADICIONAR = "ADD_MSG";
	public static String CHV_ATUALIZAR = "UPD_MSG";
	public static String CHV_REMOVER = "DEL_MSG";

	/**
	 * Construtor padrão.
	 */
	public TipoAcaoMensagemDTO() {
		super();
	}

	/**
	 * Construtor com a chave da ação.
	 */
	public TipoAcaoMensagemDTO(String chvTipoAcaoMensagem) {
		this();
		this.chvTipoAcaoMensagem = chvTipoAcaoMensagem;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(82, 37).append(this.getChvTipoAcaoMensagem()).toHashCode();
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
		TipoAcaoMensagemDTO ins = (TipoAcaoMensagemDTO) obj;
		return new EqualsBuilder().append(this.getChvTipoAcaoMensagem(), ins.getChvTipoAcaoMensagem()).isEquals();
	}

	/**
	 * Obtém o tipo de ação de mensagem em uma lista.
	 * @param tiposAcoesMensagem Lista de tipos de ações
	 * @param chvTipoAcaoMensagem Chave do tipo de ação da mensagem
	 * @return TipoAcaoMensagemDTO
	 */
	public static TipoAcaoMensagemDTO obterTipoAcaoMensagem(List<TipoAcaoMensagemDTO> tiposAcoesMensagem,
			String chvTipoAcaoMensagem) {
		TipoAcaoMensagemDTO tipoAcao = null;

		int i = tiposAcoesMensagem.indexOf(new TipoAcaoMensagemDTO(chvTipoAcaoMensagem));
		if (i != -1) {
			tipoAcao = tiposAcoesMensagem.get(i);
		}

		return tipoAcao;
	}

	/**
	 * Obtém o campo idTipoAcaoMensagem.
	 * @return idTipoAcaoMensagem
	 */
	public Integer getIdTipoAcaoMensagem() {
		return this.idTipoAcaoMensagem;
	}

	/**
	 * Especificao o campo idTipoAcaoMensagem.
	 * @param idTipoAcaoMensagem idTipoAcaoMensagem
	 */
	public void setIdTipoAcaoMensagem(Integer idTipoAcaoMensagem) {
		this.idTipoAcaoMensagem = idTipoAcaoMensagem;
	}

	/**
	 * Obtém o campo chvTipoAcaoMensagem.
	 * @return chvTipoAcaoMensagem
	 */
	public String getChvTipoAcaoMensagem() {
		return this.chvTipoAcaoMensagem;
	}

	/**
	 * Especificao o campo chvTipoAcaoMensagem.
	 * @param chvTipoAcaoMensagem chvTipoAcaoMensagem
	 */
	public void setChvTipoAcaoMensagem(String chvTipoAcaoMensagem) {
		this.chvTipoAcaoMensagem = chvTipoAcaoMensagem;
	}

	/**
	 * Obtém o campo dscTipoAcaoMensagem.
	 * @return dscTipoAcaoMensagem
	 */
	public String getDscTipoAcaoMensagem() {
		return this.dscTipoAcaoMensagem;
	}

	/**
	 * Especificao o campo dscTipoAcaoMensagem.
	 * @param dscTipoAcaoMensagem dscTipoAcaoMensagem
	 */
	public void setDscTipoAcaoMensagem(String dscTipoAcaoMensagem) {
		this.dscTipoAcaoMensagem = dscTipoAcaoMensagem;
	}

}
