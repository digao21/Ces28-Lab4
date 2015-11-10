package comercio.paravenda;

import java.util.HashMap;
import java.util.Map;

import comercio.notafiscal.NotaFiscal;

public class FabricaItemDeVenda {
	private int quantidade;
	private String psNome = null;
	private double desconto;
	private Map<String,String> informacao = new HashMap<>();
	
	public FabricaItemDeVenda definirQuantidade(int quantidade){
		this.quantidade = quantidade;
		return this;
	}
	
	public FabricaItemDeVenda definirNomeDoProdutoServico(String nome){
		psNome = nome;
		return this;
	}
	
	public FabricaItemDeVenda adicionarDesconto(double desconto){
		this.desconto = desconto;
		return this;
	}
	
	public FabricaItemDeVenda adicionarInformacao(String infTipo, String informacao){
		this.informacao.put(infTipo, informacao);
		return this;
	}
	
	public FabricaItemDeVenda adicionarInformacao(Map<String,String> map){
		informacao = map;
		return this;
	}
	
	public void criarItemDeVenda(NotaFiscal nf){
		nf.adicionarItemDeVenda(new ItemDeVenda(quantidade,psNome,desconto,informacao));
	}
	
}
