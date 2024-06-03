class Solution {
    public int solution(String s) {
        int answer = 0;
        int sameCount = 0;
        int diffCount = 0;
        
        char f = s.charAt(0);
        
        for(int i = 0; i < s.length(); i++) {
            if(sameCount == diffCount) {
                answer++;
                f = s.charAt(i);
            }
            
            if(f == s.charAt(i)) {
                sameCount++;
            } else {
                diffCount++;
            }
        }
        
        return answer;
    }
}