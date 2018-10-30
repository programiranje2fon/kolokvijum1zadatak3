package izlozba;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Modifier;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eksponati.Eksponat;
import eksponati.slike.Slika;
import test.TestUtil;

public class IzlozbaTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;
	
	Izlozba instance;

	@Before
	public void setUp() throws Exception {
		GregorianCalendar datum = new GregorianCalendar(2000, 10, 2);
		instance = new Izlozba(datum);
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));		
	}

	@After
	public void tearDown() throws Exception {
		System.setOut(originalOut);
	    System.setErr(originalErr);
	}

	@Test
	public void atribut_datumOtvaranja() {
		assertTrue("U klasi nije definisan atribut datumOtvaranja", TestUtil.doesFieldExist(Izlozba.class, "datumOtvaranja"));
	}
	
	@Test
	public void atribut_datumOtvaranja_vidljivost() {
		assertTrue("Atribut datumOtvaranja nije privatan", TestUtil.hasFieldModifier(Izlozba.class, "datumOtvaranja", Modifier.PRIVATE));
	}
	
	@Test
	public void atribut_eksponati() {
		assertTrue("U klasi nije definisan atribut eksponati", TestUtil.doesFieldExist(Izlozba.class, "eksponati"));
	}
	
	@Test
	public void atribut_eksponati_vidljivost() {
		assertTrue("Atribut eksponati nije privatan", TestUtil.hasFieldModifier(Izlozba.class, "eksponati", Modifier.PRIVATE));
	}
	
	@Test
	public void konstruktor_Izlozba() {
		GregorianCalendar datum = new GregorianCalendar(2004, 1, 22);
		instance = new Izlozba(datum);
		
		assertNotNull("Konstruktor uopste nije inicijalizovao niz", TestUtil.getFieldValue(instance,"eksponati"));
		assertEquals("Konstruktor ne inicijalizuje niz na kapacitet 50", 50, ((Eksponat[])TestUtil.getFieldValue(instance,"eksponati")).length);
		assertEquals("Konstruktor ne unosi vrednost datuma u atribut", datum, TestUtil.getFieldValue(instance, "datumOtvaranja"));
	}

	@Test
	public void metoda_unesiEksponat() {
		fail("Not yet implemented");
	}

	@Test
	public void metoda_ispisiSveEksponate() {
		fail("Not yet implemented");
	}

	@Test
	public void metoda_pronadji() {
		fail("Not yet implemented");
	}

}
