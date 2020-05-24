package model;

import java.io.Serializable;

public class Korisnik implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String korisnickoIme;
	public String lozinka;
	public String ime;
	public String prezime;
	public TipKorisnika tipKorisnika;
	
	public Korisnik() {
		
	}
	
	public Korisnik(String korisnickoIme,String lozinka,String ime, String prezime, TipKorisnika tipKorisnika) {
		this.korisnickoIme = korisnickoIme;
		this.ime = ime;
		this.lozinka = lozinka;
		this.prezime = prezime;
		this.tipKorisnika = tipKorisnika;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public TipKorisnika getTipKorisnika() {
		return tipKorisnika;
	}

	public void setTipKorisnika(TipKorisnika tipKorisnika) {
		this.tipKorisnika = tipKorisnika;
	}
	
	
	

}
