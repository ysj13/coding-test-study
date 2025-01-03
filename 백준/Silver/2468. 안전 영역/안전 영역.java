import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] visited;
    static int count;
    static int result = 1;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static void dfs(int height, int x, int y) {
        if (height > max) {
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (visited[newX][newY] == false && map[newX][newY] > height) {
                dfs(height, newX, newY);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        map = new int[110][110];

        for(int i = 1; i <= N; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
                
                max = Math.max(max, n);
                min = Math.min(min, n);
            }
        }
        
        List<Integer> countList = new ArrayList<>();

        for(int height = 0; height <= max; height++) {
            visited = new boolean[110][110];
            count = 0;

            for(int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (!visited[i][j] && map[i][j] > height) {
                        dfs(height, i, j);
                        count++;
                    }
                }
            }
            result = Math.max(result, count);
            countList.add(count);
        }

        Collections.sort(countList, Collections.reverseOrder());

        bw.write(String.valueOf(countList.get(0)));

        bw.close();
        br.close();
    }
 }