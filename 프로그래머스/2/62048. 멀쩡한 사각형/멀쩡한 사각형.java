class Solution {
    public long solution(int w, int h) {
        long answer = 0;
        if(w == 1 || h == 1) return 0;
        long weight = (long)w;
        long height = (long)h;
        long num=gcd(w,h);
        answer = weight * height - (weight + height - num);
        return answer;
    }
    private long gcd(long x, long y){
        long min = Math.min(x, y);
        long max = Math.max(x, y);
        long temp = 0;
        while (min > 0) {
            temp = max % min;
            max = min;
            min = temp;
        }
        return max;
    }
}