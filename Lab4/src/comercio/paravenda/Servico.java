package comercio.paravenda;

import java.util.Map;

public class Servico extends ProdutoServico {
	
	private double precoPorHora;	
	
	public Servico(String nome, Map<String,String> informacoes, double precoPorHora){
		super(nome,informacoes);
		this.precoPorHora = precoPorHora;		
	}
		
	@Override
	public double getPrecoPorHora() {
		return precoPorHora;
	}
	@Override
	public double getPrecoPorUnidade() {
		return 0;
	}	
	
}
