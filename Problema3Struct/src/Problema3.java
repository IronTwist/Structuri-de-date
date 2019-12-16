import java.util.Scanner;

/*
 * 
 * Casa lui Sam se găsește între 2 copaci: un măr și un portocal  și amândoi copaci produc multe 
fructe. Casa lui Sam se întinde între 2 puncte pe stradă, punctele  s  și  t, iar copacii se găsesc la 
punctele a și  b. Mărul este în stânga casei (deci  a < s) și portocala este în dreapta casei (deci  b  > 
t).  Când un fruct cade  dintr-un copac, el aterizează la o distanță  d  de la copac. O valoare 
negativă înseamnă că fructul a căzut în stânga copacului, iar o valoare pozitivă înseamnă că 
fructul a căzut în dreapta. Citind de la tastatură valorile  s, t, a  și  b, urmate de numărul de mere 
(și distanțele la care merele au căzut față de copac) și numărul de portocale (și distanțele la care 
portocalele au căzut față de copac) determinați câte fructe au căzut pe casa lui Sam.
 */

public class Problema3 {

	public static void main(String[] args) {
		int s, t, a, b;
		
		int nrAMere;
		int distanteMere;
		int mereCazutePeCasa = 0;
		
		int nrBPortocale;
		int distantePortocale;
		int portocaleCazutePeCasa = 0;
		
		int index = 1;
		
		s = citiretastatura("Introdu marginea casei din stanga: ");
		
		do {
			t = citiretastatura("Introdu marginea casei din dreapta: ");
			if(t <= s) {
				System.out.println("Atentie! Marginea din dreapta trebuie sa fie mai mare decat cea din stanga.");
			}
		}while(t <= s);
		
		do {
			a = citiretastatura("Introdu pozitia marului: ");
				if(a >= s) {
					System.out.println("Atentie! marul nu poate fi in acelasi loc cu casa.");
				}
		}while(a >= s);
		
		do {
			b = citiretastatura("Introdu pozitia portocalului: ");
			if(b <= t) {
				System.out.println("Atentie! portocalul nu poate fi in acelasi loc cu casa");
			}
		}while(b <= t);
		System.out.println("\n");
		//..................................................................................................................
		
		nrAMere = citiretastatura("Introdu numarul de mere care cad: ");   //5
		
			do {
				System.out.print("\tIntrodu distanta la care cade marul " + index + ": ");
				
				distanteMere = citiretastatura("");
					if((distanteMere + a) >= s){
						System.out.println("Acest mar a cazut pe casa!!!");
						mereCazutePeCasa++;
					}
				index++;
			}while(index <= nrAMere);  // 1...5
			
			
			nrBPortocale = citiretastatura("Introdu numarul de portocale care cad: ");
			index = 1;
			
			do {
				System.out.print("\t Introdu distanta la care cade portocala " + index + ": ");
				
				distantePortocale = citiretastatura("");
					if((distantePortocale + b) <= t) {
						System.out.println("Aceasta portocala a cazut pe casa!!!");
						portocaleCazutePeCasa++;
					}
				
				index++;
			}while(index <= nrBPortocale);
			//...........................................................................Afisare casa si pomi
			System.out.println("\n\t\t Reprezentare casa si pomi \n");
			int lungime = t+5;
			int[] reprezentare = new int[lungime];
			
			System.out.print("\t\t[");
			for(int i=0; i < lungime; i++) {
				if(i == s) {
					reprezentare[i] = s;
				}
				if(i == t) {
					reprezentare[i] = t;
				}
				if(i == a) {
					reprezentare[i] = a;
				}
				if(i == b) {
					reprezentare[i] = b;
				}
				System.out.print(reprezentare[i] +", ");
			}
			System.out.print("]\n\n");
			
			System.out.println("\t\tNumarul de mere cazute pe casa este: " + mereCazutePeCasa);
			System.out.println("\t\tNumarul de portocale cazute pe casa este: " + portocaleCazutePeCasa);
			System.out.println("\n\t\tPe casa lui Sam au cazut " + (mereCazutePeCasa + portocaleCazutePeCasa) + " fructe.");

	} //end main
	
	public static int citiretastatura(String str) {				//......................citire method
		System.out.print(str);
		
		try {
			Scanner scan = new Scanner(System.in);
			
			return scan.nextInt();
			
		}catch(Exception exp) {
			System.out.println("Atentie!! datele introduse nu sunt valide.");
			return citiretastatura(str);
		}
	}

}
