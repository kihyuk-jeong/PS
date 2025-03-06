package repeat.more;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.acmicpc.net/problem/15686

class PointP {
    int x;
    int y;

    public PointP(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 치킨배달 {

    private static ArrayList<PointP> selectChicken;
    private static ArrayList<PointP> chicken;
    private static ArrayList<PointP> houses;

    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        selectChicken = new ArrayList<>();
        chicken = new ArrayList<>();
        houses = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int value = sc.nextInt();

                if (value == 1) {
                    houses.add(new PointP(i, j));
                }

                if (value == 2) {
                    chicken.add(new PointP(i, j));
                }
            }
        }

        // 치킨집 선택
        dfs(0, 0, m);

        System.out.println(answer);


        /**
         * 1. 1은 집. 집의 좌표를 저장할
         * 2. 2는 치킨집. 치킨집의 좌표를 저장함.
         * 3. 치킨집은 M 개만 선택되어야 함. 여러 치킨집 중 M 개의 조합을 구함
         */

    }

    private static void dfs(int level, int startIndex, int m) {

        if (level == m) {

            int cityChickenDistance = 0;

            // 각 집과
            for (PointP housePoint : houses) {

                // 이 집의 치킨 거리
                int houseChickenDistance = Integer.MAX_VALUE;

                int houseX = housePoint.x;
                int houseY = housePoint.y;

                for (PointP selectChicken : selectChicken) {
                    int selectChickenX = selectChicken.x;
                    int selectChickenY = selectChicken.y;

                    int chickenDistance = Math.abs(houseX - selectChickenX) + Math.abs(houseY - selectChickenY);
                    houseChickenDistance = Math.min(houseChickenDistance, chickenDistance);
                }

                cityChickenDistance += houseChickenDistance;
            }

            answer = Math.min(answer, cityChickenDistance);
            return;
        }

        for (int i = startIndex; i < chicken.size(); i++) {
            selectChicken.add(chicken.get(i));
            dfs(level + 1, i + 1, m);
            selectChicken.remove(selectChicken.size() - 1);
        }
    }
}
