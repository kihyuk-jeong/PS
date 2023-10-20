import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        char[][] arr = new char[3][4];

        arr[0] = "100".toCharArray();

        System.out.println(Arrays.toString(arr));

    }


}