import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Map<String, Integer> map = new HashMap<>();

         // 첫 단어의 첫 문자로 초기화
        char lastChar = words[0].charAt(0);

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            // 몇 번째 사람인지와 몇 번째 차례인지 계산
            int person = (i % n) + 1;
            int turn = (i / n) + 1;

            // 중복 단어인지 또는 끝말잇기가 아닌 경우
            if (map.containsKey(word) || (i > 0 && word.charAt(0) != lastChar)) {
                answer[0] = person;
                answer[1] = turn;
                return answer;
            }

            // 맵에 현재 단어 추가
            map.put(word, i);

            // 마지막 문자를 업데이트
            lastChar = word.charAt(word.length() - 1);
        }

        answer[0] = 0;
        answer[1] = 0;
        
        return answer;
    }
}