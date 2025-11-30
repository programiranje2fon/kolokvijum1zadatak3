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
import eksponati.fotografije.Fotografija;
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
	
	@Test (timeout = 2000)
	public void konstruktor_Izlozba() {
		GregorianCalendar datum = new GregorianCalendar(2004, 1, 22);
		instance = new Izlozba(datum);
		
		assertNotNull("Konstruktor uopste nije inicijalizovao niz", TestUtil.getFieldValue(instance,"eksponati"));
		assertEquals("Konstruktor ne inicijalizuje niz na kapacitet 50", 50, ((Eksponat[])TestUtil.getFieldValue(instance,"eksponati")).length);
		assertEquals("Konstruktor ne unosi vrednost datuma u atribut", datum, TestUtil.getFieldValue(instance, "datumOtvaranja"));
	}

	@Test (timeout = 2000)
	public void metoda_unesiEksponat() {
		Eksponat novi = new Eksponat();
		Eksponat novi2 = new Eksponat();
		
		instance.unesiEksponat(novi);
		instance.unesiEksponat(novi2);
		
		Eksponat[] eksponati = (Eksponat[])(TestUtil.getFieldValue(instance, "eksponati"));
		
		assertEquals("Ako se unesu dva eksponata, ne postavlja prvi na prvo mesto u nizu",novi, eksponati[0] );
		assertEquals("Ako se unesu dva eksponata, ne postavlja drugi na drugo mesto u nizu",novi2, eksponati[1] );
		assertEquals("Ako se unesu dva eksponata, popunjava se i trece mesto greskom",null, eksponati[2] );
		
	}
	
	@Test (timeout = 2000)
	public void metoda_unesiEksponat_NULL() {
		instance.unesiEksponat(null);
		
		assertEquals("NE ispisuje se rec GRESKA u slucaju unosa NULL vrednosti", "GRESKA", outContent.toString().trim().toUpperCase());				
	}
	
	@Test (timeout = 2000)
	public void metoda_unesiEksponat_NizPun() {
		for(int i=1;i<=50;i++)
			instance.unesiEksponat(new Eksponat());
		
		instance.unesiEksponat(new Eksponat());
		
		assertEquals("NE ispisuje se rec GRESKA u slucaju da se pokusa unos a niz je pun", "GRESKA", outContent.toString().trim().toUpperCase());				
	}

	@Test (timeout = 2000)
	public void metoda_ispisiSveEksponate() {
		Eksponat e1 = new Eksponat();
		e1.setAutor("Mika Zikic");
		e1.setNaziv("Eksponat1"); 
		
		Eksponat e2 = new Eksponat();
		e2.setAutor("Pera Peric");
		e2.setNaziv("Eksponat2");
		
		Eksponat e3 = new Eksponat();
		e3.setAutor("Pera Peric");
		e3.setNaziv("Eksponat3");
		
		instance.unesiEksponat(e1);
		instance.unesiEksponat(e2);
		instance.unesiEksponat(e3);
		
		instance.ispisiSveEksponate("Pera Peric");
		
		assertTrue("Metoda ne ispisuje datum otvaranja izlozbe na pocetku", outContent.toString().substring(0,outContent.toString().indexOf(System.lineSeparator())).contains("2000"));
		assertTrue("Ako se trazi 'Pera Peric' a uneti su eksponati 'Eksponat1' 'Mika Zikic', 'Eksponat2' 'Pera Peric' i 'Eksponat 3' 'Pera Peric', metoda ne ispisuje drugi eksponat", outContent.toString().contains("Eksponat2"));
		assertTrue("Ako se trazi 'Pera Peric' a uneti su eksponati 'Eksponat1' 'Mika Zikic', 'Eksponat2' 'Pera Peric' i 'Eksponat 3' 'Pera Peric', metoda ne ispisuje treci eksponat", outContent.toString().contains("Eksponat3"));
	}

	@Test (timeout = 2000)
	public void metoda_pronadji() {
		Fotografija e1 = new Fotografija();
		e1.setAutor("Pera Peric");
		e1.setNaziv("Eksponat1"); 
		
		Slika e2 = new Slika();
		e2.setAutor("Pera Peric");
		e2.setNaziv("Eksponat2");
		e2.setTehnika("tempera");
		
		Slika e3 = new Slika();
		e3.setAutor("Pera Mikic");
		e3.setNaziv("Eksponat3");
		e3.setTehnika("akvarel");
		
		Slika e4 = new Slika();
		e4.setAutor("Dejan Peric");
		e4.setNaziv("Eksponat4");
		e4.setTehnika("tempera");

		instance.unesiEksponat(e1);
		instance.unesiEksponat(e2);
		instance.unesiEksponat(e3);
		instance.unesiEksponat(e4);
		
		Eksponat[] niz = instance.pronadji("Peric");
		
		assertEquals("Ako se trazi 'Peric' a uneti su Fotografija('Eksponat1' 'Pera Peric'),"+""
				+ " Slika ('Eksponat2' 'Pera Peric'), Slika ('Eksponat3' 'Pera Mikic') i Slika ('Eksponat 4' 'Pera Peric')"+""
						+ ", metoda ne vraca niz duzine 2", 2, niz.length);
		assertTrue("Ako se trazi 'Peric' a uneti su Fotografija('Eksponat1' 'Pera Peric'),"+""
				+ " Slika ('Eksponat2' 'Pera Peric'), Slika ('Eksponat3' 'Pera Mikic') i Slika ('Eksponat 4' 'Pera Peric')"+""
						+ ", metoda ne vraca eksponat 2 u rezultatu", (e2==niz[0] || e2 == niz[1]));
		assertTrue("Ako se trazi 'Peric' a uneti su Fotografija('Eksponat1' 'Pera Peric'),"+""
				+ " Slika ('Eksponat2' 'Pera Peric'), Slika ('Eksponat3' 'Pera Mikic') i Slika ('Eksponat 4' 'Pera Peric')"+""
						+ ", metoda ne vraca eksponat 4 u rezultatu", (e4==niz[0] || e4 == niz[1]));				
	}

}
