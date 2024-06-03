package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 1. poll 로 뽑아서, 남은 큐 들을 순회함. 자신보다 높은 위홈도를 가진 사람이 있다면 맨 뒤로 보냄
 * 2. 우선순위가 가장 높다면, 진료를 하고 poll 로 나감. 만약 나간 녀석이 m 이라면 그게 몇 번째 인지 확인.
 * 3. 확인하는 변수를 둘 것
 */

class Person {

    private final Integer index;
    private final Integer priority;

    public Integer getIndex() {
        return index;
    }

    public Integer getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Person{" +
                "index=" + index +
                ", priority=" + priority +
                '}';
    }

    public Person(Integer index, Integer priority) {
        this.index = index;
        this.priority = priority;
    }
}

public class 응급실 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Queue<Person> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            queue.offer(new Person(i, sc.nextInt()));
        }

        solve(queue, m);

    }

    private static void solve(Queue<Person> queue, int m) {

        int count = 0;

        while (!queue.isEmpty()) {
            Person currentPerson = queue.poll();

            for (Person person : queue) {
                if (currentPerson.getPriority() < person.getPriority()) {
                    queue.offer(currentPerson);
                    currentPerson = null;
                    break;
                }
            }

            if (currentPerson != null) {
                if (currentPerson.getIndex() == m) {
                    count++;
                    break;
                } else {
                    count++;
                }
            }
        }

        System.out.println(count);



    }
}
