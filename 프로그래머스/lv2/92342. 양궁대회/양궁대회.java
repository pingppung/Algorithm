import java.util.*;
class Solution {
    static int[] ryan_info;
    static int[] answer;
    static int max_diff = -1;
    public int[] solution(int n, int[] info) {
        answer = new int[11];
        ryan_info = new int[11]; //라이언 화살 배열
        dfs(0, n, info, 0);
        return max_diff==-1 ? new int[]{-1} : answer;
    }
    public static void dfs(int depth, int n, int[] info, int idx){
        if(depth == n){
            int r_score = 0;
            int a_score = 0;
            
            for(int i = 0; i < 11; i++){
                if(ryan_info[i] == 0 && info[i] == 0) continue;
                if(ryan_info[i] > info[i]) r_score += (10-i);
                else a_score += (10-i);
            }
            
            if(r_score > a_score){
                int diff = r_score - a_score;
                if(diff > max_diff){
                    max_diff = diff;
                    answer = ryan_info.clone();
                } else if(diff == max_diff){
                    for(int i = 10; i >= 0; i--){
                        if(answer[i] < ryan_info[i]){ 
                            answer = ryan_info.clone();
                            break;
                        }else if(answer[i] > ryan_info[i]){ 
                            break;
                        }
                    }
                }
            }
            return;
        }
        for(int i = idx; i < 11; i++){
            ryan_info[i]++;
            dfs(depth+1, n, info, i);
            ryan_info[i]--;
        }
    } 
}