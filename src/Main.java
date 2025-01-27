import java.time.YearMonth;

public class Main {

    public static void main(String[] args) {

        YearMonth now = YearMonth.now();

        System.out.println(now.toString());

        System.out.println(now.plusMonths(1));
        System.out.println(now.plusYears(5));

    }
}