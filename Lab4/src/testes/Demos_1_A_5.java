package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import comercio.notafiscal.NFBuilder;
import comercio.notafiscal.NotaFiscal;
import utilidades.Const;

public class Demos_1_A_5 {

	@Test
	public void requisito_1() {
		
		//	O codigo abaixo nao funciona se descomenta-lo o 
		//programa nao compila. A unica forma de criar NF e com o
		//construtor
		//NotaFiscal nf = new NotaFiscal();
					
		//BUILDER COM INTERFACE FLUENTE
		NotaFiscal nf;
		
		//NF COM 1 IV
		nf =	new NFBuilder()
					.adicionarInformacao(Const.DATA_DE_ENTREGA, "10/11/2015")
					.adicionarInformacao(Const.CLIENTE, "ITA")
					.adicionarInformacao(Const.FORNECEDOR, "Alunos")
					.adicionarItemDeVenda(1, Const.PS_SHOW_DE_ROCK, 0, null)
					.criarNotaFiscal();
		
		//VERIFICANDO ATRIBUTOS
		assertEquals("10/11/2015",nf.getInformacao(Const.DATA_DE_ENTREGA));
		assertEquals("ITA",nf.getInformacao(Const.CLIENTE));
		assertEquals("Alunos",nf.getInformacao(Const.FORNECEDOR));
		assertEquals(new Double(7400),new Double(nf.getValor()));		
		
		//NF COM 3 IV
		nf =	new NFBuilder()
					.adicionarInformacao(Const.DATA_DE_ENTREGA, "10/11/2015")
					.adicionarInformacao(Const.CLIENTE, "ITA")
					.adicionarInformacao(Const.FORNECEDOR, "Alunos")
					.adicionarItemDeVenda(3, Const.PS_SHOW_DE_ROCK, 0, null)
					.adicionarItemDeVenda(2, Const.PS_CONSTRUIR_PAREDE, 50, null)
					.adicionarItemDeVenda(1, Const.PS_CONSTRUIR_PAREDE, 30, null)
					.criarNotaFiscal();
		
		//VERIFICANDO ATRIBUTOS
		assertEquals("10/11/2015",nf.getInformacao(Const.DATA_DE_ENTREGA));
		assertEquals("ITA",nf.getInformacao(Const.CLIENTE));
		assertEquals("Alunos",nf.getInformacao(Const.FORNECEDOR));
		assertEquals(new Double(22525),new Double(nf.getValor()));
		
		
		
	}

}
