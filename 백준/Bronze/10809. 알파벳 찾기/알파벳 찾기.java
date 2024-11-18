import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] alpha = new char[26];
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < 26; i++) {
            alpha[i] = (char) ('a' + i);
        }

        for(int i = 0; i < s.length(); i++) {
            map.putIfAbsent(s.charAt(i), s.indexOf(s.charAt(i)));
        }

        for(int i = 0; i < 26; i++) {
            if(map.containsKey(alpha[i])) {
                System.out.print(map.get(alpha[i]) + " ");
            } else {
                System.out.print("-1 ");
            }
        }
    }
}