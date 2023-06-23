import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++){
            q.offer(scoville[i]);
        }
        int count = 0;
        while(q.peek() < K){
            if(q.size()==1) return -1;
            int a = q.poll();
            int b = q.poll();
            int ind = a+(b*2);
            q.offer(ind);
            count++;
        }
        return count;
    }
}