class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int success_time = 0;
        int max_health = health;
        int last_attack = attacks[attacks.length-1][0];
        int idx = 0;
        for(int i = 1; i <= last_attack; i++){
            int attack_time = attacks[idx][0];
            int attack_amount = attacks[idx][1];
            if(i == attack_time) {
                health -= attack_amount;
                success_time = 0;
                idx++;
                if(health <= 0) return -1;
                continue;
            } 
            success_time++;
            health += bandage[1];
            
            if(success_time == bandage[0]){
                health += bandage[2];
                success_time = 0;
            }
            
            if(health > max_health) {
                health = max_health;
            }
           // System.out.println(i +" "+success_time+" "+health);
            
        }
        return health <= 0 ? -1 : health;
    }
}
