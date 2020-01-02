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
			System.out.println("5. Incarca a doua lista si noile coordonate");
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
		int lista = 0;
		
		Persoana Pers[]= null;
		Set<Persoana> listaPersoane = new HashSet<Persoana>();
		Set<Integer> listaSuspecti = new HashSet<Integer>();
		Iterator<Integer> iter = listaSuspecti.iterator();
		
	
		do {
			menu = meniu();
			switch(menu) {
				case 1://Incarca lista din fisier
						Pers = CitireDate.citireDinFisier("F:\\GitHub\\Structuri-de-date\\Testare Proiect Jaf\\src\\BazaDate\\Lista1.txt");
						for(int i=0; i< Pers.length; i++) {				//adaug in lista cu persoane
							listaPersoane.add(Pers[i]);
						}
						System.out.println("Datele s-au citit din fisier");
						lista = 1;
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
				case 5:	listaPersoane.removeAll(listaPersoane);
						
						Pers = CitireDate.citireDinFisier("F:\\GitHub\\Structuri-de-date\\Testare Proiect Jaf\\src\\BazaDate\\Lista2.txt");
						for(int i=0; i< Pers.length; i++) {				//adaug in lista cu persoane
							listaPersoane.add(Pers[i]);
						}
						System.out.println("Datele s-au citit din fisier");
						
						System.out.println("Dati noile coordonate");
						coordonataX = Double.parseDouble(CitireDate.citesteDate("Coordonata x: "));
						coordonataY = Double.parseDouble(CitireDate.citesteDate("Coordonata y: "));
						lista = 2;
					   break;
				case 6:	//Analiza lista la banca
					int[] sterge = new int[listaSuspecti.size()];
					
					if(lista == 1) {
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
						}//end for
					}else if(lista == 2) {
						//analiza lista 2
						
						
						for(Persoana p: listaPersoane) {					//parcurg lista cu persoane
							int timp = p.getTimestamp();					//timp persoane
							int imei = p.getIMEI();
							
							while(iter.hasNext()) {					//parcurg lista cu suspecti
								
								if(imei == iter.next()) {					//daca s.IMEI == p.Imei
									System.out.println("Era suspect si la banca");
									if(timpJaf + 15 >= timp && timp >= timpJaf + 10) {
										System.out.println("Era suspect la banca si e suspect in continuare");
										iter.remove();
									}else {
										System.out.println("Era suspect la banca dar e prea departe de locul 2");
										iter.remove();
									}
									
								}else {
									System.out.println("Nu era suspect la banca");
									listaSuspecti.remove(p.getIMEI());
									iter.remove();
								}
								
							}//while for suspecti
						}//end for persoane
						
					}else {
						System.out.println("Nu ai incarcat nicio lista");
					}
					//sterg persoanele care nu sunt suspecte din lista
//					for(int i=0; i < sterge.length; i++) {
//						listaSuspecti.remove(sterge[i]);
//					}
					   break;
				case 7:																		//Afisare lista cu posibil suspecti
					if (listaSuspecti.isEmpty()) {
						System.out.println("Nu am suspecti");
					}
					
					while(iter.hasNext()) {
						System.out.println(iter.next());
					}
					
					System.out.println(">>>>>>>>>>>>>>>>>");
						for(int pS:listaSuspecti) {
							System.out.println("\tIMEI: " + pS);
							for(Persoana xp: listaPersoane) {
								
								if(pS == xp.getIMEI()) {
									
								//	System.out.println("\t\tCu coordonate (x,y): (" + xp.getxCoordonate() +","+ xp.getyCoordonate() + ")");
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

	}//end main
	
}//end class
