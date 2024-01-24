import java.util.*;
class Solution {
    int[][] map = new int[101][101];
    boolean[][] visited = new boolean[101][101];
    class Node{
        int x, y, count;
        public Node(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    int result = 0;
    int[] dx = {0,0,-1,1};
    int[] dy = {1,-1,0,0};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for(int i = 0; i < rectangle.length; i++){
             drawLine(rectangle[i][0]*2, rectangle[i][1]*2, rectangle[i][2]*2, rectangle[i][3]*2);
        }
        bfs(2*characterX, 2*characterY, 2*itemX, 2*itemY);
        
        return result / 2;
    }
    private void drawLine(int x1, int y1, int x2, int y2){
        for(int i = x1; i <= x2; i++){
            for(int j = y1; j <= y2; j++){
                if(map[i][j] == 1) continue;
                map[i][j] = 1; //테두리 외의 값은 1
                if(i == x1 || i == x2 || j == y1 || j == y2) {
                    map[i][j] = 2; //테두리는 2
                }
            }
        }
    }
    private void bfs(int characterX, int characterY, int itemX, int itemY){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(characterX, characterY, 0));
        while(!q.isEmpty()){
            Node node = q.poll();
            characterX = node.x;
            characterY = node.y;
            
            if(characterX == itemX && characterY == itemY) {
                result = node.count;
                return;
            }
            for(int i = 0; i < 4; i++){
                int xx = dx[i]+characterX;
                int yy = dy[i]+characterY;
                
                if(xx < 0 || yy < 0 || xx >= 101 || yy >= 101) continue;
                if(map[xx][yy] == 2 && !visited[xx][yy]){
                    q.offer(new Node(xx, yy, node.count+1));
                    visited[xx][yy] = true;
                }
            }
        }
    }
}