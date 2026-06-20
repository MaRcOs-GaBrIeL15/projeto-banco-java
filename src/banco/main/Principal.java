package banco.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import banco.clientes.Cliente;
import banco.clientes.PessoaFisica;
import banco.contas.Conta;
import banco.contas.ContaEspecial;
import banco.contas.ContaPoupanca;

public class Principal {

	static Scanner teclado = new Scanner(System.in);
	static List<Cliente> clientes = new ArrayList<>();

	public static void main(String[] args) {

		Cliente clienteAtual = null;

		while (clienteAtual == null) {

			System.out.println("\n=== SISTEMA BANCARIO ===");
			System.out.println("1 - Criar cliente");
			System.out.println("2 - Sair");

			int opcao = teclado.nextInt();
			teclado.nextLine();

			switch (opcao) {

			case 1:
				clienteAtual = criarCliente();
				break;

			case 2:
				System.out.println("Encerrando sistema...");
				return;

			default:
				System.out.println("Opcao invalida.");
				break;
			}
		}

		while (true) {

			System.out.println("\n=== MENU DO CLIENTE ===");
			System.out.println("1 - Criar conta");
			System.out.println("2 - Acessar conta");
			System.out.println("3 - Sair");

			int opcao = teclado.nextInt();
			teclado.nextLine();

			switch (opcao) {

			case 1:
				criarConta(clienteAtual);
				break;

			case 2:
				acessarConta(clienteAtual);
				break;

			case 3:
				System.out.println("Encerrando sistema...");
				return;

			default:
				System.out.println("Opcao invalida.");
				break;
			}
		}
	}

	private static Cliente criarCliente() {

		System.out.println("\n=== CRIACAO DE CLIENTE ===");

		System.out.println("Nome:");
		String nome = teclado.nextLine();

		System.out.println("Endereco:");
		String endereco = teclado.nextLine();

		System.out.println("CEP:");
		String cep = teclado.nextLine();

		System.out.println("Telefone:");
		String telefone = teclado.nextLine();

		System.out.println("Renda:");
		double renda = teclado.nextDouble();
		teclado.nextLine();

		Cliente cliente = new PessoaFisica(nome, endereco, cep, telefone, renda, "ATIVO", new ArrayList<>(), 0L, 0L);

		clientes.add(cliente);

		System.out.println("Cliente criado com sucesso!");

		return cliente;
	}

	private static void criarConta(Cliente cliente) {

		System.out.println("\n=== CRIACAO DE CONTA ===");

		System.out.println("Escolha o tipo de conta:");
		System.out.println("1 - Conta Corrente");
		System.out.println("2 - Conta Especial");
		System.out.println("3 - Conta Poupanca");

		int tipoConta = teclado.nextInt();
		teclado.nextLine();

		System.out.println("Senha:");
		String senha = teclado.nextLine();

		System.out.println("Saldo inicial:");
		double saldo = teclado.nextDouble();
		teclado.nextLine();

		Long numero = (long) (cliente.getContas().size() + 1);

		Conta conta;

		switch (tipoConta) {

		case 1:
			conta = new Conta(numero, "ATIVA", senha, saldo);
			break;

		case 2:
			conta = new ContaEspecial(numero, "ATIVA", senha, saldo);
			break;

		case 3:
			System.out.println("Data de aniversario da poupanca (AAAA-MM-DD):");
			String data = teclado.nextLine();

			LocalDate dataAniversario = LocalDate.parse(data);

			conta = new ContaPoupanca(numero, "ATIVA", senha, saldo, dataAniversario);
			break;

		default:
			System.out.println("Tipo de conta invalido.");
			return;
		}

		cliente.adicionarConta(conta);

		System.out.println("Conta criada com sucesso!");
	}

	private static void acessarConta(Cliente cliente) {

		if (cliente.getContas().isEmpty()) {

			System.out.println("O cliente nao possui contas.");
			return;
		}

		System.out.println("\n=== CONTAS DISPONIVEIS ===");

		for (int i = 0; i < cliente.getContas().size(); i++) {

			Conta conta = cliente.getConta(i);

			System.out.println("Conta numero: " + conta.getNumero());
		}

		System.out.println("Escolha uma conta:");

		int indice = teclado.nextInt();
		teclado.nextLine();

		if (indice < 0 || indice >= cliente.getContas().size()) {

			System.out.println("Conta invalida.");
			return;
		}

		Conta contaSelecionada = cliente.getConta(indice);

		menuConta(contaSelecionada);
	}

	private static void menuConta(Conta conta) {

		while (true) {

			System.out.println("\n=== CONTA " + conta.getNumero() + " ===");
			System.out.println("1 - Sacar");
			System.out.println("2 - Depositar");
			System.out.println("3 - Verificar situacao da conta");
			System.out.println("4 - Sair");

			int opcao = teclado.nextInt();
			teclado.nextLine();

			switch (opcao) {

			case 1:

				System.out.println("Valor do saque:");

				double valorSaque = teclado.nextDouble();
				teclado.nextLine();

				try {

					conta.sacar(valorSaque);

					System.out.println("Saque realizado com sucesso!");

				} catch (IllegalArgumentException e) {

					System.out.println(e.getMessage());

				}

				break;

			case 2:

				System.out.println("Valor do depósito:");

				double valorDeposito = teclado.nextDouble();
				teclado.nextLine();

				try {

					conta.depositar(valorDeposito);

					System.out.println("Depósito realizado com sucesso!");

				} catch (IllegalArgumentException e) {

					System.out.println(e.getMessage());

				}

				break;

			case 3:

				System.out.println("\n=== SITUAÇÃO DA CONTA ===");

				System.out.println("Numero: " + conta.getNumero());
				System.out.println("Saldo: " + conta.getSaldo());
				System.out.println("Situacao: " + conta.getSituacao());
				System.out.println("Data de abertura: " + conta.getDataAbertura());

				System.out.println("\nMovimentos:");

				if (conta.getMovimentos().isEmpty()) {

					System.out.println("Nenhum movimento realizado.");

				} else {

					for (int i = 0; i < conta.getMovimentos().size(); i++) {

						System.out.println(conta.getMovimento(i));
					}
				}

				break;

			case 4:

				return;

			default:

				System.out.println("Opcao invalida.");

				break;
			}
		}
	}
}