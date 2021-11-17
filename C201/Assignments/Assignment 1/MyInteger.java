public class MyInteger {

    private int value;

    public MyInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isEven() {
        return value % 2 == 0;
    }

    public boolean isOdd() {
        return value % 2 != 0;
    }

    public boolean isPrime() {
        boolean itIsPrime = value > 1;
        for (int i = 2; i <= (Math.sqrt(value) + 1); i++) {
            if (value % i == 0) {
                itIsPrime = false;
                break;
            }
        }
        if (value == 2) {
            itIsPrime = true;
        }
        return itIsPrime;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }

    public static boolean isPrime(int number) {
        boolean itIsPrime = number > 1;
        for (int i = 2; i <= (Math.sqrt(number) + 1); i++) {
            if (number % i == 0) {
                itIsPrime = false;
                break;
            }
        }
        if (number == 2) {
            itIsPrime = true;
        }
        return itIsPrime;
    }

    public static boolean isEven(MyInteger number) {
        return number.isEven();
    }

    public static boolean isOdd(MyInteger number) {
        return number.isOdd();
    }

    public static boolean isPrime(MyInteger number) {
        return number.isPrime();
    }

    public boolean equals(int number) {
        return number == value;
    }

    public boolean equals(MyInteger number) {
        return number.equals(value);
    }

    public static int parseInt(char[] arr) {
        return Integer.parseInt(new String(arr));
    }

    public static int parseInt(String str) {
        return Integer.parseInt(str);
    }

}
