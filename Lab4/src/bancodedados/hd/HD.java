package bancodedados.hd;

import bancodedados.BancoDeDados;

public class HD {

	private static HD hd = null;
	
	private HD(){};
	
	public static HD getHD(){
		if(hd == null)
			hd = new HD();
		
		return hd;
	}	
	
	public void readProdutoServico(){
		HDPS hdps = new HDPS();
		hdps.readConstruirEPintarParede();
		hdps.readShowDeRock();
	}
	
}
