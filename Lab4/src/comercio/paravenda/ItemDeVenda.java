package comercio.paravenda;

import java.util.Map;

import bancodedados.BancoDeDados;
import tributacao.CategoriaTributaria;
import tributacao.Tributavel;

public class ItemDeVenda implements Tributavel {
	
	//IMPLEMENTAR
	
	private int quantidade;
	private ProdutoServico ps;
	private double desconto;
	CategoriaTributaria ct = null;
	private Map<String,String> map;
	
	public ItemDeVenda(int qnt, String psNome, double desc, 
			Map<String,String> mp){
		quantidade = qnt;
		desconto = desc;
		map = mp;
		
		BancoDeDados bd = BancoDeDados.getBancoDeDados();
		
		
	}
	
	public CategoriaTributaria getCategoriaTributaria(){
		return ct;
	}

	public void setCategoriaTributaria(CategoriaTributaria ct){
		if(this.ct != null)
			throw new RuntimeException("Categoria tributaria e imutavel");
		this.ct = ct;
	}
	
	@Override
	public int getQuantidade() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getPreco() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String categoriaTributaria() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
