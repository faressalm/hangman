package Tests;
import java.io.IOException;
import java.util.Scanner;

import Classes.Hangman;

public class test {

	public static void main(String[] args) throws Exception {
		Hangman play=new Hangman();
	  Scanner opj=new Scanner(System.in);
		play.setDictionary(play.readfile("dictionary.txt", 10001));
		System.out.println("just for testing\n "+play.selectRandomSecretWord());//print the word for testing
		play.setMaxWrongGuesses(6);
		System.out.println("Enter the letter:");
		
		Character c=opj.next().charAt(0);
		String help=play.guess(c);
		
		while(help!=null&&help.contains("-")) {
			System.out.println("Enter the letter:");
			c=opj.next().charAt(0);
			help=play.guess(c);
			
		}
		

	}
	
	
}
