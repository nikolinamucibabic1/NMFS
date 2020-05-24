package model;

import java.io.Serializable;

public class Transakcija implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sifraLeka;
	private Korisnik apotekar;
	private int kolicina;
	private String proizvodjac;
	private float cena;
	
	public Transakcija() {
		
	}


	public String getSifraLeka() {
		return sifraLeka;
	}


	public void setSifraLeka(String sifraLeka) {
		this.sifraLeka = sifraLeka;
	}


	public Korisnik getApotekar() {
		return apotekar;
	}

	public void setApotekar(Korisnik apotekar) {
		this.apotekar = apotekar;
	}

	public int getKolicina() {
		return kolicina;
	}

	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}


	public float getCena() {
		return cena;
	}


	public void setCena(float cena) {
		this.cena = cena;
	}


	public String getProizvodjac() {
		return proizvodjac;
	}


	public void setProizvodjac(String proizvodjac) {
		this.proizvodjac = proizvodjac;
	}
	
}
