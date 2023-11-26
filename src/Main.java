import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LocalDate lastOrder = LocalDate.of(2023, 04, 05);

        LocalDate localDate = LocalDate.now().minusMonths(6);

        System.out.println(lastOrder);
        System.out.println(localDate);

        System.out.println(lastOrder.isBefore(localDate));


    }
}