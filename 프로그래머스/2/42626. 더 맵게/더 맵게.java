import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++){
            pq.offer(scoville[i]);
        }
        int count = 0;
        while(pq.peek() < K){
            if(pq.size()==1) return -1;
            int a = pq.poll();
            int b = pq.poll();
            int ind = a + (b * 2);
            pq.offer(ind);
            count++;
        }
        return count;
    }
}