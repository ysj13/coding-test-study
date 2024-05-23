class Solution {
    public long solution(long n) {
        double d = Math.pow(n, 0.5);

        if(((int)(d) - d) == 0) {
             return (long) ((d + 1) * (d + 1));
        } else {
            return -1;
        }
    }
}