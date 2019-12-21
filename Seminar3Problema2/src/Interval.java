import java.util.*;

public class Interval implements Comparable<Interval> {
	public int inceput;
	public int lungime;
	
	public Interval(int inceputNou, int lungimeNoua) {
		this.inceput = inceputNou;
		this.lungime = lungimeNoua;
	}
	@Override
	public int comparableTo(Interval alDoileaInterval) {
		//0 -1 1
		
		if(this.lungime > alDoileaInterval.lungime) {
			return -1;
		}
		else if(this.lungime < alDoileaInterval.lungime)
		{
			return 1;
		}
		
			return 0;
		
		
		
	}
}
