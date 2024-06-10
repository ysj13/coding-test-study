class Solution {
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return answer;
    }
    
    static void dfs(int[] nums, int idx, int target, int num) {
        if(idx == nums.length) {
            if(num == target) {
                answer++;
            }
            
            return;
        }
        
        int plus = num + nums[idx];
        int minus = num - nums[idx];
        
        dfs(nums, idx + 1, target, plus);
        dfs(nums, idx + 1, target, minus);
    }
}