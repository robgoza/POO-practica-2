package bicicletas;

/**
 * Implementacion de la clase que modeliza una bicicleta para niños
 * 
 * @author robgoza
 * @author mancome
 *
 */

public class ChildBike extends Bike {

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
	 *            peso de la bicicleta
	 * @param tallaBici
	 *            talla de la bicicleta
	 * @assert.pre la talla de la bici debe ser un numero par comprendido entre
	 *             12 y 16 ambos inclusive
	 */
	public ChildBike(int id, String marca, String modelo, int numeroPinones, int numeroPlatos, double peso,
			String tallaBici) {
		super(id, marca, modelo, numeroPinones, numeroPlatos, peso, tallaBici);
		assert this.tallaBiciCorrecta(tallaBici);

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
	 * Funcion que realiza un 15% de descuento en el precio de la fianza
	 * 
	 * @see interfaz.Resource
	 * @param deposit
	 *            la fiaza sin modificar
	 * @return la fianza con el descuento aplicado
	 */
	@Override
	public double getDepositToPay(double deposit) {
		deposit = deposit * 0.85;
		return deposit;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		assert obj != null;
		if (!(obj instanceof ChildBike)) {
			return false;
		}
		return super.equals(obj);
	}

	/**
	 * Funcion que comprueba si una talla es par y esta comprendida entre los
	 * valores 12 y 16 ambos incluidos
	 * 
	 * @param talla
	 *            la talla a comprobar
	 * @return true si la talla es correcta, false en caso contrario
	 */

	private boolean tallaBiciCorrecta(String talla) {
		int tallaInt = Integer.parseInt(talla);
		int resto = tallaInt % 2;
		if (resto == 0 & tallaInt >= 12 & tallaInt <= 26)
			return true;
		else
			return false;
	}

	/**
	 * @see bicicletas.Bike#toString()
	 */
	@Override
	public String toString() {
		return "BICICLETA DE NIÑO: " + super.toString() + " talla: " + getTallaBici();
	}

}