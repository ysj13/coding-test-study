import java.util.*;
import java.io.*;

class Main {
    final static int MAX = 1000000 + 10;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int N, M, R;
    static int[] answer;
    static int order;

    public static void dfs(int n) {
        visited[n] = true;
        answer[n] = order;
        order++;

        for(int i = 0; i < graph[n].size(); i++) {
            int next = graph[n].get(i);
            
            if (visited[next] == false) {
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[MAX];
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        visited = new boolean[MAX];
        answer = new int[MAX];
        order = 1;

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[y].add(x);
            graph[x].add(y);
        }

        for(int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        dfs(R);

        for(int i = 1; i <=N; i++) {
            bw.write(String.valueOf(answer[i]));
            bw.newLine();
        }
        
        bw.close();
        br.close();
    }
}