package punto;

import org.junit.Test;

import coordenadas.Coordenadas;

import static org.junit.Assert.*;


/**
 * Clase de test para la clase CityBikeParkingPoint
 * 
 * @author robgoza
 * @author mancome
 *
 */

public class CityBikeParkingPointTest {
	public static final double ERROR_ADMISIBLE = 0.00001;

	@Test
	public void testConstructorConParametrosValidos() {
		Coordenadas a = new Coordenadas(0.0, 0.0);
		CityBikeParkingPoint b = new CityBikeParkingPoint(1, a);
		assertNotNull(a);
		assertNotNull(b);
		assertEquals(b.getNumeroAnclajes(), 1);
		

	}

	@Test(expected = AssertionError.class)
	public void testInicializarConstructorConAnclajesInvalidos() {
		Coordenadas a = new Coordenadas(0.0, 0.0);

		CityBikeParkingPoint b = new CityBikeParkingPoint(0, a);
		assertNotNull(a);
		assertNotNull(b);
	}

	@Test
	public void testGetNumeroAnclajes() {
		Coordenadas a = new Coordenadas(0.0, 0.0);

		CityBikeParkingPoint b = new CityBikeParkingPoint(1, a);
		assertEquals(b.getNumeroAnclajes(), 1, ERROR_ADMISIBLE);
	}

	@Test
	public void testSetNumeroAnclajes() {
		Coordenadas a = new Coordenadas(0.0, 0.0);

		CityBikeParkingPoint b = new CityBikeParkingPoint(1, a);
		b.setNumeroAnclajes(2);
		assertEquals(b.getNumeroAnclajes(), 2, ERROR_ADMISIBLE);

	}

	
	@Test
	public void testAnclajesOcupados() {
		Coordenadas a = new Coordenadas(0.0, 0.0);

		CityBikeParkingPoint b = new CityBikeParkingPoint(3, a);

		b.devolverBici(1);

		assertEquals(b.anclajesOcupados(), 1, ERROR_ADMISIBLE);

	}

	@Test
	public void testAnclajesLibres() {
		Coordenadas a = new Coordenadas(0.0, 0.0);

		CityBikeParkingPoint b = new CityBikeParkingPoint(3, a);

		b.devolverBici(1);

		assertEquals(b.anclajesLibres(), 2, ERROR_ADMISIBLE);

	}

	@Test
	public void testEstadoModulo() {
		Coordenadas a = new Coordenadas(0.0, 0.0);

		CityBikeParkingPoint b = new CityBikeParkingPoint(3, a);

		assertEquals(b.estadoModulo(1), false);

	}

	@Test
	public void testPrestarBici() {
		Coordenadas a = new Coordenadas(0.0, 0.0);

		CityBikeParkingPoint b = new CityBikeParkingPoint(3, a);
		boolean p[] = b.getPunto();
		p[0] = true;
		b.prestarBici(1);

		assertEquals(b.estadoModulo(1), false);

	}

	@Test
	public void testDevolverBici() {
		Coordenadas a = new Coordenadas(0.0, 0.0);

		CityBikeParkingPoint b = new CityBikeParkingPoint(3, a);

		b.devolverBici(1);

		assertEquals(b.estadoModulo(0), true);

	}

	

}