import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        for (int right = 0; right < N; right++) {
            sum += arr[right];
            
            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= arr[left++];
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            bw.write(String.valueOf(0));
        } else {
            bw.write(String.valueOf(minLength));
        }

        bw.flush();
        bw.close();
        br.close();
    }
    
}