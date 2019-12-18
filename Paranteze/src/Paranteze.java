import java.util.*;

/**
 * Să considerăm o secvență de paranteze (paranteze rotunde, pătrate și
 * acolade). Trebuie să verificăm dacă secvența este corectă. 
 * 
 * De exemplu:
 * ([])((){}[]) – este corectă 
 * (((()) – nu este corectă (prima paranteză nu este închisă deloc) 
 * ([)] – nu este corectă (ordinea în care sunt închise parantezele nu e ok) 
 * ([{}])}{ – nu este corectă (avem o acoladă închisă care nu a fost deschisă nicăieri).
 */

public class Paranteze {
	
	public static void main(String[] args)
    {
        String input = "[(){[]}]";

        Stack<Character> brackets = new Stack<Character>();

        for (int i = 0, n = input.length(); i < n; i++) { 
            Character currentBracket = input.charAt(i);
            if (isOpenBracket(currentBracket)) {
                brackets.push(currentBracket);
                continue;
            }
            
           
            if (brackets.isEmpty()) {
                System.out.println("Sequence is invalid.");
                return;
            }

            
            Character lastBracket = brackets.pop();
            if (!areMatchingBrackets(lastBracket, currentBracket)) {
                System.out.println("Brackets do not match. Sequence is invalid.");
                return;
            }
        }

       
        if (brackets.empty()) {
            System.out.println("All brackets match!");
            return;
        }

        
        System.out.println("Brackets do not match. Sequence is invalid.");
    }

  
    private static boolean isOpenBracket(Character bracket)
    {
        return bracket == '(' || bracket == '[' || bracket == '{';
    }

    
    private static boolean areMatchingBrackets(Character openBracket, Character closedBracket)
    {
        if (openBracket == '(' && closedBracket == ')') {
            return true;
        }

        if (openBracket == '[' && closedBracket == ']') {
            return true;
        }

        if (openBracket == '{' && closedBracket == '}') {
            return true;
        }

        return false;
    }

}
