package packs;

import static org.junit.Assert.*;

import org.junit.Test;

import bicicletas.AdultBike;
import bicicletas.ChildBike;
import bicicletas.Bike;
import packs.GroupPack;

/**
 * Clase de test para la clase GroupPack
 * 
 * @author robgoza
 * @author mancome
 *
 */

public class GroupPackTest {
	public static final double ERROR_ADMISIBLE = 0.00001;

	@Test
	public void testConstructorConParametrosValidos() {
		AdultBike a = new AdultBike(1, "bh", "a", 6, 3, 100.0, "L");
		AdultBike b = new AdultBike(2, "bh", "b", 9, 3, 300.0, "M");
		ChildBike c = new ChildBike(3, "bh", "c", 6, 3, 100.0, "14");
		ChildBike d = new ChildBike(4, "bh", "d", 3, 1, 50.0, "12");
		AdultBike e = new AdultBike(5, "bh", "e", 6, 3, 100.0, "L");
		AdultBike f = new AdultBike(6, "bh", "f", 3, 3, 500.0, "XL");
		ChildBike g = new ChildBike(7, "bh", "g", 2, 1, 100.0, "14");
		ChildBike h = new ChildBike(8, "bh", "h", 3, 1, 50.0, "12");
		ChildBike i = new ChildBike(9, "bh", "i", 2, 1, 100.0, "16");
		ChildBike j = new ChildBike(10, "bh", "j", 4, 2, 150.0, "16");
		Bike[] pack = { a, b, c, d, e, f, g, h, i, j };
		GroupPack grupo = new GroupPack(pack);
		assertNotNull(a);
		assertNotNull(b);
		assertNotNull(c);
		assertNotNull(d);
		assertNotNull(e);
		assertNotNull(f);
		assertNotNull(g);
		assertNotNull(h);
		assertNotNull(i);
		assertNotNull(j);
		assertEquals(grupo.esCorrecto(), true);
	}

	@Test(expected = AssertionError.class)
	public void testConstructorConParametrosInvalidosMenosParametros() {
		AdultBike a = new AdultBike(1, "bh", "a", 6, 3, 100.0, "L");
		AdultBike b = new AdultBike(2, "bh", "b", 9, 3, 300.0, "M");
		ChildBike c = new ChildBike(3, "bh", "c", 6, 3, 100.0, "14");
		ChildBike d = new ChildBike(4, "bh", "d", 3, 1, 50.0, "12");
		AdultBike e = new AdultBike(5, "bh", "e", 6, 3, 100.0, "L");
		AdultBike f = new AdultBike(6, "bh", "f", 3, 3, 500.0, "XL");
		ChildBike g = new ChildBike(7, "bh", "g", 2, 1, 100.0, "14");
		ChildBike h = new ChildBike(8, "bh", "h", 3, 1, 50.0, "12");
		ChildBike i = new ChildBike(9, "bh", "i", 2, 1, 100.0, "16");

		Bike[] pack = { a, b, c, d, e, f, g, h, i };
		GroupPack grupo = new GroupPack(pack);
		assertNotNull(a);
		assertNotNull(b);
		assertNotNull(c);
		assertNotNull(d);
		assertNotNull(e);
		assertNotNull(f);
		assertNotNull(g);
		assertNotNull(h);
		assertNotNull(i);

		assertEquals(grupo.esCorrecto(), false);
	}

	@Test
	public void testEqualsconPacksIguales() {
		AdultBike a = new AdultBike(1, "bh", "a", 6, 3, 100.0, "L");
		AdultBike b = new AdultBike(2, "bh", "b", 9, 3, 300.0, "M");
		ChildBike c = new ChildBike(3, "bh", "c", 6, 3, 100.0, "14");
		ChildBike d = new ChildBike(4, "bh", "d", 3, 1, 50.0, "12");
		AdultBike e = new AdultBike(5, "bh", "e", 6, 3, 100.0, "L");
		AdultBike f = new AdultBike(6, "bh", "f", 3, 3, 500.0, "XL");
		ChildBike g = new ChildBike(7, "bh", "g", 2, 1, 100.0, "14");
		ChildBike h = new ChildBike(8, "bh", "h", 3, 1, 50.0, "12");
		ChildBike i = new ChildBike(9, "bh", "i", 2, 1, 100.0, "16");
		ChildBike j = new ChildBike(10, "bh", "j", 4, 2, 150.0, "16");
		Bike[] pack = { a, b, c, d, e, f, g, h, i, j };
		GroupPack grupo = new GroupPack(pack);
		assertNotNull(a);
		assertNotNull(b);
		assertNotNull(c);
		assertNotNull(d);
		assertNotNull(e);
		assertNotNull(f);
		assertNotNull(g);
		assertNotNull(h);
		assertNotNull(i);
		assertNotNull(j);
		assertEquals(grupo.equals(grupo), true);
	}

	@Test
	public void testEqualsconGroupPacksDistintos() {
		AdultBike a = new AdultBike(1, "bh", "a", 6, 3, 100.0, "L");
		AdultBike b = new AdultBike(2, "bh", "b", 9, 3, 300.0, "M");
		ChildBike c = new ChildBike(3, "bh", "c", 6, 3, 100.0, "14");
		ChildBike d = new ChildBike(4, "bh", "d", 3, 1, 50.0, "12");
		AdultBike e = new AdultBike(5, "bh", "e", 6, 3, 100.0, "L");
		AdultBike f = new AdultBike(6, "bh", "f", 3, 3, 500.0, "XL");
		ChildBike g = new ChildBike(7, "bh", "g", 2, 1, 100.0, "14");
		ChildBike h = new ChildBike(8, "bh", "h", 3, 1, 50.0, "12");
		ChildBike i = new ChildBike(9, "bh", "i", 2, 1, 100.0, "16");
		ChildBike j = new ChildBike(10, "bh", "j", 4, 2, 150.0, "16");
		Bike[] pack = { a, b, c, d, e, f, g, h, i, j };
		Bike[] pack2 = { a, b, c, d, e, f, g, h, i, a };
		GroupPack grupo = new GroupPack(pack);
		FamilyPack grupo2 = new FamilyPack(pack2);
		assertNotNull(a);
		assertNotNull(b);
		assertNotNull(c);
		assertNotNull(d);
		assertNotNull(e);
		assertNotNull(f);
		assertNotNull(g);
		assertNotNull(h);
		assertNotNull(i);
		assertNotNull(j);
		assertEquals(grupo.equals(grupo2), false);
	}

	@Test
	public void testEqualsconPacksDeDistintoTipo() {
		AdultBike a = new AdultBike(1, "bh", "a", 6, 3, 100.0, "L");
		AdultBike b = new AdultBike(2, "bh", "b", 9, 3, 300.0, "M");
		ChildBike c = new ChildBike(3, "bh", "c", 6, 3, 100.0, "14");
		ChildBike d = new ChildBike(4, "bh", "d", 3, 1, 50.0, "12");
		AdultBike e = new AdultBike(5, "bh", "e", 6, 3, 100.0, "L");
		AdultBike f = new AdultBike(6, "bh", "f", 3, 3, 500.0, "XL");
		ChildBike g = new ChildBike(7, "bh", "g", 2, 1, 100.0, "14");
		ChildBike h = new ChildBike(8, "bh", "h", 3, 1, 50.0, "12");
		ChildBike i = new ChildBike(9, "bh", "i", 2, 1, 100.0, "16");
		ChildBike j = new ChildBike(10, "bh", "j", 4, 2, 150.0, "16");
		Bike[] pack = { a, b, c, d, e, f, g, h, i, j };
		Bike[] pack2 = { a, b, c, d, e, f, g, h, i, a };
		GroupPack grupo = new GroupPack(pack);
		FamilyPack grupo2 = new FamilyPack(pack2);
		assertNotNull(a);
		assertNotNull(b);
		assertNotNull(c);
		assertNotNull(d);
		assertNotNull(e);
		assertNotNull(f);
		assertNotNull(g);
		assertNotNull(h);
		assertNotNull(i);
		assertNotNull(j);
		assertEquals(grupo.equals(grupo2), false);
	}

	@Test
	public void testToString() {
		AdultBike a = new AdultBike(1, "bh", "a", 6, 3, 100.0, "L");
		AdultBike b = new AdultBike(2, "bh", "b", 9, 3, 300.0, "M");
		ChildBike c = new ChildBike(3, "bh", "c", 6, 3, 100.0, "14");
		ChildBike d = new ChildBike(4, "bh", "d", 3, 1, 50.0, "12");
		AdultBike e = new AdultBike(5, "bh", "e", 6, 3, 100.0, "L");
		AdultBike f = new AdultBike(6, "bh", "f", 3, 3, 500.0, "XL");
		ChildBike g = new ChildBike(7, "bh", "g", 2, 1, 100.0, "14");
		ChildBike h = new ChildBike(8, "bh", "h", 3, 1, 50.0, "12");
		ChildBike i = new ChildBike(9, "bh", "i", 2, 1, 100.0, "16");
		ChildBike j = new ChildBike(10, "bh", "j", 4, 2, 150.0, "16");
		Bike[] pack = { a, b, c, d, e, f, g, h, i, j };
		GroupPack grupo = new GroupPack(pack);
		assertNotNull(a);
		assertNotNull(b);
		assertNotNull(c);
		assertNotNull(d);
		assertNotNull(e);
		assertNotNull(f);
		assertNotNull(g);
		assertNotNull(h);
		assertNotNull(i);
		assertNotNull(j);
		assertEquals(grupo.toString(), "Group Pack formado por: 6 Bicis Child 4 Bicis Adult 0 Bicis Electric");
	}

	@Test
	public void testEsCorrecto() {
		AdultBike a = new AdultBike(1, "bh", "a", 6, 3, 100.0, "L");
		AdultBike b = new AdultBike(2, "bh", "b", 9, 3, 300.0, "M");
		ChildBike c = new ChildBike(3, "bh", "c", 6, 3, 100.0, "14");
		ChildBike d = new ChildBike(4, "bh", "d", 3, 1, 50.0, "12");
		AdultBike e = new AdultBike(5, "bh", "e", 6, 3, 100.0, "L");
		AdultBike f = new AdultBike(6, "bh", "f", 3, 3, 500.0, "XL");
		ChildBike g = new ChildBike(7, "bh", "g", 2, 1, 100.0, "14");
		ChildBike h = new ChildBike(8, "bh", "h", 3, 1, 50.0, "12");
		ChildBike i = new ChildBike(9, "bh", "i", 2, 1, 100.0, "16");
		ChildBike j = new ChildBike(10, "bh", "j", 4, 2, 150.0, "16");
		Bike[] pack = { a, b, c, d, e, f, g, h, i, j };
		GroupPack grupo = new GroupPack(pack);
		assertNotNull(a);
		assertNotNull(b);
		assertNotNull(c);
		assertNotNull(d);
		assertNotNull(e);
		assertNotNull(f);
		assertNotNull(g);
		assertNotNull(h);
		assertNotNull(i);
		assertNotNull(j);
		assertEquals(grupo.esCorrecto(), true);
	}

	@Test(expected = AssertionError.class)
	public void testEsCorrectoConPackConMenosBicis() {
		AdultBike a = new AdultBike(1, "bh", "a", 6, 3, 100.0, "L");
		AdultBike b = new AdultBike(2, "bh", "b", 9, 3, 300.0, "M");
		ChildBike c = new ChildBike(3, "bh", "c", 6, 3, 100.0, "14");
		ChildBike d = new ChildBike(4, "bh", "d", 3, 1, 50.0, "12");
		AdultBike e = new AdultBike(5, "bh", "e", 6, 3, 100.0, "L");
		AdultBike f = new AdultBike(6, "bh", "f", 3, 3, 500.0, "XL");
		ChildBike g = new ChildBike(7, "bh", "g", 2, 1, 100.0, "14");
		ChildBike h = new ChildBike(8, "bh", "h", 3, 1, 50.0, "12");
		ChildBike i = new ChildBike(9, "bh", "i", 2, 1, 100.0, "16");
		Bike[] pack = { a, b, c, d, e, f, g, h, i };
		GroupPack grupo = new GroupPack(pack);
		assertNotNull(a);
		assertNotNull(b);
		assertNotNull(c);
		assertNotNull(d);
		assertNotNull(e);
		assertNotNull(f);
		assertNotNull(g);
		assertNotNull(h);
		assertNotNull(i);
		assertEquals(grupo.esCorrecto(), false);
	}

	@Test
	public void testGetDepositToPay() {
		AdultBike a = new AdultBike(1, "bh", "a", 6, 3, 100.0, "L");
		AdultBike b = new AdultBike(2, "bh", "b", 9, 3, 300.0, "M");
		ChildBike c = new ChildBike(3, "bh", "c", 6, 3, 100.0, "14");
		ChildBike d = new ChildBike(4, "bh", "d", 3, 1, 50.0, "12");
		AdultBike e = new AdultBike(5, "bh", "e", 6, 3, 100.0, "L");
		AdultBike f = new AdultBike(6, "bh", "f", 3, 3, 500.0, "XL");
		ChildBike g = new ChildBike(7, "bh", "g", 2, 1, 100.0, "14");
		ChildBike h = new ChildBike(8, "bh", "h", 3, 1, 50.0, "12");
		ChildBike i = new ChildBike(9, "bh", "i", 2, 1, 100.0, "16");
		ChildBike j = new ChildBike(10, "bh", "j", 4, 2, 150.0, "16");
		Bike[] pack = { a, b, c, d, e, f, g, h, i, j };
		GroupPack grupo = new GroupPack(pack);
		assertNotNull(a);
		assertNotNull(b);
		assertNotNull(c);
		assertNotNull(d);
		assertNotNull(e);
		assertNotNull(f);
		assertNotNull(g);
		assertNotNull(h);
		assertNotNull(i);
		assertNotNull(j);
		assertEquals(grupo.getDepositToPay(10.0), 72.8, ERROR_ADMISIBLE);
	}

	@Test(expected = AssertionError.class)
	public void testGetDepositToPayConFianzaNegativa() {
		AdultBike a = new AdultBike(1, "bh", "a", 6, 3, 100.0, "L");
		AdultBike b = new AdultBike(2, "bh", "b", 9, 3, 300.0, "M");
		ChildBike c = new ChildBike(3, "bh", "c", 6, 3, 100.0, "14");
		ChildBike d = new ChildBike(4, "bh", "d", 3, 1, 50.0, "12");
		AdultBike e = new AdultBike(5, "bh", "e", 6, 3, 100.0, "L");
		AdultBike f = new AdultBike(6, "bh", "f", 3, 3, 500.0, "XL");
		ChildBike g = new ChildBike(7, "bh", "g", 2, 1, 100.0, "14");
		ChildBike h = new ChildBike(8, "bh", "h", 3, 1, 50.0, "12");
		ChildBike i = new ChildBike(9, "bh", "i", 2, 1, 100.0, "16");
		ChildBike j = new ChildBike(10, "bh", "j", 4, 2, 150.0, "16");
		Bike[] pack = { a, b, c, d, e, f, g, h, i, j };
		GroupPack grupo = new GroupPack(pack);
		assertNotNull(a);
		assertNotNull(b);
		assertNotNull(c);
		assertNotNull(d);
		assertNotNull(e);
		assertNotNull(f);
		assertNotNull(g);
		assertNotNull(h);
		assertNotNull(i);
		assertNotNull(j);
		grupo.getDepositToPay(-1.0);
	}

	@Test
	public void testAgregarBici() {
		AdultBike a = new AdultBike(1, "bh", "a", 6, 3, 100.0, "L");
		AdultBike b = new AdultBike(2, "bh", "b", 9, 3, 300.0, "M");
		ChildBike c = new ChildBike(3, "bh", "c", 6, 3, 100.0, "14");
		ChildBike d = new ChildBike(4, "bh", "d", 3, 1, 50.0, "12");
		AdultBike e = new AdultBike(5, "bh", "e", 6, 3, 100.0, "L");
		AdultBike f = new AdultBike(6, "bh", "f", 3, 3, 500.0, "XL");
		ChildBike g = new ChildBike(7, "bh", "g", 2, 1, 100.0, "14");
		ChildBike h = new ChildBike(8, "bh", "h", 3, 1, 50.0, "12");
		ChildBike i = new ChildBike(9, "bh", "i", 2, 1, 100.0, "16");
		ChildBike j = new ChildBike(10, "bh", "j", 4, 2, 150.0, "16");
		ChildBike k = new ChildBike(11, "bh", "j", 4, 2, 150.0, "16");
		Bike[] pack = { a, b, c, d, e, f, g, h, i, j };
		GroupPack grupo = new GroupPack(pack);
		grupo.agregarBici(k);
		assertNotNull(a);
		assertNotNull(b);
		assertNotNull(c);
		assertNotNull(d);
		assertNotNull(e);
		assertNotNull(f);
		assertNotNull(g);
		assertNotNull(h);
		assertNotNull(i);
		assertNotNull(j);
		assertNotNull(k);
		assertEquals(grupo.numeroBicis(), 11);

	}

	@Test
	public void testAgregarBiciConBiciRepetida() {
		AdultBike a = new AdultBike(1, "bh", "a", 6, 3, 100.0, "L");
		AdultBike b = new AdultBike(2, "bh", "b", 9, 3, 300.0, "M");
		ChildBike c = new ChildBike(3, "bh", "c", 6, 3, 100.0, "14");
		ChildBike d = new ChildBike(4, "bh", "d", 3, 1, 50.0, "12");
		AdultBike e = new AdultBike(5, "bh", "e", 6, 3, 100.0, "L");
		AdultBike f = new AdultBike(6, "bh", "f", 3, 3, 500.0, "XL");
		ChildBike g = new ChildBike(7, "bh", "g", 2, 1, 100.0, "14");
		ChildBike h = new ChildBike(8, "bh", "h", 3, 1, 50.0, "12");
		ChildBike i = new ChildBike(9, "bh", "i", 2, 1, 100.0, "16");
		ChildBike j = new ChildBike(10, "bh", "j", 4, 2, 150.0, "16");
		Bike[] pack = { a, b, c, d, e, f, g, h, i, j };
		GroupPack grupo = new GroupPack(pack);
		grupo.agregarBici(a);
		assertNotNull(a);
		assertNotNull(b);
		assertNotNull(c);
		assertNotNull(d);
		assertNotNull(e);
		assertNotNull(f);
		assertNotNull(g);
		assertNotNull(h);
		assertNotNull(i);
		assertNotNull(j);
		assertEquals(grupo.numeroBicis(), 11);

	}

	@Test
	public void testEliminarBici() {
		AdultBike a = new AdultBike(1, "bh", "a", 6, 3, 100.0, "L");
		AdultBike b = new AdultBike(2, "bh", "b", 9, 3, 300.0, "M");
		ChildBike c = new ChildBike(3, "bh", "c", 6, 3, 100.0, "14");
		ChildBike d = new ChildBike(4, "bh", "d", 3, 1, 50.0, "12");
		AdultBike e = new AdultBike(5, "bh", "e", 6, 3, 100.0, "L");
		AdultBike f = new AdultBike(6, "bh", "f", 3, 3, 500.0, "XL");
		ChildBike g = new ChildBike(7, "bh", "g", 2, 1, 100.0, "14");
		ChildBike h = new ChildBike(8, "bh", "h", 3, 1, 50.0, "12");
		ChildBike i = new ChildBike(9, "bh", "i", 2, 1, 100.0, "16");
		ChildBike j = new ChildBike(10, "bh", "j", 4, 2, 150.0, "16");
		ChildBike k = new ChildBike(11, "bh", "j", 4, 2, 150.0, "16");
		Bike[] pack = { a, b, c, d, e, f, g, h, i, j, k };
		GroupPack grupo = new GroupPack(pack);
		grupo.eliminarBici(a);
		assertNotNull(a);
		assertNotNull(b);
		assertNotNull(c);
		assertNotNull(d);
		assertNotNull(e);
		assertNotNull(f);
		assertNotNull(g);
		assertNotNull(h);
		assertNotNull(i);
		assertNotNull(j);
		assertNotNull(k);
		assertEquals(grupo.numeroBicis(), 10);

	}

	@Test(expected = AssertionError.class)
	public void testEliminarBiciConBiciNoContenidaEnElPack() {
		AdultBike a = new AdultBike(1, "bh", "a", 6, 3, 100.0, "L");
		AdultBike b = new AdultBike(2, "bh", "b", 9, 3, 300.0, "M");
		ChildBike c = new ChildBike(3, "bh", "c", 6, 3, 100.0, "14");
		ChildBike d = new ChildBike(4, "bh", "d", 3, 1, 50.0, "12");
		AdultBike e = new AdultBike(5, "bh", "e", 6, 3, 100.0, "L");
		AdultBike f = new AdultBike(6, "bh", "f", 3, 3, 500.0, "XL");
		ChildBike g = new ChildBike(7, "bh", "g", 2, 1, 100.0, "14");
		ChildBike h = new ChildBike(8, "bh", "h", 3, 1, 50.0, "12");
		ChildBike i = new ChildBike(9, "bh", "i", 2, 1, 100.0, "16");
		ChildBike j = new ChildBike(10, "bh", "j", 4, 2, 150.0, "16");
		ChildBike k = new ChildBike(11, "bh", "j", 4, 2, 150.0, "16");
		Bike[] pack = { a, b, c, d, e, f, g, h, i, j };
		GroupPack grupo = new GroupPack(pack);
		grupo.eliminarBici(k);
		assertNotNull(a);
		assertNotNull(b);
		assertNotNull(c);
		assertNotNull(d);
		assertNotNull(e);
		assertNotNull(f);
		assertNotNull(g);
		assertNotNull(h);
		assertNotNull(i);
		assertNotNull(j);
		assertNotNull(k);
		assertEquals(grupo.numeroBicis(), 10);

	}

	@Test
	public void testFormarParteConBiciNoContenidaEnElPack() {
		AdultBike a = new AdultBike(1, "bh", "a", 6, 3, 100.0, "L");
		AdultBike b = new AdultBike(2, "bh", "b", 9, 3, 300.0, "M");
		ChildBike c = new ChildBike(3, "bh", "c", 6, 3, 100.0, "14");
		ChildBike d = new ChildBike(4, "bh", "d", 3, 1, 50.0, "12");
		AdultBike e = new AdultBike(5, "bh", "e", 6, 3, 100.0, "L");
		AdultBike f = new AdultBike(6, "bh", "f", 3, 3, 500.0, "XL");
		ChildBike g = new ChildBike(7, "bh", "g", 2, 1, 100.0, "14");
		ChildBike h = new ChildBike(8, "bh", "h", 3, 1, 50.0, "12");
		ChildBike i = new ChildBike(9, "bh", "i", 2, 1, 100.0, "16");
		ChildBike j = new ChildBike(10, "bh", "j", 4, 2, 150.0, "16");
		ChildBike k = new ChildBike(11, "bh", "j", 4, 2, 150.0, "16");
		Bike[] pack = { a, b, c, d, e, f, g, h, i, j };
		GroupPack grupo = new GroupPack(pack);
		assertNotNull(a);
		assertNotNull(b);
		assertNotNull(c);
		assertNotNull(d);
		assertNotNull(e);
		assertNotNull(f);
		assertNotNull(g);
		assertNotNull(h);
		assertNotNull(i);
		assertNotNull(j);
		assertNotNull(k);
		assertEquals(grupo.esCorrecto(),true);

	}

	@Test
	public void testFormarParteConBiciContenidaEnElPack() {
		AdultBike a = new AdultBike(1, "bh", "a", 6, 3, 100.0, "L");
		AdultBike b = new AdultBike(2, "bh", "b", 9, 3, 300.0, "M");
		ChildBike c = new ChildBike(3, "bh", "c", 6, 3, 100.0, "14");
		ChildBike d = new ChildBike(4, "bh", "d", 3, 1, 50.0, "12");
		AdultBike e = new AdultBike(5, "bh", "e", 6, 3, 100.0, "L");
		AdultBike f = new AdultBike(6, "bh", "f", 3, 3, 500.0, "XL");
		ChildBike g = new ChildBike(7, "bh", "g", 2, 1, 100.0, "14");
		ChildBike h = new ChildBike(8, "bh", "h", 3, 1, 50.0, "12");
		ChildBike i = new ChildBike(9, "bh", "i", 2, 1, 100.0, "16");
		ChildBike j = new ChildBike(10, "bh", "j", 4, 2, 150.0, "16");
		ChildBike k = new ChildBike(11, "bh", "j", 4, 2, 150.0, "16");
		Bike[] pack = { a, b, c, d, e, f, g, h, i, j, k };
		GroupPack grupo = new GroupPack(pack);
		assertNotNull(a);
		assertNotNull(b);
		assertNotNull(c);
		assertNotNull(d);
		assertNotNull(e);
		assertNotNull(f);
		assertNotNull(g);
		assertNotNull(h);
		assertNotNull(i);
		assertNotNull(j);
		assertNotNull(k);
		assertEquals(grupo.formarParte(k), true);

	}

	@Test
	public void testNumeroDeBicis() {
		AdultBike a = new AdultBike(1, "bh", "a", 6, 3, 100.0, "L");
		AdultBike b = new AdultBike(2, "bh", "b", 9, 3, 300.0, "M");
		ChildBike c = new ChildBike(3, "bh", "c", 6, 3, 100.0, "14");
		ChildBike d = new ChildBike(4, "bh", "d", 3, 1, 50.0, "12");
		AdultBike e = new AdultBike(5, "bh", "e", 6, 3, 100.0, "L");
		AdultBike f = new AdultBike(6, "bh", "f", 3, 3, 500.0, "XL");
		ChildBike g = new ChildBike(7, "bh", "g", 2, 1, 100.0, "14");
		ChildBike h = new ChildBike(8, "bh", "h", 3, 1, 50.0, "12");
		ChildBike i = new ChildBike(9, "bh", "i", 2, 1, 100.0, "16");
		ChildBike j = new ChildBike(10, "bh", "j", 4, 2, 150.0, "16");
		ChildBike k = new ChildBike(11, "bh", "j", 4, 2, 150.0, "16");
		Bike[] pack = { a, b, c, d, e, f, g, h, i, j, k };
		GroupPack grupo = new GroupPack(pack);
		assertNotNull(a);
		assertNotNull(b);
		assertNotNull(c);
		assertNotNull(d);
		assertNotNull(e);
		assertNotNull(f);
		assertNotNull(g);
		assertNotNull(h);
		assertNotNull(i);
		assertNotNull(j);
		assertNotNull(k);
		assertEquals(grupo.numeroBicis(), 11);

	}

	@Test
	public void testNumeroDeBicisAdult() {
		AdultBike a = new AdultBike(1, "bh", "a", 6, 3, 100.0, "L");
		AdultBike b = new AdultBike(2, "bh", "b", 9, 3, 300.0, "M");
		ChildBike c = new ChildBike(3, "bh", "c", 6, 3, 100.0, "14");
		ChildBike d = new ChildBike(4, "bh", "d", 3, 1, 50.0, "12");
		AdultBike e = new AdultBike(5, "bh", "e", 6, 3, 100.0, "L");
		AdultBike f = new AdultBike(6, "bh", "f", 3, 3, 500.0, "XL");
		ChildBike g = new ChildBike(7, "bh", "g", 2, 1, 100.0, "14");
		ChildBike h = new ChildBike(8, "bh", "h", 3, 1, 50.0, "12");
		ChildBike i = new ChildBike(9, "bh", "i", 2, 1, 100.0, "16");
		ChildBike j = new ChildBike(10, "bh", "j", 4, 2, 150.0, "16");
		ChildBike k = new ChildBike(11, "bh", "j", 4, 2, 150.0, "16");
		Bike[] pack = { a, b, c, d, e, f, g, h, i, j, k };
		GroupPack grupo = new GroupPack(pack);
		assertNotNull(a);
		assertNotNull(b);
		assertNotNull(c);
		assertNotNull(d);
		assertNotNull(e);
		assertNotNull(f);
		assertNotNull(g);
		assertNotNull(h);
		assertNotNull(i);
		assertNotNull(j);
		assertNotNull(k);
		assertEquals(grupo.numeroBicisAdult(), 4);

	}

	@Test
	public void testNumeroDeBicisChild() {
		AdultBike a = new AdultBike(1, "bh", "a", 6, 3, 100.0, "L");
		AdultBike b = new AdultBike(2, "bh", "b", 9, 3, 300.0, "M");
		ChildBike c = new ChildBike(3, "bh", "c", 6, 3, 100.0, "14");
		ChildBike d = new ChildBike(4, "bh", "d", 3, 1, 50.0, "12");
		AdultBike e = new AdultBike(5, "bh", "e", 6, 3, 100.0, "L");
		AdultBike f = new AdultBike(6, "bh", "f", 3, 3, 500.0, "XL");
		ChildBike g = new ChildBike(7, "bh", "g", 2, 1, 100.0, "14");
		ChildBike h = new ChildBike(8, "bh", "h", 3, 1, 50.0, "12");
		ChildBike i = new ChildBike(9, "bh", "i", 2, 1, 100.0, "16");
		ChildBike j = new ChildBike(10, "bh", "j", 4, 2, 150.0, "16");
		ChildBike k = new ChildBike(11, "bh", "j", 4, 2, 150.0, "16");
		Bike[] pack = { a, b, c, d, e, f, g, h, i, j, k };
		GroupPack grupo = new GroupPack(pack);
		assertNotNull(a);
		assertNotNull(b);
		assertNotNull(c);
		assertNotNull(d);
		assertNotNull(e);
		assertNotNull(f);
		assertNotNull(g);
		assertNotNull(h);
		assertNotNull(i);
		assertNotNull(j);
		assertNotNull(k);
		assertEquals(grupo.numeroBicisChild(), 7);

	}

	@Test
	public void testNumeroDeBicisElectric() {
		AdultBike a = new AdultBike(1, "bh", "a", 6, 3, 100.0, "L");
		AdultBike b = new AdultBike(2, "bh", "b", 9, 3, 300.0, "M");
		ChildBike c = new ChildBike(3, "bh", "c", 6, 3, 100.0, "14");
		ChildBike d = new ChildBike(4, "bh", "d", 3, 1, 50.0, "12");
		AdultBike e = new AdultBike(5, "bh", "e", 6, 3, 100.0, "L");
		AdultBike f = new AdultBike(6, "bh", "f", 3, 3, 500.0, "XL");
		ChildBike g = new ChildBike(7, "bh", "g", 2, 1, 100.0, "14");
		ChildBike h = new ChildBike(8, "bh", "h", 3, 1, 50.0, "12");
		ChildBike i = new ChildBike(9, "bh", "i", 2, 1, 100.0, "16");
		ChildBike j = new ChildBike(10, "bh", "j", 4, 2, 150.0, "16");
		ChildBike k = new ChildBike(11, "bh", "j", 4, 2, 150.0, "16");
		Bike[] pack = { a, b, c, d, e, f, g, h, i, j, k };
		GroupPack grupo = new GroupPack(pack);
		assertNotNull(a);
		assertNotNull(b);
		assertNotNull(c);
		assertNotNull(d);
		assertNotNull(e);
		assertNotNull(f);
		assertNotNull(g);
		assertNotNull(h);
		assertNotNull(i);
		assertNotNull(j);
		assertNotNull(k);
		assertEquals(grupo.numeroBicisElectric(), 0);

	}

	@Test
	public void testObtenerPack() {
		AdultBike a = new AdultBike(1, "bh", "a", 6, 3, 100.0, "L");
		AdultBike b = new AdultBike(2, "bh", "b", 9, 3, 300.0, "M");
		ChildBike c = new ChildBike(3, "bh", "c", 6, 3, 100.0, "14");
		ChildBike d = new ChildBike(4, "bh", "d", 3, 1, 50.0, "12");
		AdultBike e = new AdultBike(5, "bh", "e", 6, 3, 100.0, "L");
		AdultBike f = new AdultBike(6, "bh", "f", 3, 3, 500.0, "XL");
		ChildBike g = new ChildBike(7, "bh", "g", 2, 1, 100.0, "14");
		ChildBike h = new ChildBike(8, "bh", "h", 3, 1, 50.0, "12");
		ChildBike i = new ChildBike(9, "bh", "i", 2, 1, 100.0, "16");
		ChildBike j = new ChildBike(10, "bh", "j", 4, 2, 150.0, "16");
		ChildBike k = new ChildBike(11, "bh", "j", 4, 2, 150.0, "16");
		Bike[] pack = { a, b, c, d, e, f, g, h, i, j, k };
		GroupPack grupo = new GroupPack(pack);
		assertNotNull(a);
		assertNotNull(b);
		assertNotNull(c);
		assertNotNull(d);
		assertNotNull(e);
		assertNotNull(f);
		assertNotNull(g);
		assertNotNull(h);
		assertNotNull(i);
		assertNotNull(j);
		assertNotNull(k);
		assertEquals((grupo.obtenerPack()).equals(pack), true);

	}
}