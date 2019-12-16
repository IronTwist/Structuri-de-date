import java.util.Scanner;

public class Problema1 {

	public static void main(String[] args) {
		int inaltime = 0;
		int numarAni = 1;
		int repetare = 1;
		
		Scanner scanez = new Scanner(System.in);
		
		System.out.print("Introdu inaltime copac: ");		//inaltime
		inaltime = scanez.nextInt();
		
		System.out.print("Introdu numarul de ani: ");		//numar de ani
		numarAni = scanez.nextInt();
		
			do {
				
				inaltime = inaltime * 2;
				inaltime = inaltime + 1;
				
				repetare++;
			}while(repetare <= numarAni);
			
		
		System.out.println("Inaltimea copacului dupa "+numarAni+" ani: "+ inaltime);
		
		scanez.close();		
	}
	
}
