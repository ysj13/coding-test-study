class Solution {
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static void dfs(int x, int y, char[][] grid) {
        // 방문한곳 체크
        visited[x][y] = true;

        // 4방향 탐색
        for (int i = 0; i < 4; i++) {
            int newX = dx[i] + x;
            int newY = dy[i] + y;

            if (newX >= 0 && newY >= 0  
            && newX < grid.length && newY < grid[0].length 
            && !visited[newX][newY] && grid[newX][newY] == '1') {
                dfs(newX, newY, grid);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int answer = 0;
        int n = grid.length;
        int m = grid[0].length;

        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    dfs(i, j, grid);
                    answer++;
                }
            }
        }

        return answer;
        
    }
}