package recursive;

public class Fibonacci {

    static int[] fibo;

    public int DFS(int n) {

        if (fibo[n] > 0) {
            return fibo[n];
        }

        if (n == 1) {
            return fibo[n] = 1;
        } else if (n == 2) {
            return fibo[n] = 1;
        } else {
            return fibo[n] = DFS(n - 2) + DFS(n - 1);
        }
    }

    public static void main(String[] args) {

        int n = 50;
        fibo = new int[n + 1];

        Fibonacci fibonacci = new Fibonacci();

        for (int i = 1; i <= n; i++) {
            System.out.print(fibonacci.DFS(i) + " ");
        }


    }
}
