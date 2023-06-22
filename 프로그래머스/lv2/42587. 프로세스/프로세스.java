import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < priorities.length; i++) {
    		pq.add(priorities[i]); //3221
    	}
        int idx = 1;
    	while(!pq.isEmpty()) {
    		for(int i = 0; i < priorities.length; i++) {
    			if(pq.peek() == priorities[i]) {
    				if(location == i) return idx;
    				idx++;
    				pq.poll();
    				
    			}
    		}
    	}
        return idx;
    }
}