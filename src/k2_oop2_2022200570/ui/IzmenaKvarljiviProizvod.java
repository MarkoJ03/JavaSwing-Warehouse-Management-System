package k2_oop2_2022200570.ui;

import java.awt.Dimension;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpringLayout;

import k2_oop2_2022200570.model.KvarljiviProizvod;

public class IzmenaKvarljiviProizvod extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel nazivLabel = new JLabel("Naziv: ");
	private JLabel cenaLabel = new JLabel("Cena: ");
	private JLabel opisLabel = new JLabel("Opis: ");
	private JLabel kategorijaLabel = new JLabel("Kategorija: ");
	private JLabel proizvodjacLabel = new JLabel("Proizvodjac: ");
	private JLabel rokTrajanjaLabel = new JLabel("Rok trajanja: ");
	private JLabel tipAmbalazeLabel = new JLabel("Tip ambalaze: ");
	
	private JTextField nazivInput = new JTextField(30);
	private JTextField opisInput = new JTextField(30);
	private JTextField rokTrajanjaInput = new JTextField(30);
	private JSpinner cenaInput = new JSpinner(new SpinnerNumberModel(0.0,0.0,Double.MAX_VALUE,100));
	private JTextField kategorijaInput = new JTextField(30);
	private JTextField proizvodjacInput = new JTextField(30);
	private JTextField tipAmbalazeInput = new  JTextField(30);
	
	private JButton dugmePotvrdi = new JButton("Potvrdi");
	
	private SpringLayout layout = new SpringLayout();
	
    private KvarljiviProizvod originalniKvarljiviProizvod;

    
    
    public KvarljiviProizvod getOriginalniKvarljiviProizvod() {
		return originalniKvarljiviProizvod;
	}


	public void setOriginalniKvarljiviProizvod(KvarljiviProizvod originalniKvarljiviProizvod) {
		this.originalniKvarljiviProizvod = originalniKvarljiviProizvod;
	}


	public IzmenaKvarljiviProizvod(JFrame parentFrame, KvarljiviProizvod kvarljiviProizvod) {
        super(parentFrame, "Izmena kvarljivog proizvoda", true);
        this.originalniKvarljiviProizvod = kvarljiviProizvod;
        
        
        
        this.setLayout(layout);
		this.add(nazivLabel);
		this.add(nazivInput);
		this.add(cenaLabel);
		this.add(cenaInput);
		this.add(opisLabel);
		this.add(opisInput);
		this.add(kategorijaLabel);
		this.add(kategorijaInput);
		this.add(proizvodjacLabel);
		this.add(proizvodjacInput);
		this.add(rokTrajanjaLabel);
		this.add(rokTrajanjaInput);
		this.add(tipAmbalazeLabel);
		this.add(tipAmbalazeInput);
		this.add(dugmePotvrdi);
		setSize(1000,600);
		
		Dimension spinnerSize = cenaInput.getPreferredSize();
        spinnerSize.width = nazivInput.getPreferredSize().width;
        cenaInput.setPreferredSize(spinnerSize);
	

		this.layout.putConstraint(SpringLayout.NORTH, nazivLabel, 30, SpringLayout.NORTH, this);
		this.layout.putConstraint(SpringLayout.NORTH, nazivInput, 30, SpringLayout.NORTH, this);
		
		this.layout.putConstraint(SpringLayout.EAST, nazivLabel, 100, SpringLayout.WEST, this);
		this.layout.putConstraint(SpringLayout.WEST, nazivInput, 20, SpringLayout.EAST, nazivLabel);
		
		this.layout.putConstraint(SpringLayout.NORTH, cenaLabel, 30, SpringLayout.SOUTH, nazivLabel);
		this.layout.putConstraint(SpringLayout.NORTH, cenaInput, 30, SpringLayout.SOUTH, nazivInput);
		
		this.layout.putConstraint(SpringLayout.EAST, cenaLabel, 100, SpringLayout.WEST, this);
		this.layout.putConstraint(SpringLayout.WEST, cenaInput, 20, SpringLayout.EAST, cenaLabel);
		
		this.layout.putConstraint(SpringLayout.NORTH, opisLabel, 30, SpringLayout.SOUTH, cenaLabel);
		this.layout.putConstraint(SpringLayout.NORTH, opisInput, 30, SpringLayout.SOUTH, cenaInput);
		
		this.layout.putConstraint(SpringLayout.EAST, opisLabel, 100, SpringLayout.WEST, this);
		this.layout.putConstraint(SpringLayout.WEST, opisInput, 20, SpringLayout.EAST, opisLabel);
		
		this.layout.putConstraint(SpringLayout.NORTH, kategorijaLabel, 30, SpringLayout.NORTH, this);
		this.layout.putConstraint(SpringLayout.NORTH, kategorijaInput, 30, SpringLayout.NORTH, this);
		
		this.layout.putConstraint(SpringLayout.EAST, kategorijaLabel, 150, SpringLayout.EAST, nazivInput);
		this.layout.putConstraint(SpringLayout.WEST, kategorijaInput, 20, SpringLayout.EAST, kategorijaLabel);
		
		this.layout.putConstraint(SpringLayout.NORTH, proizvodjacLabel, 30, SpringLayout.SOUTH, kategorijaLabel);
		this.layout.putConstraint(SpringLayout.NORTH, proizvodjacInput, 30, SpringLayout.SOUTH, kategorijaInput);
		
		this.layout.putConstraint(SpringLayout.EAST, proizvodjacLabel, 150, SpringLayout.EAST, cenaInput);
		this.layout.putConstraint(SpringLayout.WEST, proizvodjacInput, 20, SpringLayout.EAST, proizvodjacLabel);
		
		this.layout.putConstraint(SpringLayout.NORTH, rokTrajanjaLabel, 30, SpringLayout.SOUTH, proizvodjacInput);
		this.layout.putConstraint(SpringLayout.EAST, rokTrajanjaLabel, 150, SpringLayout.EAST, opisInput);

		this.layout.putConstraint(SpringLayout.WEST, rokTrajanjaInput, 20, SpringLayout.EAST, rokTrajanjaLabel);
		this.layout.putConstraint(SpringLayout.NORTH, rokTrajanjaInput, 30, SpringLayout.SOUTH, proizvodjacInput);
		
		this.layout.putConstraint(SpringLayout.NORTH, tipAmbalazeLabel, 30, SpringLayout.SOUTH, rokTrajanjaInput);
		this.layout.putConstraint(SpringLayout.EAST, tipAmbalazeLabel, 150, SpringLayout.EAST, opisInput);
		
		this.layout.putConstraint(SpringLayout.WEST, tipAmbalazeInput, 20, SpringLayout.EAST, tipAmbalazeLabel);
		this.layout.putConstraint(SpringLayout.NORTH, tipAmbalazeInput, 30, SpringLayout.SOUTH, opisInput);
		
		this.layout.putConstraint(SpringLayout.NORTH, dugmePotvrdi, 30, SpringLayout.SOUTH, opisInput);
		this.layout.putConstraint(SpringLayout.WEST, dugmePotvrdi, 100, SpringLayout.WEST, this);
    
    
    
    dugmePotvrdi.addActionListener(e -> potvrdiIzmene());
    
    if (kvarljiviProizvod != null) {
        nazivInput.setText(kvarljiviProizvod.getNaziv());
        opisInput.setText(kvarljiviProizvod.getOpis());
        rokTrajanjaInput.setText(kvarljiviProizvod.getRokTrajanja());
        cenaInput.setValue(kvarljiviProizvod.getCena());
        kategorijaInput.setText(kvarljiviProizvod.getKategorija());
        proizvodjacInput.setText(kvarljiviProizvod.getProizvodjac());
        tipAmbalazeInput.setText(kvarljiviProizvod.getTipAmbalaze());
        
    }

    setVisible(true);
    
}


private void potvrdiIzmene() {

	originalniKvarljiviProizvod.setNaziv(nazivInput.getText());
	originalniKvarljiviProizvod.setOpis(opisInput.getText());
	originalniKvarljiviProizvod.setCena((Double) cenaInput.getValue());
	originalniKvarljiviProizvod.setRokTrajanja(rokTrajanjaInput.getText());
	originalniKvarljiviProizvod.setKategorija(kategorijaInput.getText());
	originalniKvarljiviProizvod.setProizvodjac(proizvodjacInput.getText());
	originalniKvarljiviProizvod.setTipAmbalaze(tipAmbalazeInput.getText());

    dispose(); 
	}
}
