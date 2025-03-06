import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left = 0;
        int result = Integer.MAX_VALUE;

        for (int right = 0; right < arr.length; right++) {
            int diff = Math.abs(arr[right] - arr[left]);

            while (diff >= M) {
                result = Math.min(diff, result);
                left++;

                if (left > right) {
                    break;
                }
                
                diff = Math.abs(arr[right] - arr[left]);
            }
        }

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }
}
