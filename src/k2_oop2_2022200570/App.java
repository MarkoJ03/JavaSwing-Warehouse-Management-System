package k2_oop2_2022200570;



import k2_oop2_2022200570.model.UpravljacDatotekama;
import k2_oop2_2022200570.ui.MainWindow;






public class App {
	


	public static void main(String[] args) {

		MainWindow mainWindow= new MainWindow();
		mainWindow.init();
		
		UpravljacDatotekama.citajIzFajla("src/k2_oop2_2022200570/data/objekti.txt");
		

		
	}

}
