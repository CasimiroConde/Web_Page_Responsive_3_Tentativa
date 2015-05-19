package arvoreSolucao;

import java.util.Stack;

import classes.Caracteristica;
import classes.Componente;
import classes.Modelo;

public class GeraArvore {
	
	public static int TAMANHO_DE_TELA = 1200;
	
	public static Node executa(String input, Modelo modelo) {
		String[] vetorInput = input.split(",");
		int contConteiner = 0;
		
		Node pai = new Node(contConteiner, DirecaoConteiner.get(vetorInput[1]));
		pai.getConteiner().setTamanho(TAMANHO_DE_TELA);
		Stack<Node> pilhaConteiners = new Stack<Node>();
		pilhaConteiners.push(pai);
		
		contConteiner++;
		int posicaoVetor = 2;
		
		while (posicaoVetor < vetorInput.length) {
			String token = vetorInput[posicaoVetor];
		
			if (token.compareToIgnoreCase("s") == 0) {
				pilhaConteiners.pop();
				posicaoVetor++;
			}

			else if (token.compareToIgnoreCase("c") == 0) {
				DirecaoConteiner direcao = DirecaoConteiner.get(vetorInput[posicaoVetor + 1]);
				Node no = new Node(contConteiner, direcao);

				Node conteiner = pilhaConteiners.peek();
				conteiner.addLeaf(no);
				pilhaConteiners.push(no);
				
				posicaoVetor = posicaoVetor + 2;
				contConteiner++;
			}
			
			else {
				int indiceComponente = Integer.parseInt(vetorInput[posicaoVetor]);
				int indiceCaracteristica = Integer.parseInt(vetorInput[posicaoVetor + 1]);
				Node no = new Node(indiceComponente, indiceCaracteristica);
				
				Node noConteiner = pilhaConteiners.peek();
				noConteiner.addLeaf(no);

				Componente componente = modelo.pegaComponenteIndice(indiceComponente);
				Caracteristica caracteristica = componente.getConfiguracao().pegaCaracteristicaIndice(indiceCaracteristica);
				int largura = Integer.parseInt(caracteristica.getLargura());
				int tamanho = noConteiner.getConteiner().getTamanho();
				
				if(tamanho < largura){
					noConteiner.getConteiner().setTamanho(largura);
					noConteiner.getParent().getConteiner().setTamanho(largura);
					
				}
				posicaoVetor = posicaoVetor + 2;
			}
		}
		
		return pai;
	}
}