import java.util.Scanner;

public class TowerofHanoi {

    public static void towerOfHanoi(int n, char source, char auxiliary, char destination) {
        if (n == 0) return;
        towerOfHanoi(n - 1, source, destination, auxiliary);
        System.out.println(source + " " + destination);
        towerOfHanoi(n - 1, auxiliary, source, destination);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        towerOfHanoi(n, 'a', 'b', 'c');
    }
}
