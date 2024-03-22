import java.util.Arrays;
class Solution {
    int n;
    int[][] gift_records; //선물 주고받은 기록 
    int[] indices; // 선물 지수
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        n = friends.length;
        gift_records = new int[n][n];
        indices = new int[n];
        
        for(String gift : gifts){
            String[] names = gift.split(" ");
            String A = names[0];
            String B = names[1];
            int A_Idx = Arrays.asList(friends).indexOf(A);
            int B_Idx = Arrays.asList(friends).indexOf(B);
            gift_records[A_Idx][B_Idx]++;
        }
        
        calIndices();// 선물 지수 구하는 메서드 호출
        
        int[] next_gift = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                if(gift_records[i][j] > gift_records[j][i]) next_gift[i]++;
                //횟수가 같을 경우   선물 지수가 작은 사람 -> 큰 사람 +1
                else if(gift_records[i][j] == gift_records[j][i]){ 
                    if(indices[i] == indices[j]) continue; //선물 지수도 같은 경우엔 패쓰
                    if(indices[i] > indices[j]) next_gift[i]++;
                }
            }
        }
        return Arrays.stream(next_gift).max().getAsInt();
    }
    private void calIndices(){
        for(int i = 0; i < n; i++){
            int cal = 0;
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                cal += gift_records[i][j] - gift_records[j][i];
            }
            indices[i] = cal;
        }
    }
}
/* 선물 기록 
1. 서로 준 횟수 비교해서  적은 사람 -> 많은 사람 + 1
2. 횟수가 같을 경우   선물 지수가 작은 사람 -> 큰 사람 +1 (예외 - 선물 지수도 같은 경우엔 패쓰~)
(선물 지수 = 친구에게 준 선물의 수 - 받은 선물의 수)
목표 : 다음달 선물을 가장 많이 받을 친구의 선물 수
*/