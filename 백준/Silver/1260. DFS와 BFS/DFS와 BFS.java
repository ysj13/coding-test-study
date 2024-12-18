import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[] visited;   // 배열의 인덱스가 정점의 번호와 같다
    static int N, M, start;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());        // 정점의 개수
        M = Integer.parseInt(st.nextToken());        // 간선의 개수
        start = Integer.parseInt(st.nextToken());    // 시작 번호

        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = 1;
            arr[y][x] = 1;
        }
        // 입력 끝

        // dfs
        dfs(start);
        sb.append('\n');

        for (int i = 1; i <= N; i++) {
            visited[i] = false;
        }

        // bfs
        bfs(start);
        System.out.println(sb);

    }

    static void dfs(int x) {
        visited[x] = true;
        sb.append(x).append(' ');
        for (int y = 1; y <= N; y++) {
            if (arr[x][y] == 0) continue;
            if (visited[y]) continue;
            dfs(y);
        }

    }

    static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();

        q.add(x);
        visited[x] = true;

        while (!q.isEmpty()) {
            x = q.poll();
            sb.append(x).append(' ');

            for (int y = 1; y <= N; y++) {
                if (arr[x][y] == 0) continue;
                if (visited[y]) continue;

                q.add(y);
                visited[y] = true;
            }
        }
    }
}
