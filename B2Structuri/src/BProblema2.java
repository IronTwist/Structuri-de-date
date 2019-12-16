import java.util.Scanner;

public class BProblema2 {

	public static void main(String[] args) {
		int n = citesteNumar("Introdu marime vector: ");
		int k = citesteNumar("Introdu k: ");
		
		int[] tablou = new int[n];
		
		for(int i=0; i < tablou.length; i++) {
			tablou[i] = citesteNumar("Introdu numar: ");
		}
		
		for(int i=0; i < tablou.length; i++) {
			for(int j=0; j < tablou.length; j++) {
				if(i < j){
					if((tablou[i] + tablou[j]) % k == 0) {
						System.out.print("("+ (i+1) + "," + (j+1) + "),");
					}
				}
			}
		}
		
	}//end main
	
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
