import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        recursive(1, n, new ArrayList<>());

        for (List<Integer> list : result) {
            System.out.println(list.toString());
        }
    }

    private static void recursive(int startIndex, int n, List<Integer> current) {

        if (current.size() == 3) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = startIndex; i <= n; i++) {

            current.add(i);
            recursive(i+1, n, current);
            current.remove(current.size() - 1);
        }
    }



}