
public abstract class Conta  implements IConta {

	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	
	public Conta(Cliente cliente) {
		this.agencia = AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}
	
	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}


	public double getSaldo() {
		return saldo;
	}

	@Override
	public void sacar(double valor) {
		saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public String transferir(double valor, Conta contaDestino, Conta contaOrigem) {
		if (verificaSaldo(valor, contaOrigem) == true)  {
			this.sacar(valor);
			contaDestino.depositar(valor);
			System.out.println("Transferência realizada com sucesso para conta " + contaDestino);
			return "Transferência realizada com sucesso para conta " + contaDestino;
		} else {
			System.out.println("Saldo insuficiente na conta " + contaOrigem);
			return "Saldo insuficiente na conta " + contaOrigem;
		}
		
		
	}

	protected void ImprimirInfoComuns() {
		System.out.println(String.format("Titular: %s", cliente.getNome()));
		System.out.println(String.format("Agência: %d", agencia));
		System.out.println(String.format("Número: %d", numero));
		System.out.println(String.format("Saldo: %.2f", saldo));
	}

	private Boolean verificaSaldo(double valor, Conta contaOrigem) {
		if (contaOrigem.saldo >= valor) {
			return true;
		} else {
			return false;
		}
	}
}
