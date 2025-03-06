import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int G = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= G/2+1; i++) {
            list.add(i);
        }

        for (int i = 0; i < list.size(); i++) {
            double a = Math.pow(list.get(i), 2);

            double b = 0.0;
            if (a - G > 0) {
                b = Math.sqrt(a - G);

                if (b % 1 == 0) {
                    result.add(list.get(i));
                }
            }
        }

        if (result.isEmpty()) {
            result.add(-1);
        }

        Collections.sort(list);

        for (int i = 0; i < result.size(); i++) {
            bw.write(String.valueOf(result.get(i)));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
