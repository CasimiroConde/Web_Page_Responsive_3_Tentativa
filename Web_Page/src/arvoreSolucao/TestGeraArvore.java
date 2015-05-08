package arvoreSolucao;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGeraArvore {

	@Test
	public void testCargaNode() {
		String [] conteiner = new String[2], elemento1 = new String[2];
		conteiner[0] = new String("0");
		conteiner[1] = new String("1");
		elemento1[0] = new String("0");
		elemento1[1] = new String("0");
		
		
		Node no1 = new Node(1,conteiner);
		Node no2 = new Node(0,elemento1);
		
		assertEquals(null, no1.getElemento());
		assertEquals("0", no1.getConteiner().getIndice());
		assertEquals(1,no1.getConteiner().getDirecao());
		assertEquals(null, no2.getConteiner());
		assertEquals(0, no2.getElemento().getIndiceComponente());
		assertEquals(0, no2.getElemento().getIndiceCaracteristica());
		
	}
	
	@Test
	public void testCargaNodeEmArvore() {
		String [] conteiner = new String[2], conteinerSub = new String[2], elemento1 = new String[2];
		conteiner[0] = new String("0");
		conteiner[1] = new String("1");
		elemento1[0] = new String("0");
		elemento1[1] = new String("0");
		conteinerSub[0] = new String("1");
		conteinerSub[1] = new String("1");
		
		
		Node no1 = new Node(1,conteiner);
		Node no2 = new Node(0,elemento1);
		Node no3 = new Node(1,conteinerSub);
		
		ArvoreSolucao<Node> arvoreSolucao = new ArvoreSolucao<Node>(no1);
		arvoreSolucao.addLeaf(no1, no2);

		assertEquals(no1, arvoreSolucao.getHead());
		assertEquals(no2, arvoreSolucao.getTree(no2).getHead());
	}

	@Test
	public void testSubstituiNodeEmArvore() {
		String [] conteiner = new String[2], conteinerSub = new String[2], elemento1 = new String[2];
		conteiner[0] = new String("0");
		conteiner[1] = new String("1");
		elemento1[0] = new String("0");
		elemento1[1] = new String("0");
		conteinerSub[0] = new String("1");
		conteinerSub[1] = new String("1");
		
		
		Node no1 = new Node(1,conteiner);
		Node no2 = new Node(0,elemento1);
		Node no3 = new Node(1,conteinerSub);
		
		ArvoreSolucao<Node> arvoreSolucao = new ArvoreSolucao<Node>(no1);
		arvoreSolucao.addLeaf(no1, no2);

		assertEquals(no1, arvoreSolucao.getHead());
		assertEquals(no2, arvoreSolucao.getTree(no2).getHead());
		
		arvoreSolucao.setHead(no3);
		assertEquals(no3, arvoreSolucao.getHead());
		
	}
	
	@Test
	public void testAlteraConteinerNodeEmArvore() {
		String [] conteiner = new String[2], conteiner1 = new String[2], elemento1 = new String[2];
		conteiner[0] = new String("0");
		conteiner[1] = new String("1");
		elemento1[0] = new String("0");
		elemento1[1] = new String("0");
		conteiner1[0] = new String("1");
		conteiner1[1] = new String("1");
		
		
		Node no1 = new Node(1,conteiner);
		Node no2 = new Node(0,elemento1);
		Node no3 = new Node(1,conteiner1);
		
		ArvoreSolucao<Node> arvoreSolucao = new ArvoreSolucao<Node>(no1);
		arvoreSolucao.addLeaf(no1, no3);
		arvoreSolucao.addLeaf(no3, no2);
		
		Node no4 = new Node(no3);
		
		no4.getConteiner().setTamanho(100);
		
		arvoreSolucao.getTree(no3).setHead(no4);
		
		assertEquals(no4, arvoreSolucao.getTree(no2).getParent().getHead());
				
		System.out.print(arvoreSolucao.toString());
	}
}
