import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length / 2;
        HashSet<Integer> set = new HashSet<>();

        for(int i : nums) {
            set.add(i);
        }

        if(set.size() > n) {
            answer = n;
        } else if(set.size() <= n) {
            answer = set.size();
        }

        return answer;
    }
}