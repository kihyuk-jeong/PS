import java.io.IOException;
import java.util.Base64;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {
        String di = "37fjvg5150po562ut02flddh0f:17n6a0ee7ffv1366fuj25vp8n3uhma1jsa671h150g8pdcl35r63";
        String s = Base64.getEncoder().encodeToString(di.getBytes());

        System.out.println(s);


    }

    private static List<Long> get() {
        return List.of();
    }

}