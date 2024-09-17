import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        List<String> collect = IntStream.rangeClosed(0, 1501)
                .mapToObj(String::valueOf)
                .collect(Collectors.toList());

        System.out.println(collect);


    }



}