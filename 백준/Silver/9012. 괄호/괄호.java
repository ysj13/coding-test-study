import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }
        
        for (String s : list) {
            Stack<String> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {  
                String str = Character.toString(s.charAt(i));
                // 여는괄호
                if ("(".equals(str)) {
                    stack.push(str);
                } else {
                    // 닫는괄호
                    if (stack.isEmpty()) {
                        stack.push(str);
                        break;
                    } else {
                        String peek = stack.peek();

                        if ("(".equals(peek)) {
                            stack.pop();
                        } else {
                            stack.push(str);
                            break;
                        }
                    }
                }
            }
            
            if (!stack.isEmpty()) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
