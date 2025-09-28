import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {


    public static void main(String[] args) throws URISyntaxException {

        System.out.println(
                LocalDateTime.now().plusDays(30).minusYears(5).minusDays(3)
        );

    }


}