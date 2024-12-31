import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int N;
    static String[][] map;
    static boolean[][] visited;
    static final int MAX = 110;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static void dfs(int x, int y, String s) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (map[newX][newY] != null) {
                if (!visited[newX][newY] && s.equals(map[newX][newY])) {
                    dfs(newX, newY, s);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        map = new String[MAX][MAX];
        visited = new boolean[MAX][MAX];

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= N; j++) {
                map[i][j] = Character.toString(str.charAt(j - 1));
            }
        }

        int count1 = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(visited[i][j] == false) {
                    dfs(i, j, map[i][j]);
                    count1++;
                }
            }
        }

        visited = new boolean[MAX][MAX];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if("G".equals(map[i][j])) {
                    map[i][j] = "R";
                }
            }
        }

        int count2 = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(visited[i][j] == false) {
                    dfs(i, j, map[i][j]);
                    count2++;
                }
            }
        }

        bw.write(count1 + " " + count2);

        bw.close();
        br.close();
    }
 }