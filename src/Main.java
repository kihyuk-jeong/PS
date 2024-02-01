import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String binaryNumbers = getBinaryNumbers("#*****#");

        System.out.println(binaryNumbers);
        int temp = 0;
        int powCount = 6;

        for (int i = 0; i < 7; i++) {
            if (binaryNumbers.charAt(i) == '1') {
                temp += (int) Math.pow(2, powCount);
            }
            powCount--;
        }

        System.out.println(temp);


    }

    private static String getBinaryNumbers(String temp) {

        StringBuilder binaryNumbers = new StringBuilder();

        for (int i = 0; i < temp.length(); i++) {

            if (temp.charAt(i) == '#') {
                binaryNumbers.append("1");
            } else {
                binaryNumbers.append("0");
            }

        }
        return binaryNumbers.toString();
    }
}