import java.util.*;

public class Solution {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
//         System.out.println('A' - 0);
//         System.out.println('Z' - 0);
        
//         System.out.println('a' - 0);
//         System.out.println('z' - 0);
        
        for(char c : a.toCharArray()) {
            int i = c - 0;
            if(i >= 65 && i <= 90) {
                sb.append((c + "").toLowerCase());
            }
            
            if(i >= 97 && i <= 122) {
                sb.append((c + "").toUpperCase());
            }
        }
        
        System.out.println(sb.toString());
    }
}