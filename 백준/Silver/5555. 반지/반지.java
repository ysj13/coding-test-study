import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<String> list = new ArrayList<>();
        int count = 0;

        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            String s = br.readLine();
            sb.append(s);
            sb.append(s);

            list.add(sb.toString());
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains(str)) {
                count++;
            }
        }

        bw.write(Integer.toString(count));
        bw.close();
        br.close();
    }
}