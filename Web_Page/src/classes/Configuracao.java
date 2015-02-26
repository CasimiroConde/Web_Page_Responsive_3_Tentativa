package classes;

import java.util.ArrayList;

import lombok.Getter;

/*Classe que representa das possíveis configurações que um componente pode assumir.
*Configurações possuem uma ou mais possíveis características que serão utilizadas para
*definir a melhor solução.
*/
public class Configuracao {

	private @Getter String nome;
	private ArrayList<Caracteristica> caract;

	public Configuracao(String nome) {
		this.nome = nome;
		this.caract = new ArrayList<Caracteristica>();
	}

	public Iterable<Caracteristica> getCaracteristicas() {
		return caract;
	}

	public void addAllCaracteristicas(ArrayList<Caracteristica> caracteristicas) {
		this.caract.addAll(caracteristicas);
	}

	public void addCaracteristicas(String larg, String alt, double coef) {
		Caracteristica caracteristica = new Caracteristica();
		caracteristica.setAltura(alt);
		caracteristica.setLargura(larg);
		caracteristica.setCoeficienteInformacao(coef);
		this.caract.add(caracteristica);
	}

	public void print() {
		System.out.println(this.nome + ":");
		for (Caracteristica c : this.caract) {
			System.out.println("        " + c.getAltura() + ";" + c.getLargura() + ";"
					+ c.getCoeficienteInformacao());
		}
	}
	
	public int pegaNumeroCaracteristicas(){
		return caract.size();
	}
	
	public Caracteristica pegaCaracteristicaIndice(int indice){
		return this.caract.get(indice);
	}
}