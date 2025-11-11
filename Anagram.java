/** Functions for checking if a given string is an anagram. */

import java.util.Random;

public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		int count1 = 0;
		int count2 = 0;

		for (int i=0; i<str1.length(); i++)
		{
			if (str1.charAt(i) != ' ')
			{
				count1++;
			}
		}
		for (int i=0; i<str2.length(); i++)
		{
			if (str2.charAt(i) != ' ')
			{
				count2++;
			}
		}
		if (count1 != count2)
		{
			return false;
		}

		for (int i=0; i<str1.length(); i++)
		{
			int letterCountStr1 = 0;
			int letterCountStr2 = 0;
			for (int j=0; j<str1.length(); j++)
			{
				if (str1.charAt(i) == str1.charAt(j) && str1.charAt(i) != ' ')
				{
					letterCountStr1++;
				}
			}
			for (int p=0; p<str2.length(); p++)
			{
				if (str1.charAt(i) == str2.charAt(p) && str1.charAt(i) != ' ')
				{
					letterCountStr2++;
				}
			}
			if (letterCountStr1 != letterCountStr2)
			{
				return false;
			}
		}
		return true;
	}

	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		str = str.toLowerCase();
		String newWord = "";
		for (int i=0; i<str.length(); i++)
		{
			if (Character.isLetter(str.charAt(i)))
			{
				newWord = newWord + str.charAt(i);
			}
		}
		return newWord;
	} 
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		StringBuilder newWord = new StringBuilder(str);
		Random rand = new Random();

		for (int i=newWord.length()-1; i>0; i--)
		{
			int j = rand.nextInt(i + 1);
			char temp = newWord.charAt(i);
			newWord.setCharAt(i, newWord.charAt(j));
			newWord.setCharAt(j, temp);
		}
		return newWord.toString();
	}
}