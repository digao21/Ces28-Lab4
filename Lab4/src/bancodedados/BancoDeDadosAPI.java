package bancodedados;

import comercio.paravenda.ProdutoServico;

public class BancoDeDadosAPI {
	private BancoDeDados BDD;
	
	public BancoDeDadosAPI(){
		BDD = BancoDeDados.getBancoDeDados();
	}
	
	public ProdutoServico getProdutoServicoBDD(String psNome){
		return BDD.getProdutoServico(psNome);
	}
	
	public void setProdutoServicoBDD(ProdutoServico ps){
		BDD.setProdutoServico(ps);
	}
}
