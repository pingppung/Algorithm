class Solution {
    static int[] sales = {10, 20, 30, 40};
    static int[] discounts;
    static int plus_join, total_max;
    public int[] solution(int[][] users, int[] emoticons) {
        discounts = new int[emoticons.length];
        dfs(0, users, emoticons);
        return new int[]{plus_join, total_max};
    }
    public static void dfs(int depth, int[][] users, int[] emoticons){
        if(depth == emoticons.length){
            int plus = 0;
            int total = 0;
            for(int i = 0; i < users.length; i++){
                int percent = users[i][0];
                int price = users[i][1];
                int sum = 0;
                for(int j = 0; j < emoticons.length; j++){
                    if(discounts[j]>=percent){
                        sum += emoticons[j]/100*(100-discounts[j]);
                    }
                }
                if(sum >= price) plus++;
                else total += sum;
            }
            if(plus > plus_join) {
                plus_join = plus;
                total_max = total;
            } else if(plus == plus_join) 
                total_max = Math.max(total_max, total);
            return;
        }
        for(int i = 0; i < sales.length; i++){
            discounts[depth]  = sales[i];
            dfs(depth+1, users, emoticons);
        }
    }
}