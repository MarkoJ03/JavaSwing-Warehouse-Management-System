package k2_oop2_2022200570.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class KvarljiviProizvodTableModel extends AbstractTableModel {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<KvarljiviProizvod> kvarljiviProizvodi = new ArrayList<KvarljiviProizvod>();
	
	
	
	public ArrayList<KvarljiviProizvod> getKvarljiviProizvodi() {
		return kvarljiviProizvodi;
	}

	public void setKvarljiviProizvodi(ArrayList<KvarljiviProizvod> kvarljiviProizvodi) {
		this.kvarljiviProizvodi = kvarljiviProizvodi;
	}

	public void dodajKvarljiviProizvod(KvarljiviProizvod proizvod){
        kvarljiviProizvodi.add(proizvod);
        fireTableRowsInserted(kvarljiviProizvodi.size()-1, kvarljiviProizvodi.size()-1);
    }

    public void ukloniKvarljiviProizvod(int i){
    	kvarljiviProizvodi.remove(i);
        fireTableRowsDeleted(i,i);

    }
    
    public KvarljiviProizvod getKvarljiviProizvodAt(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < kvarljiviProizvodi.size()) {
            return kvarljiviProizvodi.get(rowIndex);
        }
        return null;
    }
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return kvarljiviProizvodi.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public String getColumnName(int columnIndex) {
		if(columnIndex==0) {
            return "Naziv";
        }
        if(columnIndex==1) {
            return "Cena";
        }
        if(columnIndex==2) {
            return "Opis";
        }
        if(columnIndex==3) {
            return "Kategorija";
        }
        if(columnIndex==4) {
            return "Proizvodjac";
        }
        if(columnIndex==5) {
            return "Rok";
        }
        if(columnIndex==6) {
            return "Ambalaza";
        }
       return null;
    }
     



	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		KvarljiviProizvod p= kvarljiviProizvodi.get(rowIndex);
		if(columnIndex==0) {
            return p.getNaziv();
        }
        if(columnIndex==1) {
            return p.getCena() + " RSD";
        }
        if(columnIndex==2) {
            return p.getOpis();
        }
        if(columnIndex==3) {
            return p.getKategorija();
        }
        if(columnIndex==4) {
            return p.getProizvodjac();
        }
        if(columnIndex==5) {
            return p.getRokTrajanja();
        }
        if(columnIndex==6) {
            return p.getTipAmbalaze();
        }
       return null;
	}

	}

