package k2_oop2_2022200570.ui;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpringLayout;

import k2_oop2_2022200570.model.Magacin;
import k2_oop2_2022200570.model.Menadzer;
import k2_oop2_2022200570.model.Prodavac;
import k2_oop2_2022200570.model.Proizvod;
import k2_oop2_2022200570.model.UpravljacDatotekama;

public class IzmenaMenadzer extends JDialog{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Menadzer originalniMenadzer;
	
	public Menadzer getOriginalniMenadzer() {
		return originalniMenadzer;
	}



	public void setOriginalniMenadzer(Menadzer originalniMenadzer) {
		this.originalniMenadzer = originalniMenadzer;
	}
	
	private JLabel sifraLabel = new JLabel("Sifra zaposlenog: ");
	private JLabel imeLabel = new JLabel("Ime: ");
	private JLabel prezimeLabel = new JLabel("Prezime:  ");
	private JLabel visinaPlateLabel = new JLabel("Visina plate: ");
	private JLabel magacinLabel = new JLabel("Magacin: ");
	
	private JTextField imeInput = new JTextField(30);
	private JTextField prezimeInput = new JTextField(30);
	private JTextField sifraInput = new JTextField(30);
	private JSpinner visinaPlateInput = new JSpinner(new SpinnerNumberModel(0.0,0.0,Double.MAX_VALUE,100));
	private JComboBox<Magacin> magacinInput = new JComboBox<Magacin>(new DefaultComboBoxModel<Magacin>());
	
	private JButton dugmePotvrdi = new JButton("Potvrdi");
	
	private SpringLayout layout = new SpringLayout();
    
	UpravljacDatotekama upravljacDatotekama = new UpravljacDatotekama();
	

	static PrikazMenadzer prikazMenadzer = new PrikazMenadzer();
	
	public IzmenaMenadzer(JFrame parentFrame, Menadzer menadzer) {
        super(parentFrame, "Izmena Menadzera", true);
        this.originalniMenadzer = menadzer;
        this.setLayout(layout);
		this.add(imeLabel);
		this.add(imeInput);
		this.add(prezimeLabel);
		this.add(prezimeInput);
		this.add(visinaPlateLabel);
		this.add(visinaPlateInput);
		this.add(sifraLabel);
		this.add(sifraInput);
		this.add(magacinLabel);
		this.add(magacinInput);
		this.add(dugmePotvrdi);
		setSize(1000,600);
		magacinInput.addItem(PrikazMenadzer.getMagacinKvarljiviProizvod());
		magacinInput.addItem(PrikazMenadzer.getMagacinKucniAparati());
		
		Dimension spinnerSize = visinaPlateInput.getPreferredSize();
        spinnerSize.width = prezimeInput.getPreferredSize().width;
        visinaPlateInput.setPreferredSize(spinnerSize);
        
        this.layout.putConstraint(SpringLayout.NORTH, imeLabel, 30, SpringLayout.NORTH, this);
		this.layout.putConstraint(SpringLayout.NORTH, imeInput, 30, SpringLayout.NORTH, this);
		
		this.layout.putConstraint(SpringLayout.EAST, imeLabel, 100, SpringLayout.WEST, this);
		this.layout.putConstraint(SpringLayout.WEST, imeInput, 20, SpringLayout.EAST, imeLabel);
		
		this.layout.putConstraint(SpringLayout.NORTH, prezimeLabel, 30, SpringLayout.SOUTH, imeLabel);
		this.layout.putConstraint(SpringLayout.NORTH, prezimeInput, 30, SpringLayout.SOUTH, imeInput);
		
		this.layout.putConstraint(SpringLayout.EAST, prezimeLabel, 100, SpringLayout.WEST, this);
		this.layout.putConstraint(SpringLayout.WEST, prezimeInput, 20, SpringLayout.EAST, prezimeLabel);
		
		this.layout.putConstraint(SpringLayout.NORTH, visinaPlateLabel, 30, SpringLayout.SOUTH, prezimeLabel);
		this.layout.putConstraint(SpringLayout.NORTH, visinaPlateInput, 30, SpringLayout.SOUTH, prezimeInput);
		
		this.layout.putConstraint(SpringLayout.EAST, visinaPlateLabel, 100, SpringLayout.WEST, this);
		this.layout.putConstraint(SpringLayout.WEST, visinaPlateInput, 20, SpringLayout.EAST, visinaPlateLabel);
		
		this.layout.putConstraint(SpringLayout.NORTH, sifraLabel, 30, SpringLayout.NORTH, this);
		this.layout.putConstraint(SpringLayout.NORTH, sifraInput, 30, SpringLayout.NORTH, this);
		
		this.layout.putConstraint(SpringLayout.EAST, sifraLabel, 150, SpringLayout.EAST, imeInput);
		this.layout.putConstraint(SpringLayout.WEST, sifraInput, 20, SpringLayout.EAST, sifraLabel);
		
		this.layout.putConstraint(SpringLayout.NORTH, magacinLabel, 30, SpringLayout.SOUTH, sifraLabel);
		this.layout.putConstraint(SpringLayout.EAST, magacinLabel, 150, SpringLayout.EAST, prezimeInput);

		this.layout.putConstraint(SpringLayout.WEST, magacinInput, 20, SpringLayout.EAST, sifraLabel);
		this.layout.putConstraint(SpringLayout.NORTH, magacinInput, 30, SpringLayout.SOUTH, sifraLabel);
		
		this.layout.putConstraint(SpringLayout.NORTH, dugmePotvrdi, 30, SpringLayout.SOUTH, visinaPlateInput);
		this.layout.putConstraint(SpringLayout.WEST, dugmePotvrdi, 100, SpringLayout.WEST, this);
		
		dugmePotvrdi.addActionListener(e -> potvrdiIzmene());
	       
        if (menadzer != null) {
            imeInput.setText(menadzer.getIme());
            prezimeInput.setText(menadzer.getPrezime());
            visinaPlateInput.setValue(menadzer.getVisinaPlate());
            sifraInput.setText(menadzer.getSifraZaposlenog());
            magacinInput.setSelectedItem(menadzer.getMagacin());
            
        }

        setVisible(true);
	}	
	public Prodavac izmenjeniProdavac(Prodavac izmenjeni) {
    	return izmenjeni;
    }
    private void potvrdiIzmene() {

        originalniMenadzer.setIme(imeInput.getText());
        originalniMenadzer.setPrezime(prezimeInput.getText());
        originalniMenadzer.setVisinaPlate((Double) visinaPlateInput.getValue());
        originalniMenadzer.setSifraZaposlenog(sifraInput.getText());
        originalniMenadzer.setMagacin((Magacin) magacinInput.getSelectedItem());
        
        
        dispose(); 
    }
}