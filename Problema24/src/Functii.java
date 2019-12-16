import java.util.Scanner;

public class Functii {
	//................................................................................................................
		public static int[] sortareVect(int[] vector, int k){			//metoda pentru sortarea vectorului in functie de k
			int tmp = 0;
			int sortare = 0;
			int[] tmpArray = new int[vector.length];
			
			for(int i=0; i < tmpArray.length; i++) {			//copiez in vector temporar pentru sortare
				tmpArray[i] = vector[i];
			}
			
			do {												//sortare in functie de  k	descrescator		
				sortare = 0;
				for(int i = 0; i < k-1; i++) {
					if(tmpArray[i] < tmpArray[i+1]) {
						tmp = tmpArray[i];
						tmpArray[i] = tmpArray[i+1];
						tmpArray[i+1] = tmp;
						sortare = 1;
					}	
				}
				
				for(int i = k; i < tmpArray.length - 1; i++) {	//sortare in functie de k crescator
					
					if(tmpArray[i] > tmpArray[i+1]) {
						tmp = tmpArray[i];
						tmpArray[i] = tmpArray[i+1];
						tmpArray[i+1] = tmp;
						sortare = 1;
					}
				}
		
			}while(sortare == 1);
			
			System.out.println("\t\tAfisare vector original introdus in functie:");	//afisare vector original introdus in functie
			System.out.print("\t\t[");
				for(int i = 0; i < vector.length - 1; i++) {
					System.out.print(vector[i] + ",");
				}
			System.out.print(vector[vector.length - 1] + "]\n");
			
			System.out.println("\t\tAfisare vector sortat in functie de k: " + k);	//afisare vector sortat
			System.out.print("\t\t[");
				for(int i = 0; i < k; i++) {
					System.out.print(tmpArray[i] + ",");
				}
				
			System.out.print("|");
			
				for(int i = k; i < tmpArray.length-1; i++) {
					System.out.print(tmpArray[i] + ",");
				}
			System.out.print(tmpArray[tmpArray.length - 1] + "]\n");			///...............end afisare 
				
			return tmpArray;
		}//end sortareVect
		
		//.......................................................................................................
		public static int citesteNumar(String mesaj) {				//functie citire numar de la tastatura
			System.out.print(mesaj);
			
			try {
				
				Scanner scan = new Scanner(System.in);
				int numar = scan.nextInt();
				return numar;
				
			} catch(Exception exp){
				System.out.println("\t\tA aparut o eroare, incearca iar!!");
				return citesteNumar(mesaj);
			}
			
		}//end citesteNumar
		
		//.......................................................................................................
		public static int meniu() {									//Meniu
			int optMeniu;
			System.out.println("1. Introdu vector");
			System.out.println("2. Introdu k");
			System.out.println("3. Afiseaza vector");
			System.out.println("4. Sorteaza vector");
			System.out.println("5. Exit");
			optMeniu = citesteNumar("Alege optiune: ");
			
			return optMeniu;		
		}

}
