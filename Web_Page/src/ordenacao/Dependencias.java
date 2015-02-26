package ordenacao;

import java.util.ArrayList;

import lombok.Data;
import classes.Componente;
import classes.Modelo;
import classes.Relacao;
import enums.Direcao;

public @Data class Dependencias {

	private int A;
	private int B;
	private Direcao direcao;
	
	public Dependencias (int a, int b, Direcao dir){
		this.A = a;
		this.B = b;
		this.direcao = dir;
	}
	
	public static ArrayList<Dependencias> geraDependencia(Modelo modelo){
		ArrayList<Dependencias>  dep = new ArrayList<Dependencias>();
		for(int i = 0 ; i < modelo.pegaNumeroRelacoes() ; i++){
			Dependencias dependencia;
			for(Direcao d : modelo.pegaRelacaoIndice(i).getDirecao()){
				if(d.equals(Direcao.ABOVE)){
					dependencia = new Dependencias(modelo.pegaIndiceComponente(modelo.pegaRelacaoIndice(i).getComp_1()), 
												modelo.pegaIndiceComponente(modelo.pegaRelacaoIndice(i).getComp_2()), 
												Direcao.ABOVE);
					dep.add(dependencia); 
				}
				else if(d.equals(Direcao.UNDER)){
					dependencia = new Dependencias(modelo.pegaIndiceComponente(modelo.pegaRelacaoIndice(i).getComp_2()), 
												modelo.pegaIndiceComponente(modelo.pegaRelacaoIndice(i).getComp_1()), 
												Direcao.ABOVE);
					dep.add(dependencia);
				}
				else if(d.equals(Direcao.RIGHT)){
					dependencia = new Dependencias(modelo.pegaIndiceComponente(modelo.pegaRelacaoIndice(i).getComp_1()), 
												modelo.pegaIndiceComponente(modelo.pegaRelacaoIndice(i).getComp_2()), 
												Direcao.RIGHT);
					dep.add(dependencia);
				}
				else if(d.equals(Direcao.LEFT)){
					dependencia = new Dependencias(modelo.pegaIndiceComponente(modelo.pegaRelacaoIndice(i).getComp_2()), 
												modelo.pegaIndiceComponente(modelo.pegaRelacaoIndice(i).getComp_1()), 
												Direcao.RIGHT);
					dep.add(dependencia);
				}
			}
		}
		return dep;
	}
}
