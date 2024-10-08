package etc;

import java.util.Scanner;

/**
 * 유클리드호제법
 * 1. A 와 B 숫자가 주어진다. (A > B)
 * 2. B 가 0 이라면 A 가 최대공약수가 된다.
 * 3. 재귀적 호출로 A 자리에 B 가 들어가고, B 자리에 A % B 가 들어간다.
 * 요약 : 큰 수를 작은수로 나눈 '나머지'를 '작은 수' 자리로 보내고, '작은수' 를 '큰수' 자리로 보낸다.
 */
public class 최대공약수_GCD {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();


        int gcd = getGCD(n, m);

        System.out.println(gcd);

    }

    private static int getGCD(int n, int m) {

        if (m == 0) {
            return n;
        }

        return getGCD(m, n % m);
    }


}
