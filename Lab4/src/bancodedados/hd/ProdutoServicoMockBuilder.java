package bancodedados.hd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import comercio.paravenda.ProdutoServico;
import comercio.paravenda.ProdutoServicoComposto;

public class ProdutoServicoMockBuilder {

	private String nome = "";
	private Map<String,String> mpI = new HashMap<>();
	private List<ProdutoServico> psL = new ArrayList<>();
	
	public ProdutoServicoMockBuilder adicionarNome(String nome){
		this.nome = nome;
		return this;
	}
	
	public ProdutoServicoMockBuilder adicionarProdutoServico(ProdutoServico ps){
		psL.add(ps);
		return this;
	}
	
	public ProdutoServicoMockBuilder adicionarInformacao(String nomeInformacao, String informacao){
		mpI.put(nomeInformacao, informacao);
		return this;
	}
	
	public ProdutoServico criarProdutoServico(){
		ProdutoServico ps = new ProdutoServicoComposto(nome,mpI,psL);
		return ps;
	}
	
}
