import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        List<Integer> burger = List.of(1,2,3,1);
        List<Integer> order = new ArrayList<>();
        for(int mat : ingredient){
            order.add(mat);
            while(order.size() >= burger.size()){
                int len = order.size();
                if(!(order.get(len-1) == burger.get(3) && order.get(len-2) == burger.get(2) && order.get(len-3) == burger.get(1) && order.get(len-4) == burger.get(0))) break;
                for(int i = 0; i < burger.size(); i++) {
                    order.remove(order.size()-1);
                }
                answer++;
            }
        }
        return answer;
    }
}