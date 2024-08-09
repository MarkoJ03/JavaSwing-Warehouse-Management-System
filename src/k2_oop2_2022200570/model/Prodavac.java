package k2_oop2_2022200570.model;

public class Prodavac extends Zaposleni {

	private String primedbe;
	private String radnoMesto;
	
	
	
	public Prodavac() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Prodavac(String ime, String prezime, Double visinaPlate, String sifraZaposlenog, String primedbe, String radnoMesto) {
		super(ime, prezime, visinaPlate, sifraZaposlenog);
		this.primedbe = primedbe;
		this.radnoMesto = radnoMesto;
	}
	public String getPrimedbe() {
		return primedbe;
	}
	public void setPrimedbe(String primedbe) {
		this.primedbe = primedbe;
	}
	public String getRadnoMesto() {
		return radnoMesto;
	}
	public void setRadnoMesto(String radnoMesto) {
		this.radnoMesto = radnoMesto;
	}
	@Override
	public String toString() {
		return "Prodavac [primedbe=" + primedbe + ", radnoMesto=" + radnoMesto + "]";
	}
	
	
	
}
