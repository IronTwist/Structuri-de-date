import java.util.*;

public class Seminar3 {

	public static void main(String[] args) {
		Interval inter = new Interval(1,3);
//
//	//	PriorityQueue<Interval> scaune = new PriorityQueue<Interval>();
//		
//		ArrayList<Interval> intervale = new ArrayList<Interval>();
//		
//		intervale.add(new Interval(7,6));
////		intervale.get(0).inceput = 0;
////		intervale.get(0).lungime = 6;
////		intervale.get(1).inceput = 7;
////		intervale.get(1).lungime = 12;
//		
//		intervale.get(0);
		
		
		PriorityQueue<Interval> scaune = new PriorityQueue<Interval>();
		int n = 10;
		int k = 5;
		
		String preferinte = "DSDDDS";
		
		Interval intInitial = new Interval(0, n);
		
		scaune.add(intInitial);
		for(int i = 0; i < k; i++) {
			Interval intervalBun = scaune.poll(); //returneaza intervalul cel mai mare
			
			
		}
		
	}

}
