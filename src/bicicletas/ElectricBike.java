package bicicletas;

import java.util.Arrays;

/**
 * Implementacion de la clase que modeliza una bicicleta electrica
 * 
 * @author robgoza
 * @author mancome
 *
 */
public class ElectricBike extends AdultBike {
	private double parMotor;
	private int voltaje;
	private double cargaElectrica;
	// Hemos añadido 72 y 38 a nuestra lista ya que en un futuro podrian ser
	// utilizados estos voltajes
	private static final String VOLTAJES[] = { "26", "36", "72", "38" };

	/**
	 * Constructor de la clase
	 * 
	 * @param id
	 *            el id de la bici
	 * @param marca
	 *            la marca de la bici
	 * @param modelo
	 *            el modelo de la bici
	 * @param numeroPinones
	 *            el numero de piñones de la bici
	 * @param numeroPlatos
	 *            el numero de platos de la bici
	 * @param peso
	 *            el peso de la bici
	 * @param parMotor
	 *            el par motor de la bici
	 * @param voltaje
	 *            el voltaje de la bici
	 * @param cargaElectrica
	 *            la carga de la bici
	 * 
	 * @assert.pre el voltaje debe estar previamente en nuestra lista
	 * 
	 * @assert.pre la carga electrica debe ser mayor que 0 ya que la necesitamos
	 *             para el calculo de la energia almacenada
	 * @assert.pre el numero de platos debe ser como minimo de uno
	 * @assert.pre el par motor debe ser mayor que 0
	 * @aseert.pre el voltaje tiene que ser mayor que 0
	 */
	public ElectricBike(int id, String marca, String modelo, int numeroPiñones, int numeroPlatos, double peso,
			String tallaBici, double parMotor, int voltaje, double cargaElectrica) {
		super(id, marca, modelo, numeroPiñones, numeroPlatos, peso, tallaBici);
		assert this.comprobarVoltaje(Integer.toString(voltaje)) == true;
		assert cargaElectrica > 0.0;
		assert parMotor > 0.0;
		assert voltaje > 0;
		this.parMotor = parMotor;
		this.voltaje = voltaje;
		this.cargaElectrica = cargaElectrica;
	}

	/**
	 * Funcion que permite consultar el voltaje de una bicicleta
	 * 
	 * @return el voltaje de la bici
	 */
	public double getVoltaje() {
		return voltaje;
	}

	/**
	 * Funcion que permite modificar el voltaje de una bicicleta
	 * 
	 * @param voltaje
	 *            nuevo para una bicicleta
	 * @assert.pre el voltaje debe estar previamente en nuestra lista
	 */
	public void setVoltaje(int voltaje) {
		assert this.comprobarVoltaje(Integer.toString(voltaje)) == true;
		this.voltaje = voltaje;
	}

	/**
	 * Funcion que permite conocer la carga electrica de la bici
	 * 
	 * @return la carga electrica
	 */
	public double getCargaElectrica() {
		return cargaElectrica;
	}

	/**
	 * Funcion que permite modificar la carga electrica de la bici
	 * 
	 * @param cargaElectrica
	 *            la nueva carga electrica
	 */
	public void setCargaElectrica(double cargaElectrica) {
		this.cargaElectrica = cargaElectrica;
	}

	/**
	 * Funcion que permite conocer el par motor de la bici
	 * 
	 * @return el par motor de la bici
	 */
	public double getParMotor() {
		return parMotor;
	}

	/**
	 * Funcion que permite conocer la energía almacenada en la batería en
	 * kilowatiosHora teniendo en cuenta que W h = V oltios × AmperiosHora.
	 * 
	 * @return la energia almacenada que se obtiene realizando la operacion
	 *         voltios × amperiosHora
	 */
	public double energiaAlmacenada() {

		return cargaElectrica * voltaje;

	}

	/**
	 * Funcion que aplica un descuento en relacion con el par motor de la
	 * bicicleta y el votaje de esta
	 * 
	 * @param deposit
	 *            la fianza
	 * @return deposit la fianza con el descuento aplicado
	 * @see interfaz.Resource#getDepositToPay
	 */
	@Override
	public double getDepositToPay(double deposit) {
		deposit = deposit * (parMotor * voltaje) / 100 + deposit;
		return deposit;
	}

	/**
	 * comprobacion de que el voltaje introducido se encuentra en la lista de
	 * los voltajes esperados
	 * 
	 * @param voltaje
	 *            el voltaje a comprobar
	 * @return true si esta, false si no esta
	 */
	private boolean comprobarVoltaje(String voltaje) {
		return Arrays.asList(VOLTAJES).contains(voltaje);

	}

	/**
	 * @see bicicletas.AdultBike#toString()
	 */
	@Override
	public String toString() {
		return "BICI ELECTRICA: " + super.toString() + " par motor: " + getParMotor() + " voltaje: " + getVoltaje()
				+ "carga electrica :" + getCargaElectrica();

	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		assert obj != null;
		if (!(obj instanceof ElectricBike)) {
			return false;
		}
		return super.equals(obj);
	}
}