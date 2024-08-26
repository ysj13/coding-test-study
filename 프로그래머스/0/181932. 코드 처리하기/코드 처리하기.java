class Solution {
    public String solution(String code) {
        String mode = "0";
        StringBuilder answer = new StringBuilder();
        
        if ("".equals(code)) {
            return "EMPTY";
        } else {
            for (int i = 0; i < code.length(); i++) {
                String s = String.valueOf(code.charAt(i));

                if (s.equals("1")) {
                    mode = mode.equals("0") ? "1" : "0";
                } else {
                    if ("0".equals(mode) && i % 2 == 0) {
                        answer.append(s);
                    } else if ("1".equals(mode) && i % 2 != 0) {
                        answer.append(s);
                    }
                }
            }
            
            return answer.length() == 0 ? "EMPTY" : answer.toString();
        }
    }
}
