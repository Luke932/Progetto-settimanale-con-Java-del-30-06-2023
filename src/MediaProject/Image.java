package MediaProject;

public class Image extends ElementMedia implements Player {
	private int luminosita;

	public Image(String titolo, int luminosita) {
		super(titolo);
		this.luminosita = luminosita;
	}

	public void aumentaLuminosita() {
		if (luminosita < 10) {
			luminosita++;
			System.out.println("Luminosità aumentata. Luminosità attuale: " + luminosita);
		} else {
			System.out.println("Luminosità già al massimo.");
		}
	}

	public void diminuisciLuminosita() {
		if (luminosita > 0) {
			luminosita--;
			System.out.println("Luminosità diminuita. Luminosità attuale: " + luminosita);
		} else {
			System.out.println("Luminosità già al minimo.");
		}
	}

	@Override
	public void play() {
		System.out.println("Impossibile riprodurre un'immagine.");
	}

	public void show() {
		System.out.println(titolo + " " + "*".repeat(luminosita));
	}
}
