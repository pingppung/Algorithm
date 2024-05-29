import java.util.*;
class Solution {
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    char[] dir = {'d', 'l', 'r', 'u'};
    int ex, ey, n, m;
    Set<String> set = new TreeSet<>();
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        this.n = n; this.m = m; ex = r; ey = c;
        
        int minDist = Math.abs(ex - x) + Math.abs(ey - y);
        if(minDist > k || (k - minDist) % 2 != 0) return "impossible";
        
        answer = findPath(x, y, k, new StringBuilder());
        return answer.isEmpty() ? "impossible" : answer;
    }
    private String findPath(int x, int y, int k, StringBuilder path){
        
        if (k == 0) {
            if (x == ex && y == ey) {
                return path.toString();
            } else {
                return "";
            }
        }
        for(int i = 0; i < 4; i++){
            int xx = x + dx[i];
            int yy = y + dy[i];
            
            if(xx < 1 || yy < 1 || xx > n || yy > m) continue;
            
            
            int minDist = Math.abs(ex - xx) + Math.abs(ey - yy);
            if (minDist <= k - 1) {
                path.append(dir[i]);
                String result = findPath(xx, yy, k - 1, path);
                if (!result.isEmpty()) {
                    return result;
                }
                path.deleteCharAt(path.length() - 1);
            }
        }
        return "";
    }
}