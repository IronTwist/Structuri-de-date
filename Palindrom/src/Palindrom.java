import java.util.Scanner;

public class Palindrom {

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		
		System.out.println("Introdu un sir: ");
		String sirVerificare = key.next();
		int palindrom = 0;
	
		int j=sirVerificare.length()-1;
		
		for(int i=0; i < ((int)sirVerificare.length()/2); i++) {
			System.out.println("i= " + i);
			System.out.println("j= " + j);
			if(sirVerificare.charAt(i) != sirVerificare.charAt(j)) {
				palindrom = 0;
			}else {
				palindrom = 1;
			}
			j--;
		}
		
		if(palindrom == 1) {
			System.out.println("Sirul este palindrom!");
		}else {
			System.out.println("Sirul nu este palindrom!");
		}
		
	}

}
