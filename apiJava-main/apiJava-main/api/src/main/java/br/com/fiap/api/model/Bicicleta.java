package br.com.fiap.api.model;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Bicicleta {
	
	private int num_serie;
	private String modelo;
	private String marca;
	private String cor;
	private String tamanho;
	private String tipo;
	private double valor;
	private int nota_fiscal;
	private int ano;
	private String cpf;
	
	public Bicicleta() {
		
	}	
	public Bicicleta(int num_serie, String modelo, String marca, String cor, String tamanho, String tipo, double valor,
			int nota_fiscal, int ano, String cpf) {
		super();
		this.num_serie = num_serie;
		this.modelo = modelo;
		this.marca = marca;
		this.cor = cor;
		this.tamanho = tamanho;
		this.tipo = tipo;
		this.valor = valor;
		this.nota_fiscal = nota_fiscal;
		this.ano = ano;
		this.cpf = cpf;
	}
	
	public int getNum_serie() {
		return num_serie;
	}
	public void setNum_serie(int num_serie) {
		this.num_serie = num_serie;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getNota_fiscal() {
		return nota_fiscal;
	}
	public void setNota_fiscal(int nota_fiscal) {
		this.nota_fiscal = nota_fiscal;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
