package packs;

/**
 * Clase abstracta que modeliza un pack de bicicletas
 * @author robgoza
 * @author mancome
 * @assert.pre no pueden existir bicis repetidas dentro de un mismo pack
 */
import java.util.ArrayList;

import bicicletas.AdultBike;
import bicicletas.Bike;
import bicicletas.ChildBike;
import bicicletas.ElectricBike;
import interfaz.Resource;

public abstract class Pack implements Resource {
	private ArrayList<Bike> pack;
	private Bike[] bicis;

	/**
	 * Constructor de la clase
	 * 
	 * @param bicis
	 *            el array con las bicis que van a formar parte del pack
	 */
	public Pack(Bike[] bicis) {
		this.bicis = bicis;
		this.pack = new ArrayList<Bike>();
		// Copia del array[] en un arraylist para trabajar mas comodamente
		for (int i = 0; i < bicis.length; i++) {
			pack.add(bicis[i]);

		}
	}

	/**
	 * Inclusion de una bici en el pack
	 * 
	 * @param bici
	 *            la bicicleta que va a ser a�adida al pack
	 * @assert.pre la bici no puede estar repetida
	 */
	public void agregarBici(Bike bici) {
		assert formarParte(bici) == true;
		pack.add(bici);

	}

	/**
	 * Eliminacion de una bici del pack
	 * 
	 * @param bici
	 *            la bici que va a ser eliminada
	 * @assert.pre la bici debe formar parte del pack
	 * @assert.post esCorrecto()==true
	 */
	public void eliminarBici(Bike bici) {
		assert formarParte(bici) == true;
		pack.remove(bici);
		assert esCorrecto() == true;
	}

	/**
	 * Comprobacion de que una bicicleta forma parte del pack
	 * 
	 * @param bici
	 *            la bici que se desea comprobar
	 * @return true, si la bici se encuentra en el pack, en caso contrario false
	 */
	public boolean formarParte(Bike bici) {
		return this.pack.contains(bici);
	}

	/**
	 * Funcion que devuelve el numero de bicis que forman el pack
	 * 
	 * @return el numero de bicis que forman el pack
	 */
	public int numeroBicis() {
		return pack.size();
	}

	/**
	 * Funcion que devuelve el numero de bicis Child que forman el pack
	 * 
	 * @return el numero de bicis Child que forman el pack
	 */
	public int numeroBicisChild() {
		int contador = 0;
		for (Bike bici : getPack()) {
			if (bici instanceof ChildBike) {
				contador++;
			}
		}
		return contador;
	}

	/**
	 * Funcion que devuelve el numero de bicis Adult que forman el pack
	 * 
	 * @return el numero de bicis Adult que forman el pack
	 */
	public int numeroBicisAdult() {
		int contador = 0;
		for (Bike bici : getPack()) {
			if (bici instanceof AdultBike) {
				contador++;
			}
		}
		return contador;
	}

	/**
	 * Funcion que devuelve el numero de bicis Electric que forman el pack
	 * 
	 * @return el numero de bicis Electric que forman el pack
	 */
	public int numeroBicisElectric() {
		int contador = 0;
		for (Bike bici : getPack()) {
			if (bici instanceof ElectricBike) {
				contador++;
			}
		}
		return contador;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		assert obj != null;
		if (!(obj instanceof Pack)) {
			return false;
		}
		Pack a = (Pack) obj;
		if (this.pack.size() != a.pack.size()) {
			return false;
		}
		for (Bike i : pack) {
			if (!a.formarParte(i)) {
				return false;
			}
		}
		return true;

	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ("formado por: " + numeroBicisChild() + " Bicis Child " + numeroBicisAdult() + " Bicis Adult "
				+ numeroBicisElectric() + " Bicis Electric");
	}

	/**
	 * Funcion que permite conocer la lista de bicis que forman el pack
	 * 
	 * @return el pack en forma de ArrayList
	 */
	public ArrayList<Bike> getPack() {
		return pack;
	}

	/**
	 * Funcion que permite conocer que bicis forman el pack
	 * 
	 * @return el array de bicis que forman el pack
	 */
	public Bike[] obtenerPack() {
		return bicis;
	}

	/**
	 * Comprobacion de que el pack cumple las especificaciones propias de cada
	 * tipo de pack
	 * 
	 * @return true si el pack cumple las especificaciones
	 */
	abstract public boolean esCorrecto();

	@Override
	abstract public double getDepositToPay(double fianza);

}