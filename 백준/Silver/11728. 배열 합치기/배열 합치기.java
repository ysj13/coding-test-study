import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[N];
        int[] arr2 = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        int p1 = 0;
        int p2 = 0;
        StringBuilder sb = new StringBuilder();
        while (p1 < N && p2 < M) {
            if (arr1[p1] <= arr2[p2]) {
                sb.append(arr1[p1++]).append(" ");
            } else {
                sb.append(arr2[p2++]).append(" ");
            }
        }

        while (p1 < N) {
            sb.append(arr1[p1++]).append(" ");
        }

        while (p2 < M) {
            sb.append(arr2[p2++]).append(" ");
        }

        bw.write(String.valueOf(sb));

        bw.flush();
        bw.close();
        br.close();
    }
}
