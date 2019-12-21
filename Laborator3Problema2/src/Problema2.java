import java.util.*;

public class Problema2 {

	public static void main(String[] args) {
		int[] vector = new int[] {1,2,3,4,4,5};
		int k=9;
		
		Set<Integer> elemente = new HashSet<Integer>();
		
			for(int i=0; i < vector.length; i++) {
				if(elemente.contains(vector[i])){
					System.out.println("Elementul exista deja: " + vector[i]);
					continue;
				}else {
						elemente.add(vector[i]);
				}
			}
			
			for(int i=0; i < vector.length; i++) {
					if(elemente.contains(k - vector[i])) {
						System.out.println("true");
				}
			}
			
	System.out.println(elemente);
	}

}
