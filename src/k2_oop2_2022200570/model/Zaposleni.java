package k2_oop2_2022200570.model;

public abstract class Zaposleni {
	private String ime;
	private String prezime;
	private Double visinaPlate;
	private String sifraZaposlenog;
	
	public Zaposleni() {
		super();
		
	}

	public Zaposleni(String ime, String prezime, Double visinaPlate, String sifraZaposlenog) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.visinaPlate = visinaPlate;
		this.sifraZaposlenog = sifraZaposlenog;
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

	public Double getVisinaPlate() {
		return visinaPlate;
	}

	public void setVisinaPlate(Double visinaPlate) {
		this.visinaPlate = visinaPlate;
	}

	public String getSifraZaposlenog() {
		return sifraZaposlenog;
	}

	public void setSifraZaposlenog(String sifraZaposlenog) {
		this.sifraZaposlenog = sifraZaposlenog;
	}

	@Override
	public String toString() {
		return "Zaposleni [ime=" + ime + ", prezime=" + prezime + ", visinaPlate=" + visinaPlate + ", sifraZaposlenog="
				+ sifraZaposlenog + "]";
	}
	
	
	
}
