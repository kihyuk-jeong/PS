package repeat.more;

// 0 = 빈칸
// 1 = 집
// 2 = 피자집

// 집과 피자집의 피자배달거리 = |x1-x2| + |y1-y2|
// 최소 피자 배달 거리 = 각 집과 모든 피자집을 하나하나씩 피자배달거리를 구하고, 그 중 가장 작은 값.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 치킨집 {

    private static int n, m;
    private static List<Point> chickens;
    private static List<Point> homes;

    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        chickens = new ArrayList<>();
        homes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = sc.nextInt();

                if (value == 1) {
                    homes.add(new Point(i, j));
                }

                if (value == 2) {
                    chickens.add(new Point(i, j));
                }
            }
        }

        dfs(0, 0, new ArrayList<>());

        System.out.println(answer);
    }

    private static void dfs(int level, int startIndex, List<Point> selectChickenHouse) {

        // m 개의 치킨집이 select 되었다면
        if (level == m) {

            // 각 집과 선택된 피자집들의 배달 거리를 구하고, 각 집의 피자 배달 거리 최소값 갱신

            int cityMinValue = 0;

            for (int i = 0; i < homes.size(); i++) {
                int houseMinValue = Integer.MAX_VALUE;

                int x1 = homes.get(i).x;
                int y1 = homes.get(i).y;

                for (Point selectChicken : selectChickenHouse) {

                    int x2 = selectChicken.x;
                    int y2 = selectChicken.y;

                    houseMinValue = Math.min(houseMinValue, (Math.abs(x1 - x2) + Math.abs(y1 - y2)));
                }
                cityMinValue += houseMinValue;
            }

            answer = Math.min(answer, cityMinValue);

            return;
        }


        for (int i = startIndex; i < chickens.size(); i++) {
            selectChickenHouse.add(chickens.get(i));
            dfs(level + 1, i + 1, selectChickenHouse);
            selectChickenHouse.remove(selectChickenHouse.size() - 1);
        }


    }
}
