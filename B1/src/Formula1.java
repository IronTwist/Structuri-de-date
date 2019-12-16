import java.util.Scanner;

public class Formula1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introdu numar de masini: ");
		int nrMasini = scan.nextInt();
		
		int[] masini = new int[nrMasini];
		
		for(int i=0; i < nrMasini; i++) {
			System.out.println("introdu viteza la masina nr " + (i+1));
			masini[i] = scan.nextInt();
		}
		scan.close();
		
		int masiniViteza = 1;
		
		for(int i = 1; i < masini.length; i++) {
			
			if(masini[i-1] > masini[i]) {
				masiniViteza += 1;
			}else if(masini[i-1] == masini[i]){
				masiniViteza += 1;
			}else {
				continue;
			}
			                 
		}
		System.out.print("["); 
		for(int i=0; i < nrMasini-1; i++) {
			System.out.print(masini[i] + ","  );
		}
		System.out.println(masini[nrMasini-1] + "]");
		
		System.out.println(masiniViteza + " masini merg cu viteza maxima.");
		

	}

}
