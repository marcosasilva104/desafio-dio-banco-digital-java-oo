
public class Main {

	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		
		cliente.setNome("Marcos Silva");
		
		Conta contaCorrente = new ContaCorrente(cliente);
		Conta contaPoupanca = new ContaPoupanca(cliente);
		
		contaCorrente.depositar(100);
		contaCorrente.transferir(50, contaPoupanca, contaCorrente);
		
		contaCorrente.imprimirExtrato();
		contaPoupanca.imprimirExtrato();
	}

}