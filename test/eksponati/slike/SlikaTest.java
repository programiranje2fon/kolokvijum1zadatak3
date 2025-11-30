package eksponati.slike;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Modifier;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test.TestUtil;

public class SlikaTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	Slika instance;
	
	@Before
	public void setUp() throws Exception {
		instance = new Slika();
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
		System.setOut(originalOut);
	    System.setErr(originalErr);
	}

	@Test
	public void atribut_tehnika() {
		assertTrue("U klasi nije definisan atribut tehnika", TestUtil.doesFieldExist(Slika.class, "tehnika"));
	}
	
	@Test
	public void atribut_tehnika_vidljivost() {
		assertTrue("Atribut tehnika nije privatan", TestUtil.hasFieldModifier(Slika.class, "tehnika", Modifier.PRIVATE));
	}
	
	@Test
	public void metoda_setTehnika() {
		instance.setTehnika("tempere");
		
		assertEquals("Ako se unese tehnika 'tempere', atribut ne dobija tu vrednost", "tempere", instance.getTehnika());
	}
	
	@Test
	public void metoda_ispisi() {
		instance.setNaziv("Slika1");
		instance.setAutor("Autor2");
		instance.setTehnika("akvarel");
		
		instance.ispisi();
		
		assertTrue("NE ispisuje se naziv eksponata", outContent.toString().contains("Slika1"));		
		assertTrue("NE ispisuje se autor", outContent.toString().contains("Autor2"));		
		assertTrue("NE ispisuje se tehnika", outContent.toString().contains("akvarel"));		
	}

	

}
