import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;

        Stack<String> stack = new Stack<>();
        
        for(char c : s.toCharArray()) {
            String str = Character.toString(c);

            if("(".equals(str)) {
                stack.push(str);
            } else {
                if(!stack.isEmpty()) {
                    String top = stack.peek();
                    if("(".equals(top)) {
                        stack.pop();
                    } else {
                        stack.push(str);
                    }
                } else {
                    return false;
                }
            }
        }
        
        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}