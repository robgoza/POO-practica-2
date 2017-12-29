package bicicletas;

import static org.junit.Assert.*;

import org.junit.Test;

import interfaz.Resource;

public class AdultBikeTest {
	public static final double ERROR_ADMISIBLE = 0.00001;

	@Test
	public final void testContructorValido() {
		AdultBike a = new AdultBike(1, "orbea", "fast", 2, 3, 15.3, "S");
		assertNotNull(a);
		assertEquals(a.getIdBike(), 1, ERROR_ADMISIBLE);
		assertEquals(a.getMarca(), "orbea");
		assertEquals(a.getModelo(), "fast");
		assertEquals(a.getNumeroPinones(), 2, ERROR_ADMISIBLE);
		assertEquals(a.getNumeroPlatos(), 3, ERROR_ADMISIBLE);
		assertEquals(a.getPeso(), 15.3, ERROR_ADMISIBLE);
		assertEquals(a.getTallaBici(), "S");

	}

	@Test(expected = AssertionError.class)
	public final void testContructorParametrosNoValidosPlatosMinimo() {
		AdultBike a = new AdultBike(1, "orbea", "fast", 2, 0, 15.3, "L");
		assertNotNull(a);
	}

	@Test
	public final void testContructorParametrosValidoPlatosIgualMinimo() {
		AdultBike a = new AdultBike(1, "orbea", "fast", 2, 1, 15.3, "L");
		assertNotNull(a);
	}

	@Test
	public final void testContructorParametrosValidoPinonesIgualMinimo() {
		AdultBike a = new AdultBike(1, "orbea", "fast", 1, 3, 15.3, "L");
		assertNotNull(a);
	}

	@Test
	public final void testContructorParametrosValidoPinonesMayor() {
		AdultBike a = new AdultBike(1, "orbea", "fast", 2, 3, 15.3, "L");
		assertNotNull(a);
	}

	@Test
	public final void testContructorParametrosValidoPlatosMayor() {
		AdultBike a = new AdultBike(1, "orbea", "fast", 3, 2, 15.3, "L");
		assertNotNull(a);
	}

	@Test(expected = AssertionError.class)
	public final void testContructorParametrosNoValidoPesoMenor() {
		AdultBike a = new AdultBike(1, "orbea", "fast", 2, 3, -0.9, "XL");
		assertNotNull(a);
	}

	@Test
	public final void testContructorParametrosValidoPesoMayor() {
		AdultBike a = new AdultBike(1, "orbea", "fast", 2, 3, 0.1, "XL");
		assertNotNull(a);
	}

	@Test(expected = AssertionError.class)
	public final void testContructorParametrosNoValidoPeso() {
		AdultBike a = new AdultBike(1, "orbea", "fast", 2, 3, 0, "XL");
		assertNotNull(a);
	}

	@Test(expected = AssertionError.class)
	public final void testContructorParametrosNoValidoPinones() {
		AdultBike a = new AdultBike(1, "orbea", "fast", 0, 3, 15.3, "L");
		assertNotNull(a);
	}

	@Test(expected = AssertionError.class)
	public final void testContructorParametrosNoValidoPlatos() {
		AdultBike a = new AdultBike(1, "orbea", "fast", 2, 0, 15.3, "XL");
		assertNotNull(a);
	}

	@Test
	public final void testGetDepositToPay() {

		Resource c = new AdultBike(5, "bh", "e", 6, 3, 100.0, "L");
		assertNotNull(c);
		assertEquals(c.getDepositToPay(10.0), 10.0, ERROR_ADMISIBLE);
	}

	@Test(expected = AssertionError.class)
	public final void testGetDepositToPayIncorrecto() {
		Resource c = new AdultBike(5, "bh", "e", 6, 3, 100.0, "L");
		assertNotNull(c);
		assertEquals(c.getDepositToPay(10.0), 10.1, ERROR_ADMISIBLE);
	}

	@Test(expected = AssertionError.class)
	public final void testGetDepositToPayIncorrectoMenor() {
		Resource c = new AdultBike(5, "bh", "e", 6, 3, 100.0, "L");
		assertNotNull(c);
		assertEquals(c.getDepositToPay(10.0), 9.999, ERROR_ADMISIBLE);
	}

	@Test
	public final void testGetIdBike() {
		AdultBike a = new AdultBike(1, "bh", "a", 6, 3, 100.0, "L");
		assertNotNull(a);
		assertEquals(a.getIdBike(), 1, ERROR_ADMISIBLE);
	}

	@Test
	public final void testGetMarca() {
		AdultBike a = new AdultBike(1, "bh", "a", 6, 3, 100.0, "L");
		assertNotNull(a);
		assertEquals(a.getMarca(), "bh");
	}

	@Test
	public final void testGetModelo() {
		AdultBike a = new AdultBike(1, "bh", "a", 6, 3, 100.0, "L");
		assertNotNull(a);
		assertEquals(a.getModelo(), "a");
	}

	@Test
	public final void testGetNumeroPinones() {
		AdultBike a = new AdultBike(1, "bh", "a", 6, 3, 100.0, "L");
		assertNotNull(a);
		assertEquals(a.getNumeroPinones(), 6, ERROR_ADMISIBLE);
	}

	@Test
	public final void testGetNumeroPlatos() {
		AdultBike a = new AdultBike(1, "bh", "a", 6, 3, 100.0, "L");
		assertNotNull(a);
		assertEquals(a.getNumeroPlatos(), 3, ERROR_ADMISIBLE);
	}

	@Test
	public final void testGetPeso() {
		AdultBike a = new AdultBike(1, "bh", "a", 6, 3, 100.0, "L");
		assertNotNull(a);
		assertEquals(a.getPeso(), 100.0, ERROR_ADMISIBLE);
	}

	@Test
	public final void testGetTallaBici() {
		AdultBike e = new AdultBike(5, "bh", "e", 6, 3, 100.0, "L");
		assertNotNull(e);
		assertEquals(e.getTallaBici(), "L");
	}

	@Test(expected = AssertionError.class)
	public final void testGetTallaBiciIncorrecto() {
		AdultBike e = new AdultBike(5, "bh", "e", 6, 3, 100.0, "L");
		assertNotNull(e);
		assertEquals(e.getTallaBici(), "l");
	}

	@Test
	public final void testToString() {
		AdultBike a = new AdultBike(1, "bh", "a", 6, 3, 100.0, "L");
		assertNotNull(a);
		assertEquals(a.toString(),
				"BICICLETA ADULTO: id: 1 marca: bh modelo: a numero de Piñones: 6 numero de platos: 3 peso: 100.0 talla: L");

	}

	@Test(expected = AssertionError.class)
	public final void testToStringErroneo() {
		AdultBike a = new AdultBike(1, "bh", "a", 6, 3, 100.0, "L");
		assertNotNull(a);
		assertEquals(a.toString(), "BICICLETA ADULTO:  6 numero de platos: 3 peso: 100.0 talla: L");
	}

	@Test
	public final void testEquals() {

		AdultBike a = new AdultBike(1, "bh", "a", 6, 3, 10, "L");
		AdultBike b = new AdultBike(1, "bh", "a", 6, 3, 10, "L");
		assertNotNull(a);
		assertNotNull(b);
		assertEquals(a.equals(a), true);

	}

	@Test
	public final void testEqualsBicisDistintas() {
		AdultBike a = new AdultBike(1, "bh", "a", 6, 3, 100.0, "L");
		AdultBike b = new AdultBike(4, "orbea", "fast", 2, 3, 15.3, "S");
		assertNotNull(a);
		assertNotNull(b);
		assertEquals(a.equals(b), false);

	}

	@Test
	public final void testEqualsBicisDistintasClases() {
		AdultBike a = new AdultBike(1, "bh", "a", 6, 3, 100.0, "L");
		ChildBike b = new ChildBike(4, "orbea", "fast", 2, 3, 15.3, "16");
		assertNotNull(a);
		assertNotNull(b);
		assertEquals(a.equals(b), false);

	}

	@Test
	public final void testEqualsConUnoNull() {
		AdultBike a = new AdultBike(1, "bh", "a", 6, 3, 100.0, "L");
		AdultBike b = new AdultBike(1, "bh", "a", 6, 3, 100.0, "L");
		assertNotNull(a);
		b = null;
		a.equals(b);
	}

}