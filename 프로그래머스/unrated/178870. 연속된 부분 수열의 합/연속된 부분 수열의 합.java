class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int start = 0;
        int end = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        while(end < sequence.length && start <= end){
            if(start == end) sum = sequence[start];
            if(sum == k){
                if(len > end-start+1){
                    len = end-start+1;
                    answer[0] = start;
                    answer[1] = end;
                }
                sum -= sequence[start];
                if(end+1 < sequence.length)
                    sum+=sequence[end+1];
                if(start == end) break;
                start++;
                end++;
            }else if(sum >k){
                sum-= sequence[start++];
            } else if(sum < k){
                if(end+1 < sequence.length)
                    sum+=sequence[end+1];
                end++;
            }
        }
        return answer;
    }
}