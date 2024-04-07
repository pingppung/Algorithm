import java.util.*;
class Solution {
    
    int[] answer = new int[4];
    
    Map<Integer, int[]> node = new HashMap<>();
    public int[] solution(int[][] edges) {
        for(int i = 0; i < edges.length; i++){
            int[] edge = edges[i];
            int a = edge[0];
            int b = edge[1];
            if(!node.containsKey(a)) {
    			node.put(a, new int[] {0, 0});
    		}
    		if(!node.containsKey(b)) {
    			node.put(b, new int[] {0, 0});
    		}
    		node.get(a)[0]++; // 나가는 간선
    		node.get(b)[1]++; // 들어오는 간선
        }
        for(int key : node.keySet()) {
            int[] count = node.get(key);
            //나가는 간선 2개 이상, 들어오는 간선 없을 경우 정점
            if(count[0] >= 2 && count[1] == 0) answer[0] = key;
            else if(count[0] >= 2 && count[1] >= 2){ //나가고 들어오는 간선 2개 이상인 경우엔 8자
                answer[3]++;
            } else if(count[0] == 0 && count[1] >= 1){
                answer[2]++;
            }
            
        }
        answer[1] = node.get(answer[0])[0] - answer[2] - answer[3];
    
        return answer;
    }
}