package minihotel.gestion;

import java.text.ParseException;

public class Chambre {
	
	private String type;
	private Boolean etat;
	private int numChambre;
	private double prix;
	private String client;
	private Reservation reservation;
	
	
	public Chambre() {
		super();
	}
	
	
	


	public Chambre(String type, Boolean etat, int numChambre, double prix, String client, Reservation reservation) {
		super();
		this.type = type;
		this.etat = etat;
		this.numChambre = numChambre;
		this.prix = prix;
		this.client = client;
		this.reservation = reservation;
	}


	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Boolean getEtat() {
		return etat;
	}
	public void setEtat(Boolean etat) {
		this.etat = etat;
	}
	public int getNumChambre() {
		return numChambre;
	}
	public void setNumChambre(int numChambre) {
		this.numChambre = numChambre;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}

   public String getClient() {
	   return client;
   }
   
   
   public void setClient(String client) {
		this.type = type;
   }
   
	public Reservation getReservation() {
		return reservation;
	}


	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	
	public double totalPrix() throws ParseException {
		return this.reservation.totalJourReserve() * this.prix;
	}
	@Override
	public String toString() {
		return "Chambre [etat=" + etat + ", numChambre=" + numChambre + ", client=" + client + ", reservation="
				+ reservation + "]";
	}
}
