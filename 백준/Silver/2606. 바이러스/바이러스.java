import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] map;
    static boolean[] visited;
    static int n, m, answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        map = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];

        for(int i = 1; i < m + 1; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = true;
            map[y][x] = true;
        }

        dfs(1);

        System.out.println(answer - 1);
    }

    public static void dfs(int idx) {
        visited[idx] = true;
        answer++;

        for(int i = 1; i <= n; i++) {
            if(map[idx][i] == true && visited[i] == false) {
                dfs(i);
            }
        }
    }
}
