package comercio.paravenda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProdutoServicoComposto extends ProdutoServico {

	private List<ProdutoServico> subProdutosServicos;	
	
	public ProdutoServicoComposto(String nome, Map<String,String> informacoes, List<ProdutoServico> subProdutosServicos){
		super(nome,informacoes);
		this.subProdutosServicos = subProdutosServicos;
	}	

	@Override
	public double getPrecoPorHora() {
		double answ = 0;
		
		for(ProdutoServico ps : subProdutosServicos)
			answ += ps.getPrecoPorHora();
		
		return answ;
	}

	@Override
	public double getPrecoPorUnidade() {		
		double answ = 0;
		
		for(ProdutoServico ps : subProdutosServicos)
			answ += ps.getPrecoPorUnidade();
		
		return answ;
	}

	@Override
	public String getInformacao(String tipoInformacao) {
		String inf;
		
		inf = informacoes.get(tipoInformacao);
		
		if(inf == null){
			inf = NULLSTRING;
			for(ProdutoServico ps : subProdutosServicos)
				if(inf.equals(NULLSTRING))
					inf = ps.getInformacao(tipoInformacao);						
		}		
		
		return inf;
	}
	
}