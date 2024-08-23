import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {



        System.out.println(isPrimeNumber(17));
    }

    private static boolean isPrimeNumber(int number) {

        if (number == 0 || number == 1) {
            return false;
        }

        int limit = (int) Math.sqrt(number);

        for (int i = 2; i <= limit; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }


}