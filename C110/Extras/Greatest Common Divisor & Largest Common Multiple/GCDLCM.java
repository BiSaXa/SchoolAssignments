import java.util.Scanner;

public class GCDLCM {

    /**
     * findGCD: uses euclidean gcd algorithm to an array of numbers
     * @param nums: int values to calculate the greatest common divisor
     * @return result: Greatest common divisor of the nums array
     */

    public static int findGCD(int[] nums){
        int result = 0;
        //applying gcd to every single element
        for (int num : nums) {
            result = gcd(result, num);
            if (result == 1)
                return 1;
        }
        return result;
    }

    /**
     * gcd: uses euclidean gcd algorithm to calculate greatest common divisor
     * @param num1 number 1
     * @param num2 number 2
     * @return greatest common divisor of the number 1 and number 2
     */

    public static int gcd(int num1, int num2){
        if(num2 == 0)
            return num1;
        return gcd(num2, (num1 % num2));
    }

    /**
     * lcm: calculates least common divisor by using euclidean gcd
     * @param num1: number 1
     * @param num2: number 2
     * @return lcm: least common divisor of the number 1 and number 2
     */

    public static int lcm(int num1, int num2){
        //***LCM ALGORITHM***
        return num1 * num2 / gcd(num1, num2);
    }

    /**
     * findLCM: calculates the least common divisor for array of numbers
     * @param nums: array of numbers
     * @return result: Least common divisor of the array of numbers
     */

    public static int findLCM(int[] nums){
        int result = nums[0];
        //applying lcm to every single element
        for(int i = 1; i < nums.length; i++){
            result = lcm(result, nums[i]);
            if(result == 1)
                return 1;
        }
        return result;
    }


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of numbers: ");
        int numberOfNumbers = input.nextInt();
        int[] nums = new int[numberOfNumbers];
        for(int i = 0; i < numberOfNumbers; i++){
            System.out.println("Enter the number");
            nums[i] = input.nextInt();
        }
        int gcd = findGCD(nums);
        System.out.println("GCD: " + gcd);
        int lcm = findLCM(nums);
        System.out.println("LCM: " + lcm);
    }

}