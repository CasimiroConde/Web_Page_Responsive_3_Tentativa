package validacao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import classes.Modelo;
import enums.Direcao;
import enums.TipoRelacao;
import instancia.Solucao;
import instancia.UnidadeSolucao;

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
		return (validaLargura(solucao.calculaLarguraRealSolucao(), larguraTela) && validaRelacoes(solucao, modelo) && construcaoCompleta);

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
					if(validaRelacaoPosition(solucao.pegaUnidadeSolucaoIndice(i), solucao.pegaUnidadeSolucaoIndice(modelo.pegaIndiceComponente(modelo.pegaRelacaoIndice(j).getComp_2())), modelo.pegaRelacaoIndice(j).getDirecao(), solucao, modelo)){
					
					}
				}
			}
		/*	
			for(int j = 0   ; j < modelo.pegaNumeroRelacoes() ; j++){
				if(modelo.pegaRelacaoIndice(j).getComp_1() == u.getComponente()){
					UnidadeSolucao u2 = solucao.pegaUnidadeSolucaoNome(modelo.pegaRelacaoIndice(j).getComp_2().getNome()).copy();
					if(modelo.pegaRelacaoIndice(j).getTipoRelacao() == TipoRelacao.POSITION){
						ajustaRelacaoPosition(solucao.pegaUnidadeSolucaoIndice(i), solucao.pegaUnidadeSolucaoNome(modelo.pegaRelacaoIndice(j).getComp_2().getNome()), modelo.pegaRelacaoIndice(j).getDirecao(), solucao, modelo);
						//validaRelacoes(solucao, modelo);
					}
					if(modelo.pegaRelacaoIndice(j).getTipoRelacao() == TipoRelacao.SIZE){
						validaRelacaoSize(solucao.pegaUnidadeSolucaoIndice(i), solucao.pegaUnidadeSolucaoNome(modelo.pegaRelacaoIndice(j).getComp_2().getNome()), modelo.pegaRelacaoIndice(j).getDirecao(), solucao);
						//validaRelacoes(solucao, modelo);
					}
				}
			}
		}*/
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

	private static boolean validaRelacaoPosition(UnidadeSolucao u,
			UnidadeSolucao u2, ArrayList<Direcao> direcao, Solucao solucao, Modelo modelo) {
		return true;
	}
	
}

