import java.util.*;

public class Main {

	@SuppressWarnings("null")
	public static void main(String[] args) {

		Suspect unu = new Suspect();
		
		unu.setIMEI(145);
		unu.setTimestamp(750);
		unu.setxCoordonate(12.2);
		unu.setyCoordonate(15.1);
		
		//System.out.println(unu.getxCoordonate());
		
	Map<String, Object> listaSuspecti = null;
		
	listaSuspecti.put("123", unu);
	listaSuspecti.put("123", 12);
	
	System.out.println(listaSuspecti.get());
	
	
		
	//	System.out.println(listaSuspecti.remove(unu.));
		
	}
	
	public class ListaSuspecti extends Suspect{
		
	}

}
