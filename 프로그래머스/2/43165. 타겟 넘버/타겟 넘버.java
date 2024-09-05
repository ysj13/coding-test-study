class Solution {
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        targetNumber(numbers, 0, 0, target);
        return answer;
    }
    
    static void targetNumber(int[] numbers, int index, int sum, int target) {

        // 모든 숫자를 다 사용한 경우
        if (index == numbers.length) {
            // 타겟넘버 == sum 인 경우
            if(target == sum) {
                answer++;
            }
            
            return;
        }
        
        targetNumber(numbers, index + 1, sum + numbers[index], target);
        targetNumber(numbers, index + 1, sum - numbers[index], target);
    }
}