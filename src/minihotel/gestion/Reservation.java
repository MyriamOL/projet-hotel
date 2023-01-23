package minihotel.gestion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private int numReservation;
	private Date dateDebut;
	private Date dateFin;

	public Reservation() {
		super();
	}

	public Reservation(int numReservation, String dateDebut, String dateFin) throws ParseException {
		super();
		this.numReservation = numReservation;

		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String date1;
		String date2;

		date1 = dateDebut;
		date2 = dateFin;

		Date date_entre = format.parse(date1);
		Date date_sortie = format.parse(date2);

		this.dateDebut = date_entre;
		this.dateFin = date_sortie;
	}
	// getter /setter

	// Methodes

	public int getNumReservation() {
		return numReservation;
	}

	public void setNumReservation(int numReservation) {
		this.numReservation = numReservation;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public long totalJourReserve() throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String strDate_dateDebut = formatter.format(this.dateDebut);
		String strDate_dateFin = formatter.format(this.dateFin);

		// ====
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Date d1 = sdf.parse(strDate_dateDebut);

		Date d2 = sdf.parse(strDate_dateFin);

		long difference_In_Time = d2.getTime() - d1.getTime();
		long difference_In_Days = TimeUnit.MILLISECONDS.toDays(difference_In_Time) % 365;

		return difference_In_Days;

	}

	@Override
	public String toString() {
		return "Reservation [numReservation=" + numReservation + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin+ "]";
	}

}
