package sistema;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import coordenadas.Coordenadas;
import fabricante.externo.tarjetas.TarjetaMonedero;
import punto.CityBikeParkingPoint;

/**
 * Implementacion de la clase que modeliza un sistema de gestion de puntos de
 * aparcamientos de bici asi como el prestamo y la devolucion de las mismas
 * 
 * @author robgoza
 * @author mancome
 *
 */
public class CityBikeSystem {
	private String id;
	private ArrayList<CityBikeParkingPoint> aparcamientos;
	private double fianza;
	private String ciudad;

	/**
	 * Constructor de la clase CityBikeSystem
	 * 
	 * @param fianza
	 *            la fianza que se va a imponer al sistema
	 * @param ciudad
	 *            la ciudad en la cual se va a implementar el sistema
	 */
	public CityBikeSystem(double fianza, String ciudad) {
		assert fianza >= 0;
		this.id = generarId();
		this.fianza = fianza;
		this.ciudad = ciudad;
		this.aparcamientos = new ArrayList<CityBikeParkingPoint>();
	}

	/**
	 * Procedimiento que genera un identificador para cada sistema
	 * 
	 * @return El identificador unico generado
	 */
	private static String generarId() {
		String id;
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss:SSS dd/MM/yyyy");
		// el identificador sera la fecha y hora en la que se crea el objeto en
		// formato String
		id = hourdateFormat.format(date);
		return id;
	}

	/**
	 * Procedimiento para crear un nuevo aparcamiento
	 * 
	 * @param anclajes
	 *            el numero de anclajes que va a tener el punto de aparcamiento
	 */
	public void nuevoPuntoAparcamiento(int anclajes, Coordenadas coordenadas) {
		assert coordenadas != null;
		CityBikeParkingPoint aparcamiento = new CityBikeParkingPoint(anclajes, coordenadas);
		aparcamientos.add(aparcamiento);
	}

	/**
	 * Procedimiento que modifica el valor de la fianza
	 * 
	 * @param nuevaFianza
	 *            valor de la nueva fianza
	 */
	public void setFianza(double nuevaFianza) {
		assert fianza >= 0;
		this.fianza = nuevaFianza;
	}

	/**
	 * Procedimiento que elimina un punto de aparcamineto a partir de un
	 * identificador unico
	 * 
	 * @param idAparcamiento
	 *            identificador del punto de aparcamiento que queremos eliminar
	 */
	public void eliminarPuntosAparcamiento(String idAparcamiento) {
		for (CityBikeParkingPoint aparcamiento : aparcamientos) {
			if (aparcamiento.getIdentificador().equals(idAparcamiento)) {
				aparcamientos.remove(aparcamiento);
			}

		}
	}

	/**
	 * Funcion que devuelve una lista de los aparcamientos
	 * 
	 * @return aparcamientos una lista de los aparcamientos
	 * 
	 */
	public ArrayList<CityBikeParkingPoint> obtenerPuntosAparcamiento() {
		assert aparcamientos != null;
		return aparcamientos;
	}

	/**
	 * Funcion que nos devuelve una lista de objetos con los puntos de
	 * aparcamiento que tienen bicicletas disponibles
	 * 
	 * 
	 * @return aparcamientosConAnclajesOcupados arrayList de objetos de los
	 *         aparcapientos con algun anclajes ocupado
	 */
	public ArrayList<CityBikeParkingPoint> obtenerAparcamientosConAnclajesOcupados() {
		assert aparcamientos.size() > 0;
		ArrayList<CityBikeParkingPoint> aparcamientosConAnclajesOcupados = new ArrayList<CityBikeParkingPoint>();
		for (CityBikeParkingPoint aparcamiento : aparcamientos) {
			if (aparcamiento.anclajesOcupados() != 0) {
				aparcamientosConAnclajesOcupados.add(aparcamiento);
			}

		}
		return aparcamientosConAnclajesOcupados;

	}

	/**
	 * Funcion que nos devuelve una lista de objetos con los puntos de
	 * aparcamiento que tienen anclajes disponibles
	 * 
	 * 
	 * @return aparcamientosConAnclajesLibres arrayList de objetos de los
	 *         aparcapientos con algun anclaje libre
	 */
	public ArrayList<CityBikeParkingPoint> obtenerAparcamientosConAnclajesLibres() {
		assert aparcamientos.size() > 0;
		ArrayList<CityBikeParkingPoint> aparcamientosConAnclajesLibres = new ArrayList<CityBikeParkingPoint>();
		for (CityBikeParkingPoint aparcamiento : aparcamientos) {
			if (aparcamiento.anclajesLibres() != 0) {
				aparcamientosConAnclajesLibres.add(aparcamiento);
			}

		}
		return aparcamientosConAnclajesLibres;

	}

	/**
	 * Permite conocer la ciudad
	 * 
	 * @return la ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}

	/**
	 * Permite modificar la ciudad
	 * 
	 * @param ciudad
	 *            la nueva ciudad
	 */
	public void setCiudad(String ciudad) {
		assert ciudad != null;
		this.ciudad = ciudad;
	}

	/**
	 * Funcion con la que sabemos los aparcamientos cercanos a una ubicacion
	 * dada
	 * 
	 * @param longitud
	 *            de la posicion actual
	 * @param latitud
	 *            posicion actual
	 * @param radio
	 *            maxima distancia en la cual se encuantran los puntos de
	 *            aparcamiento
	 * @return aparcamientosCercanos lista con todos los aparcamientos cercanos
	 */
	public ArrayList<CityBikeParkingPoint> puntosCercanosCoordenadas(double longitud, double latitud, double radio) {
		ArrayList<CityBikeParkingPoint> aparcamientosCercanos = new ArrayList<CityBikeParkingPoint>();
		assert radio > 0;

		for (CityBikeParkingPoint aparcamiento : aparcamientos) {
			Coordenadas a = aparcamiento.getCoordenadas();
			if (a.distancia(longitud, latitud) <= radio) {
				aparcamientosCercanos.add(aparcamiento);
			}
		}
		return aparcamientosCercanos;
	}

	/**
	 * Devuelve el valor de la fianza
	 * 
	 * @return [double] Valor de la fianza
	 */
	public double getFianza() {
		return fianza;
	}

	/**
	 * Funcion que realiza el prestamo de una bici
	 * 
	 * @param tarjeta
	 *            Tarjeta con la cual se va a realizar el prestamo de la bici
	 * 
	 * @param aparcamiento
	 *            Punto de aparcamiento de el cual se quiere prestar la bici
	 * 
	 * @param idAparcamiento
	 *            identificador del aparcamiento
	 * @param credencial
	 *            credencial de la tarjeta del anclaje
	 * @param modulo
	 *            numero del anclaje en el que se presta la bici
	 */
	public void prestarBici(TarjetaMonedero tarjeta, String idAparcamiento, String credencial, int modulo) {
		assert tarjeta != null;
		assert idAparcamiento != null;

		for (CityBikeParkingPoint aparcamiento : aparcamientos) {
			if (aparcamiento.getIdentificador().equals(idAparcamiento)) {

				assert (credencial.equals("A156Bv09_1zXo894"));
				aparcamiento.prestarBici(modulo);
				tarjeta.descontarDelSaldo(credencial, fianza);

			}
		}
	}

	/**
	 * Funcion que realiza la devolucion de una bici
	 * 
	 * @param tarjeta
	 *            Tarjeta con la cual se va a realizar la devolucion de la bici
	 * 
	 * @param aparcamiento
	 *            Punto de aparcamiento de el cual se quiere devolver la bici
	 * 
	 * @param idAparcamiento
	 *            identificador del aparcamiento
	 * @param credencial
	 *            credencial de la tarjeta del anclaje
	 * @param modulo
	 *            numero del anclaje en el cual se va a devolver la bici
	 */
	public void devolverBici(TarjetaMonedero tarjeta, String idAparcamiento, String credencial, int modulo) {
		assert tarjeta != null;
		assert idAparcamiento != null;

		for (CityBikeParkingPoint aparcamiento : aparcamientos) {
			if (aparcamiento.getIdentificador().equals(idAparcamiento)) {

				assert (credencial.equals("6Z1y00Nm31aA-571"));
				aparcamiento.devolverBici(modulo);
				tarjeta.recargaSaldo(credencial, fianza);
			}
		}
	}

	/**
	 * Permite conocer un id
	 * 
	 * @return id el identificador el cual se desea conocer
	 */
	public String getId() {
		return id;
	}

}