import java.util.*;

class Solution {
    private int n, coin;
    private Queue<Integer> card = new LinkedList<>();
    private List<Integer> pick = new ArrayList<>();
    private List<Integer> discard = new ArrayList<>();
    public int solution(int coin, int[] cards) {
        int answer = 0;
        n = cards.length;
        this.coin = coin;
        for (int num : cards) {
            card.offer(num);
        }
        initCard();
        answer = roundCard();
        int maxRound = (n - n/3)/2+1;
        if(answer > maxRound) answer = maxRound;
        return answer;
    }
    //처음에 카드 뭉치에 n/3장 뽑아가지는 메서드
    public void initCard(){
        for(int i = 0; i < n / 3; i++){
            pick.add(card.poll());
        }
        Collections.sort(pick);
    }
    //라운드
    public int roundCard(){
        int round = 0;
        while(true){
            round++;
            Collections.sort(pick);
            if(pick.size() == 0 && discard.size() == 0 && card.size() == 0) break;
            //카드 두 장 뽑기
            Integer pick1 = card.poll();
            Integer pick2 = card.poll();
            //유효한 카드 조합이 있는지 확인
            if(chkSum()) {
                //pick 카드랑 n+1 되는 카드만 가져오고 나머지는 discard에 넣기
                processWithCoin(pick1, pick2);
                continue;
            }
            
            //pick 카드로 조합이 불가능하여 pick1, pick2 랑 pick 카드랑 비교
            if (processWithCoin(pick1, pick2)) { //조합이 불가능하다면 이미 discard에 카드를 넣음
                chkSum();
                continue; // 카드 두 장 낼 수 있는 경우 라운드 계속
            } else { //pick1, pick2로도 pick 카드랑 조합이 불가능하면 discard에 넣고 2장 뽑을 수 잇는지 확인
                    
                // 코인이 없거나 카드가 부족없으면 종료
                // if (coin == 0 || (pick1 == null && pick2 == null && discard.size() == 0)) break; 
                if(coin < 2 || discard.size() < 2) break; 
                
                Collections.sort(discard);
                if(chkSum2()) coin-=2;
                else break; // discard에서도 유효한 조합을 못 만들면 종료
            }
        }
        return round;
    }
    //가지고 있는 카드(뽑은 카드 포함??)로 n+1의 합을 만들 수 있는지
    public boolean chkSum(){
        int left = 0;
        int right = pick.size() - 1;
        while (left < right) {
            int sum = pick.get(left) + pick.get(right);
            
            if (sum == n + 1) {
                pick.remove(right);
                pick.remove(left);
                return true;
            } else if (sum < n + 1) {
                left++;
            } else {
                right--;
            }
        }
        
        return false;
    }
    
    public boolean chkSum2(){
        int left = 0;
        int right = discard.size() - 1;
        while (left < right) {
            int sum = discard.get(left) + discard.get(right);
            
            if (sum == n + 1) {
                discard.remove(right);
                discard.remove(left);
                return true;
            } else if (sum < n + 1) {
                left++;
            } else {
                right--;
            }
        }
        
        return false;
    }
    // 동전 소모해서 카드 처리 메서드
    private boolean processWithCoin(Integer pick1, Integer pick2) {
        boolean comb = false;
        if (pick1 != null && pick2 != null) {
            if (coin > 0 && pick.contains(n + 1 - pick1)) {
                pick.add(pick1);
                coin--;
                comb = true;
            } else {
                discard.add(pick1);
            }
            
            if (coin > 0 && pick.contains(n + 1 - pick2)) {
                pick.add(pick2);
                coin--;
                comb = true;
            } else {
                discard.add(pick2);
            }
        }
        return comb;
    }
}
