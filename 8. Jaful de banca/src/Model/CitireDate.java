package Model;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CitireDate {
	
	//.......................................................................................................
		public static String citesteDate(String mesaj) {				//functie citire date de la tastatura
			System.out.print(mesaj);
						
			try {
							
					Scanner scan = new Scanner(System.in);
					String txt = scan.next();
					return txt;
							
			} catch(Exception exp){
					System.out.println("\t\tA aparut o eroare, incearca iar!!");
					return citesteDate(mesaj);
			}
						
		}//end citesteNumar
	
	public static Persoana[] citireDinFisier(String url) {
		int nrLinii;   								//nr linii din fisier
		
		Persoana Pe[] = null;
		
		try {
				//String lista1 = "F:\\GitHub\\Structuri-de-date\\Testare Proiect Jaf\\src\\BazaDate\\Lista1.txt";
				//String lista2 = "F:\\GitHub\\Structuri-de-date\\Testare Proiect Jaf\\src\\BazaDate\\Lista2.txt";
				
				BufferedReader fisier = new BufferedReader(new FileReader(url));
				String str = fisier.readLine();
				nrLinii = Integer.parseInt(str);
				
				Pe = new Persoana[nrLinii];				//aloc spatiu in functie de cate persoane am in fisier
				
				System.out.println("Numarul de linii: "+ Pe.length);
				
				int i=0;
				while((str = fisier.readLine()) != null) {			//pentru fiecare linie 
					String bucati[] = str.split(",");
					
					int IMEI = Integer.parseInt(bucati[0]);		//bucata IMEI
					int timestamp = Integer.parseInt(bucati[1]);	//bucata timp
					double coordX = Double.parseDouble(bucati[2]);	//bucata x
					double coordY = Double.parseDouble(bucati[3]);		//bucata y
					
					Pe[i] = new Persoana();						//adaug in Pe[]
					Pe[i].setIMEI(IMEI);
					Pe[i].setTimestamp(timestamp);
					Pe[i].setxCoordonate(coordX);
					Pe[i].setyCoordonate(coordY);
					
					i++;
				}//end while

				fisier.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return Pe;
	}//end citireDinFisier
	
	
	
}
