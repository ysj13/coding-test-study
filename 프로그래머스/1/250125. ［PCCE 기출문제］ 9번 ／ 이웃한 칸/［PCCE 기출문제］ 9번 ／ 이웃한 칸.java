class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        String color = board[h][w];

        // 상하좌우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        // 4방향 탐색 & board 범위 안으로 제한
        for(int i = 0; i < 4; i ++) {
            int x = h + dx[i];
            int y = w + dy[i];
            if(x >= 0 && y >= 0 && x <= board.length - 1 && y <= board.length - 1) {
                if(color.equals(board[x][y])) {
                    answer++;
                }
            }

            x = 0;
            y = 0;
        }

        return answer;
    }
}