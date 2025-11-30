package eksponati;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Modifier;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test.TestUtil;

public class EksponatTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	Eksponat instance;
	
	@Before
	public void setUp() throws Exception {
		instance = new Eksponat();
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
	public void atribut_autor() {
		assertTrue("U klasi nije definisan atribut autor", TestUtil.doesFieldExist(Eksponat.class, "autor"));
	}
	
	@Test
	public void atribut_autor_vidljivost() {
		assertTrue("Atribut autor nije privatan", TestUtil.hasFieldModifier(Eksponat.class, "autor", Modifier.PRIVATE));
	}

	@Test
	public void atribut_naziv() {
		assertTrue("U klasi nije definisan atribut naziv", TestUtil.doesFieldExist(Eksponat.class, "naziv"));
	}
	
	@Test
	public void atribut_naziv_vidljivost() {
		assertTrue("Atribut naziv nije privatan", TestUtil.hasFieldModifier(Eksponat.class, "naziv", Modifier.PRIVATE));
	}
	
	@Test
	public void metoda_setAutor() {
		instance.setAutor("Pera Mikic");
		
		assertEquals("Ako se unese Pera Mikic kao autor, atribut ne dobija tu vrednost", "Pera Mikic", instance.getAutor());
	}
	
	@Test
	public void metoda_setAutor_Null() {
		instance.setAutor(null);
		
		assertEquals("NE ispisuje se rec GRESKA u slucaju unosa NULL vrednosti", "GRESKA", outContent.toString().trim().toUpperCase());		
	}
	
	@Test
	public void metoda_setAutor_PrazanString() {
		instance.setAutor("");
		
		assertEquals("NE ispisuje se rec GRESKA u slucaju unosa praznog Stringa", "GRESKA", outContent.toString().trim().toUpperCase());		
		assertEquals("Uneta je nedozvoljena vrednost (prazan String) u atribut autor", null, instance.getAutor());
	}
	
	@Test
	public void metoda_setAutor_PrekratakString() {
		instance.setAutor("kkkk");
		
		assertEquals("NE ispisuje se rec GRESKA u slucaju unosa Stringa kraceg od 5 znakova", "GRESKA", outContent.toString().trim().toUpperCase());		
		assertEquals("Uneta je nedozvoljena vrednost (prekratak String) u atribut autor", null, instance.getAutor());
	}
	
	@Test
	public void metoda_setNaziv() {
		instance.setNaziv("Mona Liza");
		
		assertEquals("Ako se unese Mona Liza kao naziv, atribut ne dobija tu vrednost", "Mona Liza", instance.getNaziv());
	}
	
	@Test
	public void metoda_setNaziv_Null() {
		instance.setNaziv(null);
		
		assertEquals("NE ispisuje se rec GRESKA u slucaju unosa NULL vrednosti", "GRESKA", outContent.toString().trim().toUpperCase());		
	}
	
	@Test
	public void metoda_setNaziv_PrazanString() {
		instance.setNaziv("");
		
		assertEquals("NE ispisuje se rec GRESKA u slucaju unosa praznog Stringa", "GRESKA", outContent.toString().trim().toUpperCase());		
		assertEquals("Uneta je nedozvoljena vrednost (prazan String) u atribut naziv", null, instance.getAutor());
	}
	
	@Test
	public void metoda_ispisi() {
		instance.setNaziv("Slika1");
		instance.setAutor("Autor2");
		
		instance.ispisi();
		
		assertTrue("NE ispisuje se naziv eksponata", outContent.toString().contains("Slika1"));		
		assertTrue("NE ispisuje se autor", outContent.toString().contains("Autor2"));		
	}
	
	

}
