package Classes;

import Interfaces.IHangman;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;


public class Hangman  implements IHangman{

	private String[] dictionary;
 	private String path;
 	private String guessing;
 	private int maxwrong;
 	private int lose=0;
 	
	
	public String[] readfile(String game , int numwords ) throws IOException {
		String	arr[]=new String[numwords];
	try {	FileReader fileReader = new FileReader(game);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
	
	int i=0;
	while((arr[i] = bufferedReader.readLine()) != null) {
		i++;
		
	} 
	
   fileReader.close(); 
   
  
	} catch(IOException e) {
		System.out.print("NO file");
		
	}
	return arr;
	}
	
	
	
	@Override
	public void setDictionary(String[] words) {
		dictionary = words;
	
	}

	@Override
	public String selectRandomSecretWord() {
		
		Random cell= new Random();
		int ran;
		ran=cell.nextInt(dictionary.length);
		path=dictionary[ran];
		guessing=path;
		StringBuilder sb=new StringBuilder(guessing);
		for(int i=0;i<path.length();i++) {
			sb.setCharAt(i, '-');
			guessing = sb.toString();

		}
		return path ;
	}

	@Override
	public String guess(Character c) throws Exception {
		StringBuilder sb=new StringBuilder(guessing);
		
		int found=0;
		if(!Character.isLetter(c)) {
			System.out.println("Wrong input");
			return guessing;
		}
		for(int i=0;i<path.length();i++) {
			if(guessing.charAt(i)==c) {
				found=2;
			}
			if((path.toLowerCase().charAt(i)==Character.toLowerCase(c))&&guessing.charAt(i)=='-') {
				sb.setCharAt(i,c);
				guessing = sb.toString();
				found=1;
				
			}
				
		}
		
		if(found==1) {
			System.out.println("Good Guesssing");
			System.out.println(guessing);
			if(!guessing.contains("-")) {
				
				System.out.println("GAME OVER YOU WIN ^-^");
			}
			return guessing;
		}
		else if(found==0){
			System.out.println("Wrong Guessing");
			lose++;
			if(lose>=maxwrong) {
				System.out.println("GAME OVER YOU LOSE '~'");
				return null ;
			}
			else { System.out.println(guessing);
				return guessing;
			}
		}
		else {
			System.out.println("You Guessed It Before");
			return guessing;
		}
		
		
		
	}

	@Override
	public void setMaxWrongGuesses(Integer max) {
		
		if(max>0) {
			maxwrong=max;
		}
		else {
			maxwrong=1;
		}
	}
	
}
