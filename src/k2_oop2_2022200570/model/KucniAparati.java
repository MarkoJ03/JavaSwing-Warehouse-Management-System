package k2_oop2_2022200570.model;

public class KucniAparati extends Proizvod {

	private String dimenzije;
	private String boja;
	private int nominalnaSnaga;
	
	
	public KucniAparati(String naziv, Double cena, String opis, String kategorija, String proizvodjac, String dimenzije, String boja, int nominalnaSnaga) {
		super(naziv, cena, opis, kategorija, proizvodjac);
		this.dimenzije = dimenzije;
		this.boja = boja;
		this.nominalnaSnaga = nominalnaSnaga;
	}


	public String getDimenzije() {
		return dimenzije;
	}


	public void setDimenzije(String dimenzije) {
		this.dimenzije = dimenzije;
	}


	public String getBoja() {
		return boja;
	}


	public void setBoja(String boja) {
		this.boja = boja;
	}


	public int getNominalnaSnaga() {
		return nominalnaSnaga;
	}


	public void setNominalnaSnaga(int nominalnaSnaga) {
		this.nominalnaSnaga = nominalnaSnaga;
	}


	@Override
	public String toString() {
		return "KucniAparati " + super.toString() + "," + dimenzije + "," + boja +","+nominalnaSnaga+ "]";
	}
	
	
	
}
