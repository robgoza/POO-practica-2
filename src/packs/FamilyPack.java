package packs;

import bicicletas.Bike;

/**
 * Clase que modeliza un pack familiar
 * 
 * @author robgoza
 * @author mancome
 * @assert.pre el pack debe estar formado por un minimo de 4 bicis
 * @assert.pre al menos 2 de las bicis son infantiles
 * @assert.post al valor de la fianza se le aplicara un descuento del 50%
 *
 */
public class FamilyPack extends Pack {
	/**
	 * Constructor de la clase
	 * 
	 * @param bicis
	 *            las bicis que forman parte del pack
	 */
	public FamilyPack(Bike[] bicis) {
		super(bicis);
		assert esCorrecto() == true;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override

	public boolean equals(Object obj) {
		assert obj != null;
		if (!(obj instanceof FamilyPack)) {
			return false;
		}
		return super.equals(obj);
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Family Pack " + super.toString();
	}

	/**
	 * Calculo del total de las fianzas del pack al cual se le aplica un
	 * descuento del 50%
	 * 
	 * @see packs.Pack#getDepositToPay(double)
	 */
	@Override
	public double getDepositToPay(double fianza) {
		double precio = 0;
		double precioBici;
		double aux = 0;
		for (Bike bici : getPack()) {
			precioBici = bici.getDepositToPay(fianza);
			precio = precioBici + aux;
			aux = precioBici;
		}
		return (precio * 0.5);

	}

	/**
	 * @see packs.Pack#esCorrecto()
	 * @assert.post el pack esta formado por al menos 4 bicis de las cuales dos
	 *              como minimo son de tipo Child
	 */
	@Override
	public boolean esCorrecto() {
		if (getPack().size() >= 4 && numeroBicisChild() >= 2) {
			return true;
		} else {
			return false;
		}

	}
}