package arvoreSolucao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import classes.Modelo;

public class TestGeraArvore {

	@Test
	public void testCriacaoNoConteiner() {
		Node no = new Node(0, DirecaoConteiner.Horizontal);
		assertEquals(null, no.getElemento());
		assertEquals(0, no.getConteiner().getIndice());
		assertEquals(DirecaoConteiner.Horizontal ,no.getConteiner().getDirecao());
	}

	@Test
	public void testCriacaoNoElemento() {
		Node no = new Node(0, 0);
		assertEquals(null, no.getConteiner());
		assertEquals(0, no.getElemento().getIndiceComponente());
		assertEquals(0, no.getElemento().getIndiceCaracteristica());
	}

//	@Test
//	public void testSubstituiNodeEmArvore() {
//		Node no1 = new Node(0, Direcao.Horizontal);
//		Node no2 = new Node(0, 0);
//		Node no3 = new Node(1, Direcao.Horizontal);
//		
//		no1.addLeaf(no2);
//		
//		arvoreSolucao.setHead(no3);
//		assertEquals(no3, arvoreSolucao.getHead());
//	}
	
//	@Test
//	public void testAlteraConteinerNodeEmArvore() {
//		Node no1 = new Node(0, Direcao.Horizontal);
//		Node no2 = new Node(0, 0);
//		Node no3 = new Node(1, Direcao.Horizontal);
//		
//		no1.addLeaf(no3);
//		no3.addLeaf(no2);
//		
//		Node no4 = new Node(1, Direcao.Horizontal);
//		no4.getConteiner().setTamanho(100);
//		
//		arvoreSolucao.getTree(no3).setHead(no4);
//		assertEquals(no4, arvoreSolucao.getTree(no2).getParent().getHead());
//		System.out.print(arvoreSolucao.toString());
//	}

	@Test
	public void testSolucaoSimplesConteiner()
	{
		Modelo modelo = new Modelo();
		modelo.adicionaConfiguracao("nova", "100", "100", 100);
		modelo.adicionaComponente("Nova", modelo.pegaConfiguracaoNome("nova"));
		
		GeraArvore gerador = new GeraArvore();
		Node arvore = GeraArvore.executa("c,h,c,v,s,s", modelo);
		assertEquals("c,h,c,v,s,s,",arvore.toString());
	}
	
	@Test
	public void testSolucaoSimplesComUmElemento()
	{
		Modelo modelo = new Modelo();
		modelo.adicionaConfiguracao("ConfiguracaoUm", "100", "100", 100);
		modelo.adicionaComponente("ElementoUm", modelo.pegaConfiguracaoNome("ConfiguracaoUm"));
		
		Node arvore = GeraArvore.executa("c,h,c,v,0,0,s,s", modelo);
		assertEquals("c,h,c,v,0,0,s,s,",arvore.toString());
	}
	
	@Test
	public void testSolucaoSimplesComDoisElementos()
	{
		Modelo modelo = new Modelo();
		modelo.adicionaConfiguracao("ConfiguracaoUm", "100", "100", 100);
		modelo.adicionaComponente("ElementoUm", modelo.pegaConfiguracaoNome("ConfiguracaoUm"));
		modelo.adicionaComponente("Dois", modelo.pegaConfiguracaoNome("ConfiguracaoUm"));
		
		Node arvore = GeraArvore.executa("c,h,c,v,0,0,1,0,s,s", modelo);
		assertEquals("c,h,c,v,0,0,1,0,s,s,",arvore.toString());
	}
	
	@Test
	public void testSolucaoSimplesComDoisElementosDuasConfiguracoes()
	{
		Modelo modelo = new Modelo();
		modelo.adicionaConfiguracao("ConfiguracaoUm", "100", "100", 100);
		modelo.adicionaComponente("ElementoUm", modelo.pegaConfiguracaoNome("ConfiguracaoUm"));
		modelo.adicionaConfiguracao("ConfiguracaoDois", "200", "200", 100);
		modelo.adicionaComponente("Dois", modelo.pegaConfiguracaoNome("ConfiguracaoDois"));
		
		Node arvore = GeraArvore.executa("c,h,c,v,0,0,1,0,s,s", modelo);
		assertEquals("c,h,c,v,0,0,1,0,s,s,",arvore.toString());
	}
	
	@Test
	public void testSolucaoLarguraComponenteVertical()
	{
		Modelo modelo = new Modelo();
		modelo.adicionaConfiguracao("ConfiguracaoUm", "100", "100", 100);
		modelo.adicionaComponente("ElementoUm", modelo.pegaConfiguracaoNome("ConfiguracaoUm"));

		Node arvore = GeraArvore.executa("c,h,c,v,0,0,s,s", modelo);
		
		int tamanho = 0;
		
		for(Node no : arvore.getLeafs()){
			tamanho = no.getConteiner().getLargura();
		}
		
		assertEquals(100, tamanho);
	}
	
	@Test
	public void testSolucaoLarguraComponenteVerticalDois()
	{
		Modelo modelo = new Modelo();
		modelo.adicionaConfiguracao("ConfiguracaoUm", "100", "100", 100);
		modelo.adicionaComponente("ElementoUm", modelo.pegaConfiguracaoNome("ConfiguracaoUm"));
		modelo.adicionaConfiguracao("ConfiguracaoDois", "200", "200", 100);
		modelo.adicionaComponente("Dois", modelo.pegaConfiguracaoNome("ConfiguracaoDois"));
		
		Node arvore = GeraArvore.executa("c,h,c,v,0,0,1,0,s,s", modelo);

		int tamanho = 0;
		
		for(Node no : arvore.getLeafs()){
			tamanho = no.getConteiner().getLargura();
		}
		
		assertEquals(200, tamanho);
	}
		
	
}