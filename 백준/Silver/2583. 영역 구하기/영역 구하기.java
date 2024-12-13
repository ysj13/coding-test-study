import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<Rectangle> rectangles = new ArrayList<>();
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로 크기
        M = Integer.parseInt(st.nextToken()); // 가로 크기
        K = Integer.parseInt(st.nextToken()); // 직사각형 개수
 
        map = new int[N][M];
        visited = new boolean[N][M];
 
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            rectangles.add(new Rectangle(x1, y1, x2, y2));
        }
 
        fillRectangles();

        int count = 0;
        List<Integer> size = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0 && !visited[i][j]) {
                    size.add(bfs(i, j));
                    count++;
                }
            }
        }

        Collections.sort(size);

        bw.write(String.valueOf(count) + "\n");
        for (Integer integer : size) {
            bw.write(integer + " ");
        }
        
        bw.close();
        br.close();
    }

    static void fillRectangles() {
        for (Rectangle rect : rectangles) {
            for (int x = rect.x1; x < rect.x2; x++) {
                for (int y = rect.y1; y < rect.y2; y++) {
                    if (x >= 0 && x < M && y >= 0 && y < N) {
                        map[y][x] = 1;
                    }
                }
            }
        }
    }
    
    static int bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});
        visited[y][x] = true;
        int size = 1;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int cy = current[0];
            int cx = current[1];
            
            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if(map[ny][nx] == 0 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        queue.offer(new int[]{ny, nx});
                        size++;
                    }
                }
            }
        }

        return size;
    }
 
    static class Rectangle {
        int x1, y1, x2, y2;
 
        public Rectangle(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
 
        public int getX1() {
             return x1;
        }

        public int getY1() { 
            return y1; 
        }

        public int getX2() { 
            return x2; 
        }

        public int getY2() { 
            return y2; 
        }
    }
 }