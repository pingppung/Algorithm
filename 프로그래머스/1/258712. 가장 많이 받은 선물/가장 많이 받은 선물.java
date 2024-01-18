import java.util.*;
class Solution {
    //static HashMap<String, Integer> indicates = new HashMap<>();
    //static HashMap<String, Integer> given = new HashMap<>(); //준 횟수
    //static HashMap<String, Integer> received = new HashMap<>(); //받은 횟수
    static int[][] gr;
    static HashMap<String, int[]> record = new HashMap<>();
    static int[] nextGift;
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        int n = friends.length;
        gr = new int[n][n];
        nextGift = new int[n];
        for(String gift : gifts){
            String[] arr = gift.split(" ");
            String A = arr[0];
            String B = arr[1];
            int A_idx = Arrays.asList(friends).indexOf(arr[0]);
            int B_idx = Arrays.asList(friends).indexOf(arr[1]);
            gr[A_idx][B_idx]++;
        }
        for(int i = 0; i < n; i++){
            int given_Cnt = 0;
            int received_Cnt = 0;
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                given_Cnt += gr[i][j];
                received_Cnt += gr[j][i];
            }
            record.put(friends[i], new int[] {given_Cnt, received_Cnt});
        }
        for(int i = 0; i < n; i++){
            int[] people1 = record.get(friends[i]);
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                int[] people2 = record.get(friends[j]);
                if(gr[i][j] > gr[j][i]){ //더 많은 선물을 준 사람이 다음 달에 선물+1
                    nextGift[i]++;
                } else if(gr[i][j] == gr[j][i]){ //선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같다면
                    int indicate1 = people1[0] - people1[1];
                    int indicate2 = people2[0] - people2[1];
                    if(indicate1 == indicate2) continue; 
                    if(indicate1 > indicate2) { //선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물 받음+1
                        nextGift[i]++;
                    }
                }
            }
        }
        return Arrays.stream(nextGift).max().getAsInt();
    }
}
