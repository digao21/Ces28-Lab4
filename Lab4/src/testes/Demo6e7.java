package testes;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import utilidades.Const;
import comercio.notafiscal.NFBuilder;
import comercio.notafiscal.NFEstado;
import comercio.notafiscal.NotaFiscal;
import comercio.paravenda.ItemDeVenda;

public class Demo6e7 {

	@Test
	public void requisito_6_7() {
		NotaFiscal nf;
		
		nf =	new NFBuilder()
		.adicionarInformacao(Const.DATA_DE_ENTREGA, "10/11/2015")
		.adicionarInformacao(Const.CLIENTE, "ITA")
		.adicionarInformacao(Const.FORNECEDOR, "Alunos")
		.adicionarItemDeVenda(1, Const.PS_SHOW_DE_ROCK, 0, null)
		.criarNotaFiscal();

		//VERIFICANDO ESTADO
		//O estado emElaboracao é um estado intermediário de NotaFiscal: ele não pode ser verificado
		//externamente uma vez que as notas fiscais são construídas necessariamente por um builder que
		//ao final ou seta esse estado para validada ou lança uma exceção no caso em que não for validada.
		assertEquals(NFEstado.validada ,nf.getEstado());	
		
		
		//VERIFICANDO IMUTABILIDADE
		//Através dos diversos métodos set de NotaFiscal tenta-se modificar os campos de nf. 
		//Espera-se lançar uma exceção em todos os testes comprovando a imutabilidade.
		try{
			nf.setEstadoValidada(2);
		}catch(RuntimeException e){
			System.out.println("Não conseguiu setar id para nota fiscal validada");
		}
		
		try{
			nf.adicionarItemDeVenda(nf.getItensDeVenda().get(0));
		}catch(RuntimeException e){
			System.out.println("Não conseguiu setar item de venda para nota fiscal validada");
		}
		
		try{
			nf.adicionarInformacao("a", "b");
		}catch(RuntimeException e){
			System.out.println("Não conseguiu adicionar informação para nota fiscal validada");
		}
		
		try{
			nf.registrarImposto("a", 0);
		}catch(RuntimeException e){
			System.out.println("Não conseguiu registrar imposto sobre nota fiscal validada");
		}
	}

}
