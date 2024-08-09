package k2_oop2_2022200570.ui;


import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;

import javax.swing.JTabbedPane;

public class MainWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public MainWindow() throws HeadlessException {
		super();
		// TODO Auto-generated constructor stub
	}




	public MainWindow(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}




	public MainWindow(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}




	public MainWindow(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}


	JTabbedPane tabbedPane = new JTabbedPane();

	public void init() {
		this.setTitle("Drugi kolokvijum");
		this.setSize(1200, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Glavna glavnaStranica = new Glavna();
		PrikazProdavac prikazProdavac = new PrikazProdavac();
		PrikazMenadzer prikazMenadzer = new PrikazMenadzer();
		PrikazKvarljiviProizvod prikazKvarljiviProizvod = new PrikazKvarljiviProizvod();
		PrikazKucniAparati prikazKucniAparati = new PrikazKucniAparati();
		
		glavnaStranica.init();
		prikazProdavac.init();
		prikazMenadzer.init();
		prikazKvarljiviProizvod.init();
		prikazKucniAparati.init();
		
		tabbedPane.add("Glavna", glavnaStranica);
		tabbedPane.add("Prodavci", prikazProdavac);
		tabbedPane.add("Menadzeri", prikazMenadzer);
		tabbedPane.add("Kvarljivi proizvodi", prikazKvarljiviProizvod);
		tabbedPane.add("Kucni Aparati", prikazKucniAparati);
		add(tabbedPane);
		
	
		
		this.setVisible(true);
	}
	
}
