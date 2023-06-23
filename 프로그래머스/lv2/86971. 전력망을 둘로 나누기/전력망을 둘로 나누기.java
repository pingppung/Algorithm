import java.util.*;
class Solution {
    static int[][] tower;
    static boolean[] visited;
    public int solution(int n, int[][] wires) {
        int answer = n;
        tower = new int[n+1][n+1];
        for(int i = 0; i < wires.length; i++){
            tower[wires[i][0]][wires[i][1]] = 1;
            tower[wires[i][1]][wires[i][0]] = 1;
        }
        for(int i = 0;i<wires.length; i++){
            
            visited = new boolean[n+1];
            int a = wires[i][0];
            int b = wires[i][1];
            //a와 b의 연결을 끊었을때
            tower[a][b] = 0;
            tower[b][a] = 0;
            
            answer = Math.min(answer, bfs(n, i+1));
            
            tower[a][b] = 1;
            tower[b][a] = 1;
        }
        return answer;
    }
    public int bfs(int n, int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        int count = 1;
        while(!q.isEmpty()){
            int now = q.poll();
            visited[now] = true;
            for(int i = 1; i <= n; i++){
                if(tower[now][i] == 1 && !visited[i]){
                    count++;
                    q.offer(i);
                }
            }
        }
        return (int)Math.abs(n-2*count);
    }
}