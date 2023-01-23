package minihotel.gestion;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Hotel {
	ArrayList<Chambre> arrayChambre = new ArrayList<>();

	public Hotel(ArrayList<Chambre> arrayChambre) {
		super();
		this.arrayChambre = arrayChambre;
	}

	public Hotel() {
		super();
	}

	public ArrayList<Chambre> getArrayChambre() {
		return arrayChambre;
	}

	public void setArrayChambre(ArrayList<Chambre> arrayChambre) {
		this.arrayChambre = arrayChambre;
	}

	// Methodes
	// Tjrs specifier le string (ici un tableau)

	public String[] afficheretatHotel() throws ParseException {
		String[] etatHotel = new String[arrayChambre.size()];
		String etatChambre;

		for (int i = 0; i < this.arrayChambre.size(); i++) {
			if (arrayChambre.get(i).getEtat() == true) {
				etatChambre = "libre";
				etatHotel[i] = "Chambre numero : [" + arrayChambre.get(i).getNumChambre() + "] Type : ["
						+ arrayChambre.get(i).getType() + "] Prix : [" + arrayChambre.get(i).getPrix() + "]  Etat: ["
						+ etatChambre + "]";

			} else {// Si etatchambre = false (occupé) on affiche une ligne entre (date) sortie
					// (date) + prix total

				//
				//
				etatChambre = "occupé";
				etatHotel[i] = "Chambre numero : [" + arrayChambre.get(i).getNumChambre() + "] Type : ["
						+ arrayChambre.get(i).getType() + "] Prix : [" + arrayChambre.get(i).getPrix() + "]  Etat: ["
						+ etatChambre + "]\n--> Entrée : [" + arrayChambre.get(i).getReservation().getDateDebut()
						+ "] - Sortie: [" + arrayChambre.get(i).getReservation().getDateFin() + "] "
						+ arrayChambre.get(i).getReservation().totalJourReserve() + " jours Total:["
						+ arrayChambre.get(i).totalPrix() + "€]";

			}

		}
		return etatHotel;
	}

	public int nbChambreReservee() {

		// Si etat = false alors faire etat= etat++
		int nbCr = 0;
		for (int i = 0; i < this.arrayChambre.size(); i++) {
			if (arrayChambre.get(i).getEtat() == false) {
				nbCr = nbCr + 1;
			}
		}
		return nbCr;
	}

	public int nbChambreLibre() {
		// Si etat = false alors faire etat= etat++
		int nbCr = 0;
		for (int i = 0; i < this.arrayChambre.size(); i++) {
			if (arrayChambre.get(i).getEtat() == true) {
				nbCr = nbCr + 1;
			}
		}
		return nbCr;
	}

	// Afficher le numéro de la première chambre vide de chaque type
	public int[] afficherPremiereChambreVide() {
		int premiereChambreVide_single = 0, premiereChambreVide_twin = 0, premiereChambreVide_double = 0,
				premiereChambreVide_suite = 0;
		int[] arrayNumsPremieresChambreVides = new int[4];

		for (int i = 0; i < this.arrayChambre.size(); i++) {

			if (arrayChambre.get(i).getType().equals("single")) {// case single
				if (premiereChambreVide_single == 0) {
					if (arrayChambre.get(i).getEtat() == true) {

						premiereChambreVide_single = arrayChambre.get(i).getNumChambre();
						// break;
					}
				}
			} else if (arrayChambre.get(i).getType().equals("twin")) {// case twin
				if (premiereChambreVide_twin == 0) {
					if (arrayChambre.get(i).getEtat() == true) {

						premiereChambreVide_twin = arrayChambre.get(i).getNumChambre();
						// break;
					}
				}
			} else if (arrayChambre.get(i).getType().equals("double")) {// case double
				if (premiereChambreVide_double == 0) {
					if (arrayChambre.get(i).getEtat() == true) {
						premiereChambreVide_double = arrayChambre.get(i).getNumChambre();
						// break;
					}
				}
			} else {// case suite
				if (premiereChambreVide_suite == 0) {
					if (arrayChambre.get(i).getEtat() == true) {
						premiereChambreVide_suite = arrayChambre.get(i).getNumChambre();
						// break;
					}

				}
			} // else

		} // for

		arrayNumsPremieresChambreVides[0] = premiereChambreVide_single;
		arrayNumsPremieresChambreVides[1] = premiereChambreVide_twin;
		arrayNumsPremieresChambreVides[2] = premiereChambreVide_double;
		arrayNumsPremieresChambreVides[3] = premiereChambreVide_suite;

		return arrayNumsPremieresChambreVides;
	}


	public int[] afficherDerniereChambreVide() {
		int derniereChambreVide_single = 0, derniereChambreVide_twin = 0, derniereChambreVide_double = 0,
				derniereChambreVide_suite = 0;
		int[] arrayNumsDerniereChambreVides = new int[4];

		for (int i = 0; i < this.arrayChambre.size(); i++) {

			if (arrayChambre.get(i).getType().equals("single")) {// case single

				if (arrayChambre.get(i).getEtat() == true) {

					derniereChambreVide_single = arrayChambre.get(i).getNumChambre();
					// break;

				}
			} else if (arrayChambre.get(i).getType().equals("twin")) {// case twin

				if (arrayChambre.get(i).getEtat() == true) {

					derniereChambreVide_twin = arrayChambre.get(i).getNumChambre();
					// break;

				}
			} else if (arrayChambre.get(i).getType().equals("double")) {// case double

				if (arrayChambre.get(i).getEtat() == true) {
					derniereChambreVide_double = arrayChambre.get(i).getNumChambre();
					// break;

				}
			} else {// case suite

				if (arrayChambre.get(i).getEtat() == true) {
					derniereChambreVide_suite = arrayChambre.get(i).getNumChambre();
					// break;

				}
			} // else

		} // for

		arrayNumsDerniereChambreVides[0] = derniereChambreVide_single;
		arrayNumsDerniereChambreVides[1] = derniereChambreVide_twin;
		arrayNumsDerniereChambreVides[2] = derniereChambreVide_double;
		arrayNumsDerniereChambreVides[3] = derniereChambreVide_suite;

		return arrayNumsDerniereChambreVides;
	}


	public void reservePremiereChambreVide() {

		int premiereChambreVide_simple = this.afficherPremiereChambreVide()[0];
		int premiereChambreVide_twin = this.afficherPremiereChambreVide()[1];
		int premiereChambreVide_double = this.afficherPremiereChambreVide()[2];
		int premiereChambreVide_suite = this.afficherPremiereChambreVide()[3];

		//
		System.out.println("Quels types de chambre voulez-vous? ( single, twin, double , suite ) : ");
		Scanner sc = new Scanner(System.in);

		String choix = sc.nextLine();
		//

		if (choix.equals("single")) {

			if (this.afficherPremiereChambreVide()[0] != 0) {// cas simple
				for (int i = 0; i < this.arrayChambre.size(); i++) {
					if (arrayChambre.get(i).getNumChambre() == premiereChambreVide_simple) {
						arrayChambre.get(i).setEtat(false);
						break;
					}
				}
				System.out.println("La premiere chambre 'simple' vide est reservée maintenant");
			} else {
				System.out.println(
						"On ne peut pas reserver la première chambre 'simple' vide car Toutes les chambres 'simples' sont occupées !");
			}

		}
		if (choix.equals("twin")) {

			if (this.afficherPremiereChambreVide()[1] != 0) {// cas twin
				for (int i = 0; i < this.arrayChambre.size(); i++) {
					if (arrayChambre.get(i).getNumChambre() == premiereChambreVide_twin) {
						arrayChambre.get(i).setEtat(false);
						break;
					}
				}
				System.out.println("La premiere chambre 'twin' vide est reservée maintenant");
			} else {
				System.out.println(
						"On ne peut pas reserver la première chambre 'twin' vide car Toutes les chambres 'twin' sont occupées !");
			}
		}

		if (choix.equals("double")) {

			if (this.afficherPremiereChambreVide()[2] != 0) {// cas double
				for (int i = 0; i < this.arrayChambre.size(); i++) {
					if (arrayChambre.get(i).getNumChambre() == premiereChambreVide_double) {
						arrayChambre.get(i).setEtat(false);
						break;
					}
				}
				System.out.println("La premiere chambre 'double' vide est reservée maintenant");
			} else {
				System.out.println(
						"On ne peut pas reserver la première chambre 'double' vide car Toutes les chambres 'double' sont occupées !");
			}
		}

		if (choix.equals("suite")) {
			if (this.afficherPremiereChambreVide()[3] != 0) {// cas suite
				for (int i = 0; i < this.arrayChambre.size(); i++) {
					if (arrayChambre.get(i).getNumChambre() == premiereChambreVide_suite) {
						arrayChambre.get(i).setEtat(false);
						break;
					}
				}
				System.out.println("La premiere chambre 'suite' vide est reservée maintenant");
			} else {
				System.out.println(
						"On ne peut pas reserver la première chambre 'suite' vide car Toutes les chambres 'suite' sont occupées !");
			}
		}

	}

	public void libererDerniereChambreOccupee() {
		int indexDeLaDerniereChambreOccupee_simple = 0;
		int indexDeLaDerniereChambreOccupee_twin = 0;
		int indexDeLaDerniereChambreOccupee_double = 0;
		int indexDeLaDerniereChambreOccupee_suite = 0;
		boolean chambreExists_simple = false;boolean chambreExists_twin = false; boolean chambreExists_double = false; boolean chambreExists_suite = false;

		System.out.println("Quel type de chambre voulez-vous liberer? ( single, twin, double , suite ) : ");
		Scanner sc = new Scanner(System.in);

		String choix = sc.nextLine();
		//
		// cas simple
		if (choix.equals("single")) {
			for (int i = 0; i < this.arrayChambre.size(); i++) {
				if (arrayChambre.get(i).getEtat() == false) {
					indexDeLaDerniereChambreOccupee_simple = i;
					chambreExists_simple = true;
				}
			}

			if (chambreExists_simple == true) {
				this.arrayChambre.get(indexDeLaDerniereChambreOccupee_simple).setEtat(true);
				System.out.println("La derniere chambre occupée simple est libéré mainteant");
			} else {
				System.out.println("On ne peux pas libérer la derniere chambre occupée simple car les chambres simple sont tous déjà libres !");
			}
		}

		// cas twin

		if (choix.equals("twin")) {
			for (int i = 0; i < this.arrayChambre.size(); i++) {
				if (arrayChambre.get(i).getEtat() == false) {
					indexDeLaDerniereChambreOccupee_twin = i;
					chambreExists_twin = true;
				}
			}

			if (chambreExists_twin == true) {
				arrayChambre.get(indexDeLaDerniereChambreOccupee_twin).setEtat(true);
				System.out.println("La derniere chambre occupée twin est libéré mainteant");
			} else {
				System.out.println(
						"On ne peux pas libérer la derniere chambre occupée twin car les chambres twin sont tous déjà libres !");
			}
		}
		// cas double

		if (choix.equals("double")) {
			for (int i = 0; i < this.arrayChambre.size(); i++) {
				if (arrayChambre.get(i).getEtat() == false) {
					indexDeLaDerniereChambreOccupee_double = i;
					chambreExists_double = true;
				}
			}

			if (chambreExists_double == true) {
				arrayChambre.get(indexDeLaDerniereChambreOccupee_double).setEtat(true);
				System.out.println("La derniere chambre occupée double est libéré mainteant");
			} else {
				System.out.println(
						"On ne peux pas libérer la derniere chambre occupée double car les chambres double sont tous déjà libres !");
			}

			// cas suite
			if (choix.equals("suite")) {
				for (int i = 0; i < this.arrayChambre.size(); i++) {
					if (arrayChambre.get(i).getEtat() == false) {
						indexDeLaDerniereChambreOccupee_suite = i;
						chambreExists_suite = true;
					}
				}

				if (chambreExists_suite == true) {
					arrayChambre.get(indexDeLaDerniereChambreOccupee_suite).setEtat(true);
					System.out.println("La derniere chambre occupée suite est libéré mainteant");
				} else {
					System.out.println(
							"On ne peux pas libérer la derniere chambre occupée suite car les chambres suite sont tous déjà libres !");
				}
			}
		}
	}

}
// class
