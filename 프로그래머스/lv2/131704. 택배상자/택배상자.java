import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Queue<Integer> conveyor = new LinkedList<>();
        Stack<Integer> ass_conveyor = new Stack<>();
        for(int i = 1; i <= order.length; i++){
            conveyor.offer(i);
        }
        for(int i = 0; i < order.length; i++){
            if(!ass_conveyor.isEmpty() && ass_conveyor.peek() == order[i]) {
                ass_conveyor.pop();
                answer++;
                continue;
            } else if(conveyor.isEmpty()){
                break;
            }
            int len = conveyor.size();
            for(int j = 0; j < len; j++){
                int box = conveyor.poll();
                
                if(box == order[i]){
                    answer++;
                    break;
                } else{
                    ass_conveyor.push(box);
                }
            }
        }
        if(!conveyor.isEmpty() && conveyor.peek() == order[order.length-1]) answer++;
        return answer;
    }
}