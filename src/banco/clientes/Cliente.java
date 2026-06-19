package banco.clientes;

import java.util.LinkedList;
import java.util.List;

import banco.contas.Conta;

public abstract class Cliente {

	private String nome;
	private String endereco;
	private String cep;
	private String telefone;
	private double renda;
	private String situacao;
	private List<Conta> contas;
	
	public Cliente(String nome, String endereco, String cep, String telefone, double renda, String situacao,
			List<Conta> contas) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.cep = cep;
		this.telefone = telefone;
		this.renda = renda;
		this.situacao = situacao;
				this.contas = new LinkedList<>(contas);
	}

	public Cliente(String nome, String endereco, String cep, String telefone, double renda, String situacao,
			Conta conta) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.cep = cep;
		this.telefone = telefone;
		this.renda = renda;
		this.situacao = situacao;
		this.contas = new LinkedList<Conta>();
		this.contas.add(conta);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public double getRenda() {
		return renda;
	}

	public void setRenda(double renda) {
		this.renda = renda;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public void adicionarConta(Conta conta) {
		this.contas.add(conta);
	}
	
	public Conta getConta(int index) {
		return this.contas.get(index);
	}
	
	public List<Conta> getContas() {
		return new LinkedList<>(contas);
	}

	@Override
	public String toString() {
		return "Cliente: {nome=" + nome + ", endereco=" + endereco + ", cep=" + cep + ", telefone=" + telefone
				+ ", renda=" + renda + ", situacao=" + situacao + ", contas=" + contas + "}";
	}
}
	