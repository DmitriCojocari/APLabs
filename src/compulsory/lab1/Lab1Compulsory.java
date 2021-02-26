package compulsory.lab1;

public class Lab1Compulsory {

    public static int sumOfDigits(int number) {
        //last digit of the number and the sum of its digits
        int lastDigit = 0;
        int sum = 0;

        // while the number is not 0
        while (number != 0) {
            // compute last digit
            lastDigit = number % 10;
            // add it to the sum
            sum = sum + lastDigit;
            // move to the next digit by dividing the number to 10
            number = number / 10;
        }
        //returning the sum of the digits
        return sum;
    }

    // method to find digital sum (if the sum of the digits of a number is not a digit)
    public static int digitalSum(int number) {
        // storing the number into result so we can keep track of the order of the number
        int result = number;
        //while there are any digits left in the result
        while (result / 10 != 0) {
            //we compute the sum of the digits
            result = sumOfDigits(result);
        }
        return result;
    }


    public static void main(String[] args) {
        //step 1
        System.out.println("step 1: ");
        System.out.println("Hello World!");
        System.out.println("");

        //step 2
        System.out.println("step 2: ");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        for (int i = 0; i < languages.length; i++) {
            System.out.print(languages[i] + " ");
        }
        System.out.println("");
        System.out.println("");

        //step 3
        System.out.println("step 3: ");
        int n = (int) (Math.random() * 1000000);
        System.out.println("n=" + n);
        System.out.println("");

        //step 4
        System.out.println("step 4: ");
        int result = 0;
        result = n * 3;
        System.out.println("number multiplied by 3=" + result);

        result = result + 0B10101;
        System.out.println("result + 0B10101=" + result);

        result = result + 0XFF;
        System.out.println("result + 0XFF=" + result);

        result = result * 6;
        System.out.println("result * 6=" + result);
        System.out.println("");

        //step 5
        System.out.println("step 5: ");
        System.out.println("sum of the digits=" + sumOfDigits(result));
        System.out.println("digital sum=" + digitalSum(result));
        System.out.println("");

        //step 6
        System.out.println("step 6:");
        result = digitalSum(result);
        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }

}