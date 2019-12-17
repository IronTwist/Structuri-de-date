import java.util.Iterator;
import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int suma=0;
		int bancnota;
		int adaugaBan;
		
		ColectieImpl<Integer> portofel = new ColectieImpl<Integer>();
		Iterator<Integer> it = portofel.iterator();
		
		do {
			
			adaugaBan = citesteTastatura("Adauga bani\n(1,5,10,50,100,500)(0 pentr a opri)\n in portofel: ");
			if(adaugaBan != 0)
				adaugaBancnote(portofel, adaugaBan);
			
		}while(adaugaBan != 0);
		
		while(it.hasNext()) {
			 bancnota = it.next();
			 suma += bancnota;
		}
		
		System.out.println("Bancnote in portofel: " + portofel.dim());
		System.out.println("Suma din portofel este: " + suma + " lei");
		

	}
	
	public static void  adaugaBancnote(ColectieImpl<Integer> col, int suma) {
		col.adauga(suma);
	}
	
	public static int citesteTastatura(String str) {
		System.out.println(str);
		
		try {
			Scanner keyboard  = new Scanner(System.in);
			int x = keyboard.nextInt();
			return (int) x;
		}catch(Exception exp) {
			System.out.println("A aparut o eroare!");
			return citesteTastatura(str);
		}
		
	}
	
	
}
