package k2_oop2_2022200570.ui;

import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Glavna extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1580555861596048862L;

	public Glavna() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Glavna(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public Glavna(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public Glavna(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	private JLabel glavnaLabela = new JLabel("Drugi kolokvijum");
	
	public void init() {
		
		this.add(glavnaLabela,BorderLayout.CENTER);
	}
}
