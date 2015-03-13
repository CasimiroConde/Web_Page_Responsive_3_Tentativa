package instancia;

import classes.Modelo;

public class ConstrutorMatrizPosicionamento {

	public static MatrizPosicionamento executa(Solucao solucao, Modelo modelo)
	{
		MatrizPosicionamento m = new MatrizPosicionamento();
		m.adicionaComponenteInicial(0);
				
		for(int i = 1; i < solucao.tamanhoSolucao(); i++)
		{	
				
			boolean ok;
			
			double fatorPosicao = solucao.pegaUnidadeSolucaoIndice(i).getFatorPosicao();
			
			if (fatorPosicao == 1)
			{
				ok = m.adicionaNoroeste(i);
			}
			else if (fatorPosicao == 2)
			{
				ok = m.adicionaNorte(i);
			}
			else if (fatorPosicao == 3)
			{
				ok = m.adicionaNordeste(i);
			}
			else if (fatorPosicao == 4)
			{
				ok = m.adicionaOeste(i);
			}
			else if (fatorPosicao == 5)
			{
				ok = m.adicionaLeste(i);
			}
			else if (fatorPosicao == 6)
			{
				ok = m.adicionaSudoeste(i);
			}
			else if (fatorPosicao == 7)
			{
				ok = m.adicionaSul(i);
			}
			else
			{
				ok = m.adicionaSudeste(i);
			}
			
			if (!ok){
				//solucao.pegaUnidadeSolucaoIndice(i).geraFatorPosicao();
				//solucao.setConstrucaoCompleta(ok);
				i--;
				//return m;
			}

		}
		solucao.setConstrucaoCompleta(true);
		return m;
	}
	
	public static void print(MatrizPosicionamento matriz){
		for(int i = 0 ; i < matriz.getLinhas() ; i++){
			for(int j = 0 ; j < matriz.getColunas() ; j++){
				System.out.print(matriz.getCelula(i, j) + "|");
			}
			System.out.println();
		}
	}
}