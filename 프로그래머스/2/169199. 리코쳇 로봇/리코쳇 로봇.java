import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] map;
    static boolean[][] visited;
    static int n, m;

    static class Point {
        int x, y, count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public int solution(String[] board) {
        int answer = -1;
        n = board.length;
        m = board[0].length();
        map = new char[n][m];
        visited = new boolean[n][m];

        Point start = null;
        Point end = null;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = board[i].charAt(j);
                if (map[i][j] == 'R') {
                    start = new Point(i, j, 0);
                }
            }
        }
        return bfs(start);
    }

    public int bfs(Point start) {
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        visited[start.x][start.y] = true;
        
        while (!q.isEmpty()) {
            Point p = q.poll();
            int x = p.x;
            int y = p.y;
            int cnt = p.count;
            
            if(map[x][y] == 'G') return cnt;
            for (int i = 0; i < 4; i++) {
                int xx = x;
                int yy = y;
                while (true) {
                    xx += dx[i];
                    yy += dy[i];
                    if (xx < 0 || yy < 0 || xx >= n || yy >= m || map[xx][yy] == 'D'){
                        xx -= dx[i];
                        yy -= dy[i];
                        break;
                    }
                }
                if (!visited[xx][yy]) {
                    q.add(new Point(xx, yy, p.count + 1));
                    visited[xx][yy] = true;
                }
            }
        }
        return -1;
    }
}
