import java.io.*;
import java.util.*;

public class StockSpan {

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<Integer>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        int S[] = new int[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        
        st.push(0);
        S[0] = 1;
        
        for(int i = 1; i < n; i++){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            S[i] = st.isEmpty() ? i + 1 : i - st.peek();
            st.push(i);
        }
        
        for(int i = 0; i < n; i++){
            System.out.print(S[i] + " ");
        }
    }
}