import java.util.Scanner;

public class ProblemaB4 {
	
	public static void main(String[] args) {
		int lungimeTablou = citesteNumar("Introdu marime tablou: ");
		
		int[] tablou = new int[lungimeTablou];
		
		for(int i=0; i < tablou.length; i++) {
			tablou[i] = citesteNumar("Introdu numar in tablou: ");
		}
		
		System.out.println("\t\tAfisare tablou: \n");
		System.out.print("[");
		for(int i=0; i < tablou.length; i++) {
			System.out.print(tablou[i]+", ");
		}
		System.out.println(tablou[tablou.length-1]+"]\n");
		
		for(int i=0; i < tablou.length; i++) {
			for(int j=0; j < tablou.length; j++) {
				if(i != j && tablou[i] == tablou[j]) {
					if((i - j) >= 0) {
						if(((i - j)-1) != 0) {
							System.out.println("Distanta pentru "+ tablou[i] +" este: " + ((i - j)-1));
						}else {
							System.out.println("Distanta pentru " + tablou[i] +" este -1");
						}
						
					}
				}
			}
		}
		
		
	}
	
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
	
	
}
