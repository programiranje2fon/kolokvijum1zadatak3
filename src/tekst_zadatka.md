# Zadatak 1

** NAPOMENA: PO ZAVRŠETKU ZADATKA OBAVEZNO TESTIRATI REŠENJE POZIVANJEM AUTOMATIZOVANIH TESTOVA (desnim tasterom na naziv projekta, Run as - Java Application - PokreniTestove)**

Napraviti javnu klasu **Eksponat** u paketu **eksponati** koja ima:

* Privatni atribut **naziv** koji predstavlja naziv eksponata.

* Privatni atribut **autor** koji predstavlja ime i prezime autora u formatu "IME PREZIME".

* Odgovarajuće javne get i set metode za ove atribute. Nedozvoljene vrednosti za oba atributa su null i prazan String, a String sa imenom i prezimenom autora ne sme biti kraći od 5 znakova. U slučaju unosa nedozvoljenih vrednosti ispisati na ekranu reč "GRESKA".

* Javnu metodu **ispisi** koja na ekranu ispisuje sve podatke o eksponatu.

Napraviti javnu klasu **Slika** u paketu **eksponati.slike** koja nasleđuje klasu Eksponat i ima:

* Privatni atribut **tehnika** koji predstavlja naziv tehnike koju je slikar koristio (npr. “ulje na platnu”).

* Odgovarajuće javne get i set metode za ovaj atribut.

* Redefinisanu javnu metodu **ispisi** koja na ekranu ispisuje sve podatke o slici.

Napraviti javnu klasu **Fotografija** u paketu **eksponati.fotografije** koja nasleđuje klasu Eksponat i ima:

* Redefinisanu javnu metodu **ispisi** koja na ekranu ispisuje sve podatke o fotografiji uz odgovarajući tekst kojim se naznačava da je u pitanju fotografija.

Napraviti javnu klasu **Izlozba** u paketu **izlozba** koja ima:

* Privatni atribut **datumOtvaranja** tj. datum i vreme otvaranja izložbe (koristiti klasu GregorianCalendar).

* Privatni atribut **eksponati** koji predstavlja niz objekata klase Eksponat. **(NAPOMENA: Niz eksponata sa izložbe će zapravo da sadrži objekte klase Slika i objekte klase Fotografija)**

* Javni konstruktor koji inicijalizuje niz na 50 elemenata i postavlja da datum otvaranja bude datum koji se unosi kao ulazni parametar konstruktora (klasa GregorianCalendar).

* Javnu metodu **unesiEksponat** koja kao parametar ima objekat klase Eksponat i unosi ga u niz na prvo slobodno mesto (mesto je slobodno ako je element na tom mestu NULL). Unošenje se vrši samo ako uneti objekat nema null vrednost i ako u nizu ima mesta. U suprotnom, ispisati na ekranu reč "GRESKA".

* Javnu metodu **ispisiSveEksponate** koja kao parametar prima ime i prezime autora (kao jedan String) i na ekranu ispisuje podatke o svim eksponatim tog autora. Metoda na početku, u prvom redu, ispisuje datum otvaranja izložbe uz odgovarajuću poruku.

* Javnu metodu **pronadji** koja kao ulazni parametar dobija **samo prezime** autora i vraća niz koji sadrži sve slike koje autori sa tim prezimenom imaju na izložbi a nastale su korišćenjem tehnike "tempera". Niz treba da bude tačno tolike dužine (kapaciteta) koliko ima takvih slika.

Napraviti javnu klasu **ProbaIzlozba** u paketu **izlozba.proba** koja u okviru main metode pravi jedan objekat klase Izlozba, postavlja da je datum otvaranja izložbe 23.10.2019. i unosi jedan eksponat: fotografiju "John Lennon" autora "Yoko Ono".

# Zadatak 2 (ispravka koda)

** NAPOMENA: PO ZAVRŠETKU ZADATKA OBAVEZNO TESTIRATI REŠENJE POZIVANJEM AUTOMATIZOVANIH TESTOVA (desnim tasterom na naziv projekta, Run as - Java Application - PokreniTestove)**

U produžetku teksta je dat kod klase sa metodom koja bi trebalo da ispisuje trougao (od znakova *) na ekranu. Ideja je da se u prvom redu na ekranu ispiše jedna zvezdica, u drugom redu dve... a u poslednjem pet, tako da bi konačan izlaz na ekranu trebalo da izgleda ovako:

	*
	**
	***
	****
	*****
Dati kod se kompajlira, ali ne radi to šta treba. Napraviti klasu **Ispisivac** u paketu **ispravka_koda**, prekucati u nju kod koji je dat  i, uz minimalne izmene ga ispraviti tako da funkcioniše kako treba. Koristeći main metodu iz test klase, pozvati metodu ispisiTrougao() i proveriti njen rad.

	package ispravka_koda;
	
	class Ispisivac {
		static void ispisiTrougao(){
			for (int i=1; i>=5; i++){
				int j=1;
				while (j<i)
					j++;
					System.out.print('*');
					System.out.println();
			}							
		}
	}


