import java.util.Scanner;

public class palindrome {

    //Global increment value for printing
    public static int increment = 1;

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of strings to test palindrome case");
        int testCase = input.nextInt();

        System.out.println("Enter the " + increment + " th string:");
        input.nextLine(); //fixing the bug with the \n
        String testString = input.nextLine();
        System.out.println(isPalindrome(testString));

        while(increment++ < testCase){
            System.out.println("Enter the " + increment + " th string:");
            testString = input.nextLine();
            System.out.println(isPalindrome(testString));
        }

    }

    /**
     * isPalindrome: returns true if the word is palindrome
     * @param testString: String to test whether the word is palindrome or not
     * @return boolean value for the testString is palindrome or not
     */

    public static boolean isPalindrome(String testString){

        //anna, baba > anna palindrome baba not palindrome
        //even number case
        if(testString.length() % 2 == 0){
            //Splitting string to 2 parts
            int midIndex = testString.length() / 2 - 1;
            StringBuilder leftPart = new StringBuilder();
            String leftPartReversed = "";
            leftPart.append(testString, 0, midIndex + 1);
            /*
            Reversing the left part, abba > ba ba; if they are equal that means palindrome
            if the left part and the right part are not equal; baba > ab ba
            that means string is not a palindrome
             */
            leftPart.reverse();
            leftPartReversed += leftPart;

            String rightPart = "";
            rightPart += testString.substring(midIndex + 1);

            return leftPartReversed.equalsIgnoreCase(rightPart);
        }

        //abcba is palindrome
        else{
            //Splitting
            int midIndex = testString.length() / 2 - 1;
            StringBuilder leftPart = new StringBuilder();
            String leftPartReversed = "";
            leftPart.append(testString, 0, midIndex + 1);
            leftPart.reverse();
            leftPartReversed += leftPart;

            //Skipping one odd part
            String rightPart = "";
            rightPart += testString.substring(midIndex + 2);

            return leftPartReversed.equalsIgnoreCase(rightPart);
        }

    }
    
    /*
    The first known palindrome was in Latin 
    and read "sator arepo tenet opera rotas"
     which means either: The sower Arepo holds the wheels with effort.
      The sower Arepo leads with his hand the plough.
     */

}