package bicicletas;

import java.util.Arrays;

/**
 * Implementacion de la clase que modeliza una bicicleta de adulto
 * 
 * @author robgoza
 * @author mancome
 *
 */
public class AdultBike extends Bike {
	private static final String TALLAS[] = { "S", "M", "L", "XL" };

	/**
	 * Constructor de la clase
	 * 
	 * @param id
	 *            identificador de la bicicleta
	 * @param marca
	 *            marca de la bicicleta
	 * @param modelo
	 *            modelo de la bicicleta
	 * @param numeroPinones
	 *            numero de piñones de la bicicleta mayor que 1
	 * @param numeroPlatos
	 *            numero de platos de la bicicleta mayor que 1
	 * @param peso
	 *            peso de la bicicleta mayor que 0.0
	 * @param tallaBici
	 *            talla de la bicicleta
	 * @assert.pre la talla de la bici debe estar contenida en nuestra lista de
	 *             tallas
	 * 
	 */
	public AdultBike(int id, String marca, String modelo, int numeroPinones, int numeroPlatos, double peso,
			String tallaBici) {
		super(id, marca, modelo, numeroPinones, numeroPlatos, peso, tallaBici);
		assert comprobarTalla(tallaBici) == true;
	}

	/**
	 * Funcion que nos permite conocer la talla de la bici
	 * 
	 * @return la talla de la bici
	 */
	@Override
	public String getTallaBici() {
		return tallaBici;
	}

	/**
	 * @see interfaz.Resource#getDepositToPay(double)
	 * @return el deposito sin ningun descuento
	 */
	@Override
	public double getDepositToPay(double deposit) {
		return deposit;
	}

	/**
	 * Comprobacion de que la talla introducida se encuentra en nuestra lista de
	 * tallas
	 * 
	 * @param talla
	 * @return true si esta, false si no esta
	 */
	private boolean comprobarTalla(String talla) {
		return Arrays.asList(TALLAS).contains(talla);

	}

	/**
	 * @see bicicletas.Bike#toString()
	 */
	@Override
	public String toString() {
		return "BICICLETA ADULTO: " + super.toString() + " talla: " + this.getTallaBici();
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		if (obj == null || (obj instanceof AdultBike) == false || this.getIdBike() != ((Bike) obj).getIdBike()) {
			return false;
		} else {
			return true;
		}
	}

}