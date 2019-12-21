import java.util.*;

public class Problema1 {

	public static void main(String[] args) {
		int[] vector = new int[] {1,2,4,4,2,7};
		int k = 3;
		
		//System.out.println(vector);
		
		System.out.println(variantaCuHashSet(vector, k));
		System.out.println("\nVarianta cu for:\n");
		System.out.println(variantaCuFor(vector, k));		//varianta cu for
	}
	
	public static String variantaCuFor(int array[], int k) {
		int count=0;
		for(int i=0; i < array.length-1; i++) {
			for(int j=1; j < array.length-1; j++) {
				if(array[i] == array[j]) {
					count++;
				}
			}
		}
		if(count == k) {
			 System.out.println("Este bun");
			 return "Bun";
		}else if(count < k) {
			System.out.println("Este rau");
			return "Rau";
		}else {
			System.out.println("Este mediu");
			return "Mediu";
		}
		//return "0";
	}
	
	public static String variantaCuHashSet(int array[], int k) {
		Set<Integer> elementeDistincte = new HashSet<Integer>(); //set nou
		
		for(int i=0; i <array.length;i++) {
			elementeDistincte.add(array[i]);	//adaugare 
		}
		
		
		if(elementeDistincte.size() == k) {
			System.out.println("Este bun");
			return "Este bun";
		}else if(elementeDistincte.size() < k){
			System.out.println("Este rau");
			return "Este rau";
		}else {
			System.out.println("Este mediu");
			return "Este mediu";
		}
		//return "0";
	}
}
