package k2_oop2_2022200570.model;

public class KvarljiviProizvod extends Proizvod{

	private String rokTrajanja;
	private String tipAmbalaze;
	
	
	public KvarljiviProizvod(String naziv, Double cena, String opis, String kategorija, String proizvodjac, String rokTrajanja, String tipAmbalaze) {
		super(naziv, cena, opis, kategorija, proizvodjac);
		this.rokTrajanja= rokTrajanja;
		this.tipAmbalaze = tipAmbalaze;
	}


	public String getRokTrajanja() {
		return rokTrajanja;
	}


	public void setRokTrajanja(String rokTrajanja) {
		this.rokTrajanja = rokTrajanja;
	}


	public String getTipAmbalaze() {
		return tipAmbalaze;
	}


	public void setTipAmbalaze(String tipAmbalaze) {
		this.tipAmbalaze = tipAmbalaze;
	}


	@Override
	public String toString() {
		return "KvarljiviProizvod " + super.toString() + "," + rokTrajanja + "," + tipAmbalaze + "]";
	}
	
	
	
}
