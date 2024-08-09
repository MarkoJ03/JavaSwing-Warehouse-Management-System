package k2_oop2_2022200570.ui;

import java.awt.Dimension;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpringLayout;

import k2_oop2_2022200570.model.KucniAparati;
import k2_oop2_2022200570.model.KvarljiviProizvod;

public class IzmenaKucniAparati extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 769899685448228406L;

	private JLabel nazivLabel = new JLabel("Naziv: ");
	private JLabel cenaLabel = new JLabel("Cena: ");
	private JLabel opisLabel = new JLabel("Opis: ");
	private JLabel kategorijaLabel = new JLabel("Kategorija: ");
	private JLabel proizvodjacLabel = new JLabel("Proizvodjac: ");
	private JLabel dimenzijeLabel = new JLabel("Dimenzije: ");
	private JLabel bojaLabel = new JLabel("Boja: ");
	private JLabel nominalnaSnagaLabel = new JLabel("Nominalna snaga: ");
	
	private JTextField nazivInput = new JTextField(30);
	private JTextField opisInput = new JTextField(30);
	private JSpinner cenaInput = new JSpinner(new SpinnerNumberModel(0.0,0.0,Double.MAX_VALUE,100));
	private JTextField kategorijaInput = new JTextField(30);
	private JTextField proizvodjacInput = new JTextField(30);
	private JTextField bojaComboBox = new  JTextField(30);
	private JSpinner nominalnaSnagaInput = new JSpinner(new SpinnerNumberModel(0.0,0.0,Double.MAX_VALUE,100));
	private JTextField dimenzijeInput = new JTextField(30);
	
	private SpringLayout layout = new SpringLayout();
	
	private JButton dugmePotvrdi = new JButton("Potvrdi");
	
	private KucniAparati originalniKucniAparat;

	public KucniAparati getOriginalniKucniAparat() {
		return originalniKucniAparat;
	}

	public void setOriginalniKucniAparat(KucniAparati originalniKucniAparat) {
		this.originalniKucniAparat = originalniKucniAparat;
	}
	
	public IzmenaKucniAparati(JFrame parentFrame, KucniAparati kucniAparat) {
        super(parentFrame, "Izmena kucnog aparata", true);
        this.originalniKucniAparat = kucniAparat;
        
        this.setLayout(layout);
		this.add(nazivLabel);
		this.add(nazivInput);
		this.add(cenaLabel);
		this.add(cenaInput);
		this.add(opisLabel);
		this.add(opisInput);
		this.add(nominalnaSnagaLabel);
		this.add(nominalnaSnagaInput);
		this.add(kategorijaLabel);
		this.add(kategorijaInput);
		this.add(proizvodjacLabel);
		this.add(proizvodjacInput);
		this.add(dimenzijeLabel);
		this.add(dimenzijeInput);
		this.add(bojaLabel);
		this.add(bojaComboBox);
		this.add(dugmePotvrdi);	
		setSize(1000,600);
		
		Dimension spinnerSize = cenaInput.getPreferredSize();
        spinnerSize.width = nazivInput.getPreferredSize().width;
        cenaInput.setPreferredSize(spinnerSize);
        nominalnaSnagaInput.setPreferredSize(spinnerSize);
        
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
		
		this.layout.putConstraint(SpringLayout.NORTH, nominalnaSnagaLabel, 30, SpringLayout.SOUTH, opisLabel);
		this.layout.putConstraint(SpringLayout.NORTH, nominalnaSnagaInput, 30, SpringLayout.SOUTH, opisInput);
		
		this.layout.putConstraint(SpringLayout.EAST, nominalnaSnagaLabel, 100, SpringLayout.WEST, this);
		this.layout.putConstraint(SpringLayout.WEST, nominalnaSnagaInput, 20, SpringLayout.EAST, nominalnaSnagaLabel);
		
		this.layout.putConstraint(SpringLayout.NORTH, kategorijaLabel, 30, SpringLayout.NORTH, this);
		this.layout.putConstraint(SpringLayout.NORTH, kategorijaInput, 30, SpringLayout.NORTH, this);
		
		this.layout.putConstraint(SpringLayout.EAST, kategorijaLabel, 150, SpringLayout.EAST, nazivInput);
		this.layout.putConstraint(SpringLayout.WEST, kategorijaInput, 20, SpringLayout.EAST, kategorijaLabel);
		
		this.layout.putConstraint(SpringLayout.NORTH, proizvodjacLabel, 30, SpringLayout.SOUTH, kategorijaLabel);
		this.layout.putConstraint(SpringLayout.NORTH, proizvodjacInput, 30, SpringLayout.SOUTH, kategorijaInput);
		
		this.layout.putConstraint(SpringLayout.EAST, proizvodjacLabel, 150, SpringLayout.EAST, cenaInput);
		this.layout.putConstraint(SpringLayout.WEST, proizvodjacInput, 20, SpringLayout.EAST, proizvodjacLabel);
		
		this.layout.putConstraint(SpringLayout.NORTH, dimenzijeLabel, 30, SpringLayout.SOUTH, proizvodjacInput);
		this.layout.putConstraint(SpringLayout.EAST, dimenzijeLabel, 150, SpringLayout.EAST, opisInput);

		this.layout.putConstraint(SpringLayout.WEST, dimenzijeInput, 20, SpringLayout.EAST, dimenzijeLabel);
		this.layout.putConstraint(SpringLayout.NORTH, dimenzijeInput, 30, SpringLayout.SOUTH, proizvodjacInput);
		
		this.layout.putConstraint(SpringLayout.NORTH, bojaLabel, 30, SpringLayout.SOUTH, dimenzijeInput);
		this.layout.putConstraint(SpringLayout.EAST, bojaLabel, 150, SpringLayout.EAST, opisInput);
		
		this.layout.putConstraint(SpringLayout.WEST, bojaComboBox, 20, SpringLayout.EAST, bojaLabel);
		this.layout.putConstraint(SpringLayout.NORTH, bojaComboBox, 30, SpringLayout.SOUTH, opisInput);

		this.layout.putConstraint(SpringLayout.NORTH, dugmePotvrdi, 30, SpringLayout.SOUTH, nominalnaSnagaInput);
		this.layout.putConstraint(SpringLayout.WEST, dugmePotvrdi, 100, SpringLayout.WEST, this);
		
		 dugmePotvrdi.addActionListener(e -> potvrdiIzmene());
		    
		    if (kucniAparat != null) {
		        nazivInput.setText(kucniAparat.getNaziv());
		        opisInput.setText(kucniAparat.getOpis());
		        dimenzijeInput.setText(kucniAparat.getDimenzije());
		        cenaInput.setValue(kucniAparat.getCena());
		        kategorijaInput.setText(kucniAparat.getKategorija());
		        proizvodjacInput.setText(kucniAparat.getProizvodjac());
		        bojaComboBox.setText(kucniAparat.getBoja());
		        nominalnaSnagaInput.setValue(kucniAparat.getNominalnaSnaga());
		        
		    }

		    setVisible(true);
		    
		}


		private void potvrdiIzmene() {

			originalniKucniAparat.setNaziv(nazivInput.getText());
			originalniKucniAparat.setOpis(opisInput.getText());
			originalniKucniAparat.setCena((Double) cenaInput.getValue());
			originalniKucniAparat.setDimenzije(dimenzijeInput.getText());
			originalniKucniAparat.setKategorija(kategorijaInput.getText());
			originalniKucniAparat.setProizvodjac(proizvodjacInput.getText());
			originalniKucniAparat.setBoja((String) bojaComboBox.getText());

		    dispose(); 
			}
		
		
	}

