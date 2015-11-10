package bancodedados;

import java.util.HashMap;
import java.util.Map;

import comercio.paravenda.ProdutoServico;

public class BancoDeDados {
	
	private static BancoDeDados db = new BancoDeDados();
		
	private Map<String,ProdutoServico> mapPS;
	
	public static BancoDeDados getBancoDeDados(){
		return db;		
	}
	
	private BancoDeDados(){
		mapPS = new HashMap<>();
		readHD();
	}
	
	public ProdutoServico getProdutoServico(String psNome){
		ProdutoServico psAnsw = mapPS.get(psNome);
		
		//OU RETORNE NULLOBJECT
		if(psAnsw == null)			
			throw new RuntimeException("ProdutoServico nao encontrado");
		
		return psAnsw;
	}
	
	public void setProdutoServico(ProdutoServico ps){
		if(mapPS.containsKey(ps.getNome()))
			throw new RuntimeException("Produto/Servico ja existente. "
					+ "Proibido repeticao");
		mapPS.put(ps.getNome(), ps);
	}
	
	private void readHD(){
		
	}
	
}
