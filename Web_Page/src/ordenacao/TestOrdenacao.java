package ordenacao;

import static org.junit.Assert.assertEquals;

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
		Dependencias dep1 = new Dependencias(0, 1, Direcao.RIGHT);
		UnidadeOrdenacao uniOrd1 = new UnidadeOrdenacao(0, false);
		UnidadeOrdenacao uniOrd2 = new UnidadeOrdenacao(1, false);
		
		ord.adicionaDependencia(dep1);
		ord.adicionaListaNaoOrdenada(uniOrd1);
		ord.adicionaListaNaoOrdenada(uniOrd2);

		ord.executaRight();
	
		assertEquals(0 , ord.getListaOrdenadaRight().indexOf(0));
		assertEquals(1 , ord.getListaOrdenadaRight().indexOf(1));
	}
	
	@Test
	public void testSimpleAboveRight() {
		Ordenacao ord = new Ordenacao();
		Dependencias dep1 = new Dependencias(0, 1, Direcao.RIGHT);
		Dependencias dep2 = new Dependencias(0, 1, Direcao.ABOVE);
		UnidadeOrdenacao uniOrd1 = new UnidadeOrdenacao(0, false);
		UnidadeOrdenacao uniOrd2 = new UnidadeOrdenacao(1, false);
		
		ord.adicionaDependencia(dep1);
		ord.adicionaDependencia(dep2);
		ord.adicionaListaNaoOrdenada(uniOrd1);
		ord.adicionaListaNaoOrdenada(uniOrd2);

		ord.executaRight();
		ord.executaAbove();
	
		assertEquals(0 , ord.getListaOrdenadaRight().indexOf(0));
		assertEquals(1 , ord.getListaOrdenadaRight().indexOf(1));
		assertEquals(0 , ord.getListaOrdenadaAbove().indexOf(0));
		assertEquals(1 , ord.getListaOrdenadaAbove().indexOf(1));
	}
	
	@Test
	public void testSimpleAbove2Right() {
		Ordenacao ord = new Ordenacao();
		Dependencias dep1 = new Dependencias(0, 1, Direcao.RIGHT);
		Dependencias dep2 = new Dependencias(1, 2, Direcao.RIGHT);
		Dependencias dep3 = new Dependencias(0, 1, Direcao.ABOVE);
		UnidadeOrdenacao uniOrd1 = new UnidadeOrdenacao(0, false);
		UnidadeOrdenacao uniOrd2 = new UnidadeOrdenacao(1, false);
		UnidadeOrdenacao uniOrd3 = new UnidadeOrdenacao(2, false);
		
		ord.adicionaDependencia(dep1);
		ord.adicionaDependencia(dep2);
		ord.adicionaDependencia(dep3);
		ord.adicionaListaNaoOrdenada(uniOrd1);
		ord.adicionaListaNaoOrdenada(uniOrd2);
		ord.adicionaListaNaoOrdenada(uniOrd3);

		ord.executaRight();
		ord.executaAbove();
	
		assertEquals(0 , ord.getListaOrdenadaRight().indexOf(0));
		assertEquals(1 , ord.getListaOrdenadaRight().indexOf(1));
		assertEquals(2 , ord.getListaOrdenadaRight().indexOf(2));
		assertEquals(0 , ord.getListaOrdenadaAbove().indexOf(0));
		assertEquals(1 , ord.getListaOrdenadaAbove().indexOf(1));
	}

	@Test
	public void testSimple2Above2Right() {
		Ordenacao ord = new Ordenacao();
		Dependencias dep1 = new Dependencias(0, 1, Direcao.RIGHT);
		Dependencias dep2 = new Dependencias(1, 2, Direcao.RIGHT);
		Dependencias dep3 = new Dependencias(0, 1, Direcao.ABOVE);
		Dependencias dep4 = new Dependencias(1, 3, Direcao.ABOVE);
		UnidadeOrdenacao uniOrd1 = new UnidadeOrdenacao(0, false);
		UnidadeOrdenacao uniOrd2 = new UnidadeOrdenacao(1, false);
		UnidadeOrdenacao uniOrd3 = new UnidadeOrdenacao(2, false);
		UnidadeOrdenacao uniOrd4 = new UnidadeOrdenacao(3, false);
		
		ord.adicionaDependencia(dep1);
		ord.adicionaDependencia(dep2);
		ord.adicionaDependencia(dep3);
		ord.adicionaDependencia(dep4);
		ord.adicionaListaNaoOrdenada(uniOrd1);
		ord.adicionaListaNaoOrdenada(uniOrd2);
		ord.adicionaListaNaoOrdenada(uniOrd3);
		ord.adicionaListaNaoOrdenada(uniOrd4);

		ord.executaRight();
		ord.executaAbove();
	
		assertEquals(0 , ord.getListaOrdenadaRight().indexOf(0));
		assertEquals(1 , ord.getListaOrdenadaRight().indexOf(1));
		assertEquals(2 , ord.getListaOrdenadaRight().indexOf(2));
		assertEquals(0 , ord.getListaOrdenadaAbove().indexOf(0));
		assertEquals(1 , ord.getListaOrdenadaAbove().indexOf(1));
		assertEquals(3 , ord.getListaOrdenadaAbove().indexOf(2));
	}

	@Test
	public void testSimple2Above3Right() {
		Ordenacao ord = new Ordenacao();
		Dependencias dep1 = new Dependencias(0, 1, Direcao.RIGHT);
		Dependencias dep2 = new Dependencias(1, 2, Direcao.RIGHT);
		Dependencias dep3 = new Dependencias(1, 4, Direcao.RIGHT);
		Dependencias dep4 = new Dependencias(0, 1, Direcao.ABOVE);
		Dependencias dep5 = new Dependencias(1, 3, Direcao.ABOVE);
		UnidadeOrdenacao uniOrd1 = new UnidadeOrdenacao(0, false);
		UnidadeOrdenacao uniOrd2 = new UnidadeOrdenacao(1, false);
		UnidadeOrdenacao uniOrd3 = new UnidadeOrdenacao(2, false);
		UnidadeOrdenacao uniOrd4 = new UnidadeOrdenacao(3, false);
		UnidadeOrdenacao uniOrd5 = new UnidadeOrdenacao(4, false);
		
		ord.adicionaDependencia(dep1);
		ord.adicionaDependencia(dep2);
		ord.adicionaDependencia(dep3);
		ord.adicionaDependencia(dep4);
		ord.adicionaDependencia(dep5);
		ord.adicionaListaNaoOrdenada(uniOrd1);
		ord.adicionaListaNaoOrdenada(uniOrd2);
		ord.adicionaListaNaoOrdenada(uniOrd3);
		ord.adicionaListaNaoOrdenada(uniOrd4);
		ord.adicionaListaNaoOrdenada(uniOrd5);

		ord.executaRight();
		ord.executaAbove();
	
		assertEquals(0 , ord.getListaOrdenadaRight().indexOf(0));
		assertEquals(1 , ord.getListaOrdenadaRight().indexOf(1));
		assertEquals(2 , ord.getListaOrdenadaRight().indexOf(2));
		assertEquals(4 , ord.getListaOrdenadaRight().indexOf(3));
		assertEquals(0 , ord.getListaOrdenadaAbove().indexOf(0));
		assertEquals(1 , ord.getListaOrdenadaAbove().indexOf(1));
		assertEquals(3 , ord.getListaOrdenadaAbove().indexOf(2));
	}
}
