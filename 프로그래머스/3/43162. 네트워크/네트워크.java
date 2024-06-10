class Solution {
    static boolean[][] map;
    static boolean[] visited;
    
    static void dfs(int idx) {
        visited[idx] = true;

        for(int i = 0; i < map.length; i++) {
            if(visited[i] == false && map[idx][i] == true) {
                dfs(i);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        map = new boolean[n][n];
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i != j && computers[i][j] == 1) {
                    map[i][j] = true;
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(visited[i] == false) {
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
}