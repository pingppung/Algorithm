class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliver = 0;
        int pickup = 0;
        for(int i = n-1; i >= 0; i--){
            if(deliveries[i] != 0 || pickups[i] != 0){
                int count = 0;
                while(deliver < deliveries[i] || pickup < pickups[i]){
                    deliver += cap;
                    pickup += cap;
                    count++;
                }
                deliver -= deliveries[i];
                pickup -= pickups[i];
                answer+= (i+1)*count*2;
            }
        }
        return answer;
    }
}