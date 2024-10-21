class Solution {
    public int solution(String my_string, String is_prefix) {
        int answer = 0;
        
        if(my_string.length() >= is_prefix.length()) {
            String sub = my_string.substring(0, is_prefix.length());
            if(sub.equals(is_prefix)) {
                answer = 1;
            }
        }
        
        return answer;
    }
}