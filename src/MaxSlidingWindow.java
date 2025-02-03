import java.util.*;

public class MaxSlidingWindow {
    
    public static void maxSlidingWindow(int[] arr, int k) {
        int[] maxLeft = new int[arr.length];
        int[] maxRight = new int[arr.length];

        maxLeft[0] = arr[0];
        maxRight[arr.length - 1] = arr[arr.length - 1];

        for (int i = 1; i < arr.length; i++) {
            if (i % k == 0) {
                maxLeft[i] = arr[i];
            } else {
                maxLeft[i] = Math.max(maxLeft[i - 1], arr[i]);
            }

            int j = arr.length - 1 - i;
            if (j % k == 0) {
                maxRight[j] = arr[j];
            } else {
                maxRight[j] = Math.max(maxRight[j + 1], arr[j]);
            }
        }

        int[] slidingMax = new int[arr.length - k + 1];
        int j = 0;
        for (int i = 0; i + k <= arr.length; i++) {
            slidingMax[j] = Math.max(maxRight[i], maxLeft[i + k - 1]);
            j++;
        }

        for (int i = 0; i < slidingMax.length; i++) {
            System.out.print(slidingMax[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        int k = input.nextInt();
        maxSlidingWindow(arr, k);
    }
}
