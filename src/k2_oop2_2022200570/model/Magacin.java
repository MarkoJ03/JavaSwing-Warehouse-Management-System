package k2_oop2_2022200570.model;

import java.util.ArrayList;

public class Magacin {
	
	private ArrayList<Proizvod> proizvodi;
	
	public void dodajProizvod(Proizvod proizvod) {
		proizvodi.add(proizvod);
	}
	
	public void ukloniProizvod(Proizvod proizvod) {
		proizvodi.remove(proizvod);
	}
	

	public Magacin(ArrayList<Proizvod> proizvodi) {
		super();
		this.proizvodi = proizvodi;
	}

	public ArrayList<Proizvod> getProizvodi() {
		return proizvodi;
	}

	public void setProizvodi(ArrayList<Proizvod> proizvodi) {
		this.proizvodi = proizvodi;
	}

	@Override
	public String toString() {
		
		return "Magacin "+proizvodi;
	}

	public static Magacin parseMagacin(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
