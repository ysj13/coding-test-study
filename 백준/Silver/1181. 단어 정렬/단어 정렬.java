import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Set<String> set = new HashSet<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        List<String> list = new ArrayList<>(set);

        Collections.sort(list, Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()));

        for (String s : list) {
            bw.write(String.valueOf(s));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
