import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int[] answer;

    static void dfs(int idx) {
        visited[idx] = true;

        for(int i = 0; i < graph[idx].size(); i++) {
            int next = graph[idx].get(i);
            if(visited[next] == false) {
                answer[next] = idx;
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 10];
        answer = new int[N + 10];
        graph = new ArrayList[N + 10];

        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        dfs(1);

        for(int i = 2; i <= N; i++) {
            bw.write(String.valueOf(answer[i]));
            bw.newLine();
        }

        bw.close();
        br.close();

    }
}
