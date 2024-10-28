package recursive.dfs;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 각 집 마다 '피자배달거리' 를 갖는다. '피자배달거리' 는 존재하는 모든 피자집과의 거리를 계산해서 가장 작은 값이 된다.
 * 도시의 피자배달 거리는 각 집의 피자배달거리를 전부 합한 값이다.
 */

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 피자배달거리 {

    private static int n, m;
    private static int answer = Integer.MAX_VALUE;

    private static ArrayList<Point> selectPizza;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        // 피자집만 골라내는 작업이 필요함.

        ArrayList<Point> pizzaHouse = new ArrayList<>();
        ArrayList<Point> home = new ArrayList<>();
        selectPizza = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = sc.nextInt();

                if (value == 2) {
                    pizzaHouse.add(new Point(i, j));
                }

                if (value == 1) {
                    home.add(new Point(i, j));
                }

            }
        }

        dfs(0, 0, pizzaHouse, home);

        System.out.println(answer);
    }

    private static void dfs(int level, int start, ArrayList<Point> pizzaHouse, ArrayList<Point> home) {

        if (level == m) {

            int sum = 0;

            for (Point homePoint : home) {

                int homeX = homePoint.x;
                int homeY = homePoint.y;

                int dis = Integer.MAX_VALUE;

                for (int i = 0; i < m; i++) {
                    Point pizzaPoint = selectPizza.get(i);

                    int pizzaX = pizzaPoint.x;
                    int pizzaY = pizzaPoint.y;

                    dis = Math.min(dis, Math.abs(homeX - pizzaX) + Math.abs(homeY - pizzaY));
                }
                sum += dis;
            }

            answer = Math.min(answer, sum);

            return;
        }

        for (int i = start; i < pizzaHouse.size(); i++) {

            selectPizza.add(pizzaHouse.get(i));
            dfs(level + 1, i + 1, pizzaHouse, home);
            selectPizza.remove(selectPizza.size() - 1);
        }

    }

}
