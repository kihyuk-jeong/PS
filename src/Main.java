import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        Long memberMemberUid = 8096498L;

        int endIndex = Math.round((float) memberMemberUid / 10000);

        List<String> collect = IntStream.rangeClosed(0, endIndex + 1)
                .mapToObj(String::valueOf)
                .collect(Collectors.toList());

        System.out.println(collect);
    }

}