import java.io.*;
import java.util.*;

public class Main {
    final static int MAX = 1001;
    static boolean[][] map;
    static boolean[] visited;
    static int n, m, answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new boolean[MAX][MAX];
        visited = new boolean[MAX];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = true;
            map[y][x] = true;
        }

        for (int i = 1; i <= n; i++) {
            if(visited[i] == false) {
                dfs(i);
                answer++;
            }
        }

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }

    public static void dfs(int idx) {
        visited[idx] = true;
        for(int i = 1; i <= n; i++) {
            if(visited[i] == false && map[idx][i]) {
                dfs(i);
            }
        }
    }
}