package k2_oop2_2022200570.ui;


import java.awt.Dimension;
import java.awt.LayoutManager;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpringLayout;
import javax.swing.table.TableRowSorter;

import k2_oop2_2022200570.model.KucniAparatiTableModel;
import k2_oop2_2022200570.model.KvarljiviProizvodTableModel;
import k2_oop2_2022200570.model.MenadzerTableModel;
import k2_oop2_2022200570.model.Prodavac;
import k2_oop2_2022200570.model.ProdavacTableModel;
import k2_oop2_2022200570.model.UpravljacDatotekama;




public class PrikazProdavac extends JPanel {
	
	   private JFrame parentFrame;

	    public PrikazProdavac(JFrame parentFrame) {
	        this.parentFrame = parentFrame;
	    }

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PrikazProdavac() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PrikazProdavac(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public PrikazProdavac(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public PrikazProdavac(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	
	
	private JLabel sifraLabel = new JLabel("Sifra zaposlenog: ");
	private JLabel imeLabel = new JLabel("Ime: ");
	private JLabel prezimeLabel = new JLabel("Prezime:  ");
	private JLabel visinaPlateLabel = new JLabel("Visina plate: ");
	private JLabel primedbeLabel = new JLabel("Primedbe: ");
	private JLabel radnaMestaLabel = new JLabel("Radno mesto: ");
	private JLabel pretraziLabel = new JLabel("Pretraga: ");

	
	private JTextField imeInput = new JTextField(33);
	private JTextField prezimeInput = new JTextField(30);
	private JTextField sifraInput = new JTextField(30);
	private JSpinner visinaPlateInput = new JSpinner(new SpinnerNumberModel(0.0,0.0,Double.MAX_VALUE,100));
	private JTextField primedbeInput = new JTextField(30);
	private JTextField pretraziInput = new JTextField(30);
	private JComboBox<String> radnaMesta = new JComboBox<String>(new DefaultComboBoxModel<String>());
	
	private JButton dugmeDodaj = new JButton("Dodaj");
	private JButton dugmeIzmeni = new JButton("Izmeni");
	private JButton dugmeObrisi = new JButton("Obrisi");
	private JButton dugmePretrazi = new JButton("Pretrazi");
	private JButton dugmeDodajRadnoMesto = new JButton("Dodaj novo radno mesto ");
	
	private static ProdavacTableModel model = new ProdavacTableModel();
	private JTable tabela = new JTable(model);
	TableRowSorter<ProdavacTableModel> sorter = new TableRowSorter<>(model);
	private JScrollPane scrollPane = new JScrollPane(tabela);
	
	private SpringLayout layout = new SpringLayout();
	
	
	static PrikazKvarljiviProizvod prikazKvarljiviProizvod = new PrikazKvarljiviProizvod();
	static KvarljiviProizvodTableModel modelKvarljiviProizvod =  (KvarljiviProizvodTableModel) prikazKvarljiviProizvod.getTabela().getModel();
	static PrikazMenadzer prikazMenadzer = new PrikazMenadzer();
	static MenadzerTableModel modelMenadzer =  (MenadzerTableModel) prikazMenadzer.getTabela().getModel();
	static PrikazKucniAparati prikazKucniAparati = new PrikazKucniAparati();
	static KucniAparatiTableModel modelKucniAparati = (KucniAparatiTableModel) prikazKucniAparati.getTabela().getModel();
	
	
	
	public JTable getTabela() {
		return tabela;
	}

	public void setTabela(JTable tabela) {
		this.tabela = tabela;
	}

	public Prodavac getProdavac() {
		return new Prodavac(imeInput.getText(), prezimeInput.getText(), ((Double) visinaPlateInput.getValue()), sifraInput.getText(), primedbeInput.getText(),(String) radnaMesta.getSelectedItem());
	}
	
	public void dodajRadnoMesto(){
		String naziv= JOptionPane.showInputDialog("Unesite naziv radnog mesta: ");
		if(naziv != null) {
			radnaMesta.addItem(naziv);
		}
	}
	UpravljacDatotekama upravljacDatotekama = new UpravljacDatotekama();
	public void init() {
		this.setLayout(layout);
		this.add(imeLabel);
		this.add(imeInput);
		this.add(prezimeLabel);
		this.add(prezimeInput);
		this.add(visinaPlateLabel);
		this.add(visinaPlateInput);
		this.add(primedbeLabel);
		this.add(primedbeInput);
		this.add(sifraLabel);
		this.add(sifraInput);
		this.add(radnaMestaLabel);
		this.add(radnaMesta);
		this.add(dugmeDodajRadnoMesto);
		this.add(dugmeDodaj);
		this.add(dugmeObrisi);
		this.add(dugmeIzmeni);
		this.add(pretraziLabel);
		this.add(pretraziInput);
		this.add(dugmePretrazi);
		tabela.setRowSorter(sorter);
		this.add(scrollPane);
		radnaMesta.addItem("Novi Sad");
		radnaMesta.addItem("Beograd");
		radnaMesta.addItem("Vrsac");
		
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
		
		this.layout.putConstraint(SpringLayout.NORTH, dugmeDodajRadnoMesto, 0, SpringLayout.NORTH, radnaMestaLabel);
		this.layout.putConstraint(SpringLayout.WEST, dugmeDodajRadnoMesto, 20, SpringLayout.EAST, radnaMesta);
		
		this.layout.putConstraint(SpringLayout.NORTH, dugmeDodaj, 30, SpringLayout.SOUTH, visinaPlateInput);
		this.layout.putConstraint(SpringLayout.WEST, dugmeDodaj, 100, SpringLayout.WEST, this);
		
		this.layout.putConstraint(SpringLayout.NORTH, pretraziLabel, 30, SpringLayout.SOUTH, dugmeDodaj);
		this.layout.putConstraint(SpringLayout.WEST, pretraziLabel, 350, SpringLayout.WEST, this);
		
		this.layout.putConstraint(SpringLayout.NORTH, pretraziInput, 0, SpringLayout.NORTH, pretraziLabel);
		this.layout.putConstraint(SpringLayout.WEST, pretraziInput, 30, SpringLayout.EAST, pretraziLabel);
		
		this.layout.putConstraint(SpringLayout.NORTH, dugmePretrazi, 0, SpringLayout.NORTH, pretraziLabel);
		this.layout.putConstraint(SpringLayout.WEST, dugmePretrazi, 30, SpringLayout.EAST, pretraziInput);
		
		this.layout.putConstraint(SpringLayout.NORTH, dugmeIzmeni, 0, SpringLayout.NORTH, pretraziLabel);
		this.layout.putConstraint(SpringLayout.WEST, dugmeIzmeni, 20, SpringLayout.EAST, dugmePretrazi);
		
		this.layout.putConstraint(SpringLayout.NORTH, dugmeObrisi, 0, SpringLayout.NORTH, pretraziLabel);
		this.layout.putConstraint(SpringLayout.WEST, dugmeObrisi, 20, SpringLayout.EAST, dugmeIzmeni);
		
		this.layout.putConstraint(SpringLayout.SOUTH, scrollPane, 0, SpringLayout.SOUTH, this);
		this.layout.putConstraint(SpringLayout.NORTH, scrollPane, 20, SpringLayout.SOUTH, pretraziInput);
		this.layout.putConstraint(SpringLayout.WEST, scrollPane, 400, SpringLayout.WEST, this);


		dugmeDodaj.addActionListener(e-> {
			model.dodajProdavca(getProdavac());
			try {
				upravljacDatotekama.zapisi(model.getProdavci(),modelMenadzer.getMenadzeri(), modelKvarljiviProizvod.getKvarljiviProizvodi(), modelKucniAparati.getKucniAparati()); 
			} catch (IOException r) {
			    r.printStackTrace();
			}
		});
	
			
		
		dugmeObrisi.addActionListener(e -> {
		    int[] selectedRows = tabela.getSelectedRows();

		    for (int i = selectedRows.length - 1; i >= 0; i--) {
		        model.ukloniProdavca(selectedRows[i]);
		    }	
		    try {
				upravljacDatotekama.zapisi(model.getProdavci(),modelMenadzer.getMenadzeri(), modelKvarljiviProizvod.getKvarljiviProizvodi(), modelKucniAparati.getKucniAparati());		
				} catch (IOException r) {
			    r.printStackTrace();
			}
		});

		dugmeDodajRadnoMesto.addActionListener(e-> dodajRadnoMesto());
		
		dugmePretrazi.addActionListener(e -> {
		    String text = pretraziInput.getText();
		    if (text.trim().length() == 0) {
		        sorter.setRowFilter(null);
		    } else {
		        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
		    }
		});
		
		dugmeIzmeni.addActionListener(e -> {
		    int selectedRow = tabela.getSelectedRow();
		    if (selectedRow >= 0) {
		        Prodavac selektovaniProdavac = model.getProdavacAt(selectedRow);
		        IzmenaProdavac izmenaForma = new IzmenaProdavac(parentFrame, selektovaniProdavac);
		        Prodavac novi=izmenaForma.getOriginalniProdavac();
		        model.fireTableDataChanged();
		        
		        try {
					upravljacDatotekama.zapisi(model.getProdavci(),modelMenadzer.getMenadzeri(), modelKvarljiviProizvod.getKvarljiviProizvodi(), modelKucniAparati.getKucniAparati());
					} catch (IOException r) {
				    r.printStackTrace();
				}
		    }
		});
		
		


		this.setVisible(true);
		
	}
}


