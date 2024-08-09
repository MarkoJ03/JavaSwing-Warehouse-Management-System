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

import k2_oop2_2022200570.model.KucniAparati;
import k2_oop2_2022200570.model.KucniAparatiTableModel;
import k2_oop2_2022200570.model.KvarljiviProizvod;
import k2_oop2_2022200570.model.KvarljiviProizvodTableModel;
import k2_oop2_2022200570.model.Magacin;
import k2_oop2_2022200570.model.MenadzerTableModel;
import k2_oop2_2022200570.model.ProdavacTableModel;
import k2_oop2_2022200570.model.UpravljacDatotekama;

public class PrikazKucniAparati extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame parentFrame;
	
	public PrikazKucniAparati() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PrikazKucniAparati(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public PrikazKucniAparati(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public PrikazKucniAparati(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}
	
	

	public JTable getTabela() {
		return tabela;
	}

	public void setTabela(JTable tabela) {
		this.tabela = tabela;
	}



	private JLabel nazivLabel = new JLabel("Naziv: ");
	private JLabel cenaLabel = new JLabel("Cena: ");
	private JLabel opisLabel = new JLabel("Opis: ");
	private JLabel kategorijaLabel = new JLabel("Kategorija: ");
	private JLabel proizvodjacLabel = new JLabel("Proizvodjac: ");
	private JLabel dimenzijeLabel = new JLabel("Dimenzije: ");
	private JLabel bojaLabel = new JLabel("Boja: ");
	private JLabel nominalnaSnagaLabel = new JLabel("Nominalna snaga: ");
	private JLabel pretraziLabel = new JLabel("Pretraga: ");
	
	private JTextField nazivInput = new JTextField(30);
	private JTextField opisInput = new JTextField(33);
	private JSpinner cenaInput = new JSpinner(new SpinnerNumberModel(0.0,0.0,Double.MAX_VALUE,100));
	private JTextField kategorijaInput = new JTextField(30);
	private JTextField proizvodjacInput = new JTextField(30);
	private JComboBox<String> bojaComboBox = new  JComboBox<String>(new DefaultComboBoxModel<String>());
	private JSpinner nominalnaSnagaInput = new JSpinner(new SpinnerNumberModel(0,0,Integer.MAX_VALUE,100));
	private JTextField dimenzijeInput = new JTextField(30);
	private JTextField pretraziInput = new JTextField(30);
	
	private JButton dugmeDodaj = new JButton("Dodaj");
	private JButton dugmeIzmeni = new JButton("Izmeni");
	private JButton dugmeObrisi = new JButton("Obrisi");
	private JButton dugmePretrazi = new JButton("Pretrazi");
	private JButton dugmeDodajBoju = new JButton("Dodaj boju");
	
	private static KucniAparatiTableModel model = new KucniAparatiTableModel();
	private JTable tabela = new JTable(model);
	private JScrollPane scrollPane = new JScrollPane(tabela);
	TableRowSorter<KucniAparatiTableModel> sorter = new TableRowSorter<>(model);
	
	private SpringLayout layout = new SpringLayout();
	
	
	
	static PrikazProdavac prikazProdavac =  new PrikazProdavac();
	static ProdavacTableModel modelProdavac =  (ProdavacTableModel) prikazProdavac.getTabela().getModel();
	static PrikazMenadzer prikazMenadzer = new PrikazMenadzer();
	static MenadzerTableModel modelMenadzer =  (MenadzerTableModel) prikazMenadzer.getTabela().getModel();
	static PrikazKvarljiviProizvod prikazKvarljiviProizvod = new PrikazKvarljiviProizvod();
	static KvarljiviProizvodTableModel modelKvarljiviProizvod = (KvarljiviProizvodTableModel) prikazKvarljiviProizvod.getTabela().getModel();
	
	
	static Magacin magacinKucniAparati = PrikazMenadzer.getMagacinKucniAparati();
	
    private UpravljacDatotekama upravljacDatotekama = new UpravljacDatotekama();
	
	
	public void dodajBoju(){
		String naziv= JOptionPane.showInputDialog("Unesite boju: ");
		if(naziv != null) {
			bojaComboBox.addItem(naziv);
		}
	}
	
	public KucniAparati getKucniAparati() {
		return new KucniAparati(nazivInput.getText(), ((Double) cenaInput.getValue()), opisInput.getText(), kategorijaInput.getText(), proizvodjacInput.getText(),dimenzijeInput.getText(),(String) bojaComboBox.getSelectedItem(),((Integer) nominalnaSnagaInput.getValue()));
	}
	
	public void init() {
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
		this.add(dugmeDodajBoju);
		this.add(pretraziLabel);
		this.add(pretraziInput);
		this.add(dugmeDodaj);
		this.add(dugmeIzmeni);
		this.add(dugmeObrisi);
		this.add(dugmePretrazi);
		this.add(scrollPane);
		tabela.setRowSorter(sorter);
		bojaComboBox.addItem("Crna");
		bojaComboBox.addItem("Bela");
		bojaComboBox.addItem("Crvena");
		bojaComboBox.addItem("Siva");


	
		
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

		this.layout.putConstraint(SpringLayout.NORTH, dugmeDodajBoju, 0, SpringLayout.NORTH, bojaLabel);
		this.layout.putConstraint(SpringLayout.WEST, dugmeDodajBoju, 20, SpringLayout.EAST, bojaComboBox);
		
		this.layout.putConstraint(SpringLayout.NORTH, dugmeDodaj, 30, SpringLayout.SOUTH, nominalnaSnagaInput);
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
        
		dugmeDodaj.addActionListener(e->{ 
			model.dodajKucniAparat(getKucniAparati());
			magacinKucniAparati.dodajProizvod(getKucniAparati());
		
			try {
				upravljacDatotekama.zapisi(modelProdavac.getProdavci(),modelMenadzer.getMenadzeri(), modelKvarljiviProizvod.getKvarljiviProizvodi(), model.getKucniAparati()); 
			} catch (IOException r) {
			    r.printStackTrace();
			    
			
		}
		});
		
		
		dugmeObrisi.addActionListener(e -> {
		    int[] selectedRows = tabela.getSelectedRows();

		    for (int i = selectedRows.length - 1; i >= 0; i--) {
		        model.ukloniKucniAparat(selectedRows[i]);
		    }
		    try {
				upravljacDatotekama.zapisi(modelProdavac.getProdavci(),modelMenadzer.getMenadzeri(), modelKvarljiviProizvod.getKvarljiviProizvodi(), model.getKucniAparati());		
				} catch (IOException r) {
			    r.printStackTrace();
			    
			}
		});

		dugmeDodajBoju.addActionListener(e-> dodajBoju());
		
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
		        KucniAparati selektovaniKucniAparat = model.getKucniAparatAt(selectedRow);
		        IzmenaKucniAparati izmenaForma = new IzmenaKucniAparati(parentFrame, selektovaniKucniAparat);
		        
		        
		        model.fireTableDataChanged();
		        
		        try {
					upravljacDatotekama.zapisi(modelProdavac.getProdavci(),modelMenadzer.getMenadzeri(), modelKvarljiviProizvod.getKvarljiviProizvodi(), model.getKucniAparati());
					} catch (IOException r) {
				    r.printStackTrace();
				    
				}
		    }
		});
        
	}
}
