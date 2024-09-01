import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        OffsetDateTime now = OffsetDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

        String format = now.format(formatter);

        System.out.println(format);

//        2024-08-14T12:34:56.000+09:00
//        2024-08-29T11:22:36.271309+09:00
    }

}