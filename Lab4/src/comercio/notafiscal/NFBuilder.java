package comercio.notafiscal;

import java.util.Map;

import bancodedados.BancoDeDados;
import comercio.paravenda.FabricaItemDeVenda;

//BUILDER COM INTRFACE FLUENTE
public class NFBuilder {	
	
	NotaFiscal nf;	
	
	public NFBuilder(){
		nf = new NotaFiscal();		
	}
	
	public NFBuilder adicionarItemDeVenda(int qnt, String psNome, double desc, 
			Map<String,String> mp){
		
		new FabricaItemDeVenda()
			.definirQuantidade(qnt)
			.definirNomeDoProdutoServico(psNome)
			.adicionarDesconto(desc)
			.adicionarInformacao(mp)
			.criarItemDeVenda(nf);
		
		return this;
	}
	
	public NFBuilder adicionarItemDeVenda(FabricaItemDeVenda fabrica){		
		fabrica.criarItemDeVenda(nf);		
		return this;
	}
	
	public NFBuilder adicionarInformacao(String tipoInformacao, String informacao){
		nf.adicionarInformacao(tipoInformacao, informacao);
		return this;
	}
	
	public NotaFiscal criarNotaFiscal(){
		BancoDeDados bd = BancoDeDados.getBancoDeDados();		
		bd.validarNotaFiscal(nf);		
		return nf;
	}
	
}
