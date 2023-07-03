import java.util.*;
class Solution {
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int n, m;
    static class Point{
        int x, y, time;
        public Point(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    public int solution(String[] maps) {
        
        n = maps.length;
        m = maps[0].length();
        graph = new char[n][m];
        visited = new boolean[n][m];
        
        int answer = 0;
        Point startPos = null;
        Point leverPos = null;
        Point exitPos = null;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                graph[i][j] = maps[i].charAt(j);
                if(maps[i].charAt(j) == 'S')
                    startPos = new Point(i, j, 0);
                if(maps[i].charAt(j) == 'L')
                    leverPos = new Point(i, j, 0);
                if(maps[i].charAt(j) == 'E')
                    exitPos = new Point(i, j, 0);
            }
        }
        int time = bfs(startPos, leverPos);
        
        if(time > -1){ 
            visited = new boolean[n][m];
            int exit_lever = bfs(leverPos, exitPos);
            if(exit_lever == -1) time = -1;
            else time += exit_lever;
        }
        return time;
    }
    public static int bfs(Point start, Point exit){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(start.x,start.y, 0));
        visited[start.x][start.y] = true;
        while(!q.isEmpty()){
            Point p = q.poll();
            int x = p.x;
            int y = p.y;
            int time = p.time;
            
            if(x == exit.x && y == exit.y) return time;
            
            for(int i = 0; i < 4; i++){
                int xx = x+dx[i];
                int yy = y+dy[i];
                if(xx < 0||yy < 0||xx >= n||yy >= m) continue;
                if(graph[xx][yy] != 'X' && !visited[xx][yy]){
                    q.offer(new Point(xx, yy, time+1));
                    visited[xx][yy] = true;
                    
                }
            }
            
        }
        return -1;
        
    }
}