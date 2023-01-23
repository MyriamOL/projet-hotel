package minihotel.gestion;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class TestHotel {

	public static void main(String[] args) throws ParseException {

		boolean end = false;
		String choix;
		
		//===test :
		//public Reservation(int numReservation, String dateDebut, String dateFin) throws ParseException {
		Reservation reservation1 = new Reservation(1, "20/01/2023", "22/01/2023");
		Reservation reservation2 = new Reservation(2, "22/01/2023", "26/01/2023");
		Reservation reservation3 = new Reservation(3, "22/01/2023", "24/01/2023");

		//public Chambre(String type, Boolean etat, int numChambre, double prix/* , String client */, Reservation reservation){
		Chambre chambre1 = new Chambre("Suite", false, 1, 60, "groupe",reservation1);
		Chambre chambre2 = new Chambre("Single", true, 2, 30,"client", reservation2);// false occupé / true vide
		Chambre chambre3 = new Chambre("Single", false, 20, 30, "societe",reservation3);

		ArrayList<Chambre> arrayChambre = new ArrayList<>();
		arrayChambre.add(chambre1);
		arrayChambre.add(chambre2);
		arrayChambre.add(chambre3);
		
		//public Hotel(ArrayList<Chambre> arrayChambre) {
		Hotel hotel = new Hotel(arrayChambre);
		//===

		while (end == false) {
			System.out.println("\n----------------MENU HOTEL CDA JAVA-----------------------");
			System.out.println("A- Afficher l'etat de l'hotel");
			System.out.println("B- Afficher le nombre de chambres réservées");
			System.out.println("C- Affciher le nombre de chambres libres");
			System.out.println("D- Afficher le numero de la première chambre vide");
			System.out.println("E- Afficher le numero de la dernière chambre vide");
			System.out.println("F- Reserver une  chambre ");// Le programme doit reserver la première chambre vode
			System.out.println("G- Liberer une chambre");// Doit liberer une chambre oqp
			System.out.println("H- Savoir Qui à reservé : ");//
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
				if (hotel.afficherPremiereChambreVide() == 0) {
					System.out.println("Il n'y a plus de chambre vides !");
				} else {
					System.out.println("Le numéro de la première chambre vide : " + hotel.afficherPremiereChambreVide());
				}
				break;
			case "E":
				if (hotel.afficherDerniereChambreVide() == 0) {
					System.out.println("Il n'y a plus de chambre vides !");
				} else {
					System.out.println("Le numéro de la dernière chambre vide : " + hotel.afficherDerniereChambreVide());
				}
				break;
			case "F"://Reserver la premiere chambre vide
				hotel.reservePremiereChambreVide();
				break;
			case "G"://Libérer la derniere chambre occupée
				hotel.libererDerniereChambreOccupee();
				break;
			case "H"://Savoir qui est le client ainsi que la date 
				hotel.quelClientaQuelDate();
				break;
			default:
				break;
			}// switch

		}

	}

}
