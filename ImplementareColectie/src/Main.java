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
		int bancnoteDe500 = 0 ;
		int bancnoteDe100 = 0;
		int bancnoteDe50 = 0;
		int bancnoteDe10 = 0;
		int bancnoteDe5 = 0;
		int bancnoteDe1 = 0;
		
		ColectieImpl<Integer> portofel = new ColectieImpl<Integer>();
		Iterator<Integer> it = portofel.iterator();
		
		do {
			
			adaugaBan = citesteTastatura("Adauga bani\n(1,5,10,50,100,500)(0 pentr a opri)\n in portofel: ");
			if(adaugaBan != 0 && adaugaBan == 1 || adaugaBan == 5 || adaugaBan == 10 || adaugaBan == 50 || adaugaBan == 100 || adaugaBan == 500)
				adaugaBancnote(portofel, adaugaBan);
			else
				System.out.println("Moneda invalida!");
		}while(adaugaBan != 0);
		
		while(it.hasNext()) {
			 bancnota = it.next();
			 switch(bancnota) {
			 	case 1:
			 		bancnoteDe1++;
			 		break;
			 	case 5:
			 		bancnoteDe5++;
			 		break;
			 	case 10: 
			 		bancnoteDe10++;
			 		break;
			 	case 50:
			 		bancnoteDe50++;
			 		break;
			 	case 100:	
			 		bancnoteDe100++;
			 		break;
			 	case 500:
			 		bancnoteDe500++;
			 		break;
			 	default:
			 		System.out.println("Eroare");
			 }
			 
			 suma += bancnota;
		}
		
		System.out.println("Bancnote in portofel: " + portofel.dim());
		System.out.println("Suma din portofel este: " + suma + " lei");
		System.out.println("In portofel se afla " + bancnoteDe1 + " bancnote de 1 de lei.");
		System.out.println("In portofel se afla " + bancnoteDe5 + " bancnote de 5 de lei.");
		System.out.println("In portofel se afla " + bancnoteDe10 + " bancnote de 10 de lei.");
		System.out.println("In portofel se afla " + bancnoteDe50 + " bancnote de 50 de lei.");
		System.out.println("In portofel se afla " + bancnoteDe100 + " bancnote de 100 de lei.");
		System.out.println("In portofel se afla " + bancnoteDe500 + " bancnote de 500 de lei.");
		

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
