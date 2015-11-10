package bancodedados;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bancodedados.hd.HD;
import comercio.notafiscal.NFEstado;
import comercio.notafiscal.NotaFiscal;
import comercio.paravenda.ItemDeVenda;
import comercio.paravenda.ProdutoServico;
import tributacao.Imposto;

public class BancoDeDados {
	
	private static BancoDeDados db = null;
	
	private int psID = 1;
	
	private Map<Integer,NotaFiscal> mapNF;
	
	private Map<String,ProdutoServico> mapPS;
	private Map<String,Imposto> mapPSImposto;
	
	public static BancoDeDados getBancoDeDados(){
		if(db == null){
			db = new BancoDeDados();
			db.readHD();
		}
		return db;		
	}
	
	private BancoDeDados(){
		mapPS = new HashMap<>();
		mapPSImposto = new HashMap<>();
		mapNF = new HashMap<>();		
	}
	
	public ProdutoServico getProdutoServico(String psNome){
		ProdutoServico psAnsw = mapPS.get(psNome);
		
		//OU RETORNE NULLOBJECT
		if(psAnsw == null)			
			throw new RuntimeException("ProdutoServico nao encontrado");
		
		return psAnsw;
	}
	
	public void adicionProdutoServicoAoItemDeVenda(ItemDeVenda iv, String psNome){
		ProdutoServico ps = mapPS.get(psNome);
		Imposto imposto = mapPSImposto.get(psNome);
		
		if(ps == null || imposto == null)
			throw new RuntimeException("ProdutoServico ou Imposto null");
		
		iv.setProdutoServico(ps);
		iv.setImposto(imposto);
	}
	
	public void setProdutoServico(ProdutoServico ps, Imposto imposto){
		if(mapPS.containsKey(ps.getNome()))
			throw new RuntimeException("Produto/Servico ja existente. "
					+ "Proibido repeticao");
		
		mapPS.put(ps.getNome(), ps);
		mapPSImposto.put(ps.getNome(), imposto);
	}
	
	public void validarNotaFiscal(NotaFiscal nf){
		if(nf.getEstado().equals(NFEstado.validada))
			throw new RuntimeException("Nao pode validar nf validada");
		
		List<ItemDeVenda> l = nf.getItensDeVenda();
		if(l == null || l.size() < 1)
			throw new RuntimeException("Nao pode validar nf validada");
		
		//VALIDAR
		mapNF.put(psID++, nf);
		nf.setEstadoValidada(psID);		
		
	}
	
	private void readHD(){
		HD hd =  HD.getHD();
		hd.readProdutoServico();
	}
	
}
