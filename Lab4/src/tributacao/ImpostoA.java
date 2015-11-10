package tributacao;

import comercio.notafiscal.NotaFiscal;

public class ImpostoA extends Imposto {

	@Override
	public double calcularImposto(Tributavel item, NotaFiscal fs) {
		// TODO Auto-generated method stub
		throw new RuntimeException("calcularImposto em ImpostoA nao Implementado");
		//return 0;
	}

}
