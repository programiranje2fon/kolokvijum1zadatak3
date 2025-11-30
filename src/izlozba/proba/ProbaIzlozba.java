package izlozba.proba;

import java.util.GregorianCalendar;

import eksponati.fotografije.Fotografija;
import izlozba.Izlozba;

public class ProbaIzlozba {

	public static void main(String[] args) {
		GregorianCalendar datumIzlozbe = new GregorianCalendar();
		
		datumIzlozbe.set(2019, 9, 23);
				
		Izlozba iz = new Izlozba(datumIzlozbe);
		
		Fotografija f = new Fotografija();
		
		f.setAutor("Yoko Ono");
		f.setNaziv("John Lennon");
		
		iz.unesiEksponat(f);
	}

}
