package ordenacao;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import enums.Direcao;

public class TestOrdenacao {

	@Test
	public void testSimpleAbove() {
		Ordenacao ord = new Ordenacao();
		Dependencias dep = new Dependencias(0, 1, Direcao.ABOVE);
		UnidadeOrdenacao uniOrd0 = new UnidadeOrdenacao(0, false);
		UnidadeOrdenacao uniOrd1 = new UnidadeOrdenacao(1, false);
		
		ord.adicionaDependencia(dep);
		ord.adicionaListaNaoOrdenada(uniOrd0);
		ord.adicionaListaNaoOrdenada(uniOrd1);
		
		ord.executaAbove();
		
		assertEquals(0 , ord.getListaOrdenadaAbove().indexOf(0));
		assertEquals(1 , ord.getListaOrdenadaAbove().indexOf(1));
	}
	
	@Test
	public void testTresNosAbove() {
		Ordenacao ord = new Ordenacao();
		Dependencias dep = new Dependencias(0, 1, Direcao.ABOVE);
		UnidadeOrdenacao uniOrd0 = new UnidadeOrdenacao(0, false);
		UnidadeOrdenacao uniOrd1 = new UnidadeOrdenacao(1, false);
		UnidadeOrdenacao uniOrd2 = new UnidadeOrdenacao(2, false);
		
		ord.adicionaDependencia(dep);
		ord.adicionaListaNaoOrdenada(uniOrd0);
		ord.adicionaListaNaoOrdenada(uniOrd1);
		ord.adicionaListaNaoOrdenada(uniOrd2);
		ord.executaAbove();
		
		assertEquals(0 , ord.getListaOrdenadaAbove().indexOf(0));
		assertEquals(1 , ord.getListaOrdenadaAbove().indexOf(1));
		assertEquals(2 , ord.getListaOrdenadaAbove().indexOf(2));
	}
	
	@Test
	public void testSimpleRight() {
		Ordenacao ord = new Ordenacao();
		Dependencias dep1 = new Dependencias(1, 2, Direcao.RIGHT);
		UnidadeOrdenacao uniOrd1 = new UnidadeOrdenacao(1, false);
		UnidadeOrdenacao uniOrd2 = new UnidadeOrdenacao(2, false);
		
		ord.adicionaDependencia(dep1);
		ord.adicionaListaNaoOrdenada(uniOrd1);
		ord.adicionaListaNaoOrdenada(uniOrd2);

		ord.executaRight();
	
		assertEquals(1 , ord.getListaOrdenadaRight().indexOf(0));
		assertEquals(2 , ord.getListaOrdenadaRight().indexOf(1));
	}


}
