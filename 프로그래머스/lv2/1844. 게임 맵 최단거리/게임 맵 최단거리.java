import java.io.*;
import java.util.*;
class Solution {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int min = Integer.MAX_VALUE;
    static int n, m;
    static class Node{
        int x, y, cnt;
        public Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static boolean[][] visited;
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        return bfs(maps,0,0);
    
    }
    static int bfs(int[][] maps, int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 1));
        while(!q.isEmpty()){
            Node node = q.poll();
            x = node.x;
    		y = node.y;
            if(x == n-1 && y == m-1) return node.cnt;
    		visited[x][y] = true;
            for(int i = 0; i < 4; i++){
                int xx = dx[i]+x;
                int yy = dy[i]+y;
                if(xx < 0 || yy < 0 || xx >= n || yy >= m) continue;
                if(maps[xx][yy] == 1 &&!visited[xx][yy]){
                    q.offer(new Node(xx, yy, node.cnt+1));
                    visited[xx][yy] = true;
                }
            }
        }
        return -1;
    }
}