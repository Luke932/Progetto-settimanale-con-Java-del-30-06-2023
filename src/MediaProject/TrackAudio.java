package MediaProject;

public class TrackAudio extends ElementMedia implements Player {
	private int durata;
	private int volume;

	public TrackAudio(String titolo, int durata, int volume) {
		super(titolo);
		this.durata = durata;
		this.volume = volume;
	}

	public void abbassaVolume() {
		if (volume > 0) {
			volume--;
		}
	}

	public void alzaVolume() {
		volume++;
	}

	@Override
	public void play() {
		for (int i = 0; i < durata; i++) {
			System.out.println(titolo + " " + "!".repeat(volume));
		}

	}

}
