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
				return true;
	}
	
	private static void ajustaRelacaoPosition(UnidadeSolucao u, UnidadeSolucao u2, Direcao direcao){
		
		if(direcao.equals(Direcao.RIGHT))
			u.setX(u2.getX() + u2.pegaLarguraComponente() + 1);
		else
			u.setY(u2.getX() - u.pegaAlturaComponente());
	}
	
}

