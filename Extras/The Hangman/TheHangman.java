import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class TheHangman {
	public static void main(String [] args) throws Exception {
		/**
		 * Create a file object and an empty String array for words.
		 */
		File file = new File ("words.txt");
		Scanner fileInput = new Scanner(file);
		String [] words = null;
		/**
		 * Scanner input for getting input from user.
		 */
		Scanner input = new Scanner(System.in);
		/**
		 * Random object for generating a random number.
		 */
		Random rand = new Random();
		/**
		 * String to find out whether the user wants to continue or not.
		 */
		String cont;
		/**
		 * Since the file consists of one line, get that line and split the line when there is a comma and
		 * assign the separated words to the words array with split() function.
		 */
		String lines = fileInput.nextLine();
		words = lines.split(",");
		/**
		 * Close the file.
		 */
		fileInput.close();
		/**
		 * To run the program until the user enters 'n', we use do-while loop with the condition cont.toLowerCase().charAt(0) != 'n'
		 */
		do {
			/**
			 * Generate a random number between [0, words.length - 1] to get a random index to get a word. 
			 * Get the word in form of a char array to compare the letters with the letter given by the user.
			 * Counter for right and wrong guesses. A boolean array to keep track of the found letters.
			 */
			int wordNumber = rand.nextInt(words.length - 1);
			char [] word = words[wordNumber].toCharArray();
			int correctGuesses = 0;
			int wrongGuesses = 0;
			boolean [] foundLetters = new boolean [word.length];
			/**
			 * If the correct guesses equal to word's length, that means the user has found the word. Until that happens,
			 * if there is a letter that was found -information taken from the boolean array- show that letter. If not, show an
			 * asterisk.
			 */
			while (correctGuesses != word.length) {
				System.out.println("Enter a letter to guess the word.");
				for (int j = 0; j < word.length; j++) {
					if (foundLetters[j])
						System.out.print(word[j]);
					else
						System.out.print("*");
				}
				/**
				 * Answer prompt.
				 */
				System.out.print(">");
				/**
				 * Lowercase the input and take the character at index 0 as the guess. miss determines if the user
				 * has missed or not, repeat determines if the user has entered a character that is already shown.
				 */
				char guess = input.next().toLowerCase().charAt(0);
				boolean miss = true;
				boolean repeat = false;
				/**
				 * Go through the entire word array to make comparisons. If the guess is the same as the letter we are looking at
				 * and it was not found before, i.e., foundLetters[j] is false, foundletters[j] should be true and correct guesses should go up by one.
				 * If the the letter was found before, print the appropriate message by changing repeat to be true. In both cases, miss should be false.
				 * If the letter and the guess was equal to each other, upgrade the wrong guesses.
				 */
				for (int j = 0; j < word.length; j++) {
					if (word[j] == guess) {
						if (!foundLetters[j]) {
							foundLetters[j] = true;
							correctGuesses++;
						} 
						else {
							repeat = true;
							break;
						}
						miss = false;
					}
				}
				if (miss)
					wrongGuesses++;
				if (repeat)
					System.out.println(guess + " is already in the word");
			}
			/**
			 * After the word is found, display results and ask the user if they want to continue.
			 */
			System.out.println("The word is " + String.valueOf(word) + ". You missed " + wrongGuesses + " times.");
			System.out.print("Do you want to guess another word? Enter y or n>");
			/**
			 * Get the answer from the user. Re-enter the loop or quit depending on the outcome.
			 */
			cont = input.next();
		} while (cont.toLowerCase().charAt(0) != 'n');
		System.out.println("Quitting...");
		input.close();
	}
}