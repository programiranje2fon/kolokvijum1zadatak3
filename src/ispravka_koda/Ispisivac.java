package ispravka_koda;

class Ispisivac {
	static void ispisiTrougao() {
		for (int i = 1; i <= 5; i++) {
			int j = 1;
			while (j <= i) {
					j++;
					System.out.print('*');
			}
			System.out.println();
		}
	}
}
