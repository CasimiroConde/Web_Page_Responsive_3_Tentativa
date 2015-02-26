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
		return (validaLargura(solucao.calculaLarguraRealSolucao(), larguraTela) /*&& /*validaRelacoes(solucao, modelo) construcaoCompleta*/);

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

	private static void validaRelacaoSize(UnidadeSolucao u, UnidadeSolucao u2,
			ArrayList<Direcao> direcao, Solucao solucao) {
		// TODO Auto-generated method stub
		
	}

	/*private static void ajustaRelacaoPosition(UnidadeSolucao u,
			UnidadeSolucao u2, ArrayList<Direcao> direcao, Solucao solucao, Modelo modelo) {
		for(Direcao d : direcao){
			if(d.equals(Direcao.ABOVE)){
				if(u.getLinha() > u2.getLinha())
					u.trocaLinha(u2);
			} else if (d.equals(Direcao.UNDER)){
				if(u.getLinha() < u2.getLinha())
					u.trocaLinha(u2);
			}else if (d.equals(Direcao.LEFT)){
				if(u.getPrioridade() > u2.getPrioridade())
					u.trocaPrioridade(u2);
			}else if (d.equals(Direcao.RIGHT)){
				if(u.getPrioridade() < u2.getPrioridade())
					u.trocaPrioridade(u2);
			}
		}
	}
	
	private static boolean validaQualidadeRelacaoPosition(UnidadeSolucao u,
			Solucao solucao, Modelo modelo) {
		
		for(int j = 0   ; j < modelo.pegaNumeroRelacoes() ; j++){
			if(modelo.pegaRelacaoIndice(j).getComp_1() == u.getComponente()){
				if(modelo.pegaRelacaoIndice(j).getTipoRelacao() == TipoRelacao.POSITION){
					for(Direcao d : modelo.pegaRelacaoIndice(j).getDirecao()){
						if(d.equals(Direcao.ABOVE)){
							if(u.getLinha() > solucao.pegaUnidadeSolucaoNome(modelo.pegaRelacaoIndice(j).getComp_2().getNome()).getLinha())
								return false;
						} else if (d.equals(Direcao.UNDER)){
							if(u.getLinha() < solucao.pegaUnidadeSolucaoNome(modelo.pegaRelacaoIndice(j).getComp_2().getNome()).getLinha())
								return false;
						}else if (d.equals(Direcao.LEFT)){
							if(u.getPrioridade() >	solucao.pegaUnidadeSolucaoNome(modelo.pegaRelacaoIndice(j).getComp_2().getNome()).getPrioridade())
								return false;
						}else if (d.equals(Direcao.RIGHT)){
							if(u.getPrioridade() < solucao.pegaUnidadeSolucaoNome(modelo.pegaRelacaoIndice(j).getComp_2().getNome()).getPrioridade())
								return false;
						}
					}
				}
			}
		}
		return true;
	}*/
}
