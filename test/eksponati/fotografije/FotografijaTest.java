package eksponati.fotografije;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FotografijaTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	Fotografija instance;
	
	@Before
	public void setUp() throws Exception {
		instance = new Fotografija();
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
	public void metoda_ispisi() {
		instance.setNaziv("Slika1");
		instance.setAutor("Autor2");
		
		instance.ispisi();
		
		assertTrue("NE ispisuje se naziv eksponata", outContent.toString().contains("Slika1"));		
		assertTrue("NE ispisuje se autor", outContent.toString().contains("Autor2"));		
		assertTrue("NE ispisuje se napomena da je rec o fotografiji", outContent.toString().contains("otografij"));		
	}
}
