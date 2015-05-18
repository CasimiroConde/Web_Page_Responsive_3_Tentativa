package old.arvoreSolucao;

public class CorrigeArvore {

	public static void executa(ArvoreSolucao<Node> arvore) throws Throwable{
		
		corrigeTamanhos(arvore);
		
		corrigeRelacoes(arvore);
		
		retiraConteinerVazio(arvore);
		
		corrigeDirecaoConteiner(arvore);
		
		unificaConteneiner(arvore);
		
	}

	private static void corrigeRelacoes(ArvoreSolucao<Node> arvore) {
		// TODO Auto-generated method stub
		
	}

	private static void corrigeTamanhos(ArvoreSolucao<Node> arvore) {
		// TODO Auto-generated method stub
		
	}

	private static void unificaConteneiner(ArvoreSolucao<Node> arvore) {
		// TODO Auto-generated method stub
		
	}

	private static void corrigeDirecaoConteiner(ArvoreSolucao<Node> arvore) {
		// TODO Auto-generated method stub
		
	}

	private static void retiraConteinerVazio(ArvoreSolucao<Node> arvore) {

			
		 for (ArvoreSolucao<Node> leaf : arvore.getLeafs()){
			 if(!leaf.getSubTrees().isEmpty())
				 retiraConteinerVazio(leaf);
			 
			 if(leaf.getHead().getTipo() == 1){
					if(leaf.getSubTrees().isEmpty()){
						leaf.remove();
					}
				}
			 
		 }
	}
	
}
