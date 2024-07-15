package recursive;

public class Main {

    public void DFS(int n) {

        if (n == 0) {
            return;
        } else {
//            DFS(n - 1);
            System.out.println(n);
            DFS(n - 1);


        }

    }

    public static void main(String[] args) {

        Main main = new Main();
        main.DFS(3);

    }


}
