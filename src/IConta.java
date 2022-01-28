
public interface IConta {

	void sacar(double valor);
	
    void depositar(double valor);
	
	String transferir(double valor, Conta contaDestino, Conta contaOrigem);
	
	void imprimirExtrato();
}
