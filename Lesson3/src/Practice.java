import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lenth = scanner.nextInt();
        int[] array = new int[lenth];

        for(int i = 0;i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        System.out.println(Arrays.toString(array));


    }
}
