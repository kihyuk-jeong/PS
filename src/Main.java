import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayDeque;

public class Main {


    public static void main(String[] args) {

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= 5; i++) {
            deque.addLast(i);
        }
        System.out.println(deque);
    }
}