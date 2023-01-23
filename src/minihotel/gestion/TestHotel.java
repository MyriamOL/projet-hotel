package minihotel.gestion;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class TestHotel {

	public static void main(String[] args) throws ParseException {

		boolean end = false;
		String choix;

		// ===test :
		// public Reservation(int numReservation, String dateDebut, String dateFin)
		// throws ParseException {
		Reservation reservation1 = new Reservation(1, "20/01/2023", "22/01/2023");
		Reservation reservation2 = new Reservation(2, "22/01/2023", "26/01/2023");
		Reservation reservation3 = new Reservation(3, "22/01/2023", "27/01/2023");
		Reservation reservation4 = new Reservation(4, "22/01/2023", "28/01/2023");
		Reservation reservation5 = new Reservation(5, "20/01/2023", "29/01/2023");
		Reservation reservation6 = new Reservation(6, "22/01/2023", "30/01/2023");
		Reservation reservation7 = new Reservation(7, "22/01/2023", "01/02/2023");
		Reservation reservation8 = new Reservation(8, "22/01/2023", "02/02/2023");

		// public Chambre(String type, Boolean etat, int numChambre, double prix/* ,
		// String client */, Reservation reservation){
		int randomNum1 = ThreadLocalRandom.current().nextInt(0, 1 + 1);
		int randomNum2 = ThreadLocalRandom.current().nextInt(0, 1 + 1);
		int randomNum3 = ThreadLocalRandom.current().nextInt(0, 1 + 1);
		int randomNum4 = ThreadLocalRandom.current().nextInt(0, 1 + 1);
		int randomNum5 = ThreadLocalRandom.current().nextInt(0, 1 + 1);
		int randomNum6 = ThreadLocalRandom.current().nextInt(0, 1 + 1);
		int randomNum7 = ThreadLocalRandom.current().nextInt(0, 1 + 1);
		int randomNum8 = ThreadLocalRandom.current().nextInt(0, 1 + 1);
		//
		boolean etat1, etat2, etat3, etat4, etat5, etat6, etat7, etat8;
		if (randomNum1 == 1) {
			etat1 = true;
		} else {
			etat1 = false;
		}
		if (randomNum2 == 1) {
			etat2 = true;
		} else {
			etat2 = false;
		}
		if (randomNum3 == 1) {
			etat3 = true;
		} else {
			etat3 = false;
		}
		if (randomNum4 == 1) {
			etat4 = true;
		} else {
			etat4 = false;
		}
		if (randomNum5 == 1) {
			etat5 = true;
		} else {
			etat5 = false;
		}
		if (randomNum6 == 1) {
			etat6 = true;
		} else {
			etat6 = false;
		}
		if (randomNum7 == 1) {
			etat7 = true;
		} else {
			etat7 = false;
		}
		if (randomNum8 == 1) {
			etat8 = true;
		} else {
			etat8 = false;
		}
		//
		Chambre chambre1 = new Chambre("single", etat1, 11, 60, reservation1);
		Chambre chambre2 = new Chambre("single", etat2, 22, 30, reservation2);// false(0) occupé / true(1) vide
		Chambre chambre3 = new Chambre("twin", etat3, 33, 30, reservation3);
		Chambre chambre4 = new Chambre("twin", etat4, 44, 30, reservation4);
		Chambre chambre5 = new Chambre("double", etat5, 55, 60, reservation5);
		Chambre chambre6 = new Chambre("double", etat6, 66, 30, reservation6);// false(0) occupé / true(1) vide
		Chambre chambre7 = new Chambre("suite", etat7, 77, 30, reservation7);
		Chambre chambre8 = new Chambre("suite", etat8, 88, 30, reservation8);

		ArrayList<Chambre> arrayChambre = new ArrayList<>();
		arrayChambre.add(chambre1);
		arrayChambre.add(chambre2);
		arrayChambre.add(chambre3);
		arrayChambre.add(chambre4);
		arrayChambre.add(chambre5);
		arrayChambre.add(chambre6);
		arrayChambre.add(chambre7);
		arrayChambre.add(chambre8);

		// public Hotel(ArrayList<Chambre> arrayChambre) {
		Hotel hotel = new Hotel(arrayChambre);
		// ===

		while (end == false) {
			System.out.println("\n----------------MENU HOTEL CDA JAVA-----------------------");
			System.out.println("A- Afficher l'etat de l'hotel");
			System.out.println("B- Afficher le nombre de chambres réservées");
			System.out.println("C- Affciher le nombre de chambres libres");
			System.out.println("D- Afficher le numero de la première chambre vide");
			System.out.println("E- Afficher le numero de la dernière chambre vide");
			System.out.println("F- Reserver une  chambre ");// Le programme doit reserver la première chambre vode
			System.out.println("G- Liberer une chambre");// Doit liberer une chambre oqp
			System.out.println("Q- Quitter");

			System.out.println("-----------------------------------------------------------");

			System.out.println(" Votre Choix : ");

			Scanner sc = new Scanner(System.in);

			choix = sc.nextLine().toUpperCase();

			switch (choix) {
			case "Q":
				System.out.println("Au revoir !");
				end = true;
				break;
			case "A":
				// Affcher etat de lhotel
				for (int i = 0; i < hotel.afficheretatHotel().length; i++) {

					System.out.println(hotel.afficheretatHotel()[i]);
				}
				break;
			case "B":
				System.out.println("Nombre de chambres reservées : " + hotel.nbChambreReservee());
				break;
			case "C":
				System.out.println("Nombre de chambres libres : " + hotel.nbChambreLibre());
				break;
			case "D":
				// int premiereChambreVide_single = 0, premiereChambreVide_twin = 0,
				// premiereChambreVide_double = 0, premiereChambreVide_suite = 0;
				if (hotel.afficherPremiereChambreVide()[0] == 0) {
					System.out.println("Il n'y a plus de chambre Single vides !");
				} else {
					System.out.println(
							"Le numéro de la première chambre Single vide : " + hotel.afficherPremiereChambreVide()[0]);
				}

				if (hotel.afficherPremiereChambreVide()[1] == 0) {
					System.out.println("Il n'y a plus de chambre Twin vides !");
				} else {
					System.out.println(
							"Le numéro de la première chambre Twin vide : " + hotel.afficherPremiereChambreVide()[1]);
				}

				if (hotel.afficherPremiereChambreVide()[2] == 0) {
					System.out.println("Il n'y a plus de chambre Double vides !");
				} else {
					System.out.println(
							"Le numéro de la première chambre Double vide : " + hotel.afficherPremiereChambreVide()[2]);
				}

				if (hotel.afficherPremiereChambreVide()[3] == 0) {
					System.out.println("Il n'y a plus de chambre Suite vides !");
				} else {
					System.out.println(
							"Le numéro de la première chambre Suite vide : " + hotel.afficherPremiereChambreVide()[3]);
				}
				break;
			case "E":
				// int derniereChambreVide_single = 0, derniereChambreVide_twin = 0,
				// derniereChambreVide_double = 0, derniereChambreVide_suite = 0;
				if (hotel.afficherDerniereChambreVide()[0] == 0) {
					System.out.println("Il n'y a plus de chambre Single vides !");
				} else {
					System.out.println(
							"Le numéro de la derniere chambre Single vide : " + hotel.afficherDerniereChambreVide()[0]);
				}

				if (hotel.afficherDerniereChambreVide()[1] == 0) {
					System.out.println("Il n'y a plus de chambre Twin vides !");
				} else {
					System.out.println(
							"Le numéro de la derniere chambre Twin vide : " + hotel.afficherDerniereChambreVide()[1]);
				}

				if (hotel.afficherDerniereChambreVide()[2] == 0) {
					System.out.println("Il n'y a plus de chambre Double vides !");
				} else {
					System.out.println(
							"Le numéro de la derniere chambre Double vide : " + hotel.afficherDerniereChambreVide()[2]);
				}

				if (hotel.afficherDerniereChambreVide()[3] == 0) {
					System.out.println("Il n'y a plus de chambre Suite vides !");
				} else {
					System.out.println(
							"Le numéro de la derniere chambre Suite vide : " + hotel.afficherDerniereChambreVide()[3]);
				}
				break;
			case "F":// Reserver la premiere chambre vide du type choisie par le client
				hotel.reservePremiereChambreVide();

				break;
			case "G":// Libérer la derniere chambre occupée
				hotel.libererDerniereChambreOccupee();
				break;
			default:
				break;
			}// switch

		}

	}

}
