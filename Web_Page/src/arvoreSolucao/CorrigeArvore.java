package arvoreSolucao;

public class CorrigeArvore {

//	public static void executa(Node<Node> arvore) throws Throwable{
//		
//		corrigeTamanhos(arvore);
//		
//		corrigeRelacoes(arvore);
//		
//		retiraConteinerVazio(arvore);
//		
//		corrigeDirecaoConteiner(arvore);
//		
//		unificaConteneiner(arvore);
//		
//	}
//
//	private static void corrigeRelacoes(Node<Node> arvore) {
//	}
//
//	private static void corrigeTamanhos(Node<Node> arvore) {
//	}
//
//	private static void unificaConteneiner(Node<Node> arvore) {
//	}
//
//	private static void corrigeDirecaoConteiner(Node<Node> arvore) {
//	}
//
//	private static void retiraConteinerVazio(Node<Node> arvore) {
//		 for (Node<Node> leaf : arvore.getLeafs()){
//			 if(!leaf.getSubTrees().isEmpty())
//				 retiraConteinerVazio(leaf);
//			 
//			 if(leaf.getHead().getTipo() == 1){
//					if(leaf.getSubTrees().isEmpty()){
//						leaf.remove();
//					}
//				}
//		 }
//	}	
}