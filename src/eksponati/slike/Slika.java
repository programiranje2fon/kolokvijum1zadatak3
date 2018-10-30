package eksponati.slike;

import eksponati.Eksponat;

public class Slika extends Eksponat {
	
	private String tehnika;

	public String getTehnika() {
		return tehnika;
	}

	public void setTehnika(String tehnika) {
		this.tehnika = tehnika;
	}
	
	public void ispisi() {
		super.ispisi();
		System.out.println("Tehnika: "+ tehnika);
	}

}
