package com.rafaelbiase.cursojava.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.rafaelbiase.cursojava.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComboleto extends Pagamento {
	
	private static final long serialVersionUID = 1L;
	
	private Date dataVencimento;
	private Date dataPagamento;
	
	public PagamentoComboleto() {
		
	}

	public PagamentoComboleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamneto) {
		super(id, estado, pedido);
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamneto;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	
	
	
	

}
