package string.re._1157;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _1 {
//    Mississipi
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.next().toUpperCase();

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {

            String t = text.substring(i, i + 1);

            if (map.get(t) == null) {
                map.put(t, 1);
            } else {
                Integer value = map.get(t);
                map.put(t, value + 1);
            }
        }

        String max = "";
        int maxValue = 0;

        for (String key : map.keySet()) {
            Integer value = map.get(key);

            if (value > maxValue) {
                maxValue = value;
                max = key;
            }

            else if (maxValue == map.get(key)){
                max = "?";
            }
        }

        System.out.println(max);

    }
}
