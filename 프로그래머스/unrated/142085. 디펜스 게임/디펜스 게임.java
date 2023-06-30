import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        if(enemy.length <= k) return enemy.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < enemy.length; i++){
            n -= enemy[i];
            pq.offer(enemy[i]);
            if(n < 0){
                if(k == 0){
                    return pq.size()-1;
                } else{
                    n += pq.poll();
                    pq.offer(0);
                    k--;
                }
            }
        }
        return pq.size();
    }
}