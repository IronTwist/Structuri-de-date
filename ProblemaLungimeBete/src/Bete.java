
public class Bete {

	public static void main(String[] args) {
		// Problema 1 Seminar 2;		
		int[] bete = new int[] {5,4,4,2,2,8};
		int min = 0;
		int continua = 0;
		int k = 0;

		
		System.out.println("minim= "+min);
	
	}
	
	public static int aflareMinim(int[] vector) {
		
		int min = vector[0];
		
		for(int i=1; i < vector.length-1; ++i) {
			if(vector[i] < min) {
				min = vector[i];
			}
		}
		
		
		//System.out.println("Minimul este: " + min);
		
		return min;
	}
	
	public boolean afisare(int[] vector) {
		int contor=0;
		for (int i = 0; i < vector.length; i++) {	//afisare	
			if(vector[i] != 0) {
				System.out.println(vector[i] + " ");
				contor++;
			}
		}
		return boolean;
	}

}
