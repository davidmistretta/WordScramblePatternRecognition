import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PatternScramble {

	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		String str;
		char ch;
		boolean yes = true;
		while(yes)
		{
			System.out.println("Enter a sentence to scramble: ");
			str = keyboard.nextLine();
			String[] tokens = str.split(" ");
			for(int i = 0; i < tokens.length; i++)
			{
					//System.out.println(tokens[i]);
					if(tokens[i].length() > 2)
					tokens[i] = tokens[i].charAt(0) + generateRandomMiddle(tokens[i]) + tokens[i].charAt(tokens[i].length()-1);
					
					System.out.print(tokens[i] + " ");
			}
			
			System.out.println("\nWould you like to enter another string? (Y/N):");
			str = keyboard.nextLine().toUpperCase();
			ch = str.charAt(0);
			if(ch == 'Y')
				yes = true;
			else
				yes = false;
		}
	}
	public static String generateRandomMiddle(String str)
	{
		String middle = str.substring(1, str.length()-1);
		
		if(str.length() <= 3)
			return middle;
		
		char[] temp = new char[middle.length()];
		
		/*
		 * Create an ArrayList of Integer objects of 0 - length of middle of word
		 */
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < middle.length(); i++) 
        {
            list.add(new Integer(i));
        }
        /*
         * Collections.shuffle shuffles the list of Integers randomly (so 0, 1, 2, 3 = (2, 3, 1, 0)
         */
        Collections.shuffle(list);
        
        /*
         * Sets a temp char array to the values of middle.charAt(i) where i is list.get(i) which corresponds
         * to random integers between 0 and middle.length()
         */
        for(int i = 0; i < middle.length(); i++)
        {
        	temp[i] = middle.charAt(list.get(i));
        }
        /*
         * turn the char array into a string and return that string
         */
        String stra = new String(temp);
        return stra;
	}
}
