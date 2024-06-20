import java.util.List;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        int max = 16028371;

        int CHUNK_SIZE = 100000;
        int endIndex = (int) Math.ceil(max / CHUNK_SIZE);

        System.out.println(endIndex);

        List<String> collect = IntStream.rangeClosed(0, endIndex + 1)
                .mapToLong(index -> (index * CHUNK_SIZE) + 1)
                .mapToObj(String::valueOf)
                .toList();


        System.out.println(collect.size());


    }
}