import java.util.*;
class Solution {
    private List<List<Integer>> routes = new ArrayList<>();
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<Integer> answer = new ArrayList<>();
        for(int i =0; i <= n; i++){
            routes.add(new ArrayList<>());
        }
        for(int[] road : roads){
            int a = road[0];
            int b = road[1];
            routes.get(a).add(b);
            routes.get(b).add(a);
        }
        
        for(int start : sources){
            boolean[] visited = new boolean[n+1];
            int time = comeBack(start, destination, visited);
            answer.add(time);
        }
        return answer.stream().mapToInt(i->i).toArray();
        
    }
    private int comeBack(int start, int dest, boolean[] visited){
        Queue<int[]> path = new LinkedList<>();
        path.add(new int[] {start, 0});
        visited[start] = true;
        
        while(!path.isEmpty()){
            int[] cur = path.poll();
            int curPos = cur[0]; 
            int curTime = cur[1]; 
            
           
            List<Integer> next = routes.get(curPos);
            if (curPos == dest) return curTime;
            
            // 연결된 노드들 탐색
            for (int nextPos : next) {
                if (!visited[nextPos]) {
                    if (nextPos == dest) return curTime+1;
                    visited[nextPos] = true;
                    path.add(new int[] {nextPos, curTime + 1});
                }
            }
            
        }
        return -1;
        
    }
}