package punto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import coordenadas.Coordenadas;

/**
 * 
 * @author robgoza
 * @author mancome
 * 
 *         Implementacion de la clase que representa un punto de aparcamiento
 *         para el sistema de prestamo de bicis
 *
 */
public class CityBikeParkingPoint {
	private int numeroAnclajes;
	private String identificador;
	private boolean punto[];
	private Coordenadas coordenadas;

	/**
	 * Constructor de la clase CityBikeParkingPoint con longitud y latitud en GD
	 * 
	 * @param anclajes
	 *            numero de anclajes del punto
	 * @param coordenadas
	 *            objeto de la clase coordenadas para la localizacion del punto
	 *            de aparcamiento
	 */
	public CityBikeParkingPoint(int anclajes, Coordenadas coordenadas) {
		assert anclajes >= 1;
		assert coordenadas != null;
		this.numeroAnclajes = anclajes;

		this.coordenadas=coordenadas;
		this.identificador = generarId();
		this.punto = new boolean[anclajes];
	}

	/**
	 * Permite conocer la cantidad de anclajes ocupados de un cierto punto de
	 * aparcamiento
	 * 
	 * @return El numero de anclajes ocupados del punto de aparcamiento
	 */

	public int anclajesOcupados() {
		int contador = 0;
		for (int i = 0; i < punto.length; i++) {
			if (punto[i] == true) {
				contador++;
			}
		}
		return contador;
	}

	/**
	 * Permite conocer la cantidad de anclajes libres de un cierto punto de
	 * aparcamiento
	 * 
	 * @return El numero de anclajes libres del punto de aparcamiento
	 */
	public int anclajesLibres() {
		int contador = 0;
		for (int i = 0; i < punto.length; i++) {
			if (punto[i] == false) {
				contador++;
			}
		}
		return contador;
	}

	/**
	 * Permite conocer el estado de un punto de anclaje
	 * 
	 * @param modulo
	 *            el modulo del que se desea consultar el estado
	 * @return El estado del punto de anclaje. Si es false significa que el
	 *         modulo esta libre y viceversa
	 */
	public boolean estadoModulo(int modulo) {

		return punto[modulo];
	}

	/**
	 * Gestion del prestamo de una bici de un modulo de anclaje
	 * 
	 * @param modulo
	 *            el modulo en el cual se encuentra la bici que va a ser
	 *            prestada
	 */
	public void prestarBici(int modulo) {
		assert punto[modulo - 1] == true;
		assert modulo >= 1;
		punto[modulo - 1] = false;

	}

	/**
	 * Gestion de la devolucion de una bici de un modulo de anclaje
	 * 
	 * @param modulo
	 *            el modulo en el cual se va a insertar la bici que va a ser
	 *            devuelta
	 */
	public void devolverBici(int modulo) {
		assert punto[modulo - 1] == false;
		assert modulo >= 1;
		punto[modulo - 1] = true;

	}

	/**
	 * Procedimiento que genera un identificador para el punto de aparcamiento
	 * 
	 * @return El identificador generado
	 */
	private String generarId() {
		String id;
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss:SSS dd/MM/yyyy");
		// el identificador sera la fecha y hora en la que se crea el objeto en
		// formato String
		id = hourdateFormat.format(date);
		return id;

	}

	public Coordenadas getCoordenadas(){
		return coordenadas;
		
	}

	/**
	 * Permite conoocer el numero de anclajes que tiene el punto de aparcamiento
	 * 
	 * @return numeroAnclajes el numero de anclajes del punto
	 */

	public int getNumeroAnclajes() {
		return numeroAnclajes;
	}

	/**
	 * Permite modificar el numero de anclajes de un punto
	 * 
	 * @param numeroAnclajes
	 *            el numero de anclajes de ese punto
	 */
	public void setNumeroAnclajes(int numeroAnclajes) {
		assert numeroAnclajes >= 1;
		this.numeroAnclajes = numeroAnclajes;
	}

	/**
	 * Permite conoocer el identificador del punto de aparcamiento
	 * 
	 * @return el identificador del punto
	 */
	public String getIdentificador() {
		return identificador;
	}

	
	/**
	 * Permite obtener el array del punto de aparcamiento
	 * 
	 * @return el punto de aparcamiento
	 */
	public boolean[] getPunto() {
		return punto;
	}

	/**
	 * Permite modificar el array del punto de aparcamiento
	 * 
	 * @param punto
	 *            el punto a modificar
	 */
	public void setPunto(boolean[] punto) {
		this.punto = punto;
	}

}