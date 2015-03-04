package validacao;

import instancia.Solucao;
import instancia.UnidadeSolucao;
import ordenacao.Ordenacao;
import classes.Modelo;
import enums.TipoRelacao;

/**
 * @author Casimiro
 *
 */
/**
 * @author Casimiro
 *
 */
/**
 * @author Casimiro
 *
 */
public class Validacao {

	
	
	/**
	 * Função geral de validação.
	 * Essa função irá rodar todos os testes para validar uma solução
	 * Os testes são: Validação de Largura, Validação de Prioridade, Validação de Relações
	 * @param solucao
	 * @param larguraTela
	 * @param modelo
	 * @return
	 */
	public static boolean executa(Solucao solucao, double larguraTela, Modelo modelo, boolean construcaoCompleta){
		if (!validaLargura(solucao.calculaLarguraRealSolucao(), larguraTela)) 
			return false;
		
		if(!validaRelacoes(solucao, modelo))
			return false;
					
		if(!construcaoCompleta)
			return false;
		
		return true;
			
	}
	
	/**
	 * Função que valida se a solução é menor que a largura de tela definida
	 * @param solucao
	 * @param larguraTela
	 * @return
	 */
	public static boolean validaLargura(int larguraReal, double larguraTela){
		return larguraReal < larguraTela;
	}
	
	
	/**
	 * @param solucao
	 * @param modelo
	 * @return
	 * Testa as relações (Em Andamento)
	 */
	public static boolean validaRelacoes(Solucao solucao, Modelo modelo){
		
		for(int i = solucao.getSolucao().length - 1; i >= 0 ; i--){

			UnidadeSolucao u = solucao.pegaUnidadeSolucaoIndice(i).copy();
			for(int j = 0   ; j < modelo.pegaNumeroRelacoes() ; j++){
				if(modelo.pegaRelacaoIndice(j).getTipoRelacao() == TipoRelacao.SAMESIZE){
					if(validaRelacaoSamesize(solucao.pegaUnidadeSolucaoIndice(i), solucao.pegaUnidadeSolucaoIndice(modelo.pegaIndiceComponente(modelo.pegaRelacaoIndice(j).getComp_2()))));
						ajustaRelacaoSamesize(solucao.pegaUnidadeSolucaoIndice(i), solucao.pegaUnidadeSolucaoIndice(modelo.pegaIndiceComponente(modelo.pegaRelacaoIndice(j).getComp_2())));
				}
				
				if(modelo.pegaRelacaoIndice(j).getTipoRelacao() == TipoRelacao.POSITION){
					if(validaRelacaoPosition(solucao, modelo)){
						return false;
					}
				}
			}
		}
		return true;
	}
		

	private static boolean validaRelacaoSamesize(UnidadeSolucao u,
			UnidadeSolucao u2) {
		if(u.getFatorTamanho() == u2.getFatorTamanho())
			return true;
		
		return false;
	}
	
	private static void ajustaRelacaoSamesize(UnidadeSolucao u, UnidadeSolucao u2){
		u.setFatorTamanho(u2.getFatorTamanho());
	}

	private static boolean validaRelacaoPosition(Solucao solucao, Modelo modelo) {
		Ordenacao ordenacao = new Ordenacao(modelo);
		ordenacao.executaAbove();
		
		for(int i = 0 ; i < ordenacao.getListaOrdenadaAbove().size() ; i ++){
			for(int j = i + 1 ; j < ordenacao.getListaOrdenadaAbove().size() ; j ++){
				if(solucao.getMatriz().pegaLinha(ordenacao.getListaOrdenadaAbove().indexOf(i)) < solucao.getMatriz().pegaLinha(ordenacao.getListaOrdenadaAbove().indexOf(j)))
					return false;
			}
		}
		
		ordenacao.executaRight();
		
		for(int i = 0 ; i < ordenacao.getListaOrdenadaRight().size() ; i ++){
			for(int j = i + 1 ; j < ordenacao.getListaOrdenadaRight().size() ; j ++){
				if(solucao.getMatriz().pegaColuna(ordenacao.getListaOrdenadaRight().indexOf(i)) < solucao.getMatriz().pegaColuna(ordenacao.getListaOrdenadaRight().indexOf(j)))
					return false;
			}
		}
		
		
		return true;
	}
	
}

