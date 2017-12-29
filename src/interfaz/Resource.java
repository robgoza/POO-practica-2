package interfaz;

/**
 * Interfaz que aplica un factor de correccion a la fianza que se cobra al
 * realizar el prestamo de una bici
 * 
 * @author robgoza
 * @author mancome
 *
 */
public interface Resource {

	/**
	 * 
	 * @param deposit
	 *            fianza original
	 * @return la fianza a cobrar por el prestamo
	 */
	double getDepositToPay(double deposit);
}