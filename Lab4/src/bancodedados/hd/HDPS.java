package bancodedados.hd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bancodedados.BancoDeDados;
import comercio.paravenda.Produto;
import comercio.paravenda.ProdutoServico;
import comercio.paravenda.ProdutoServicoComposto;
import comercio.paravenda.Servico;
import tributacao.ImpostoA;
import utilidades.Const;

public class HDPS {

	private BancoDeDados bd;
	
	public HDPS(){
		bd = BancoDeDados.getBancoDeDados();
	}
	
	//SHOW DE ROCK
	//METODOS RELACIONADOS A TODOS OS TRABALHOS E MATERIAIS ENVOLVIDOS
	//NA TAREFA
	
	public void readShowDeRock(){
		readProdutoAlugarEstrutura();
		readProdutoAlugarInstrumentos();
		readServicoContratarBanda();
		
		String nome = Const.PS_SHOW_DE_ROCK;
		
		ProdutoServico servContratarBanda = bd.getProdutoServico(Const.S_CONTRATAR_BANDA);
		ProdutoServico prodAlugarInstrumentos = bd.getProdutoServico(Const.P_ALUGAR_INSTRUMENTO);
		ProdutoServico prodAlugarEstrutura = bd.getProdutoServico(Const.P_ALUGAR_ESTRUTURA);
		List<ProdutoServico> l = new ArrayList<>();
		l.add(servContratarBanda);
		l.add(prodAlugarInstrumentos);
		l.add(prodAlugarEstrutura);
		
		Map<String,String> mpI = new HashMap<>();
		//ADICIONAR INFORMACOES
		
		ProdutoServicoComposto psc = new ProdutoServicoComposto(nome,mpI,l); 
		
		bd.setProdutoServico(psc, new ImpostoA());
	}
	
	private void readServicoContratarBanda(){
		String nome = Const.S_CONTRATAR_BANDA;
		double precoPorHora = 5000;
		Map<String,String> mpI = new HashMap<>();
		//ADICIONAR INFORMACOES
		
		Servico serv = new Servico(nome,mpI,precoPorHora);
		
		bd.setProdutoServico(serv, new ImpostoA());
	}
	
	private void  readProdutoAlugarEstrutura(){
		String nome = Const.P_ALUGAR_ESTRUTURA;
		double precoPorUnidade = 1500;
		Map<String,String> mpI = new HashMap<>();
		//ADICIONAR INFORMACOES
		
		Produto serv = new Produto(nome,mpI,precoPorUnidade);
		
		bd.setProdutoServico(serv, new ImpostoA());
	}
	
	private void  readProdutoAlugarInstrumentos(){
		String nome = Const.P_ALUGAR_INSTRUMENTO;
		double precoPorUnidade = 900;
		Map<String,String> mpI = new HashMap<>();
		//ADICIONAR INFORMACOES
		
		Produto serv = new Produto(nome,mpI,precoPorUnidade);
		
		bd.setProdutoServico(serv, new ImpostoA());
	}	
	
	//CONSTUIR E PINTAR PAREDE
	//METODOS RELACIONADOS A TODOS OS TRABALHOS E MATERIAIS ENVOLVIDOS
	//NA TAREFA
	
	public void readConstruirEPintarParede(){
		readConstruirParede();
		readPintarParede();
	}
	
	private void readConstruirParede(){
		readProdutoConstruirParede();
		readServicoConstruirParede();
		String nome = Const.PS_CONSTRUIR_PAREDE;
		
		ProdutoServico servConstruirParede = bd.getProdutoServico(Const.S_CONSTRUIR_PAREDE);
		ProdutoServico prodConstruirParede = bd.getProdutoServico(Const.P_CONSTRUIR_PAREDE);
		List<ProdutoServico> l = new ArrayList<>();
		l.add(servConstruirParede);
		l.add(prodConstruirParede);
		
		Map<String,String> mpI = new HashMap<>();
		//ADICIONAR INFORMACOES
		
		ProdutoServicoComposto psc = new ProdutoServicoComposto(nome,mpI,l); 
		
		bd.setProdutoServico(psc, new ImpostoA());		
	}
	
	private void  readProdutoConstruirParede(){
		String nome = Const.P_CONSTRUIR_PAREDE;
		double precoPorUnidade = 90;
		Map<String,String> mpI = new HashMap<>();
		//ADICIONAR INFORMACOES
		
		Produto serv = new Produto(nome,mpI,precoPorUnidade);
		
		bd.setProdutoServico(serv, new ImpostoA());
	}
	
	private void readServicoConstruirParede(){
		String nome = Const.S_CONSTRUIR_PAREDE;
		double precoPorHora = 45;
		Map<String,String> mpI = new HashMap<>();
		//ADICIONAR INFORMACOES
		
		Servico serv = new Servico(nome,mpI,precoPorHora);
		
		bd.setProdutoServico(serv, new ImpostoA());
	}
	
	private void readPintarParede(){
		readProdutoPintarParede();
		readServicoPintarParede();
		String nome = Const.PS_PINTAR_PAREDE;
		
		ProdutoServico servPintarParede = bd.getProdutoServico(Const.S_PINTAR_PAREDE);
		ProdutoServico prodPintarParede = bd.getProdutoServico(Const.P_PINTAR_PAREDE);
		List<ProdutoServico> l = new ArrayList<>();
		l.add(servPintarParede);
		l.add(prodPintarParede);
		
		Map<String,String> mpI = new HashMap<>();
		//ADICIONAR INFORMACOES
		
		ProdutoServicoComposto psc = new ProdutoServicoComposto(nome,mpI,l); 
		
		bd.setProdutoServico(psc, new ImpostoA());		
	}
	
	private void readServicoPintarParede(){
		String nome = Const.S_PINTAR_PAREDE;
		double precoPorHora = 50;
		Map<String,String> mpI = new HashMap<>();
		//ADICIONAR INFORMACOES
		
		Servico serv = new Servico(nome,mpI,precoPorHora);
		
		bd.setProdutoServico(serv, new ImpostoA());
	}
	
	private void  readProdutoPintarParede(){
		String nome = Const.P_PINTAR_PAREDE;
		double precoPorUnidade = 35;
		Map<String,String> mpI = new HashMap<>();
		//ADICIONAR INFORMACOES
		
		Produto serv = new Produto(nome,mpI,precoPorUnidade);
		
		bd.setProdutoServico(serv, new ImpostoA());
	}
	
}
