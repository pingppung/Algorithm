import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int count = (int)Math.ceil(minerals.length / 5.0); 
        int pick_cnt = Math.min(count, Arrays.stream(picks).sum());
        int[][] arr = new int[pick_cnt][3];
        for(int i = 0; i < pick_cnt; i++){
            for(int j = 5 * i; j < Math.min((i+1)*5, minerals.length); j++){
                if(minerals[j].equals("diamond")) arr[i][0]++;
                else if(minerals[j].equals("iron")) arr[i][1]++;
                else arr[i][2]++;
            }
        }
        Arrays.sort(arr, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                    if(o1[0] == o2[0]) {
                        if(o1[1] == o2[1]) return o2[2] - o1[2];
                        return o2[1] - o1[1];
                    }
                    return o2[0]- o1[0];
            }
        });
        
        for(int[] i : arr){
            if(picks[0] > 0){
                answer += (i[0]  + i[1] + i[2]);
                picks[0]--;
            } else if(picks[1] > 0){
                answer += (i[0] * 5 + i[1] + i[2]);
                picks[1]--;
            } else if(picks[2] > 0){
                answer += (i[0] * 25 + i[1] * 5 + i[2]);
                picks[2]--;
            }
        }
        return answer;
    }
}