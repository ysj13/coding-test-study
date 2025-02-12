import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Integer> stack = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<String> list = new ArrayList<>(); 

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            list.add(s);
        }

        for(String str : list) {
            if (str.contains("push")) {
                int num = Integer.parseInt(str.split(" ")[1]);
                push(num);
            } else if("pop".equals(str)) {
                bw.write(String.valueOf(pop()) + "\n");
            } else if("size".equals(str)) {
                bw.write(String.valueOf(size()) + "\n");
            } else if("empty".equals(str)) {
                bw.write(String.valueOf(empty()) + "\n");
            } else if("top".equals(str)) {
                bw.write(String.valueOf(top()) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }

    public static void push(int n) {
        stack.add(n);
    }

    public static int pop() {
        if (stack.isEmpty()) {
            return -1;
        }

        int n = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);

        return n;
    }

    public static int size() {
        return stack.size();
    }

    public static int empty() {
        return stack.isEmpty() ? 1 : 0;
    }

    public static int top() {
        if (stack.isEmpty()) {
            return -1;
        }

        return stack.get(stack.size() - 1);
    }
}