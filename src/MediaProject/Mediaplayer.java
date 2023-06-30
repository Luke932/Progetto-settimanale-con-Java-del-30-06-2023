package MediaProject;

import java.util.Scanner;

public class Mediaplayer {
	private static Scanner pippo = new Scanner(System.in);
	private static ElementMedia[] elements = new ElementMedia[5];

	public static void main(String[] args) {
		readElementsMedia();

		int check;
		do {
			printMenu();
			check = pippo.nextInt();

			if (check >= 1 && check <= 5) {
				ElementMedia element = elements[check - 1];
				playElementMedia(element);
			} else if (check != 0) {
				System.out.println("Scelta non valida.");
			}
		} while (check != 0);
	}

	private static void readElementsMedia() {
		for (int i = 0; i < elements.length; i++) {
			System.out.println("Inserisci il titolo per la traccia " + (i + 1) + ":");
			String titolo = pippo.nextLine();

			System.out.println("1 - Immagine, 2 - Registrazione audio, 3 - Video");
			int typeElm = pippo.nextInt();
			pippo.nextLine(); // Pulisci il buffer di input

			switch (typeElm) {
			case 1:
				System.out.println("Inserisci la luminosità per l'immagine");
				int luminosita = pippo.nextInt();
				pippo.nextLine(); // Pulisci il buffer di input
				elements[i] = new Image(titolo, luminosita);
				break;
			case 2:
				System.out.println("Inserisci la durata per la registrazione audio");
				int durata = pippo.nextInt();
				System.out.println("Inserisci il volume per la registrazione audio");
				int volume = pippo.nextInt();
				pippo.nextLine(); // Pulisci il buffer di input
				elements[i] = new TrackAudio(titolo, durata, volume);
				break;
			case 3:
				System.out.println("Inserisci la durata per il video");
				int durataV = pippo.nextInt();
				System.out.println("Inserisci il volume per il video");
				int volumeV = pippo.nextInt();
				System.out.println("Inserisci la luminosità per il video");
				int luminositaV = pippo.nextInt();
				pippo.nextLine(); // Pulisci il buffer di input
				elements[i] = new Video(titolo, durataV, volumeV, luminositaV);
				break;
			default:
				System.out.println("Tipo di elemento non valido");
				break;
			}
		}
	}

	public static void printMenu() {
		System.out.println("Scelta file multimediale da eseguire: ");
		for (int i = 0; i < elements.length; i++) {
			System.out.println((i + 1) + ". " + elements[i].titolo);
		}
		System.out.println("0. Esci");

		while (!pippo.hasNextInt()) {
			System.out.println("Inserisci un numero valido:");
			pippo.next();
		}

		int choice = pippo.nextInt();
		pippo.nextLine(); // Consuma il newline residuo dopo nextInt()

		if (choice >= 1 && choice <= elements.length) {
			ElementMedia element = elements[choice - 1];
			playElementMedia(element);
		} else if (choice != 0) {
			System.out.println("Scelta non valida.");
		}
	}

	public static void playElementMedia(ElementMedia element) {
		if (element instanceof Player) {
			Player vlc = (Player) element;
			vlc.play();
		} else if (element instanceof Image) {
			Image jpg = (Image) element;
			jpg.show();
		}
	}
}
