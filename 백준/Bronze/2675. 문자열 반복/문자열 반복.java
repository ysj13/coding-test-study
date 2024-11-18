import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            String s = st.nextToken();

            StringBuilder sb = new StringBuilder();
            
            for(int j = 0; j < s.length(); j++) {
                String temp = String.valueOf(s.charAt(j));
                sb.append(str(temp, num));
            }

            System.out.println(sb.toString());
        }
    }

    public static String str(String s, int cnt) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < cnt; i++) {
            sb.append(s);
        }

        return sb.toString();
    }
}