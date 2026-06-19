package banco.contas;

import banco.movimentos.Movimento;

public class ContaEspecial extends Conta {
	
	private static final double LIMITE_PADRAO = 500;
	
	private double limite = LIMITE_PADRAO;

	public ContaEspecial(Long numero, String situacao, String senha,
			double saldo) {
		super(numero, situacao, senha, saldo);
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	@Override
	public void sacar(double valor) {
	    validaValor(valor);

	    if (this.getSaldo() + limite < valor) {
	        throw new IllegalArgumentException("Saldo insuficiente para realizar o saque.");
	    }

	    adicionarMovimento(new Movimento(0, valor));
	    removerSaldo(valor);
	}
	
	@Override
	public String toString() {
		return "ContaEspecial: {numero=" + this.getNumero() + ", dataAbertura=" + this.getDataAbertura() + ", dataEncerramento=" + this.getDataEncerramento()
				+ ", situacao=" + this.getSituacao() + ", senha=" + this.getSenha() + ", saldo=" + this.getSaldo() + ", movimentos=" + this.getMovimentos() + ", limite=" + limite
				+ "}";
	}
}
