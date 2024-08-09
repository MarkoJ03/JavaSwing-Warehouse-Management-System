package k2_oop2_2022200570.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class MenadzerTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

ArrayList<Menadzer> menadzeri = new ArrayList<Menadzer>();
	
	
	
	public ArrayList<Menadzer> getMenadzeri() {
		return menadzeri;
	}

	public void setMenadzeri(ArrayList<Menadzer> menadzeri) {
		this.menadzeri = menadzeri;
	}
	
	public Menadzer getProdavacAt(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < menadzeri.size()) {
            return menadzeri.get(rowIndex);
        }
        return null;
    }

	public void dodajMenadzera(Menadzer menadzer){
        menadzeri.add(menadzer);
        fireTableRowsInserted(menadzeri.size()-1, menadzeri.size()-1);
    }

	public void ukloniMenadzera(int i){
	    menadzeri.remove(i);
	    fireTableRowsDeleted(i, i); 
	}
	
	public Menadzer getMenadzerAt(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < menadzeri.size()) {
            return menadzeri.get(rowIndex);
        }
        return null;
    }
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return menadzeri.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public String getColumnName(int columnIndex) {
		if(columnIndex==0) {
            return "Ime";
        }
        if(columnIndex==1) {
            return "Prezime";
        }
        if(columnIndex==2) {
            return "Visina plate";
        }
        if(columnIndex==3) {
            return "Sifra zaposlenog";
        }
        if(columnIndex==4) {
            return "Magacin";
        }
       
       return null;
    }
     


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Menadzer m= menadzeri.get(rowIndex);
		if(columnIndex==0) {
            return m.getIme();
        }
        if(columnIndex==1) {
            return m.getPrezime();
        }
        if(columnIndex==2) {
            return m.getVisinaPlate() + " EUR";
        }
        if(columnIndex==3) {
            return m.getSifraZaposlenog();
        }
        if(columnIndex==4) {
            return m.getMagacin();
        }
       
       return null;
	}

	
}
