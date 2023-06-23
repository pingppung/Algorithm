import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> Min_queue = new PriorityQueue<>();
        PriorityQueue<Integer> Max_queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < operations.length; i++){
            String[] s = operations[i].split(" ");
            if(s[0].equals("I")) {
            	Min_queue.add(Integer.parseInt(s[1]));
            	Max_queue.add(Integer.parseInt(s[1]));
            }
            else {
                if(!Min_queue.isEmpty()){
                    if(s[1].equals("1")){
                        Min_queue.remove(Max_queue.poll());
                    }
                    else if(s[1].equals("-1")){
                    	Max_queue.remove(Min_queue.poll());
                    }
                    
                }
            }
        }
        if(Min_queue.size() >0){
            answer[0] = Max_queue.poll();
            answer[1] = Min_queue.poll();
        }
        return answer;
    }
}