package banco.contas;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import banco.movimentos.Movimento;

public class Conta {
	
	private final Long numero;
	private final LocalDate dataAbertura;
	private LocalDate dataEncerramento;
	private String situacao;
	private String senha;
	private double saldo;
	private List<Movimento> movimentos;
	
	public Conta(Long numero, String situacao, String senha, double saldo) {
		super();
		this.numero = numero;
		this.dataAbertura = LocalDate.now();
		this.situacao = situacao;
		this.senha = senha;
		this.saldo = saldo;
		this.movimentos = new LinkedList<>();
	}

	public Long getNumero() {
		return numero;
	}

	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	public LocalDate getDataEncerramento() {
		return dataEncerramento;
	}

	public void setDataEncerramento(LocalDate dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void validaValor(double valor) {
		if (valor <= 0) {
	        throw new IllegalArgumentException("O valor deve ser maior que zero.");
	    }
	}
	
	public void depositar(double valor){
		validaValor(valor);
		
		this.saldo += valor;
		adicionarMovimento(new Movimento(1, valor));
	}
	
	protected void removerSaldo(double valor) {
		this.saldo -= valor;
	}

	public void sacar(double valor) {
	    validaValor(valor);

	    if (this.saldo < valor) {
	        throw new IllegalArgumentException("Saldo insuficiente para realizar o saque.");
	    }

	    adicionarMovimento(new Movimento(0, valor));
	    removerSaldo(valor);
	}
	
	public void adicionarMovimento(Movimento movimento) {
		this.movimentos.add(movimento);
	}
	
	public Movimento getMovimento (int index) {
		return this.movimentos.get(index);
	}

	
	public List<Movimento> getMovimentos(){
		return new LinkedList<>(movimentos);
	}
	
	@Override
	public String toString() {
		return "Conta: {numero=" + numero + ", dataAbertura=" + dataAbertura + ", dataEncerramento=" + dataEncerramento
				+ ", situacao=" + situacao + ", senha=" + senha + ", saldo=" + saldo + ", movimentos=" + movimentos
				+ "}";
	}

}
