package recursive.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Pnt {
    int x;
    int y;

    public Pnt(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 피자배달부 {

    private static int n, m;
    private static int answer = Integer.MAX_VALUE;

    private static List<Pnt> pizza, house;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        pizza = new ArrayList<>();
        house = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int value = sc.nextInt();

                if (value == 1) {
                    house.add(new Pnt(i, j));
                }

                if (value == 2) {
                    pizza.add(new Pnt(i, j));
                }
            }
        }

        dfs(0, 0, new ArrayList<Pnt>());

        System.out.println(answer);
    }

    private static void dfs(int level, int startIndex, ArrayList<Pnt> pizzaPointList) {

        if (level == m) {

            int sum = 0;

            for (Pnt housePnt : house) {

                int homeMinDis = Integer.MAX_VALUE;

                int houseX = housePnt.x;
                int houseY = housePnt.y;

                for (Pnt pizzaPnt : pizzaPointList) {

                    int pizzaX = pizzaPnt.x;
                    int pizzaY = pizzaPnt.y;

                    homeMinDis = Math.min(homeMinDis, (Math.abs(houseX - pizzaX) + Math.abs(houseY - pizzaY)));
                }

                sum += homeMinDis;
            }

            answer = Math.min(sum, answer);


            return;
        }

        for (int i = startIndex; i < pizza.size(); i++) {
            pizzaPointList.add(pizza.get(i));
            dfs(level + 1, i + 1, pizzaPointList);
            pizzaPointList.remove(pizzaPointList.size() - 1);
        }
    }
}
