package k2_oop2_2022200570.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import k2_oop2_2022200570.ui.PrikazKucniAparati;
import k2_oop2_2022200570.ui.PrikazKvarljiviProizvod;
import k2_oop2_2022200570.ui.PrikazMenadzer;
import k2_oop2_2022200570.ui.PrikazProdavac;

public class UpravljacDatotekama {

	static PrikazProdavac prikazProdavac =  new PrikazProdavac();
	static PrikazKvarljiviProizvod prikazKvarljiviProizvod = new PrikazKvarljiviProizvod();
	static KvarljiviProizvodTableModel modelKvarljiviProizvod =  (KvarljiviProizvodTableModel) prikazKvarljiviProizvod.getTabela().getModel();
	static PrikazMenadzer prikazMenadzer = new PrikazMenadzer();
	static MenadzerTableModel modelMenadzer =  (MenadzerTableModel) prikazMenadzer.getTabela().getModel();
	
	 static ProdavacTableModel modelProdavac =  (ProdavacTableModel) prikazProdavac.getTabela().getModel();
	 static PrikazKucniAparati prikazKucniAparati = new PrikazKucniAparati();
	 static KucniAparatiTableModel modelKucniAparati = (KucniAparatiTableModel) prikazKucniAparati.getTabela().getModel();
	 static Magacin magacinKvarljiviProizvod = PrikazMenadzer.getMagacinKvarljiviProizvod();
	 static Magacin magacinKucniAparati = PrikazMenadzer.getMagacinKucniAparati();
	 
	 
	
	
	public void zapisi(List<Prodavac> prodavci, List<Menadzer> menadzeri,List<KvarljiviProizvod> kvarljiviProizvodi,List<KucniAparati> kucniAparati) throws IOException {
		    File file = new File("src/k2_oop2_2022200570/data/objekti.txt");
		    if (!file.exists()) {
		        file.getParentFile().mkdirs();
		        file.createNewFile();
		    }
		    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
		    	
		        writer.write("START Prodavci\n");

		        
		        prodavci.stream()
		        .map(prodavac -> prodavac.getIme() + "/" + prodavac.getPrezime() + "/" + 
		                         prodavac.getVisinaPlate() + "/" + prodavac.getSifraZaposlenog() + "/" + 
		                         prodavac.getPrimedbe() + "/" + prodavac.getRadnoMesto())
		        .forEach(line -> {
		            try {
		                writer.write(line + "\n");
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        });
		        writer.write("END Prodavci\n");
		        
		        writer.write("START Menadzeri\n");
		        menadzeri.stream()
		        .map(menadzer -> menadzer.getIme() + "/" + menadzer.getPrezime() + "/" + 
		                         menadzer.getVisinaPlate() + "/" + menadzer.getSifraZaposlenog() + 
		                          "/" + menadzer.getMagacin())
		        .forEach(line -> {
		            try {
		                writer.write(line + "\n");
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        });
		   
		        
		        writer.write("END Menadzeri\n");
		        
		        writer.write("START Kvarljivi Proizvodi\n");

		        kvarljiviProizvodi.stream()
		        .map(proizvod -> proizvod.getNaziv() + "/" + proizvod.getCena() + "/" + proizvod.getOpis() + "/" + proizvod.getKategorija() + "/" + proizvod.getProizvodjac() + "/" + proizvod.getRokTrajanja() + "/" + proizvod.getTipAmbalaze())
		        .forEach(line -> {
					try {
						writer.write(line + "\n");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});

		        writer.write("END Kvarljivi Proizvodi\n");
		        
		        writer.write("START Kucni Aparati\n");

		        kucniAparati.stream()
		        .map(proizvodk -> proizvodk.getNaziv() + "/" + proizvodk.getCena() + "/" + proizvodk.getOpis() + "/" + proizvodk.getKategorija() + "/" + proizvodk.getProizvodjac() + "/" + proizvodk.getDimenzije() + "/" + proizvodk.getBoja() + "/"+ proizvodk.getNominalnaSnaga())
		        .forEach(line -> {
					try {
						writer.write(line + "\n");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});

		        writer.write("END Kucni Aparati\n");
		    }
		}
	
	public static void citajIzFajla(String filePath) {
      
        try (BufferedReader reader = new BufferedReader(new FileReader("src/k2_oop2_2022200570/data/objekti.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("START Prodavci")) {
                    while (!(line = reader.readLine()).equals("END Prodavci")) {
                        modelProdavac.dodajProdavca(parseProdavac(line));
                       

                 
                    }
                } else if (line.startsWith("START Kvarljivi Proizvodi")) {
                    while (!(line = reader.readLine()).equals("END Kvarljivi Proizvodi")) {
                        
                        modelKvarljiviProizvod.dodajKvarljiviProizvod(parseKvarljiviProizvod(line));
            			magacinKvarljiviProizvod.dodajProizvod(parseKvarljiviProizvod(line));
                       
                    }
                }else if (line.startsWith("START Menadzeri")) {
                    while (!(line = reader.readLine()).equals("END Menadzeri")) {
                        
                        modelMenadzer.dodajMenadzera(parseMenadzer(line));
                      
                    }
                }else if (line.startsWith("START Kucni Aparati")) {
                    while (!(line = reader.readLine()).equals("END Kucni Aparati")) {
                        
                        modelKucniAparati.dodajKucniAparat(parseKucniAparati(line));
            			magacinKucniAparati.dodajProizvod(parseKucniAparati(line));
                       
                    }

            }
            
        }} catch (IOException e) {
            e.printStackTrace();
        }
     
      
	}
        
        private static Prodavac parseProdavac(String line) {
            String[] tokens = line.split("/");
            return new Prodavac(tokens[0], tokens[1],Double.parseDouble(tokens[2]) ,tokens[3],  tokens[4], tokens[5]);
        }
        
        private static KvarljiviProizvod parseKvarljiviProizvod(String line) {
            String[] tokens = line.split("/");
            return new KvarljiviProizvod(tokens[0], Double.parseDouble(tokens[1]), tokens[2], tokens[3], tokens[4], tokens[5], tokens[6]);
        }
        private static KucniAparati parseKucniAparati(String line) {
            String[] tokens = line.split("/");
          
            return new KucniAparati(tokens[0], Double.parseDouble(tokens[1]), tokens[2], tokens[3], tokens[4], tokens[5], tokens[6], Integer.parseInt(tokens[7]));
        }

        private static Menadzer parseMenadzer(String line) {
            String[] tokens = line.split("/");
            return new Menadzer(tokens[0], tokens[1],Double.parseDouble(tokens[2]) ,tokens[3],  parseMagacin(tokens[4]));
        }

        private static Magacin parseMagacin(String magacinData) {
            ArrayList<Proizvod> proizvodi = new ArrayList<>();

            String proizvodiString = magacinData.replace("Magacin [", "").replace("]]", "");

            String[] proizvodiTokens = proizvodiString.split(", ");
            for (String proizvodToken : proizvodiTokens) {
                Proizvod proizvod = parseProizvod(proizvodToken);
                if (proizvod != null) {
                    proizvodi.add(proizvod);
                }
            }

            return new Magacin(proizvodi);
        }

        private static Proizvod parseProizvod(String proizvodToken) {
            String[] parts = proizvodToken.split(" ", 2);
            String tip = parts[0];

            switch (tip) {
                case "KvarljiviProizvod":
                    
                	return parseKvarljiviProizvodMagacin(parts[1]);
                    
                    
                case "KucniAparati":
                	return parseKucniAparatiMagacin(parts[1]);
                    
                default:
                    return null;
            }
        }

        private static KvarljiviProizvod parseKvarljiviProizvodMagacin(String proizvodData) {
            String[] attributes = proizvodData.split(",");
            String naziv = attributes[0];
            double cena = Double.parseDouble(attributes[1]);
            String opis = attributes[2];
            String kategorija = attributes[3];
            String proizvodjac = attributes[4];
            String rokTrajanja = attributes[5];
            String tipAmbalaze = attributes[6];
            return new KvarljiviProizvod(naziv, cena, opis, kategorija, proizvodjac, rokTrajanja, tipAmbalaze);
        }
        
        private static KucniAparati parseKucniAparatiMagacin(String proizvodData) {
            String[] attributes = proizvodData.split(",");
            String naziv = attributes[0];
            double cena = Double.parseDouble(attributes[1]);
            String opis = attributes[2];
            String kategorija = attributes[3];
            String proizvodjac = attributes[4];
            String dimenzije = attributes[5];
            String boja = attributes[6];
            int nominalnaSnaga = Integer.parseInt(attributes[7]);
            return new KucniAparati(naziv, cena, opis, kategorija, proizvodjac, dimenzije, boja, nominalnaSnaga);
        }

}
