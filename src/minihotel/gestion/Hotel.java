package minihotel.gestion;

import java.text.ParseException;
import java.util.ArrayList;

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
				etatHotel[i] = "Chambre numero : [" + i + "] Type : [" + arrayChambre.get(i).getType() + "] Prix : ["
						+ arrayChambre.get(i).getPrix() + "]  Etat: [" + etatChambre + "]";

			} else {// Si etatchambre = false (occupé) on affiche une ligne entre (date) sortie
					// (date) + prix total

				//
				//
				etatChambre = "occupé";
				etatHotel[i] = "Chambre numero : [" + i + "] Type : [" + arrayChambre.get(i).getType() + "] Prix : ["
						+ arrayChambre.get(i).getPrix() + "]  Etat: [" + etatChambre + "]\n--> Entrée : ["
						+ arrayChambre.get(i).getReservation().getDateDebut() + "] - Sortie: ["
						+ arrayChambre.get(i).getReservation().getDateFin() + "] "
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

	public int afficherPremiereChambreVide() {
		int premiereChambreVide = 0;

		for (int i = 0; i < this.arrayChambre.size(); i++) {
			if (arrayChambre.get(i).getEtat() == true) {
				premiereChambreVide = arrayChambre.get(i).getNumChambre();
				break;
			}
		}
		return premiereChambreVide;
	}

	public int afficherDerniereChambreVide() {
		int derniereChambreVide = 0;

		for (int i = 0; i < this.arrayChambre.size(); i++) {
			if (arrayChambre.get(i).getEtat() == true) {
				derniereChambreVide = arrayChambre.get(i).getNumChambre();
			}
		}
		return derniereChambreVide;
	}
	

	public void reservePremiereChambreVide() {
		int premiereChambreVide = this.afficherPremiereChambreVide();
		if(this.afficherPremiereChambreVide() != 0) {
			for (int i = 0; i < this.arrayChambre.size(); i++) {
				if (arrayChambre.get(i).getNumChambre() == premiereChambreVide) {
					arrayChambre.get(i).setEtat(false);
					break;
				}
			}
			System.out.println("La premiere chambre vide est reservée maintenant");
		}else {
			System.out.println("On ne peut pas reserver la première chambre vide car Toutes les chambres sont occupées !");
		}
	}
	
	public void libererDerniereChambreOccupee() {
		int indexDeLaDerniereChambreOccupee = 0;
		boolean chambreExists = false;
		
		for (int i = 0; i < this.arrayChambre.size(); i++) {
			if (arrayChambre.get(i).getEtat() == false) {
				indexDeLaDerniereChambreOccupee = i;
				chambreExists = true;
			}
		}
		
		if (chambreExists == true) {
			arrayChambre.get(indexDeLaDerniereChambreOccupee).setEtat(true);
			System.out.println("La derniere chambre occupée est libéré mainteant");
		} else {
			System.out.println("On ne peux pas libérer la derniere chambre occupée car les chambres sont tous déjà libres !");
		}
	}
	
	
	public void quelClientaQuelDate () {
		String cl=""; 	String info ="";
		for (int i = 0; i < this.arrayChambre.size(); i++) {
			if (arrayChambre.get(i).getEtat() == false) {//oqp
				cl=arrayChambre.get(i).getClient();
//				 info= super.toString();
		
		
			}

				
			}
		System.out.println("" + cl);
			
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}//class
