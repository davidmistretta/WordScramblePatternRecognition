import java.util.Random;
import java.util.Scanner;
public class PatternScramble2 {

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
		String middle = str.substring(1,  str.length()-1);
		char temp = 't';
		char[] middleChars = middle.toCharArray();
		int midLength = middle.length();
		
		Random randomInt = new Random();
		
		if(str.length() <= 3)
			return middle;
		
		/*
		 * For loop holds logic for middle character switching
		 * 
		 * 
		 * example: Master
		 * middle = a s t e
		 * 
		 * Loop 1
		 * random[between 0 and 3] = 2
		 * temp = middle[0] //a
		 * middle[0] = middle[random] //t
		 * middle[random] = temp  // a
		 * middle = t s a e
		 * 
		 * Loop 2
		 * ...
		 * 
		 * 
		 */
		for(int index = 0; index < midLength; index++)
		{
			int randomNum = randomInt.nextInt(midLength); //0 and midlength
			
			temp = middleChars[index]; 
			
			middleChars[index] = middleChars[randomNum];
			
			middleChars[randomNum] = temp;
			
		}
		String a = new String(middleChars);
		return a;
	}
}
