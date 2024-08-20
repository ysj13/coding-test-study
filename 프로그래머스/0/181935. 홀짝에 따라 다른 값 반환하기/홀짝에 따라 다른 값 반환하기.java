class Solution {
    public int solution(int n) {
        int answer = 0;
        
        if(n % 2 == 0) {
            // 짝
            for(int i = 2; i <= n; i++) {
                if(i % 2 == 0) {
                    answer += i * i;
                }
            }
        } else {
            // 홀
            for(int i = 1; i <= n; i++) {
                if(i % 2 != 0) {
                    answer += i;
                }
            }
        }
        
        return answer;
    }
}