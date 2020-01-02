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
			System.out.println("6. Analiza lista");
			System.out.println("7. Afisare lista cu suspecti");
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
		
		
	
		do {
			menu = meniu();
			switch(menu) {
				case 1://Incarca lista din fisier
						listaPersoane.removeAll(listaPersoane);
						Pers = CitireDate.citireDinFisier("F:\\GitHub\\Structuri-de-date\\Testare Proiect Jaf\\src\\BazaDate\\Lista1.txt");
						for(int i=0; i< Pers.length; i++) {				//adaug in lista cu persoane
							listaPersoane.add(Pers[i]);
						}
						System.out.println("\t\tDatele s-au citit din fisier");
						lista = 1;
					   break;
				case 2:
						//Adauga date pentru inca o persoana
						listaPersoane.add(new Persoana(
								Integer.parseInt(CitireDate.citesteDate("\t\tIMEI: ")), 
								Integer.parseInt(CitireDate.citesteDate("\t\ttimp: ")), 
								Double.parseDouble(CitireDate.citesteDate("\t\tCoordonata x: ")), 
								Double.parseDouble(CitireDate.citesteDate("\t\tCoordonata y: "))
						));
					   break;
					   
				case 3:	timpJaf = Integer.parseInt(CitireDate.citesteDate("\t\tTimpul in minute: "));
						coordonataX = Double.parseDouble(CitireDate.citesteDate("\t\tCoordonata x: "));
						coordonataY = Double.parseDouble(CitireDate.citesteDate("\t\tCoordonata y: "));
				
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
						System.out.println("\t\tDatele s-au citit din fisier");
						
						System.out.println("\t\tDati noile coordonate");
						coordonataX = Double.parseDouble(CitireDate.citesteDate("\t\t\tCoordonata x: "));
						coordonataY = Double.parseDouble(CitireDate.citesteDate("\t\t\tCoordonata y: "));
						lista = 2;
					   break;
				case 6:	//Analiza lista 
					
					int[] sterge = new int[10];
					int indexSterge = 0;
					
					System.out.println("\n\tAnaliza lista persoane (nr de pers. in lista= " + listaPersoane.size() + ")");
					System.out.println("\t================================================");
					if(lista == 1) {
						for(Persoana p: listaPersoane) {
							int timp = p.getTimestamp();
							
							if(timp == timpJaf) {
								
								System.out.println("\tIMEI: " + p.getIMEI());
								double calcCoord = Math.sqrt(
										Math.pow((p.getxCoordonate() - coordonataX),2) + Math.pow((p.getyCoordonate() - coordonataY),2)
										);
								System.out.println("\t\tCoordonata calculata: " + round(calcCoord, 2));
								if(round(calcCoord, 2) >= (-1.1) &&  round(calcCoord, 2) <= 1.1) {
									System.out.println("\t\t\t IMEI suspect: " + p.getIMEI());
									listaSuspecti.add(p.getIMEI());
								}
							}else {
								System.out.println("\tIMEI: " + p.getIMEI());
								System.out.println("\t\t\tNu e ok timpul\n");
							}
						}//end for
					}else if(lista == 2) {										//analiza lista 2
					//	Iterator<Integer> iter = listaSuspecti.iterator();
						
						for(Persoana p: listaPersoane) {					//parcurg lista cu persoane
							int timp = p.getTimestamp();					//timp persoane
							int imei = p.getIMEI();
		
							for(Integer suspect: listaSuspecti) {			//parcurg lista cu suspecti
								int imeiSuspect = suspect;
								
								if(imei == imeiSuspect) {					//doar daca era suspect la banca
									System.out.println("\t\tImei:" +imei+ " ->Era suspect la banca");
									if(timpJaf + 15 >= timp && timp >= timpJaf + 10) {		//+10-15 minunte
										
											double calcCoord = 0;
											calcCoord = Math.sqrt(
													Math.pow((p.getxCoordonate() - coordonataX),2) + Math.pow((p.getyCoordonate() - coordonataY),2)
													);
											System.out.println("\t\tCoordonata calculata: " + round(calcCoord, 2));
											if(round(calcCoord, 2) >= (-1.1) &&  round(calcCoord, 2) <= 1.1) {
												System.out.println("\t\tIMEI suspect: " + imei);
												System.out.println("\t\t\tRamane suspect in continuare\n");
											}else {
												System.out.println("\t\t\tDar e prea departe de locul 2\n");
												sterge[indexSterge] = imeiSuspect;
												indexSterge++;
											}
									}else{
											System.out.println("\t\tDar timpul nu se potriveste pentru imei: " + imei);
											sterge[indexSterge] = imeiSuspect;
											indexSterge++;
									}
									
								}//end if imei suspect
								
							}// for suspecti
						}//end for persoane
						
					}else {
						System.out.println("\t\tNu ai incarcat nicio lista");
					}
					
					for(int x=0; x < sterge.length; x++) {				//sterg care nu sunt suspecti din lista 
						listaSuspecti.remove(sterge[x]);
					}

					   break;
				case 7:											//Afisare lista cu posibil suspecti
					System.out.println("\t\tLista cu suspecti (" + listaSuspecti.size() + " suspecti in lista)");
					System.out.println("\t\t========================================");
					if (listaSuspecti.isEmpty()) {
						System.out.println("\t\tNu am suspecti");
					}else {
						for(int pS:listaSuspecti) {
							System.out.println("\t\tIMEI: " + pS);
							for(Persoana xp: listaPersoane) {
								
								if(pS == xp.getIMEI()) {
									
									System.out.println("\t\t\tCu coordonate (x,y): (" + xp.getxCoordonate() +","+ xp.getyCoordonate() + ")");
								}
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
