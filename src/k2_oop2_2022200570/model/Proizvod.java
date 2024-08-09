package k2_oop2_2022200570.model;

public abstract class Proizvod {
	
	private String naziv;
	private Double cena;
	private String opis;
	private String Kategorija;
	private String proizvodjac;
	
	public Proizvod(String naziv, Double cena, String opis, String kategorija, String proizvodjac) {
		super();
		this.naziv = naziv;
		this.cena = cena;
		this.opis = opis;
		Kategorija = kategorija;
		this.proizvodjac = proizvodjac;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Double getCena() {
		return cena;
	}

	public void setCena(Double cena) {
		this.cena = cena;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getKategorija() {
		return Kategorija;
	}

	public void setKategorija(String kategorija) {
		Kategorija = kategorija;
	}

	public String getProizvodjac() {
		return proizvodjac;
	}

	public void setProizvodjac(String proizvodjac) {
		this.proizvodjac = proizvodjac;
	}

	@Override
	public String toString() {
		return    naziv + "," + cena +"," + opis +"," + Kategorija
				+ "," + proizvodjac; 
	}
	
	
	
}
