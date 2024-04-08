import java.util.*;
class Solution {
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    Map<Integer, Integer> pipe = new HashMap<>();
    int[] p2;
    boolean[][] visited;
    int n, m;
    
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        visited = new boolean[n][m];
        p2 = new int[m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(land[i][j] == 1 && !visited[i][j]){
                    findOil(i, j, land);
                }
            }
        }
        //answer = Collections.max(pipe.values());
        answer = Arrays.stream(p2).max().getAsInt();
        return answer;
    }
    private void findOil(int x, int y, int[][] land){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x,y});
        visited[x][y] = true;
        
        int area = 1;
        Set<Integer> pos = new HashSet<>();
        pos.add(y);
        while(!q.isEmpty()){
            int now[] = q.poll();
            for(int i = 0; i < 4; i++){
                int xx = now[0] + dx[i];
                int yy = now[1] + dy[i];
                if(xx < 0 || yy < 0 || xx >= n || yy >= m) continue;
                if(!visited[xx][yy] && land[xx][yy] == 1){
                    q.offer(new int[] {xx, yy});
                    visited[xx][yy] = true;
                    area++;
                    pos.add(yy);
                }
            }
        }
        for(int p : pos){
            p2[p] += area;
            //System.out.print(p);
            //pipe.put(p, pipe.getOrDefault(p, 0)+area);
        }
       // System.out.println(" "+area);
        
    }
}