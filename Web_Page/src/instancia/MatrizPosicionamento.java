package instancia;

public class MatrizPosicionamento
{
	private int[][] componentes = null;
	private int ultimaPosicaoX = -1;
	private int ultimaPosicaoY = -1;
	
	public void adicionaComponenteInicial(int indice)
	{
		componentes = new int[1][1];
		componentes[0][0] = indice;
		ultimaPosicaoX = 0;
		ultimaPosicaoY = 0;
	}
	
	public boolean adicionaNoroeste(int indice)
	{
		if (ultimaPosicaoX == 0)
			aumentaEsquerda();
		
		if (ultimaPosicaoY == 0)
			aumentaCima();

		if (componentes[ultimaPosicaoY-1][ultimaPosicaoX-1] >= 0){
			ultimaPosicaoX = ultimaPosicaoX-1;
			ultimaPosicaoY = ultimaPosicaoY-1;
			return false;
		}
		
		componentes[ultimaPosicaoY-1][ultimaPosicaoX-1] = indice;
		ultimaPosicaoX = ultimaPosicaoX-1;
		ultimaPosicaoY = ultimaPosicaoY-1;
		return true;
	}

	public boolean adicionaNorte(int indice)
	{
		if (ultimaPosicaoY == 0)
			aumentaCima();

		if (componentes[ultimaPosicaoY-1][ultimaPosicaoX] >= 0){
			ultimaPosicaoY = ultimaPosicaoY-1;
			return false;
		}
		
		componentes[ultimaPosicaoY-1][ultimaPosicaoX] = indice;
		ultimaPosicaoY = ultimaPosicaoY-1;
		return true;
	}
	
	public boolean adicionaNordeste(int indice)
	{
		int colunas = getColunas();

		if (ultimaPosicaoX == colunas-1)
			aumentaDireita();
		
		if (ultimaPosicaoY == 0)
			aumentaCima();

		if (componentes[ultimaPosicaoY-1][ultimaPosicaoX+1] >= 0){
			ultimaPosicaoX = ultimaPosicaoX+1;
			ultimaPosicaoY = ultimaPosicaoY-1;
			return false;
		}
		
		componentes[ultimaPosicaoY-1][ultimaPosicaoX+1] = indice;
		ultimaPosicaoX = ultimaPosicaoX+1;
		ultimaPosicaoY = ultimaPosicaoY-1;
		return true;
	}
	
	public boolean adicionaOeste(int indice)
	{
		if (ultimaPosicaoX == 0)
			aumentaEsquerda();
		
		if (componentes[ultimaPosicaoY][ultimaPosicaoX-1] >= 0){
			ultimaPosicaoX = ultimaPosicaoX-1;
			return false;
		}
		
		componentes[ultimaPosicaoY][ultimaPosicaoX-1] = indice;
		ultimaPosicaoX = ultimaPosicaoX-1;
		return true;
	}
	
	public boolean adicionaLeste(int indice)
	{
		int colunas = getColunas();

		if (ultimaPosicaoX == colunas-1)
			aumentaDireita();
		
		if (componentes[ultimaPosicaoY][ultimaPosicaoX+1] >= 0){
			ultimaPosicaoX = ultimaPosicaoX+1;
			return false;
		}
		
		componentes[ultimaPosicaoY][ultimaPosicaoX+1] = indice;
		ultimaPosicaoX = ultimaPosicaoX+1;
		return true;
	}
	
	public boolean adicionaSudoeste(int indice)
	{
		int linhas = getLinhas();

		if (ultimaPosicaoX == 0)
			aumentaEsquerda();
		
		if (ultimaPosicaoY == linhas-1)
			aumentaBaixo();

		if (componentes[ultimaPosicaoY+1][ultimaPosicaoX-1] >= 0){
			ultimaPosicaoX = ultimaPosicaoX-1;
			ultimaPosicaoY = ultimaPosicaoY+1;
			return false;
		}
		
		componentes[ultimaPosicaoY+1][ultimaPosicaoX-1] = indice;
		ultimaPosicaoX = ultimaPosicaoX-1;
		ultimaPosicaoY = ultimaPosicaoY+1;
		return true;
	}
	
	public boolean adicionaSul(int indice)
	{
		int linhas = getLinhas();

		if (ultimaPosicaoY == linhas-1)
			aumentaBaixo();

		if (componentes[ultimaPosicaoY+1][ultimaPosicaoX] >= 0){
			ultimaPosicaoY = ultimaPosicaoY+1;
			return false;
		}
		
		componentes[ultimaPosicaoY+1][ultimaPosicaoX] = indice;
		ultimaPosicaoY = ultimaPosicaoY+1;
		return true;
	}
	
	public boolean adicionaSudeste(int indice)
	{
		int linhas = getLinhas();
		int colunas = getColunas();

		if (ultimaPosicaoX == colunas-1)
			aumentaDireita();
		
		if (ultimaPosicaoY == linhas-1)
			aumentaBaixo();

		if (componentes[ultimaPosicaoY+1][ultimaPosicaoX+1] >= 0){
			ultimaPosicaoX = ultimaPosicaoX+1;
			ultimaPosicaoY = ultimaPosicaoY+1;
			return false;
		}
		
		componentes[ultimaPosicaoY+1][ultimaPosicaoX+1] = indice;
		ultimaPosicaoX = ultimaPosicaoX+1;
		ultimaPosicaoY = ultimaPosicaoY+1;
		return true;
	}
	
	private void aumentaEsquerda() {
		int linhas = getLinhas();
		int colunas = getColunas();
		int[][] nova = new int[linhas][colunas+1];
		
		for (int linha = 0; linha < linhas; linha++)
		{
			nova[linha][0] = -1;
			
			for (int coluna = 0; coluna < colunas; coluna++)
				nova[linha][coluna+1] = componentes[linha][coluna];
		}
		
		componentes = nova;
		ultimaPosicaoX++;
	}
	
	private void aumentaDireita() {
		int linhas = getLinhas();
		int colunas = getColunas();
		int[][] nova = new int[linhas][colunas+1];
		
		for (int linha = 0; linha < linhas; linha++)
		{
			for (int coluna = 0; coluna < colunas; coluna++)
				nova[linha][coluna] = componentes[linha][coluna];

			nova[linha][colunas] = -1;
		}
		
		componentes = nova;
	}
	
	private void aumentaCima() {
		int linhas = getLinhas();
		int colunas = getColunas();
		int[][] nova = new int[linhas+1][colunas];
		
		for (int linha = 0; linha < linhas; linha++)
			for (int coluna = 0; coluna < colunas; coluna++)
				nova[linha+1][coluna] = componentes[linha][coluna];

		for (int coluna = 0; coluna < colunas; coluna++)
			nova[0][coluna] = -1;
		
		componentes = nova;
		ultimaPosicaoY++;
	}
	
	private void aumentaBaixo() {
		int linhas = getLinhas();
		int colunas = getColunas();
		int[][] nova = new int[linhas+1][colunas];
		
		for (int linha = 0; linha < linhas; linha++)
			for (int coluna = 0; coluna < colunas; coluna++)
				nova[linha][coluna] = componentes[linha][coluna];

		for (int coluna = 0; coluna < colunas; coluna++)
			nova[linhas][coluna] = -1;
		
		componentes = nova;
	}

	public int getLinhas() {
		return componentes.length;
	}
	
	public int getColunas() {
		return componentes[0].length;
	}
	
	public int getCelula(int linha, int coluna) {
		return componentes[linha][coluna];
	}
	
	public int pegaLinha(int indice){
		for(int i = 0 ; i < this.getLinhas() ; i++){
			for(int j = 0 ; j < this.getColunas(); j++){
				if(indice == getCelula(i, j))
					return i;
			}
		}
		return -1;
	}
	
	public int pegaColuna(int indice){
		for(int i = 0 ; i < this.getLinhas() ; i++){
			for(int j = 0 ; j < this.getColunas(); j++){
				if(indice == getCelula(i, j))
					return j;
			}
		}
		return -1;
	}

	
	
}