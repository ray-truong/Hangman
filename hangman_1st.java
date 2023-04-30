import java.util.Scanner;

public class hangman_1st {
	
public static void main(String[] args) {	
		
		//declaring variables for Hangman
		
		Scanner input = new Scanner(System.in); 
		boolean hasNumber = true;
		String Word = "";
		int wordLength = 0;
		String Stars = "**********";
		String lettersSoFar = "";
		int Guesses = 10; 
		String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int guessCounter = 11;
		
		//opening screen and requesting input
		
		System.out.println("-------------------------------");
		System.out.println("     Welcome to HANGMAN\t");
		System.out.println("-------------------------------");
		System.out.println("\n OK Guessing Player ... turn around, while your friend enters the word to guess!");
		
		//making sure that the input word has only letters and is less than 10 characters long. 
		
		while (wordLength > 10 || hasNumber) {
		System.out.println("\n Other Player - Enter your word (up to 10 letters only, not case sensitive):");
		Word = input.nextLine().toUpperCase();
		wordLength = Word.length();
		hasNumber = false;
	
		for (int i = 0; i < wordLength; i++) {
			if (!Character.isLetter(Word.charAt(i))) {
				hasNumber = true;
				break;
				
				}
			}
		}
		
		//printing 20 lines so that the word cannot be seen
		
		for (int i = 0; i < 20; i++) {
			System.out.println("");
		}
		
		//loop for guessing player to make their guesses
		
		while (Guesses >= 0) {
			StringBuilder Alphabet2 = new StringBuilder(Alphabet);
			StringBuilder wordSoFar = new StringBuilder(Stars.substring(0, wordLength));
			for (int i = 0; i < lettersSoFar.length(); i++){
				String checkChar = Character.toString(lettersSoFar.charAt(i));
					
					//hiding the word with stars and revealing it letter by letter
				
				for (int ii = 0; ii < Word.length(); ii++) {
						String checkChar1 = Character.toString(Word.charAt(ii));
						String checkWordSoFar = Character.toString(wordSoFar.charAt(ii));
						if (checkChar.equals(checkChar1) && !checkWordSoFar.equals(checkChar1)) {
							wordSoFar.replace(ii, ii + 1, checkChar);
							break;
					}
				}
			}
			
			//constructing the alphabet
			
			for (int ii = 0; ii < Alphabet.length(); ii++) {
				int count1 = 0;
				int count2 = 0;
				char checkAlphabet = Alphabet.charAt(ii);
				
				for (int iii = 0; iii < Word.length(); iii++) {
					char checkWord = Word.charAt(iii);
					if (checkAlphabet == checkWord) {
						count1++;
					}
				}
				for (int iv = 0; iv < lettersSoFar.length(); iv++) {
					char checkLettersSoFar = lettersSoFar.charAt(iv);
					if (checkAlphabet == checkLettersSoFar) {
					count2++;
					}
				}
								
				if (count2 >= count1 && count2 != 0) {
						Alphabet2.replace(ii, ii + 1, "*");			
				}	
			}	
				
			//checking to see if the guessing player has all the lettters
			
			String checkWordSoFar = wordSoFar.toString();
			if (!checkWordSoFar.contains("*")) {
				guessCounter = 11 - Guesses;
				Guesses = -1;
				break;
			}
			
			//checking to see if guessing player has lost
			
			if (Guesses == 0 && checkWordSoFar.contains("*")) {
				Guesses = -2;
				break;
			}
				
			//input y or n for if guessing player wants to guess the word
			
			System.out.println("Word to Date: " + wordSoFar + "(" + Guesses + " guess(es) left)");
			System.out.println("Want to solve the puzzle? Enter \"Y\" to solve the puzzle, or \"N\" to guess a character:");
			char yOrN = input.next().charAt(0);
			yOrN = Character.toUpperCase(yOrN);
			
			//for if guessing player wants to guess the word
			
			if (yOrN == 'Y') {
				System.out.println("What do you think the mystery word is?");
				input.nextLine();
				String guessWord = input.nextLine().toUpperCase();
				
				//for if guessing player guesses word correctly
				
				if (guessWord.equals(Word)) {
					guessCounter = 11 - Guesses;
					Guesses = -1;
					break;
				}
				
				//for if guessing player guesses word incorrectly
				
				if (!guessWord.equals(Word)) {
					System.out.println("Sorry that isn't the mystery word");
					System.out.println(" ");
					Guesses--;
				}
				
			}
			
			//if guessing player only wants to enter guess a letter
			
			if (yOrN == 'N') {
				input.nextLine();
				System.out.println("Letters not tried yet: " + Alphabet2);
				System.out.println("Which letter should I check for? ");
				String nextLetter = input.nextLine().toUpperCase();
				
				//loop for if guessing player guesses more than 1 letter
				
				while (nextLetter.length() > 1) {
					System.out.println("Letters not tried yet: " + Alphabet2);
					System.out.println("Which letter should I check for? ");
					nextLetter = input.nextLine().toUpperCase();
				}
				lettersSoFar += nextLetter;
				Guesses--;
			}
			
			//for if guessing player doesn't enter in either y or n
			
			else { 
				Guesses += 0;
				}
			}
		
		//if guessing player wins this code executes
		
		if (Guesses == -1) {
			System.out.println("----------------------------------------------------");
			System.out.println("Congratulations!!!");
			System.out.println("You guessed the mystery word \"" + Word + "\"in " + guessCounter + " guesses!");
			System.out.println("Goodbye . . . ");
			System.out.println("----------------------------------------------------");
		}
		
		//if guessing player loses this code executes
		
		if (Guesses == -2) {
			System.out.println("----------------------------------------------------");
			System.out.println("Sorry you didn't find the mystery word!");
			System.out.println("It was \"" + Word + "\"");
			System.out.println("\n Goodbye...");
			System.out.println("----------------------------------------------------");
		}
	}
}

/*
 * 
 * public void play_a_guess(Scanner key) {
	
	if (Guesses > 0) {
		gameFinish = true;
	}
	
	if (gameFinish == true) {
		StringBuilder Alphabet2 = new StringBuilder(Alphabet);
		StringBuilder wordSoFar = new StringBuilder(Stars.substring(0, wordLength));
		for (int i = 0; i < lettersSoFar.length(); i++){
			String checkChar = Character.toString(lettersSoFar.charAt(i));
				
				//hiding the word with stars and revealing it letter by letter
			
			for (int ii = 0; ii < Word.length(); ii++) {
					String checkChar1 = Character.toString(Word.charAt(ii));
					String checkWordSoFar = Character.toString(wordSoFar.charAt(ii));
					if (checkChar.equals(checkChar1) && !checkWordSoFar.equals(checkChar1)) {
						wordSoFar.replace(ii, ii + 1, checkChar);
						break;
				}
			}
		}
		
		//constructing the alphabet
		
		for (int ii = 0; ii < Alphabet.length(); ii++) {
			int count1 = 0;
			int count2 = 0;
			char checkAlphabet = Alphabet.charAt(ii);
			
			for (int iii = 0; iii < Word.length(); iii++) {
				char checkWord = Word.charAt(iii);
				if (checkAlphabet == checkWord) {
					count1++;
				}
			}
			for (int iv = 0; iv < lettersSoFar.length(); iv++) {
				char checkLettersSoFar = lettersSoFar.charAt(iv);
				if (checkAlphabet == checkLettersSoFar) {
				count2++;
				}
			}
							
			if (count2 >= count1 && count2 != 0) {
					Alphabet2.replace(ii, ii + 1, "*");			
			}	
		}	
			
		//checking to see if the guessing player has all the letters
		
		String checkWordSoFar = wordSoFar.toString();
		if (!checkWordSoFar.contains("*")) {
			guessCounter = 11 - Guesses;
			Guesses = -1;
		}
		
		//checking to see if guessing player has lost
		
		if (Guesses == 0 && checkWordSoFar.contains("*")) {
			Guesses = -2;
		}
			
		//input y or n for if guessing player wants to guess the word
		
		System.out.println("Game ID: " + current_game + " Word to Date: " + wordSoFar + "(" + Guesses + " guess(es) left)");
		System.out.println("Game ID: " + current_game + " Want to solve the puzzle? Enter \"Y\" to solve the puzzle, or \"N\" to guess a character:");
		char yOrN = input.next().charAt(0);
		yOrN = Character.toUpperCase(yOrN);
		
		//for if guessing player wants to guess the word
		
		while (yOrN != 'N' && yOrN != 'Y') {
			
			System.out.println("Game ID: " + current_game + " Word to Date: " + wordSoFar + "(" + Guesses + " guess(es) left)");
			System.out.println("Game ID: " + current_game + " Want to solve the puzzle? Enter \"Y\" to solve the puzzle, or \"N\" to guess a character:");
			yOrN = input.next().charAt(0);
			yOrN = Character.toUpperCase(yOrN);
		}
		
		if (yOrN == 'Y') {
			System.out.println("What do you think the mystery word is?");
			input.nextLine();
			String guessWord = input.nextLine().toUpperCase();
			
			//for if guessing player guesses word correctly
			
			if (guessWord.equals(this.Word)) {
				guessCounter = 11 - Guesses;
				Guesses = -1;
			}
			
			//for if guessing player guesses word incorrectly
			
			if (!guessWord.equals(this.Word)) {
				System.out.println("Game ID: " + current_game + " Incorrect guess, Continue guessting next character");
				System.out.println("Game ID: " + current_game + " Which letter should I check for? ");
				System.out.println("Game ID: " + current_game + " Letters to try: " + Alphabet2);
				Guesses--;
				String nextLetter = input.nextLine().toUpperCase();
				
				String Alphabet3 = Alphabet2.toString();
				while (nextLetter.length() != 1 || !Alphabet3.contains(nextLetter)){
					
					System.out.println("Game ID: " + current_game + " --> Not a valid request - either not a letter or already guessed.");
					System.out.println("Game ID: " + current_game + " Which letter should I check for? ");
					nextLetter = input.nextLine().toUpperCase();
				}
				if (this.Word.contains(nextLetter)) {
					System.out.println("Game ID: " + current_game + " --> great guess!");	
					System.out.println("");
				}
				else {
					System.out.println("Game ID: " + current_game + " --> Sorry, wrong guess!");
					System.out.println("");
				}
				
				lettersSoFar += nextLetter;
				Guesses--;
				}
			}
		
		//if guessing player only wants to enter guess a letter
		
		if (yOrN == 'N') {
			input.nextLine();
			System.out.println("Game ID: " + current_game + " Letters to try: " + Alphabet2);
			System.out.println("Game ID: " + current_game + " Which letter should I check for? ");
			String nextLetter = input.nextLine().toUpperCase();
			
			//loop for if guessing player guesses more than 1 letter
			String Alphabet3 = Alphabet2.toString();
			while (nextLetter.length() != 1 || !Alphabet3.contains(nextLetter)){
				
				System.out.println("Game ID: " + current_game + " --> Not a valid request - either not a letter or already guessed.");
				System.out.println("Game ID: " + current_game + " Which letter should I check for? ");
				nextLetter = input.nextLine().toUpperCase();
				}
				
				
			
			if (this.Word.contains(nextLetter)) {
				System.out.println("Game ID: " + current_game + " --> great guess!");	
				System.out.println("");
			}
			else {
				System.out.println("Game ID: " + current_game + " --> Sorry, wrong guess!");
				System.out.println("");
			}
			
			lettersSoFar += nextLetter;
			Guesses--;
			}
		}
	
	//if guessing player wins this code executes
	
	if (Guesses == -1) {
		System.out.println("----------------------------------------------------");
		System.out.println("Game ID: " + current_game + " Congratulations!!!");
		System.out.println("You guessed the mystery word \"" + Word + "\"in " + guessCounter + " guesses!");
		System.out.println("Game ID: " + current_game + " Goodbye . . . ");
		System.out.println("----------------------------------------------------");
		gameFinish = false;
	}
	
	//if guessing player loses this code executes
	
	if (Guesses == -2) {
		System.out.println("----------------------------------------------------");
		System.out.println("Game ID: " + current_game + " Sorry you didn't find the mystery word!");
		System.out.println("It was \"" + Word + "\"");
		System.out.println("\nGame ID: " + current_game + " Goodbye...");
		System.out.println("----------------------------------------------------");
		gameFinish = false;
		}
	}
}/*
 */

