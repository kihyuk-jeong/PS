package repeat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Map {
    int x;
    int y;

    public Map(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 배달 {

    private static int n, m;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        ArrayList<Map> pizzaList = new ArrayList<>();
        ArrayList<Map> houseList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = sc.nextInt();

                if (value == 2) {
                    pizzaList.add(new Map(i, j));
                }

                if (value == 1) {
                    houseList.add(new Map(i, j));
                }
            }
        }

        dfs(0, 0, pizzaList, houseList, new ArrayList<>());

        System.out.println(answer);
    }

    private static void dfs(int level, int startIndex, List<Map> pizzaList, List<Map> houseList, List<Map> selectPizzaHouse) {

        if (level == m) {

            // 집과 피자집들의 배달 거리 중 가장 최소인 값이 그 집의 최소 피자 배달거리 이고
            // 각 집의 최소 피자 배달 거리를 모두 합친 값이 그 도시의 최소 피자 배달거리 이다.

            int cityMinValue = 0;
            for (Map house : houseList) {

                int houseMinDistance = Integer.MAX_VALUE;

                int houseX = house.x;
                int houseY = house.y;

                for (Map pizza : selectPizzaHouse) {

                    int pizzaX = pizza.x;
                    int pizzaY = pizza.y;

                    houseMinDistance = Math.min(houseMinDistance, (Math.abs(houseX - pizzaX) + Math.abs(houseY - pizzaY)));
                }

                cityMinValue += houseMinDistance;
            }

            answer = Math.min(answer, cityMinValue);


            return;
        }

        for (int i = startIndex; i < pizzaList.size(); i++) {
            selectPizzaHouse.add(pizzaList.get(i));
            dfs(level + 1, i + 1, pizzaList, houseList, selectPizzaHouse);
            selectPizzaHouse.remove(selectPizzaHouse.size() - 1);
        }


    }


}
