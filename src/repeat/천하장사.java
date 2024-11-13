package repeat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 1. 키 또는 몸무게 내림차순으로 정렬
 * 2. 맨 위에 있는 녀석은 키 또는 몸무게 중 하나는 무조건 제일 high 하다는 의미 (즉, 무조건 선발)
 * 3. 만약 몸무게 순으로 정렬했다면, 키라도 위에있는 아이들 보다 커야함.
 */

class Spec implements Comparable<Spec> {


    int height;
    int weight;

    public Spec(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }


    @Override
    public int compareTo(Spec spec) {
        return spec.weight - this.weight;
    }
}

public class 천하장사 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Spec> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new Spec(sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(list);

        int base = 0;
        int count = 0;

        for (Spec spec : list) {
            int height = spec.height;

            if (height > base) {
                count++;
                base = height;
            }

        }

        System.out.println(count);
    }

}

// 5
// 172 67
// 183 65
// 180 70
// 170 72
// 181 60