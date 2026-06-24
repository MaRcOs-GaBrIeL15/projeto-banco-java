package banco.clientes;

import java.util.List;

import banco.contas.Conta;

public class PessoaFisica extends Cliente {

	private long cpf;
	private long rg;

	public PessoaFisica(String nome, String endereco, String cep, String telefone, double renda, String situacao,
			Conta conta, long cpf, long rg) {
		super(nome, endereco, cep, telefone, renda, situacao, conta);
		this.cpf = cpf;
		this.rg = rg;
	}

	public PessoaFisica(String nome, String endereco, String cep, String telefone, double renda, String situacao,
			List<Conta> contas, long cpf, long rg) {
		super(nome, endereco, cep, telefone, renda, situacao, contas);
		this.cpf = cpf;
		this.rg = rg;
	}

	@Override
	public String toString() {
		return "PessoaFisica: {nome=" + this.getNome() + ", endereco=" + this.getEndereco() + ", cep=" + this.getCep()
				+ ", telefone=" + this.getTelefone() + ", renda=" + this.getRenda() + ", situacao=" + this.getSituacao()
				+ ", contas=" + this.getContas() + ", cpf=" + cpf + ", rg=" + rg + "}";
	}
}
