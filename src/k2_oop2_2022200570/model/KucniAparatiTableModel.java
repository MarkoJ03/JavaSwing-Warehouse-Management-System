package k2_oop2_2022200570.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class KucniAparatiTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -922650110105588630L;

	ArrayList<KucniAparati> kucniAparati = new ArrayList<KucniAparati>();
	
	
	
	public ArrayList<KucniAparati> getKucniAparati() {
		return kucniAparati;
	}

	public void setKucniAparati(ArrayList<KucniAparati> kucniAparati) {
		this.kucniAparati = kucniAparati;
	}

	public void dodajKucniAparat(KucniAparati proizvod){
        kucniAparati.add(proizvod);
        fireTableRowsInserted(kucniAparati.size()-1, kucniAparati.size()-1);
    }

    public void ukloniKucniAparat(int i){
    	kucniAparati.remove(i);
        fireTableRowsDeleted(i,i);

    }
    
    public KucniAparati getKucniAparatAt(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < kucniAparati.size()) {
            return kucniAparati.get(rowIndex);
        }
        return null;
    }
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return kucniAparati.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 8;
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
            return "Dimenzije";
        }
        if(columnIndex==6) {
            return "Boja";
        }
        if(columnIndex==7) {
            return "Snaga";
        }
       return null;
    }
     


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		KucniAparati p= kucniAparati.get(rowIndex);
		if(columnIndex==0) {
            return p.getNaziv();
        }
        if(columnIndex==1) { 
            return p.getCena()+ " RSD";
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
            return p.getDimenzije();
        }
        if(columnIndex==6) {
            return p.getBoja();
        }
        if(columnIndex==7) {
            return p.getNominalnaSnaga()+ "W";
        }
       return null;
	}


}
