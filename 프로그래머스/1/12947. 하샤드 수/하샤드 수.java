class Solution {
    public boolean solution(int x) {
        int n = 0;
        
        for(char c : Integer.toString(x).toCharArray()) {
            n += Character.getNumericValue(c);
        }
        
        if(x % n != 0) {
            return false;
        }
        
        return true;
    }
}