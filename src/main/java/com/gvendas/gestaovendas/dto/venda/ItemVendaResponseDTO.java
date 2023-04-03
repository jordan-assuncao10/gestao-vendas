package com.gvendas.gestaovendas.dto.venda;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Itens venda retorno DTO")
public class ItemVendaResponseDTO {

	@ApiModelProperty(value = "Código")
	private Long codigo;
	
	@ApiModelProperty(value = "Quantidade")
	private Integer quantidade;
	
	@ApiModelProperty(value = "Preço vendido")
	private BigDecimal precoVendido;
	
	@ApiModelProperty(value = "Código produto")
	private Long codigoProduto;
	
	@ApiModelProperty(value = "Descrição")
	private String descricao;

	public ItemVendaResponseDTO(Long codigo, Integer quantidade, BigDecimal precoVendido, Long codigoProduto,
			String descricao) {
		this.codigo = codigo;
		this.quantidade = quantidade;
		this.precoVendido = precoVendido;
		this.codigoProduto = codigoProduto;
		this.descricao = descricao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPrecoVendido() {
		return precoVendido;
	}

	public void setPrecoVendido(BigDecimal precoVendido) {
		this.precoVendido = precoVendido;
	}

	public Long getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Long codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
