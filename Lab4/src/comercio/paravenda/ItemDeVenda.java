package comercio.paravenda;

import java.util.Map;

import bancodedados.BancoDeDados;
import comercio.notafiscal.NotaFiscal;
import tributacao.Imposto;
import tributacao.Tributavel;

public class ItemDeVenda implements Tributavel {
	
	//IMPLEMENTAR	
	private int quantidade;
	private ProdutoServico ps = null;
	private double desconto;
	Imposto imposto = null;
	private Map<String,String> map;
	
	ItemDeVenda(int qnt, String psNome, double desc, 
			Map<String,String> mp){
		quantidade = qnt;
		desconto = desc;
		map = mp;
		
		BancoDeDados bd = BancoDeDados.getBancoDeDados();
		bd.adicionProdutoServicoAoItemDeVenda(this, psNome);
				
	}
		

	public void setImposto(Imposto im){
		if(imposto != null)
			throw new RuntimeException("Imposto e imutavel");
		imposto = im;
	}
	
	public void setProdutoServico(ProdutoServico ps){
		if(this.ps != null)
			throw new RuntimeException("ProdutoServico e imutavel");
		this.ps = ps;
	}
	
	public void calcularImposto(NotaFiscal nf){
		if(imposto != null)
			imposto.calcularImposto(this, nf);
	}
	
	@Override
	public int getQuantidade() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getPreco() {
		// TODO Auto-generated method stub
		return (ps.getPrecoPorHora() + ps.getPrecoPorUnidade())*quantidade -  desconto;
	}

	@Override
	public String categoriaTributaria() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
