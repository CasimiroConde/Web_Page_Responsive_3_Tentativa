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
		
		ord.executa();
		
		assertEquals(0 , ord.getListaOrdenada().indexOf(0));
		assertEquals(1 , ord.getListaOrdenada().indexOf(1));
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
		ord.executa();
		
		assertEquals(0 , ord.getListaOrdenada().indexOf(0));
		assertEquals(1 , ord.getListaOrdenada().indexOf(1));
		assertEquals(2 , ord.getListaOrdenada().indexOf(2));
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

		ord.executa();
	
		assertEquals(0 , ord.getListaOrdenada().indexOf(0));
		assertEquals(1 , ord.getListaOrdenada().indexOf(1));
	}
	
	@Test
	public void testSimpleAboveRightRelacaoMapeada() {
		Ordenacao ord = new Ordenacao();
		Dependencias dep1 = new Dependencias(0, 1, Direcao.RIGHT);
		Dependencias dep2 = new Dependencias(0, 1, Direcao.ABOVE);
		UnidadeOrdenacao uniOrd1 = new UnidadeOrdenacao(0, false);
		UnidadeOrdenacao uniOrd2 = new UnidadeOrdenacao(1, false);
		
		ord.adicionaDependencia(dep1);
		ord.adicionaDependencia(dep2);
		ord.adicionaListaNaoOrdenada(uniOrd1);
		ord.adicionaListaNaoOrdenada(uniOrd2);

		ord.executa();
		
		assertEquals(0 , ord.getListaOrdenada().indexOf(0));
		assertEquals(1 , ord.getListaOrdenada().indexOf(1));
		assertEquals(-1, ord.getListaOrdenada().indexOf(2));
	}
	
	@Test
	public void testSimpleAboveRightNovaRelacao() {
		Ordenacao ord = new Ordenacao();
		Dependencias dep1 = new Dependencias(0, 1, Direcao.RIGHT);
		Dependencias dep2 = new Dependencias(1, 2, Direcao.ABOVE);
		UnidadeOrdenacao uniOrd1 = new UnidadeOrdenacao(0, false);
		UnidadeOrdenacao uniOrd2 = new UnidadeOrdenacao(1, false);
		UnidadeOrdenacao uniOrd3 = new UnidadeOrdenacao(2, false);
		
		ord.adicionaDependencia(dep1);
		ord.adicionaDependencia(dep2);
		ord.adicionaListaNaoOrdenada(uniOrd1);
		ord.adicionaListaNaoOrdenada(uniOrd2);
		ord.adicionaListaNaoOrdenada(uniOrd3);

		ord.executa();
	
		assertEquals(0 , ord.getListaOrdenada().indexOf(0));
		assertEquals(1 , ord.getListaOrdenada().indexOf(1));
		assertEquals(2 , ord.getListaOrdenada().indexOf(2));
		assertEquals(-1 , ord.getListaOrdenada().indexOf(3));
	}

	@Test
	public void testSimple1Above2Right() {
		Ordenacao ord = new Ordenacao();
		Dependencias dep1 = new Dependencias(0, 1, Direcao.RIGHT);
		Dependencias dep2 = new Dependencias(1, 2, Direcao.RIGHT);
		Dependencias dep4 = new Dependencias(1, 3, Direcao.ABOVE);
		UnidadeOrdenacao uniOrd1 = new UnidadeOrdenacao(0, false);
		UnidadeOrdenacao uniOrd2 = new UnidadeOrdenacao(1, false);
		UnidadeOrdenacao uniOrd3 = new UnidadeOrdenacao(2, false);
		UnidadeOrdenacao uniOrd4 = new UnidadeOrdenacao(3, false);
		
		ord.adicionaDependencia(dep1);
		ord.adicionaDependencia(dep2);
		ord.adicionaDependencia(dep4);
		ord.adicionaListaNaoOrdenada(uniOrd1);
		ord.adicionaListaNaoOrdenada(uniOrd2);
		ord.adicionaListaNaoOrdenada(uniOrd3);
		ord.adicionaListaNaoOrdenada(uniOrd4);

		ord.executa();
	
		assertEquals(0 , ord.getListaOrdenada().indexOf(0));
		assertEquals(1 , ord.getListaOrdenada().indexOf(1));
		assertEquals(2 , ord.getListaOrdenada().indexOf(2));
		assertEquals(3 , ord.getListaOrdenada().indexOf(3));
	}

	@Test
	public void testSimple2Above3Right() {
		Ordenacao ord = new Ordenacao();
		Dependencias dep1 = new Dependencias(0, 1, Direcao.RIGHT);
		Dependencias dep2 = new Dependencias(1, 2, Direcao.ABOVE);
		Dependencias dep3 = new Dependencias(1, 4, Direcao.RIGHT);
		Dependencias dep4 = new Dependencias(0, 1, Direcao.ABOVE);
		Dependencias dep5 = new Dependencias(1, 3, Direcao.RIGHT);
		UnidadeOrdenacao uniOrd1 = new UnidadeOrdenacao(0, false);
		UnidadeOrdenacao uniOrd2 = new UnidadeOrdenacao(1, false);
		UnidadeOrdenacao uniOrd3 = new UnidadeOrdenacao(2, false);
		UnidadeOrdenacao uniOrd4 = new UnidadeOrdenacao(3, false);
		UnidadeOrdenacao uniOrd5 = new UnidadeOrdenacao(4, false);
		
		ord.adicionaDependencia(dep1);
		ord.adicionaDependencia(dep2);
		ord.adicionaDependencia(dep5);
		ord.adicionaDependencia(dep4);
		ord.adicionaDependencia(dep3);
		ord.adicionaListaNaoOrdenada(uniOrd1);
		ord.adicionaListaNaoOrdenada(uniOrd2);
		ord.adicionaListaNaoOrdenada(uniOrd3);
		ord.adicionaListaNaoOrdenada(uniOrd4);
		ord.adicionaListaNaoOrdenada(uniOrd5);

		ord.executa();
		
		assertEquals(0 , ord.getListaOrdenada().indexOf(0));
		assertEquals(1 , ord.getListaOrdenada().indexOf(1));
		assertEquals(2 , ord.getListaOrdenada().indexOf(2));
		assertEquals(3 , ord.getListaOrdenada().indexOf(3));
		assertEquals(4 , ord.getListaOrdenada().indexOf(4));
	}
}
