package bicicletas;

import interfaz.Resource;

/**
 * Implementacion de la clase abstracta que modeliza una bicicleta
 * 
 * @author robgoza
 * @author mancome
 *
 */
public abstract class Bike implements Resource {

	protected final int idBike;
	protected final String marca;
	protected final String modelo;
	protected final int numeroPinones;
	protected final int numeroPlatos;
	protected final double peso;
	protected String tallaBici;

	/**
	 * Constructor de la clase
	 * 
	 * @param id
	 *            el id de la bicicleta
	 * @param marca
	 *            la marca de la bicicleta
	 * @param modelo
	 *            el modelo de la bicicleta
	 * @param numeroPinones
	 *            el numero de piñones que tiene la bicicleta
	 * @param numeroPlatos
	 *            el numero de platos que tiene la bicicleta
	 * @param peso
	 *            el peso de la bici
	 * @assert.pre el numero de piñones debe ser como minimo de uno
	 * @assert.pre el numero de platos debe ser como minimo de uno
	 * @assert.pre el peso debe de ser mayor que 0.0
	 */
	public Bike(int id, String marca, String modelo, int numeroPinones, int numeroPlatos, double peso,
			String tallaBici) {
		assert numeroPinones >= 1;
		assert numeroPlatos >= 1;
		assert peso > 0.0;
		this.idBike = id;
		this.marca = marca;
		this.modelo = modelo;
		this.numeroPinones = numeroPinones;
		this.numeroPlatos = numeroPlatos;
		this.peso = peso;
		this.tallaBici = tallaBici;
	}

	/**
	 * Funcion que permite obtener el id de la bici
	 * 
	 * @return el id de la bici
	 */
	public int getIdBike() {
		return idBike;
	}

	/**
	 * Funcion que permite obtener el numero de piñones de la bici
	 * 
	 * @return el numero de piñones
	 */
	public int getNumeroPinones() {
		return numeroPinones;
	}

	/**
	 * Funcion que permite obtener el numero de platos de la bici
	 * 
	 * @return el numero de platos
	 */
	public int getNumeroPlatos() {
		return numeroPlatos;
	}

	/**
	 * Funcion que permite obtener el peso de la bici
	 * 
	 * @return el peso
	 */
	public double getPeso() {
		return peso;
	}

	/**
	 * Funcion que permite obtener la marca de la bici
	 * 
	 * @return la marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Funcion que permite obtener el modelo de la bici
	 * 
	 * @return el modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * Funcion que se redifine en las clases hijas
	 */
	public abstract String getTallaBici();

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "id: " + getIdBike() + " marca: " + getMarca() + " modelo: " + getModelo() + " numero de Piñones: "
				+ getNumeroPinones() + " numero de platos: " + getNumeroPlatos() + " peso: " + getPeso();
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		assert obj != null;
		if (!(obj instanceof Bike)) {
			return false;
		}
		return true;

	}
}