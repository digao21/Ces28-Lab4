package tributacao;

import comercio.notafiscal.NotaFiscal;

public abstract class Imposto {
	private String nome;
	
	public String getNome(){
		return nome;
	}
	
	public abstract double calcularImposto(Tributavel item , NotaFiscal fs);
	
	protected void registrar(double valor, NotaFiscal fs){
		fs.registrarImposto(nome, valor);
	}
	
}
