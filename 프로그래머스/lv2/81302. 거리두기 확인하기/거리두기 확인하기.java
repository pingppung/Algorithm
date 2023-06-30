import java.util.*;
class Solution {
    static boolean[][] visited;
    static int[][] dis;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static boolean fail = false;
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i = 0; i < 5; i++){
            dis = new int[5][5];
            visited = new boolean[5][5];
            for(int j = 0; j < 5; j++){
                char[] arr = places[i][j].toCharArray();
                for(int k = 0; k < 5; k++){
                    if(arr[k] == 'P'){ //p->-1
                        dis[j][k] = -1;
                    }else if(arr[k] == 'X'){ //x->-2
                        dis[j][k] = -2;
                    } else dis[j][k] = 0;
                }
            }
            for(int j = 0; j < 5; j++){
                for(int k = 0; k < 5; k++){
                    if(dis[j][k] == -1){ //p좌표
                        dfs(j, k); 
                    }
                }
            }
            if(fail) {
                answer[i] = 0;
                fail = false;
                continue;
            } else answer[i] = 1;
        }
        
        return answer;
    }
    public static void dfs(int x, int y){
        for(int i = 0; i < 4; i++){
            
            int xx = dx[i]+x;
            int yy = dy[i]+y;
            if(xx < 0 || yy < 0 || xx >= 5 || yy >= 5) continue;
            if(dis[xx][yy] == -1) { //옆자리 사람
                fail = true;
                return;
            }
            if(dis[xx][yy] >= 0){ //빈책상 바로 옆칸 사람일 경우 빈책상+1
                dis[xx][yy]++;
                if(dis[xx][yy] >= 2) {
                    fail = true;
                    return;
                };
            }
        }
    }
}