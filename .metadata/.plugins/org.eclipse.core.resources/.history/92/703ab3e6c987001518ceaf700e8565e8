package comercio.notafiscal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import comercio.paravenda.ItemDeVenda;

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
	
	public void setEstadoValidada(int id){
		testarImutabilidade();
		this.id = id;
		estado = NFEstado.validada;
	}
	public void adicionarItemDeVenda(ItemDeVenda item){
		testarImutabilidade();
		valor += item.getPreco();
		itensDeVenda.add(item);
	}
		
	public void registrarImposto(String impostoNome, double valor){
		testarImutabilidade();
		logImposto.put(impostoNome, valor);
		totalImposto += valor;
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
		for(ItemDeVenda item : itensDeVenda)
			item.calcularImposto(this);			
	}

	//LOGIC
	
	private void testarImutabilidade(){
		if(estado.equals(NFEstado.validada))
			throw new RuntimeException("Impossivel mudar NF validada");
	}
}
