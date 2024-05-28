import java.util.*;
class Solution {
    int n, max = Integer.MIN_VALUE;
    int[] answer;
    List<Integer> dices = new ArrayList<>();
    public int[] solution(int[][] dice) {
        n = dice.length;
        answer = new int[n/2];
        
        choice(dice, 0, 0);

        return answer;
    }
    //주사위 조합
    private void choice(int[][] dice, int depth, int start){
        if(depth == n / 2) {
            int count = calWinningPercentage(dice, 0);
            if(max < count){
                max = count;
                for(int i = 0; i < dices.size(); i++){
                    answer[i] = dices.get(i)+1;
                }
            }
        }
        for(int i = start; i < n; i++){
            dices.add(i);
            choice(dice, depth+1, i+1);
            dices.remove(dices.size()-1);
        }
    }
    //A, B마다 조합된 배열을 나눠주기
    private int calWinningPercentage(int[][] dice, int start){
        List<int[]> Adices = new ArrayList<>();
        List<int[]> Bdices = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(dices.contains(i)) 
                Adices.add(dice[i]);
            else 
                Bdices.add(dice[i]);
        }
        
        List<Integer> Asum = new ArrayList<>();
        List<Integer> Bsum = new ArrayList<>();
        calScore(Adices, 0, 0, Asum);
        calScore(Bdices, 0, 0, Bsum);
        Collections.sort(Asum);
        Collections.sort(Bsum);
        int aI = 0, bI = 0, count = 0;
        
        while(aI < Asum.size() && bI < Bsum.size()){
            if(Asum.get(aI) > Bsum.get(bI)) {
                bI++;
            } else {
                count += bI;
                aI++;
            }
        }
        if(bI > aI) {
            count += bI * (bI - aI);
        }
        
        //System.out.println(count);
        
        return count;
    }
    //주사위 조합별 나올수 있는 숫자 계산
    private void calScore(List<int[]> dices, int count, int sum, List<Integer> nums){
        if(count == n / 2){
            nums.add(sum);
            return;
        }
        for(int i = 0; i < 6; i++){
            calScore(dices, count+1, sum + dices.get(count)[i], nums);
        }
    }
    
}