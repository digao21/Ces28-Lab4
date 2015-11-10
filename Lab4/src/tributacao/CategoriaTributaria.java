package tributacao;

import comercio.notafiscal.NotaFiscal;

public abstract class CategoriaTributaria {
	protected String nome;
	
	public abstract void tributar(NotaFiscal nf);
	
	public String getNome(){
		return nome;
	}
	
	@Override
	public boolean equals(Object ob){
		if(ob instanceof CategoriaTributaria){
			CategoriaTributaria obj = (CategoriaTributaria)ob;
			return nome.equals(obj.getNome());
		}			
		
		return false;
	}
}
