package comercio.notafiscal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import comercio.paravenda.ItemDeVenda;
import tributacao.CategoriaTributaria;

public class NotaFiscal {
	
	private long id;
	private NFEstado estado;
	private double valor;
	private List<ItemDeVenda> itensDeVenda;	
	private Map<String,Double> logImposto; 
	private double totalImposto;
	private Map<String, String> informacoes;
	//private String condicoesEntrega;
	//private Date dataDeEntrega;
	//private DadosCliente dadosCliente;
	//private String dadosSubmissao;
	
	NotaFiscal(){
		estado = NFEstado.emElaboracao;
		valor = 0;
		totalImposto = 0;
		itensDeVenda = new ArrayList<>();		
		logImposto = new HashMap<>();
		informacoes = new HashMap<>();
	}
	
	//SETTERS
	
	public void setEstadoValidada(){
		estado = NFEstado.validada;
	}
	void adicionarItemDeVenda(ItemDeVenda item){
		valor += item.getPreco();
		itensDeVenda.add(item);
	}
	public void setId(long id) {
		testarImutabilidade();
		this.id = id;
	}	
		
	//GETTERS	
	
	public long getId() {
		return id;
	}
	public NFEstado getEstado() {
		return estado;
	}
	public double getValor() {
		return valor;
	}
	public List<ItemDeVenda> getItensDeVenda() {
		return itensDeVenda;//.CLONE
	}	
	public void tributar(){
		List<CategoriaTributaria> l = new ArrayList<>();
		
		for(ItemDeVenda item : itensDeVenda){
			CategoriaTributaria cat = item.getCategoriaTributaria();
			if(cat != null && !l.contains(cat))
				l.add(cat);
		}
		
		for(CategoriaTributaria cat : l)
			cat.tributar(this);
		
	}

	//LOGIC
	
	private void testarImutabilidade(){
		if(estado.equals(NFEstado.validada))
			throw new RuntimeException("Impossivel mudar NF validada");
	}
}
