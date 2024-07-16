package recursive;

public class BinaryNumber {

    public void binaryNumber(int n) {

        if (n == 0) {
            return;
        }

        binaryNumber(n / 2);
        System.out.print(n % 2);

    }

    public static void main(String[] args) {

        BinaryNumber binaryNumber = new BinaryNumber();

        binaryNumber.binaryNumber(11);
    }
}
