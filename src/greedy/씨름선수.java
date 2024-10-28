package greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1. 키 순으로 정렬하면 키가 가장 큰 사람은 무조건 선발됨
 * 2. 몸무게를 비교하면서, 최대값이 갱신된다면 나보다 몸무게가 작은 사람이 1명이라도 있다는 의미임
 */
class Body implements Comparable<Body> {

    int height;
    int weight;

    public Body(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Body body) {
        return body.height - this.height;
    }
}

public class 씨름선수 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Body[] bodies = new Body[n];

        for (int i = 0; i < n; i++) {
            int height = sc.nextInt();
            int weight = sc.nextInt();

            bodies[i] = new Body(height, weight);
        }

        Arrays.sort(bodies);

        int max = Integer.MIN_VALUE;
        int count = 0;

        for (int i = 0; i < n; i++) {

            Body body = bodies[i];

            int weight = body.weight;

            if (max < weight) {
                max = weight;
                count++;
            }

        }
        System.out.println(count);

    }
}
