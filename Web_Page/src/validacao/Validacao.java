package validacao;

import old.UnidadeSolucao;
import instancia.Solucao;
import ordenacao.Dependencias;
import ordenacao.Ordenacao;
import classes.Modelo;
import enums.Direcao;
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
	public static boolean executa(Solucao solucao, double larguraTela, Modelo modelo){
	
		if (!validaLargura(solucao.calculaLarguraRealSolucao(), larguraTela)) 
			return false;

		if(!validaRelacoes(solucao, modelo))
			return false;
	
		if(!validaSobreposicao(solucao))
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
	 * Função sobreposição dos componentes de uma solução
	 * * @param solucao
	 * @param larguraTela
	 * @return
	 */
	public static boolean validaSobreposicao(Solucao solucao){
		
		for(int i = 0 ; i < solucao.tamanhoSolucao() ; i++){
			int xZero = solucao.pegaUnidadeSolucaoIndice(i).getX();
			int xLargura = solucao.pegaUnidadeSolucaoIndice(i).getX() + solucao.pegaUnidadeSolucaoIndice(i).pegaLarguraComponente();
			int yZero = solucao.pegaUnidadeSolucaoIndice(i).getY();
			int yAltura = solucao.pegaUnidadeSolucaoIndice(i).getY() + solucao.pegaUnidadeSolucaoIndice(i).pegaAlturaComponente();
			
			
			for(int j = i + 1 ; j < solucao.tamanhoSolucao(); j++){
				
				if((solucao.pegaUnidadeSolucaoIndice(j).getX() >= xZero) && (solucao.pegaUnidadeSolucaoIndice(j).getX() <= xLargura)){
					return false;
				}

				if((solucao.pegaUnidadeSolucaoIndice(j).getY() >= yZero) && (solucao.pegaUnidadeSolucaoIndice(j).getY() <= yAltura)){
					return false;
				}
			
			}
		}
		return true;
	}
	
	
	
	/**
	 * @param solucao
	 * @param modelo
	 * @return
	 * Testa as relações (Em Andamento)
	 */
	public static boolean validaRelacoes(Solucao solucao, Modelo modelo){
		
		for(int i = solucao.getSolucao().length - 1; i >= 0 ; i--){
			for(int j = 0   ; j < modelo.pegaNumeroRelacoes() ; j++){
				if(modelo.pegaRelacaoIndice(j).getComp_1() == solucao.pegaUnidadeSolucaoIndice(i).getComponente()){
					if(modelo.pegaRelacaoIndice(j).getTipoRelacao() == TipoRelacao.SAMESIZE){
						if(!validaRelacaoSamesize(solucao.pegaUnidadeSolucaoIndice(i), solucao.pegaUnidadeSolucaoIndice(modelo.pegaIndiceComponente(modelo.pegaRelacaoIndice(j).getComp_2()))));
						ajustaRelacaoSamesize(solucao.pegaUnidadeSolucaoIndice(i), solucao.pegaUnidadeSolucaoIndice(modelo.pegaIndiceComponente(modelo.pegaRelacaoIndice(j).getComp_2())));
						}
					
					if(modelo.pegaRelacaoIndice(j).getTipoRelacao() == TipoRelacao.POSITION){
						if(!validaRelacaoPosition(solucao, modelo)){
							return false;
						}
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
		ordenacao.executa();
		
		for(int i = 0 ; i < ordenacao.getListaOrdenada().size() ; i++){
			for(int j = i ; j < ordenacao.getListaOrdenada().size() ; j++){
				for(Dependencias d : ordenacao.getDependencias()){
					if((d.getA() == ordenacao.pegaListaOrdenadaIndice(i)) && (d.getB() == ordenacao.pegaListaOrdenadaIndice(j))){
						if((d.getDirecao() == Direcao.RIGHT) && 
							(solucao.pegaUnidadeSolucaoIndice(i).getX() < solucao.pegaUnidadeSolucaoIndice(j).getX())){
							ajustaRelacaoPosition(solucao.pegaUnidadeSolucaoIndice(i), solucao.pegaUnidadeSolucaoIndice(j), Direcao.RIGHT);
						}
						
						if((d.getDirecao() == Direcao.ABOVE) && 
							(solucao.pegaUnidadeSolucaoIndice(i).getY() > solucao.pegaUnidadeSolucaoIndice(j).getY())){
							ajustaRelacaoPosition(solucao.pegaUnidadeSolucaoIndice(i), solucao.pegaUnidadeSolucaoIndice(j), Direcao.LEFT);}
					}
				}
			}	
		}	
				return true;
	}
	
	private static void ajustaRelacaoPosition(UnidadeSolucao u, UnidadeSolucao u2, Direcao direcao){
		
		if(direcao.equals(Direcao.RIGHT))
			u.setX(u2.getX() + u2.pegaLarguraComponente() + 1);
		else
			u.setY(u2.getX() - u.pegaAlturaComponente());
	}
	
}

