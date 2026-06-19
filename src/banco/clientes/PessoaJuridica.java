package banco.clientes;

import java.util.List;

import banco.contas.Conta;

public class PessoaJuridica extends Cliente {
	
	private long cnpj;

	public PessoaJuridica(String nome, String endereco, String cep, String telefone, double renda, String situacao, Conta conta,
			long cnpj) {
		super(nome, endereco, cep, telefone, renda, situacao, conta);
		this.cnpj = cnpj;
	}
	
	public PessoaJuridica(String nome, String endereco, String cep, String telefone, double renda, String situacao, List<Conta> contas,
			long cnpj) {
		super(nome, endereco, cep, telefone, renda, situacao, contas);
		this.cnpj = cnpj;
	}
	
	@Override
	public String toString() {
		return "PessoaJuridica: {nome=" + this.getNome() + ", endereco=" + this.getEndereco() + ", cep=" + this.getCep() + ", telefone=" + this.getTelefone()
				+ ", renda=" + this.getRenda() + ", situacao=" + this.getSituacao() + ", contas=" + this.getContas() + ", cnpj=" + cnpj + "}";
	}
}
