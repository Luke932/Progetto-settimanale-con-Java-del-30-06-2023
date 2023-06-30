package MediaProject;

public class Image extends ElementMedia {
	private int luminosita;

	public Image(String titolo, int luminosita) {
		super(titolo);
		this.luminosita = luminosita;
	}

	protected void show() {
		System.out.println(titolo + " " + "*".repeat(luminosita));
	}

}
