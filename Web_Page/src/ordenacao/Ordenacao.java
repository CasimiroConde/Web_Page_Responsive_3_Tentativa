package ordenacao;

import java.util.ArrayList;

import lombok.Data;
import classes.Modelo;
import enums.Direcao;

public @Data class Ordenacao {
	
	 
	
	private ArrayList<Dependencias> dependencias;
	private ArrayList<Integer> listaOrdenadaUnder;
	private ArrayList<Integer> listaOrdenadaRight;
	private ArrayList<UnidadeOrdenacao> listaNaoOrdenada;
	
	public Ordenacao(){
		dependencias = null;
		listaNaoOrdenada = null;
		listaOrdenadaRight = null;
		listaOrdenadaUnder = null;
	}
	
	
	public Ordenacao(Modelo modelo){
		dependencias = Dependencias.geraDependencia(modelo);
		listaNaoOrdenada = geraListaNaoOrdenada(modelo);
		listaOrdenadaRight = null;
		listaOrdenadaUnder = null;
	}
	
	public ArrayList<UnidadeOrdenacao> geraListaNaoOrdenada(Modelo modelo){
		ArrayList<UnidadeOrdenacao> listaNaoOrd = new ArrayList<UnidadeOrdenacao>();
		for(int i = 0 ; i < modelo.pegaNumeroComponentes() ; i++){
			UnidadeOrdenacao uniOrdenacao = new UnidadeOrdenacao(i, false);
			listaNaoOrd.add(uniOrdenacao);
		}
		
		return listaNaoOrd;
	}
	
	
	public void executaUnder (){
		for(UnidadeOrdenacao n : this.getListaNaoOrdenada()){
				this.visita(n, this.dependencias, Direcao.UNDER, this.listaOrdenadaUnder);
		}		
	}
	
	public void executaRight (){
		for(UnidadeOrdenacao n : this.getListaNaoOrdenada()){
			if(!n.isVisitado())
				this.visita(n, this.dependencias, Direcao.RIGHT, this.listaOrdenadaRight);
		}
	}

 
	private void visita(UnidadeOrdenacao no, ArrayList<Dependencias> dependencias, Direcao direcao, ArrayList<Integer> listaOrdenada) {
		if(!no.isVisitado()){
			no.setVisitado(true);
			for(Dependencias d : dependencias){
				if(d.getA() == no.getIndice()){
					visita(pegaNo(d.getB()), dependencias, direcao, listaOrdenada);
					listaOrdenada.add(no.getIndice());
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
