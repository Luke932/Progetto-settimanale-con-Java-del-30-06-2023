package MediaProject;

public class Video extends ElementMedia implements Player {
	private int durata;
	private int volume;
	private int luminosita;

	public Video(String titolo, int durata, int volume, int luminosita) {
		super(titolo);
		this.durata = durata;
		this.volume = volume;
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

	public void alzaVolume() {
		if (volume < 10) {
			volume++;
			System.out.println("Volume alzato. Volume attuale: " + volume);
		} else {
			System.out.println("Volume già al massimo.");
		}
	}

	public void abbassaVolume() {
		if (volume > 0) {
			volume--;
			System.out.println("Volume abbassato. Volume attuale: " + volume);
		} else {
			System.out.println("Volume già al minimo.");
		}
	}

	@Override
	public void play() {
		for (int i = 0; i < durata; i++) {
			System.out.println(titolo + " " + "!".repeat(volume) + "*".repeat(luminosita));
		}
	}
}
