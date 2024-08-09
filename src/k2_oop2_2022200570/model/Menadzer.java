 package k2_oop2_2022200570.model;

public class Menadzer extends Zaposleni {
	
	private Magacin magacin;

	public Menadzer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Menadzer(String ime, String prezime, Double visinaPlate, String sifraZaposlenog, Magacin magacin) {
		super(ime, prezime, visinaPlate, sifraZaposlenog);
		this.magacin = magacin;
	}

	public Magacin getMagacin() {
		return magacin;
	}

	public void setMagacin(Magacin magacin) {
		this.magacin = magacin;
	}

	@Override
	public String toString() {
		return "Menadzer [magacin=" + magacin + "]";
	}
	
	
	
	
	
	
	
}
