package old;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestMatrizPosicionamento {

	@Test
	public void testSimple() {
		MatrizPosicionamento m = new MatrizPosicionamento();
		m.adicionaComponenteInicial(2);
		assertEquals(1, m.getLinhas());
		assertEquals(1, m.getColunas());
		assertEquals(2, m.getCelula(0, 0));
	}

	@Test
	public void testAdicionaNoroeste() {
		MatrizPosicionamento m = new MatrizPosicionamento();
		m.adicionaComponenteInicial(2);
		m.adicionaNoroeste(3);
		assertEquals(2, m.getLinhas());
		assertEquals(2, m.getColunas());
		assertEquals(3, m.getCelula(0, 0));
		assertEquals(-1, m.getCelula(0, 1));
		assertEquals(-1, m.getCelula(1, 0));
		assertEquals(2, m.getCelula(1, 1));
	}

	@Test
	public void testAdicionaNorte() {
		MatrizPosicionamento m = new MatrizPosicionamento();
		m.adicionaComponenteInicial(2);
		m.adicionaNorte(3);
		assertEquals(2, m.getLinhas());
		assertEquals(1, m.getColunas());
		assertEquals(3, m.getCelula(0, 0));
		assertEquals(2, m.getCelula(1, 0));
	}

	@Test
	public void testAdicionaNordeste() {
		MatrizPosicionamento m = new MatrizPosicionamento();
		m.adicionaComponenteInicial(2);
		m.adicionaNordeste(3);
		assertEquals(2, m.getLinhas());
		assertEquals(2, m.getColunas());
		assertEquals(-1, m.getCelula(0, 0));
		assertEquals(3, m.getCelula(0, 1));
		assertEquals(2, m.getCelula(1, 0));
		assertEquals(-1, m.getCelula(1, 1));
	}

	@Test
	public void testAdicionaOeste() {
		MatrizPosicionamento m = new MatrizPosicionamento();
		m.adicionaComponenteInicial(2);
		m.adicionaOeste(3);
		assertEquals(1, m.getLinhas());
		assertEquals(2, m.getColunas());
		assertEquals(3, m.getCelula(0, 0));
		assertEquals(2, m.getCelula(0, 1));
	}

	@Test
	public void testAdicionaLeste() {
		MatrizPosicionamento m = new MatrizPosicionamento();
		m.adicionaComponenteInicial(2);
		m.adicionaLeste(3);
		assertEquals(1, m.getLinhas());
		assertEquals(2, m.getColunas());
		assertEquals(2, m.getCelula(0, 0));
		assertEquals(3, m.getCelula(0, 1));
	}

	@Test
	public void testAdicionaSudoeste() {
		MatrizPosicionamento m = new MatrizPosicionamento();
		m.adicionaComponenteInicial(2);
		m.adicionaSudoeste(3);
		assertEquals(2, m.getLinhas());
		assertEquals(2, m.getColunas());
		assertEquals(-1, m.getCelula(0, 0));
		assertEquals(2, m.getCelula(0, 1));
		assertEquals(3, m.getCelula(1, 0));
		assertEquals(-1, m.getCelula(1, 1));
	}

	@Test
	public void testAdicionaSul() {
		MatrizPosicionamento m = new MatrizPosicionamento();
		m.adicionaComponenteInicial(2);
		m.adicionaSul(3);
		assertEquals(2, m.getLinhas());
		assertEquals(1, m.getColunas());
		assertEquals(2, m.getCelula(0, 0));
		assertEquals(3, m.getCelula(1, 0));
	}

	@Test
	public void testAdicionaSudeste() {
		MatrizPosicionamento m = new MatrizPosicionamento();
		m.adicionaComponenteInicial(2);
		m.adicionaSudeste(3);
		assertEquals(2, m.getLinhas());
		assertEquals(2, m.getColunas());
		assertEquals(2, m.getCelula(0, 0));
		assertEquals(-1, m.getCelula(0, 1));
		assertEquals(-1, m.getCelula(1, 0));
		assertEquals(3, m.getCelula(1, 1));
	}

	@Test
	public void testAdicionaNoroesteNoroeste() {
		MatrizPosicionamento m = new MatrizPosicionamento();
		m.adicionaComponenteInicial(2);
		m.adicionaNoroeste(3);
		m.adicionaNoroeste(4);
		assertEquals(3, m.getLinhas());
		assertEquals(3, m.getColunas());
		assertEquals(4, m.getCelula(0, 0));
		assertEquals(-1, m.getCelula(0, 1));
		assertEquals(-1, m.getCelula(0, 2));
		assertEquals(-1, m.getCelula(1, 0));
		assertEquals(3, m.getCelula(1, 1));
		assertEquals(-1, m.getCelula(1, 2));
		assertEquals(-1, m.getCelula(2, 0));
		assertEquals(-1, m.getCelula(2, 1));
		assertEquals(2, m.getCelula(2, 2));
	}
	
	@Test
	public void testAdicionaNoroesteNorte() {
		MatrizPosicionamento m = new MatrizPosicionamento();
		m.adicionaComponenteInicial(2);
		m.adicionaNoroeste(3);
		m.adicionaNorte(4);
		assertEquals(3, m.getLinhas());
		assertEquals(2, m.getColunas());
		assertEquals(4, m.getCelula(0, 0));
		assertEquals(-1, m.getCelula(0, 1));
		assertEquals(3, m.getCelula(1, 0));
		assertEquals(-1, m.getCelula(1, 1));
		assertEquals(-1, m.getCelula(2, 0));
		assertEquals(2, m.getCelula(2, 1));
	}
	
	@Test
	public void testAdicionaNoroesteSul() {
		MatrizPosicionamento m = new MatrizPosicionamento();
		m.adicionaComponenteInicial(2);
		m.adicionaNoroeste(3);
		m.adicionaSul(4);
		assertEquals(2, m.getLinhas());
		assertEquals(2, m.getColunas());
		assertEquals(3, m.getCelula(0, 0));
		assertEquals(-1, m.getCelula(0, 1));
		assertEquals(4, m.getCelula(1, 0));
		assertEquals(2, m.getCelula(1, 1));
	}
	@Test
	public void testAdicionaNoroesteLeste() {
		MatrizPosicionamento m = new MatrizPosicionamento();
		m.adicionaComponenteInicial(2);
		m.adicionaNoroeste(3);
		m.adicionaLeste(4);
		assertEquals(2, m.getLinhas());
		assertEquals(2, m.getColunas());
		assertEquals(3, m.getCelula(0, 0));
		assertEquals(4, m.getCelula(0, 1));
		assertEquals(-1, m.getCelula(1, 0));
		assertEquals(2, m.getCelula(1, 1));
	}
	
	@Test
	public void testAdicionaNorteSul() {
		MatrizPosicionamento m = new MatrizPosicionamento();
		m.adicionaComponenteInicial(2);
		m.adicionaNorte(3);
		m.adicionaSul(4);
		m.adicionaSul(4);
		assertEquals(3, m.getLinhas());
		assertEquals(1, m.getColunas());
		assertEquals(3, m.getCelula(0, 0));
		assertEquals(2, m.getCelula(1, 0));
		assertEquals(4, m.getCelula(2, 0));
	}
	
	@Test
	public void testAdicionaNorteSulSulNorteLeste() {
		MatrizPosicionamento m = new MatrizPosicionamento();
		m.adicionaComponenteInicial(2);
		m.adicionaNorte(3);
		m.adicionaSul(4);
		m.adicionaSul(4);
		m.adicionaNorte(5);
		m.adicionaLeste(5);
		assertEquals(3, m.getLinhas());
		assertEquals(2, m.getColunas());
		assertEquals(3, m.getCelula(0, 0));
		assertEquals(-1, m.getCelula(0, 1));
		assertEquals(2, m.getCelula(1, 0));
		assertEquals(5, m.getCelula(1, 1));
		assertEquals(4, m.getCelula(2, 0));
		assertEquals(-1, m.getCelula(2, 1));
	}

	
	
}