package com.infortech.Restaurante.classes;

public class Pedido {
	private int id;
	private long dataHora;
	private double preco;
	private String observacao;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getDataHora() {
		return dataHora;
	}
	public void setDataHora(long dataHora) {
		this.dataHora = dataHora;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	
}
