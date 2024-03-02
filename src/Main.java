import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String partition = "#****##";

        String replace = partition.replace("#", "1").replace("*", "0");

        int binaryNumber = Integer.parseInt(replace, 2);

        System.out.println((char)binaryNumber);


    }

}