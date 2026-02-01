/*  
    * Tamagotchi - Old Class
    ? Adding previous class of Tamagotchi to test it with JUnit, fix one thing to adapt it to the '@Test':

    ! 1. gioca(), adding one more condition to evitate that the dog go to a negative body count. Used in -> TestTamagotchi -> testGiocaPesoMinimo

*/

package Calcolo;

public class Tamagotchi {

	private final String nome;
	private final String specie;
	private double peso;
	private double altezza;
	private int energia;

	public Tamagotchi(String nome, String specie) {

		this.nome = nome;

		switch (specie.toLowerCase()) {

		case "cane":

			this.specie = "Cane";
			this.peso = 300.0;
			this.altezza = 20.0;

			break;

		case "gatto":

			this.specie = "Gatto";
			this.peso = 100.0;
			this.altezza = 10.0;

			break;

		case "canarino":

			this.specie = "Canarino";
			this.peso = 10.0;
			this.altezza = 3.0;

			break;

		case "coniglio":

			this.specie = "Coniglio";
			this.peso = 100.0;
			this.altezza = 10.0;
			break;

		default:

			this.specie = "Cane";
			this.peso = 300.0;
			this.altezza = 20.0;
			break;

		}

		this.energia = 3;

	}

	public Tamagotchi(String nome) {
		this(nome, "cane");
	}

	
	public String getNome() {
		return nome;
	}

	public String getSpecie() {
		return specie;
	}

	public double getPeso() {
		return peso;
	}

	public double getAltezza() {
		return altezza;
	}

	public int getEnergia() {
		return energia;
	}

	
	@Override
	public String toString() {
		return "Tamagotchi [nome= " + nome + ", specie= " + specie + ", peso= " + peso + ", altezza= " + altezza
				+ ", energia= " + energia + "]";
	}
	
	
	public boolean mangia() {

		if (energia + 1 >= 1 && energia + 1 <= 10) {

			altezza++;
			peso += 150;
			energia++;

			return true;
		} else {
			return false;
		}

	}

	public boolean dorme() {

		if (energia + 1 >= 1 && energia + 1 <= 10) {

			energia++;
			return true;
		} else {
			return false;
		}
	}

	public boolean gioca() {
		
		//Let's add an extra condition to prevent the dog from going below weight < 0 -> (weight -100 > 0)
		if (energia + 1 >= 1 && energia + 1 <= 10 && peso - 100 > 0) {

			peso -= 100.0;
			energia --;
		
			return true;
		} 
		else {
			
			return false;
		}
	}

}
