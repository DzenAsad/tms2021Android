import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Homework {
    public static void main(String[] args) {
        System.out.println(operation(1));
        System.out.println(operation(0));
        foobar(6);
        foobar(10);
        foobar(15);
        printMatrix();
        printPrimeNumbers();
    }

    /**
     * Method should perform some operation with int "number" based on some conditions:
     * - if number is positive - increase it by 1
     * - if number is negative - decrease it by 2
     * - if number is equal to zero - replace it with 10
     * return number value after operation
     */
    public static int operation(int number) {
        if (number == 0) {
            number = 10;
        } else if (number > 0) {
            ++number;
        } else {
            number -= 2;
        }
        return number;
    }

    /**
     * Method should print different strings in console based on some conditions:
     * - if remainder of the division number by 3 is zero - print "foo" (example of number - 6)
     * - if remainder of the division number by 5 is zero - print "bar" (example of number - 10)
     * - if remainder of the division number by both 3 and 5 is zero 0  and - print "foobar" (example of number - 15)
     */
    public static void foobar(int number) {
        int[] chekNumbs = {3, 5};
        String[] outString = {"foo", "bar"};
        StringBuilder strBuild = new StringBuilder();

        for (int i = 0; i < chekNumbs.length; i++) {
            if (number % chekNumbs[i] == 0) {
                strBuild.append(outString[i]);
            }
        }

        System.out.println(strBuild);
    }

    /**
     * Steps to implement:
     * - Read two ints from console
     * - Create a two-dimensional int array (use ints that you read from console height and width)
     * - Fill array with random values (under 100)
     * - Print in console matrix with given size, but:
     * - If remainder of the division array element by 3 is zero - print "+" sign instead of array element value
     * - If remainder of the division array element by 7 is zero - print "-" sign instead of array element value
     * - Print "*" otherwise
     * <p>
     * Example:
     * - Values from console -  2 and 3
     * - Array will look like this (values be different because it's a random)
     * 6 11 123
     * 1 14 21
     * - For this values output in console should be:
     * <p>
     * + * *
     * * - +
     * <p>
     * Note that 21 % 3 == 0 and 21 % 7 = 0, but output is not +-, but +
     */
    public static void printMatrix() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int height = scanner.nextInt();
        int width = scanner.nextInt();

        char[][] array = new char[height][width];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = symbol(random.nextInt(100));
            }
            System.out.println(Arrays.toString(array[i]));
        }


    }

    /**
     * (optional)
     * Method should print all prime numbers < 1000
     */
    public static void printPrimeNumbers() {
        final int COUNT = 1051;
        for (int i = 1; i <= COUNT; i++) {
            int tmp = 0;
            for (int j = i - 1; j > 1; j--) {
                if (i % j == 0) {
                    ++tmp;
                }
            }
            if (tmp == 0) {
                System.out.print(i + ", ");
            }
        }

    }

    public static char symbol(int number) {
        int[] chekNumbs = {3, 7};
        char[] outString = {'+', '-'};

        for (int i = 0; i < chekNumbs.length; i++) {
            if (number % chekNumbs[i] == 0) {
                return outString[i];
            }
        }
        return '*';
    }
}