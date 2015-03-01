package ordenacao;

import java.util.ArrayList;

import lombok.Data;
import classes.Modelo;
import enums.Direcao;

public @Data class Ordenacao {
	
	 
	
	private ArrayList<Dependencias> dependencias;
	private ArrayList<Integer> listaOrdenadaAbove;
	private ArrayList<Integer> listaOrdenadaRight;
	private ArrayList<UnidadeOrdenacao> listaNaoOrdenada;
	
	public Ordenacao(){
		dependencias = new ArrayList<Dependencias>();
		listaNaoOrdenada = new ArrayList<UnidadeOrdenacao>();
		listaOrdenadaRight = new ArrayList<Integer>();
		listaOrdenadaAbove = new ArrayList<Integer>();
	}
	
	
	public Ordenacao(Modelo modelo){
		dependencias = Dependencias.geraDependencia(modelo);
		listaNaoOrdenada = geraListaNaoOrdenada(modelo);
		listaOrdenadaRight = new ArrayList<Integer>();
		listaOrdenadaAbove = new ArrayList<Integer>();
	}
	
	public void adicionaDependencia(Dependencias dep){
		this.dependencias.add(dep);
	}
	
	public void setListaNaoOrdenadaFalse(){
		for(UnidadeOrdenacao u : this.listaNaoOrdenada){
			u.setVisitado(false);
		}
	}
	
	public void adicionaListaNaoOrdenada(UnidadeOrdenacao uni){
		this.listaNaoOrdenada.add(uni);
	}
	
	public ArrayList<UnidadeOrdenacao> geraListaNaoOrdenada(Modelo modelo){
		ArrayList<UnidadeOrdenacao> listaNaoOrd = new ArrayList<UnidadeOrdenacao>();
		for(int i = 0 ; i < modelo.pegaNumeroComponentes() ; i++){
			UnidadeOrdenacao uniOrdenacao = new UnidadeOrdenacao(i, false);
			listaNaoOrd.add(uniOrdenacao);
		}
		
		return listaNaoOrd;
	}
	
	
	public void executaAbove (){
		this.setListaNaoOrdenadaFalse();
		for(UnidadeOrdenacao n : this.getListaNaoOrdenada()){
				this.visita(n, this.dependencias, Direcao.ABOVE, this.listaOrdenadaAbove);
		}		
	}
	
	public void executaRight (){
		this.setListaNaoOrdenadaFalse();
		for(UnidadeOrdenacao n : this.getListaNaoOrdenada()){
			if(!n.isVisitado())
				this.visita(n, this.dependencias, Direcao.RIGHT, this.listaOrdenadaRight);
		}
	}

 
	private void visita(UnidadeOrdenacao no, ArrayList<Dependencias> dependencias, Direcao direcao, ArrayList<Integer> listaOrdenada) {
		if(!no.isVisitado()){
			no.setVisitado(true);
			listaOrdenada.add(no.getIndice());
			for(Dependencias d : dependencias){
				if(d.getDirecao().equals(direcao)){
					if(d.getA() == no.getIndice()){
						visita(pegaNo(d.getB()), dependencias, direcao, listaOrdenada);
					}
				}
			}
		}
	}
	
	private UnidadeOrdenacao pegaNo(int indice){
		for(UnidadeOrdenacao u : listaNaoOrdenada){
			if(u.getIndice() == indice)
				return u;
		}
		return null;
	}

}
