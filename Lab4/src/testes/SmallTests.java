package testes;

import org.junit.Test;

import bancodedados.BancoDeDados;
import comercio.paravenda.ProdutoServico;
import utilidades.Const;

public class SmallTests {

	@Test
	public void pegar_PS_no_BancoDeDados() {
		BancoDeDados bd = BancoDeDados.getBancoDeDados();
		
		ProdutoServico ps = bd.getProdutoServico(Const.PS_SHOW_DE_ROCK);
		
		System.out.println(ps.getNome());
		System.out.println("Preco por hora: " + ps.getPrecoPorHora());
		System.out.println("Preco por unidade: " + ps.getPrecoPorUnidade());
		
	}

}
