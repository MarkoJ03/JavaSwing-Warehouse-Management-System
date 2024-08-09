package k2_oop2_2022200570.model;

import java.util.ArrayList;


import javax.swing.table.AbstractTableModel;



public class ProdavacTableModel extends AbstractTableModel  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Prodavac> prodavci = new ArrayList<Prodavac>();
	
	
	
	public ArrayList<Prodavac> getProdavci() {
		return prodavci;
	}

	public void setProdavci(ArrayList<Prodavac> prodavci) {
		this.prodavci = prodavci;
	}

	public void dodajProdavca(Prodavac prodavac){
        prodavci.add(prodavac);
        fireTableRowsInserted(prodavci.size()-1, prodavci.size()-1);
    }

	public void ukloniProdavca(int i){
	    prodavci.remove(i);
	    fireTableRowsDeleted(i, i); 
	}
	
	public Prodavac getProdavacAt(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < prodavci.size()) {
            return prodavci.get(rowIndex);
        }
        return null;
    }
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return prodavci.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 6;
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
            return "Primedbe";
        }
        if(columnIndex==5) {
            return "Radno mesto";
        }
       return null;
    }
     


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Prodavac p= prodavci.get(rowIndex);
		if(columnIndex==0) {
            return p.getIme();
        }
        if(columnIndex==1) {
            return p.getPrezime();
        }
        if(columnIndex==2) {
            return p.getVisinaPlate() + " EUR";
        }
        if(columnIndex==3) {
            return p.getSifraZaposlenog();
        }
        if(columnIndex==4) {
            return p.getPrimedbe();
        }
        if(columnIndex==5) {
            return p.getRadnoMesto();
        }
       return null;
	}


		
	}


