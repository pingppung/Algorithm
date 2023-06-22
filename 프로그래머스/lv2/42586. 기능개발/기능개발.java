import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++){
            int period = (int)Math.ceil((100-progresses[i])/ (double) speeds[i]);
            q.add(period);
        }
        ArrayList<Integer> develop = new ArrayList<>();
        int period = q.poll();
        int count = 1;
        while(!q.isEmpty()){
            int compare = q.poll();
            if(period >= compare) count++;
             else{
                period = compare;
                develop.add(count);
                count = 1;
            }

        }
         develop.add(count);
        return develop.stream().mapToInt(i->i).toArray();
    }
}