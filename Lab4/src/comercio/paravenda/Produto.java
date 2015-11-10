package comercio.paravenda;

import java.util.Map;

public class Produto extends ProdutoServico {

	private double precoPorUnidade;	
	
	public Produto(String nome, Map<String,String> informacoes, double precoPorUnidade){
		super(nome,informacoes);
		this. precoPorUnidade = precoPorUnidade;		
	}
		
	@Override
	public double getPrecoPorHora() {
		return 0;
	}
	@Override
	public double getPrecoPorUnidade() {
		return precoPorUnidade;
	}	
	
}
