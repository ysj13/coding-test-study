import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count = 0;
        boolean 소수 = false;
        for (int i = 0; i < n; i++) {
            소수 = 소수개수(sc.nextInt());
            if (소수 == true) {
                count++;
            }
        }

        System.out.println(count);
    }

    static boolean 소수개수(int n) {
        if (n == 1) {
            return false;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
