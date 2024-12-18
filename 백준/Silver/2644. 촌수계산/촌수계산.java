import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, s, e, m;
    static int MAX = 110;
    static boolean[][] map;
    static boolean[] visited;
    static int result = -1;

    static void dfs(int idx, int count) {
        visited[idx] = true;

        if (idx == e) {
            result = count;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i] == false && map[idx][i] == true) {
                dfs(i, count + 1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        map = new boolean[MAX][MAX];
        visited = new boolean[MAX];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = true;
            map[b][a] = true;
        }

        dfs(s, 0);

        System.out.println(result);
    }
}