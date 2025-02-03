import java.util.*;

public class Celebrity {
    
    public static int Myfunction(int[][] mat) {
        Stack<Integer> stk = new Stack<>();
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            stk.push(i);
        }
        while (stk.size() > 1) {
            int col = stk.pop();
            int row = stk.pop();
            if (mat[row][col] == 1) {
                stk.push(col);
            } else {
                stk.push(row);
            }
        }
        int x = stk.pop();
        for (int j = 0; j < n; j++) {
            if (j == x) continue;
            if (mat[x][j] == 1) return -1;
        }
        for (int k = 0; k < n; k++) {
            if (k == x) continue;
            if (mat[k][x] == 0) return -1;
        }
        return x;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] mat = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = input.nextInt();
            }
        }
        int ret = Myfunction(mat);
        if (ret == -1) {
            System.out.println("No Celebrity");
        } else {
            System.out.println(ret);
        }
    }
}
