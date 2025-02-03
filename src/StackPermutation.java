import java.util.*;

public class StackPermutation {
    
    public static void permute(int[] arr1, int[] arr2) {
        Stack<Integer> s1 = new Stack<>();
        int j = 0;
        
        for (int i = 0; i < arr1.length; i++) {
            s1.push(arr1[i]); 
            while (!s1.isEmpty() && s1.peek() == arr2[j]) { 
                s1.pop();
                j++; 
            }
        }
        
        if (j == arr2.length) {
            System.out.println("YES");
        } else {
            System.out.println("Not Possible");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str1 = input.nextLine(); 
        String str2 = input.nextLine();
        
        String[] s1 = str1.split(" ");
        String[] s2 = str2.split(" ");
        
        int[] arr1 = new int[s1.length];
        int[] arr2 = new int[s2.length];
        
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = Integer.parseInt(s1[i]); 
        }
        
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = Integer.parseInt(s2[i]);
        }
        
        permute(arr1, arr2); 
    }
}