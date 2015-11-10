package comercio.paravenda;

import java.util.HashMap;

public class ProdutoServicoNull extends ProdutoServico {

	public ProdutoServicoNull(){
		super("",new HashMap<String,String>());
	}	

	@Override
	public double getPrecoPorHora() {
		return 0;
	}

	@Override
	public double getPrecoPorUnidade() {
		return 0;
	}

	@Override
	public String getInformacao(String tipoInformacao) {
		return "Nao possuo tal informacao";
	}
	
}
