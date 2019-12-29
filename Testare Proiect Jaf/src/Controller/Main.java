package Controller;

import Model.*;
import java.util.*;
import java.lang.Math;
import java.math.BigDecimal;
import java.math.RoundingMode; 

public class Main {
	
	//.......................................................................................................
		public static int meniu() {									//Meniu
			int optMeniu;
			System.out.println("\n1. Incarca lista primita din jurul bancii");
			System.out.println("2. Adauga date pentru inca o persoana");
			System.out.println("3. Introdu timpul si coordonatele la care a avut loc jaful");
			System.out.println("4. Afisare date");
			System.out.println("5. Coordonate a 2-a locatie");
			System.out.println("6. Analiza lista la banca");
			System.out.println("7. Afisare lista cu posibil suspecti");
			System.out.println("8. Exit");
			optMeniu = Integer.parseInt(CitireDate.citesteDate("Alege optiune: "));
			
			return optMeniu;		
		}
	//.......................................................................................................
		public static double round(double value, int places) {
		    if (places < 0) throw new IllegalArgumentException();

		    BigDecimal bd = BigDecimal.valueOf(value);
		    bd = bd.setScale(places, RoundingMode.HALF_UP);
		    return bd.doubleValue();
		}
	
	//.......................................................................................................	
	public static void main(String[] args) {
		int menu;
		int timpJaf=0;
		double coordonataX = 0;
		double coordonataY = 0;
		
		Persoana Pers[]= null;
		Set<Persoana> listaPersoane = new HashSet<Persoana>();
		Set<Integer> listaSuspecti = new HashSet<Integer>();

		do {
			menu = meniu();
			switch(menu) {
				case 1://Incarca lista din fisier
						Pers = CitireDate.citireDinFisier("F:\\GitHub\\Structuri-de-date\\Testare Proiect Jaf\\src\\BazaDate\\Lista1.txt");
						for(int i=0; i< Pers.length; i++) {				//adaug in lista cu persoane
							listaPersoane.add(Pers[i]);
						}
						System.out.println("Datele s-au citit din fisier");
					   break;
				case 2:
						//Adauga date pentru inca o persoana
						listaPersoane.add(new Persoana(
								Integer.parseInt(CitireDate.citesteDate("IMEI: ")), 
								Integer.parseInt(CitireDate.citesteDate("timp: ")), 
								Double.parseDouble(CitireDate.citesteDate("Coordonata x: ")), 
								Double.parseDouble(CitireDate.citesteDate("Coordonata y: "))
						));
					   break;
					   
				case 3:	timpJaf = Integer.parseInt(CitireDate.citesteDate("Timpul in minute: "));
						coordonataX = Double.parseDouble(CitireDate.citesteDate("Coordonata x: "));
						coordonataY = Double.parseDouble(CitireDate.citesteDate("Coordonata y: "));
				
					   break;
				case 4:	//afisare date fisier
						System.out.println("\t\tTimpul in care a avut loc jaful: " + timpJaf);
						System.out.println("\t\tCoordonate jaf la banca (x,y): " + "(" + coordonataX + "," + coordonataY + ")");
					
						for(Persoana x:listaPersoane) {
							System.out.print(x.getIMEI());
							System.out.println(" timp: " + x.getTimestamp());
						}
						
					   break;
				case 5:
					   break;
				case 6:	//Analiza lista la banca
						for(Persoana p: listaPersoane) {
							int timp = p.getTimestamp();
							
							if(timp == timpJaf) {
								System.out.println("Timpul e ok");
								double calcCoord = Math.sqrt(
										Math.pow((p.getxCoordonate() - coordonataX),2) + Math.pow((p.getyCoordonate() - coordonataY),2)
										);
								System.out.println("Coordonata calculata: " + round(calcCoord, 2));
								if(round(calcCoord, 2) >= (-1.1) &&  round(calcCoord, 2) <= 1.1) {
									System.out.println("\t\t IMEI suspect: " + p.getIMEI());
									listaSuspecti.add(p.getIMEI());
								}
							}else {
								System.out.println("Nu e ok timpul");
							}
						}
					
					   break;
				case 7:																		//Afisare lista cu posibil suspecti
						for(int pS:listaSuspecti) {
							System.out.println("\tIMEI: " + pS);
							for(Persoana xp: listaPersoane) {
								
								if(pS == xp.getIMEI()) {
									
									System.out.println("\t\tCu coordonate (x,y): (" + xp.getxCoordonate() +","+ xp.getyCoordonate() + ")");
								}
							}
						}
					   break;
				case 8:System.out.println("Program terminat");
					   break;
				default:
					System.out.println("Optiunea aleasa nu este buna, alege alta!");
					   
			}
			
		}while(menu != 8);//end while
		
		
		
//		Set<Suspect> lista1 = new HashSet<Suspect>();
//		Iterator<Suspect> iter = lista1.iterator();
//		
//		Suspect suspect1 = new Suspect(723,712,2.1,3.1);
//		Suspect suspect2 = new Suspect(223,12,2.4,3.2);
//		Suspect suspect3 = new Suspect(623,423,4.8,2.1);
//		Suspect suspect4 = new Suspect(623,423,4.9,2.1);
//		
//		
//		Suspect suspect5 = new Suspect(Integer.parseInt(citesteDate("IMEI: ")),Integer.parseInt(citesteDate("timp: ")), Double.parseDouble(citesteDate("x: ")),Double.parseDouble(citesteDate("y:")));
//	
//		
//		lista1.add(suspect1);
//		lista1.add(suspect2);
//		lista1.add(suspect3);
//		lista1.add(suspect2);
//		lista1.add(suspect3);
//		lista1.add(suspect4);
//		lista1.add(suspect5);
//		
//		
//		//System.out.println(lista1.size());
//		//System.out.println(lista1);
//		
//		while(iter.hasNext()) {
//			
//			int	x  = iter.next().getIMEI();
//			String str = Integer.toString(x);
//			System.out.println(str);
//		}
//		
//		Set<Suspect> lista2 = new HashSet<Suspect>();
//		
//		for(Suspect s: lista1) {
//			System.out.println(s.getIMEI());
//			
//				if(s.getTimestamp() == 423) {
//					System.out.println("Posibil suspect");
//					lista2.add(s);
//				}else {
//					System.out.println("Nu este suspect");
//				}
//			System.out.println("Time: " + s.getTimestamp());
//			System.out.println("Coordonatele x si y sunt: " + s.getxCoordonate() + " . " + s.getyCoordonate());
//			System.out.println("__________________");
//		}
//		
//		System.out.println(lista2.size());
//		System.out.println("IMEI-ul suspect: ");
//		for(Suspect x : lista2) {
//			System.out.println(x.getIMEI());
//			System.out.print("Coordonata x: " + x.getxCoordonate());
//		}


	}//end main
	
}//end class
