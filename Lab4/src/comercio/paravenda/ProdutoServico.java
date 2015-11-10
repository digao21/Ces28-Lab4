package comercio.paravenda;

import java.util.HashMap;
import java.util.Map;

public abstract class ProdutoServico {
	
	public static final String NULLSTRING = "Nao possuo tal informacao";
	
	protected final String nome;
	protected final Map<String,String> informacoes;	
	
	public ProdutoServico(String nome, Map<String,String> informacoes){		
		this.nome = nome;
		this.informacoes = informacoes;
	}
	
	public String getNome(){
		return nome;
	}
	
	public String getInformacao(String tipoInformacao){		
		String inf;
		
		inf = informacoes.get(tipoInformacao);	
		
		if(inf == null)
			inf = NULLSTRING;
			
		return inf;
	}	
	
	public abstract double getPrecoPorHora();
	public abstract double getPrecoPorUnidade();
		
	
}
