class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        String str = s;
        String temp = "";
        String binary = "";

        while (!"1".equals(binary)) {
            // 1. 2진법 수에서 0 제거
            for(char c : str.toCharArray()) {
                if(c == '1') {
                    temp += "1";
                } else {
                    answer[1]++;
                }
            }
    
            // 2. 1만남은 수의 길이 계산
            // 3. 계산한 길이를 다시 2진법으로 변환
            binary = Integer.toBinaryString(temp.length());

            str = binary;
            
            answer[0]++;
            temp = "";
        }
        
        return answer;
    }
}