import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> keyMap = new HashMap<>();

        for (String keys : keymap) {
            for (int i = 0; i < keys.length(); i++) {
                char c = keys.charAt(i);
                if (!keyMap.containsKey(c)) {
                    keyMap.put(c, i + 1);
                } else {
                    keyMap.put(c, Math.min(keyMap.get(c), i + 1));
                }
            }
        }
        
       int[] result = new int[targets.length];
        
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int totalStrokes = 0;
            boolean isPossible = true;
            
            for (char c : target.toCharArray()) {
                if (keyMap.containsKey(c)) {
                    totalStrokes += keyMap.get(c);
                } else {
                    isPossible = false;
                    break;
                }
            }
            
            if (isPossible) {
                result[i] = totalStrokes;
            } else {
                result[i] = -1;
            }
        }
        
        return result;
    }
}