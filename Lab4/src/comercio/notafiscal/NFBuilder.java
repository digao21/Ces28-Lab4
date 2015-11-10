package comercio.notafiscal;

import comercio.paravenda.ItemDeVenda;

public class NFBuilder {

	NotaFiscal nf;	
	
	public NFBuilder(){
		nf = new NotaFiscal();		
	}
	
	public NFBuilder adicionarItemDeVenda(String nomeDoItem){
		nf.adicionarItemDeVenda(item);
		return this;
	}
	
	public NFBuilder informarCondicoesDeEntrega(String condicoes){		
		nf.setCondicoesDeEntrega(condicoes);
		return this;
	}
	
}
