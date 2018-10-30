package izlozba;

import java.util.GregorianCalendar;

import eksponati.Eksponat;
import eksponati.slike.Slika;

public class Izlozba {
	
	private GregorianCalendar datumOtvaranja;
	
	private Eksponat[] eksponati;
	
	public Izlozba(GregorianCalendar datum) {
		datumOtvaranja = datum;
		
		eksponati = new Eksponat[50];
	}
	
	public void unesiEksponat(Eksponat novi) {
		if (novi == null) {
			System.out.println("GRESKA");
			return;
		}
		
		for (int i=0; i<eksponati.length; i++)
			if (eksponati[i] == null) {
				eksponati[i] = novi;
				return;
			}
		
		System.out.println("GRESKA");
	}
	
	public void ispisiSveEksponate(String autor) {
		System.out.println(datumOtvaranja.getTime());
		
		for(int i=0; i<eksponati.length; i++)
			if (eksponati[i]!=null && eksponati[i].getAutor().equals(autor))
				eksponati[i].ispisi();
	}
	
	public Eksponat[] pronadji(String prezime) {
		int brojac = 0;
		
		//Prvo ide prebrojavanje koliko ima trazenih slika
		for(int i=0;i<eksponati.length;i++)
			if (eksponati[i]!=null && eksponati[i].getAutor().endsWith(prezime) &&
				eksponati[i] instanceof Slika &&
				((Slika)(eksponati[i])).getTehnika().equals("tempera"))
				brojac++;
		
		//Inicijalizacija niza na tacno tu duzinu
		Eksponat[] rezultat = new Eksponat[brojac];
		
		//Ubacivanje u novi niz
		brojac = 0;
		
		for(int i=0;i<eksponati.length;i++)
			if (eksponati[i]!=null && eksponati[i].getAutor().endsWith(prezime) &&
				eksponati[i] instanceof Slika &&
				((Slika)(eksponati[i])).getTehnika().equals("tempera")) {
					rezultat[brojac] = eksponati[i];
					brojac++;
			}
		
		return rezultat;
	}

}
