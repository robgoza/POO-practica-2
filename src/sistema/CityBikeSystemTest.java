package sistema;


import static org.junit.Assert.*;

import org.junit.Test;

import coordenadas.Coordenadas;
import fabricante.externo.tarjetas.TarjetaMonedero;

public class CityBikeSystemTest {

	public static final double ERROR_ADMISIBLE = 0.00001;
	public static final double ERROR_FIANZA = 0.01;

	@Test
	public void testConstructorConParametrosValidos() {
		CityBikeSystem a = new CityBikeSystem(0.0, "madrid");
		assertNotNull(a);
		assertEquals(a.getFianza(), 0.0, ERROR_ADMISIBLE);

	}

	@Test(expected = AssertionError.class)
	public void testConstructorConParametrosNoValidos() {
		CityBikeSystem a = new CityBikeSystem(-1, "madrid");
		assertNotNull(a);
		assertEquals(a.getFianza(), 0.0, ERROR_ADMISIBLE);

	}

	@Test
	public void testNuevoPuntoAparcamientoValido() {
		CityBikeSystem a = new CityBikeSystem(0.0, "madrid");
		Coordenadas c = new Coordenadas(34.4, 23.3);
		a.nuevoPuntoAparcamiento(4, c);
	}

	@SuppressWarnings("unused")
	@Test(expected = AssertionError.class)
	public void testNuevoPuntoAparcamientoNoValido() {
		CityBikeSystem a = new CityBikeSystem(1, "madrid");
		Coordenadas c = null;
		assertNotNull(c);
		a.nuevoPuntoAparcamiento(4, c);
	}

	@Test(expected = AssertionError.class)
	public void testSetFianza() {
		CityBikeSystem a = new CityBikeSystem(12.0, "vigo");
		a.setFianza(-76.00);
	}

	@Test
	public void testEliminarPuntosAparcamiento() {
		CityBikeSystem a = new CityBikeSystem(0.0, "madrid");
		Coordenadas c = new Coordenadas(83, 5);
		Coordenadas e = new Coordenadas(34, 5);
		a.nuevoPuntoAparcamiento(4, c);
		a.nuevoPuntoAparcamiento(2, e);
		a.eliminarPuntosAparcamiento(a.getId());

	}

	@Test(expected = AssertionError.class)
	public void testEliminarPuntosAparcamientoNovalido() {
		CityBikeSystem a = new CityBikeSystem(0.0, "madrid");
		a.eliminarPuntosAparcamiento(a.getId());
		assertFalse(a.obtenerPuntosAparcamiento().isEmpty());
	}

	@Test
	public void testObtenerPuntosAparcamientoValido() {
		CityBikeSystem a = new CityBikeSystem(0.0, "madrid");
		Coordenadas ca = new Coordenadas(32, 23);
		Coordenadas c1 = new Coordenadas(12, 2);
		a.nuevoPuntoAparcamiento(4, ca);
		a.nuevoPuntoAparcamiento(3, c1);
		a.obtenerPuntosAparcamiento();

	}

	@Test
	public void testObtenerAparcamientosConAnclajesOcupadosValido() {
		CityBikeSystem a = new CityBikeSystem(0.0, "madrid");
		Coordenadas c = new Coordenadas(27, 12);
		a.nuevoPuntoAparcamiento(3, c);
		a.obtenerAparcamientosConAnclajesOcupados();

	}

	@Test
	public void testObtenerAparcamientosConAnclajesLibresValido() {
		CityBikeSystem a = new CityBikeSystem(0.0, "madrid");
		Coordenadas c = new Coordenadas(34345.4, 2322.3);
		a.nuevoPuntoAparcamiento(3, c);
		a.obtenerAparcamientosConAnclajesLibres();

	}

	@Test(expected = AssertionError.class)
	public void testObtenerAparcamientosConAnclajesLibresNoValido() {
		CityBikeSystem a = new CityBikeSystem(0.0, "madrid");
		assertFalse(a.obtenerPuntosAparcamiento().isEmpty());
		a.obtenerAparcamientosConAnclajesLibres();

	}

	@Test(expected = AssertionError.class)
	public void testObtenerAparcamientosConAnclajesOcupadosNoValido() {
		CityBikeSystem a = new CityBikeSystem(0.0, "madrid");
		assertFalse(a.obtenerPuntosAparcamiento().isEmpty());
		a.obtenerAparcamientosConAnclajesOcupados();

	}

	@Test
	public void testGetCiudad() {
		CityBikeSystem a = new CityBikeSystem(0.0, "vigo");
		assertEquals(a.getCiudad(), "vigo");
	}

	@Test
	public void testSetCiudad() {
		fail("Not yet implemented");
	}

	@Test
	public void testPuntosCercanosCoordenadas() {
		CityBikeSystem a = new CityBikeSystem(0.0, "madrid");
		Coordenadas c = new Coordenadas(34, 3);
		Coordenadas v = new Coordenadas(2, 1);
		a.nuevoPuntoAparcamiento(3, c);
		a.nuevoPuntoAparcamiento(2, v);
		a.puntosCercanosCoordenadas(2322, 23, 7);

	}

	@Test(expected = AssertionError.class)
	public void testPuntosCercanosCoordenadasVacio() {
		CityBikeSystem a = new CityBikeSystem(0.0, "madrid");
		assertFalse(a.obtenerPuntosAparcamiento().isEmpty());
		a.puntosCercanosCoordenadas(2322, 23, 7);

	}

	@Test(expected = AssertionError.class)
	public void testPuntosCercanosCoordenadasRadioInvalido() {
		CityBikeSystem a = new CityBikeSystem(0.0, "madrid");
		Coordenadas c = new Coordenadas(34, 3);
		Coordenadas v = new Coordenadas(2, 1);
		a.nuevoPuntoAparcamiento(3, c);
		a.nuevoPuntoAparcamiento(2, v);
		a.puntosCercanosCoordenadas(2322, 23, -2.34);

	}

	@Test
	public void testGetFianza() {
		CityBikeSystem a = new CityBikeSystem(25.0, "vigo");
		assertEquals(a.getFianza(), 25.0, ERROR_FIANZA);
	}

	@Test
	public void testPrestarBiciValido() {
		CityBikeSystem a = new CityBikeSystem(16, "madrid");
		Coordenadas c = new Coordenadas(23, 22);
		a.nuevoPuntoAparcamiento(3, c);
		TarjetaMonedero t = new TarjetaMonedero("A156Bv09_1zXo894", 30);
		a.prestarBici(t, a.getId(), "A156Bv09_1zXo894", 1);

	}

	@Test
	public void testDevolverBiciValido() {
		CityBikeSystem a = new CityBikeSystem(17, "madrid");
		Coordenadas c = new Coordenadas(34, 23);
		a.nuevoPuntoAparcamiento(3, c);
		TarjetaMonedero t = new TarjetaMonedero("A156Bv09_1zXo894", 34);
		a.devolverBici(t, a.getId(), "A156Bv09_1zXo894", 2);

	}

	@Test(expected = AssertionError.class)
	public void testDevolverBiciValidoInvalido() {
		CityBikeSystem a = new CityBikeSystem(7, "madrid");
		Coordenadas c = new Coordenadas(34345.4, 2322.3);
		a.nuevoPuntoAparcamiento(3, c);
		TarjetaMonedero t = new TarjetaMonedero("A156Bv09_1zXo894", 34);
		a.devolverBici(t, a.getId(), "6Z1y-", 2);

	}

}