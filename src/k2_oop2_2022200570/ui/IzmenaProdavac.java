package k2_oop2_2022200570.ui;

import java.awt.Dimension;


import javax.swing.*;


import k2_oop2_2022200570.model.Prodavac;

public class IzmenaProdavac extends JDialog {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel sifraLabel = new JLabel("Sifra zaposlenog: ");
	private JLabel imeLabel = new JLabel("Ime: ");
	private JLabel prezimeLabel = new JLabel("Prezime:  ");
	private JLabel visinaPlateLabel = new JLabel("Visina plate: ");
	private JLabel primedbeLabel = new JLabel("Primedbe: ");
	private JLabel radnaMestaLabel = new JLabel("Radno mesto: ");
	
	private JTextField imeInput = new JTextField(30);
	private JTextField prezimeInput = new JTextField(30);
	private JTextField sifraInput = new JTextField(30);
	private JSpinner visinaPlateInput = new JSpinner(new SpinnerNumberModel(0.0,0.0,Double.MAX_VALUE,100));
	private JTextField primedbeInput = new JTextField(30);
	private JTextField radnaMesta = new JTextField(30);
	

    private JButton dugmePotvrdi = new JButton("Potvrdi");
    
    private SpringLayout layout = new SpringLayout();
    
    private Prodavac originalniProdavac;
    
    
    
    public Prodavac getOriginalniProdavac() {
		return originalniProdavac;
	}

	public void setOriginalniProdavac(Prodavac originalniProdavac) {
		this.originalniProdavac = originalniProdavac;
	}
	

    
    public IzmenaProdavac(JFrame parentFrame, Prodavac prodavac) {
        super(parentFrame, "Izmena Prodavca", true);
        this.originalniProdavac = prodavac;
        

        setLayout(layout); 

 
		add(imeLabel);
		add(imeInput);
		add(prezimeLabel);
		add(prezimeInput);
		add(visinaPlateLabel);
		add(visinaPlateInput);
		add(primedbeLabel);
		add(primedbeInput);
		add(sifraLabel);
		add(sifraInput);
		add(radnaMestaLabel);
		add(radnaMesta);
		add(dugmePotvrdi);
		setSize(1000,600);
		
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
		
		this.layout.putConstraint(SpringLayout.NORTH, primedbeLabel, 30, SpringLayout.SOUTH, sifraLabel);
		this.layout.putConstraint(SpringLayout.NORTH, primedbeInput, 30, SpringLayout.SOUTH, sifraInput);
		
		this.layout.putConstraint(SpringLayout.EAST, primedbeLabel, 150, SpringLayout.EAST, prezimeInput);
		this.layout.putConstraint(SpringLayout.WEST, primedbeInput, 20, SpringLayout.EAST, primedbeLabel);
		
		this.layout.putConstraint(SpringLayout.NORTH, radnaMestaLabel, 30, SpringLayout.SOUTH, primedbeInput);
		this.layout.putConstraint(SpringLayout.EAST, radnaMestaLabel, 150, SpringLayout.EAST, visinaPlateInput);

		this.layout.putConstraint(SpringLayout.WEST, radnaMesta, 20, SpringLayout.EAST, radnaMestaLabel);
		this.layout.putConstraint(SpringLayout.NORTH, radnaMesta, 30, SpringLayout.SOUTH, primedbeInput);
		
		this.layout.putConstraint(SpringLayout.NORTH, dugmePotvrdi, 30, SpringLayout.SOUTH, visinaPlateInput);
		this.layout.putConstraint(SpringLayout.WEST, dugmePotvrdi, 100, SpringLayout.WEST, this);
		
	

        dugmePotvrdi.addActionListener(e -> potvrdiIzmene());
       
        if (prodavac != null) {
            imeInput.setText(prodavac.getIme());
            prezimeInput.setText(prodavac.getPrezime());
            visinaPlateInput.setValue(prodavac.getVisinaPlate());
            primedbeInput.setText(prodavac.getPrimedbe());
            sifraInput.setText(prodavac.getSifraZaposlenog());
            radnaMesta.setText(prodavac.getRadnoMesto());
            
        }

        setVisible(true);
    }

    public Prodavac izmenjeniProdavac(Prodavac izmenjeni) {
    	return izmenjeni;
    }
    private void potvrdiIzmene() {

        originalniProdavac.setIme(imeInput.getText());
        originalniProdavac.setPrezime(prezimeInput.getText());
        originalniProdavac.setVisinaPlate((Double) visinaPlateInput.getValue());
        originalniProdavac.setPrimedbe(primedbeInput.getText());
        originalniProdavac.setSifraZaposlenog(sifraInput.getText());
        originalniProdavac.setRadnoMesto(radnaMesta.getText());
        

        
        dispose(); 
    }
}
