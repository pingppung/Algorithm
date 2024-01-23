import java.util.*;
class Solution {
    class Point {
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    Set<String> visited = new HashSet<>();
    int totalDistance = 0;
    int answer = 0;
    public int solution(String dirs) {
        Point current = new Point(0,0);
        for(char dir : dirs.toCharArray()){
            move(current, dir);
        }
        return answer;
    }
    private void move(Point current, char dir){
        int x = current.x;
        int y = current.y;
        String line = x + ", " + y;
        if(dir == 'U' && y < 5){
            y += 1;
        } else if(dir == 'D'&& y > -5){
            y -= 1;
        } else if(dir == 'R'&& x < 5){
            x += 1;
        } else if(dir == 'L'&& x > -5){
            x -= 1;
        }
        if(current.x == x && current.y == y) return;
        line += " " + x + ", " + y;
        String opp =  x + ", " + y + " " + current.x + ", " + current.y;
        if(!visited.contains(line) && !visited.contains(opp)) answer++;
        visited.add(line);
        current.x = x;
        current.y = y;
    }
}