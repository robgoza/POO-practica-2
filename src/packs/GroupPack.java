package packs;

import bicicletas.Bike;

/**
 * Clase que modeliza un pack para grupos
 * 
 * @author robgoza
 * @author mancome
 * @assert.pre el pack debe estar formado como minimo por 10 bicis
 * @assert.post al valor de la fianza se le aplicara un descuento del 20%
 */
public class GroupPack extends Pack {
	/**
	 * Constructor de la clase
	 * 
	 * @param bicis
	 *            las bicis que van a formar parte del pack
	 */
	public GroupPack(Bike[] bicis) {
		super(bicis);
		assert esCorrecto() == true;

	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		assert obj != null;
		if (!(obj instanceof GroupPack)) {
			return false;
		}
		return super.equals(obj);
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Group Pack " + super.toString();
	}

	/**
	 * Calculo del precio del pack en el cual se aplicara un 20% de descuento a
	 * la suma de las fianzas
	 * 
	 * @see packs.Pack#getDepositToPay(double)
	 */

	@Override
	public double getDepositToPay(double fianza) {
		assert fianza > 0.0;
		double precio = 0;
		double precioBici;
		double aux = 0;
		for (Bike bici : getPack()) {
			precioBici = bici.getDepositToPay(fianza);
			precio = precioBici + aux;
			aux = precio;
		}
		return (precio * 0.8);

	}

	/**
	 * @see packs.Pack#esCorrecto()
	 * @assert.post el pack estara formado por al menos 10 bicis
	 */
	@Override
	public boolean esCorrecto() {
		if (getPack().size() >= 10) {
			return true;
		} else {
			return false;

		}
	}
}