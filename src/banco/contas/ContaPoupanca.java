	package banco.contas;
	
	import java.time.LocalDate;
	
	public class ContaPoupanca extends Conta {
		
		private LocalDate dataAniversario;
		
		public ContaPoupanca(Long numero, String situacao, String senha,
				double saldo, LocalDate dataAniversario) {
			super(numero, situacao, senha, saldo);
			this.dataAniversario = dataAniversario;
		}
	
		public LocalDate getDataAniversario() {
			return dataAniversario;
		}
	
		@Override
		public String toString() {
			return "ContaPoupanca: {numero=" + this.getNumero() + ", dataAbertura=" + this.getDataAbertura() + ", dataEncerramento=" + this.getDataEncerramento()
					+ ", situacao=" + this.getSituacao() + ", senha=" + this.getSenha() + ", saldo=" + this.getSaldo() + ", movimentos=" + this.getMovimentos() + ", dataAniversario=" + dataAniversario
					+ "}";
		}
		
		
	}
	
