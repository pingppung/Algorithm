import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> crossing = new LinkedList<>();
        int used_weight = 0;
    	int time = 0;

        for(int i = 0; i < truck_weights.length; i++){
            int truck = truck_weights[i];
    		while(true) {
	    		if(crossing.size() == bridge_length) {
	    			used_weight -= crossing.poll();
	    		}else {
	    			if(used_weight + truck <= weight) {
	    				crossing.add(truck);
	    				used_weight += truck;
		    			time++;
		    			break;
	    			} else {
	    				crossing.add(0);
	    				time++;
	    			}
	    			
	    		}
    		}
        }
        return time + bridge_length;
    }
}