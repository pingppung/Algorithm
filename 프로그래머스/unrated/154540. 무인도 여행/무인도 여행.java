import java.util.*;
class Solution {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] visited;
    static int[][] graph;
    static int n, m, area = -1;
    public int[] solution(String[] maps) {
        ArrayList<Integer> answer = new ArrayList<>();
        n = maps.length; m = maps[0].length();
        graph = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i <n; i++){
            String[] arr = maps[i].split("");
            for(int j = 0; j < m; j++){
                if(arr[j].equals("X")) graph[i][j] = 0;
                else graph[i][j] = Integer.parseInt(arr[j]);
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int num = graph[i][j];
                if(!visited[i][j] && num >= 1){
                    area = num;
                    dfs(i, j);
                    answer.add(area);
                    area = -1;
                }
            }
        }
        Collections.sort(answer);
        if(answer.size() == 0) answer.add(-1);
        return answer.stream().mapToInt(i->i).toArray();
    }
    static void dfs(int x, int y){
        visited[x][y] = true;
        for(int i = 0; i < 4; i++){
            int xx = dx[i] + x;
            int yy = dy[i] + y;
            if(xx < 0 || yy < 0 || xx >= n || yy >= m) continue;
            int num = graph[xx][yy];
            if(!visited[xx][yy] && num >= 1){
                
                area += num;
                dfs(xx, yy);
            }
        }
    }
}