import java.util.ArrayList;
import java.util.Scanner;

public class MorseCode {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter string: ");
        String inputString = input.nextLine();

        //inputString's morseCode translation
        String output = morseCode(inputString);
        System.out.print("Message to Morse Code: ");
        System.out.println(output);
        System.out.println();
        System.out.println("Enter the morse code message: ");
        String morseCode = input.nextLine();
        //Morse code to text
        System.out.println(morseToText(morseCode));
        input.close();


    }

    /**
     * morseCode: converts inputString to the morseCode
     * @param inputString: user's entered string
     * @return output: String array that contains morseCode translation
     */

    public static String morseCode(String inputString){
        //Mapping char int values to the morse string values

        //char map
        char[] converter = { 32, 44, 46, 63, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57,
							  65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81,
                 82, 83, 84, 85, 86, 87, 88, 89, 90 };

        //morse map
        String[] inputConverter = { " ", "--..--", ".-.-.-", "..--..", "-----", ".----", 
								"..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", ".-",
                "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
                 "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--",
                "-..-", "-.--", "--.." };

        //Output string array
        ArrayList<String> output = new ArrayList<>();

        //A and a have same values in the morse alphabet
        inputString = inputString.toUpperCase();

        //Outer for loop for traversing the inputString
        for(int i = 0; i < inputString.length(); i++){
            int hold = inputString.charAt(i);

            /*
              Traversing the char converted to int
              and matching the morse code to the
              char's ASCII code
             */
            for(int j = 0; j < converter.length; j++)
                if(hold == converter[j]) 
                    output.add(inputConverter[j]);
  
            output.add(" ");

        }

        StringBuilder outputString = new StringBuilder();

        for(String string : output){
            outputString.append(string);
        }

        //leaves 3 spaces between words and 1 space between same word's letters
        return outputString.toString();
    }

		/**
     * morseToText: takes the morse code message and translates
     * it to a English message
     * @param morse: morse code string
     * @return English message
     */

    public static String morseToText(String morse){

        //char map
        char[] ascii = { 32, 44, 46, 63, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57,
							  65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81,
                82, 83, 84, 85, 86, 87, 88, 89, 90 };

        //morse map
        String[] morseCodes = { " ", "--..--", ".-.-.-", "..--..", "-----", ".----", 
								"..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", ".-",
                "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
                 "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--",
                "-..-", "-.--", "--.." };

        //Output string array
        ArrayList<String> chars = new ArrayList<>();
        String [] parsed = morse.split(" ");


        //Outer for loop for traversing the morse code
        for (String s : parsed) {

            /*
              Traversing the morse map
              and matching the morse code to the
              char's ASCII code
             */
            for (int j = 0; j < morseCodes.length; j++)
                if (s.equals(morseCodes[j]))
                    chars.add(Character.toString(ascii[j]));
            chars.add(" ");

        }

        StringBuilder output = new StringBuilder();
        int numberOfSpaces = 0;
        for(String character : chars){

            //Formatting the spaces between words
            if(character.equals(" ")) {
                if(numberOfSpaces++ == 1) {
                    output.append(character);
                }
            }

            //appending the non space character
            else{
                output.append(character);
                numberOfSpaces = 0;
            }

        }

        return output.toString();

    }
}