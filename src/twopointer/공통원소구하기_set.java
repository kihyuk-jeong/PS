package twopointer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class 공통원소구하기_set {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Set<Integer> setA = new HashSet<>();
        for (int i = 0; i < n; i++) {
            setA.add(scanner.nextInt());
        }

        int m = scanner.nextInt();
        List<Integer> commonElements = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int element = scanner.nextInt();
            if (setA.contains(element)) {
                commonElements.add(element);
            }
        }

        Collections.sort(commonElements);
        for (int elem : commonElements) {
            System.out.print(elem + " ");
        }
    }
}