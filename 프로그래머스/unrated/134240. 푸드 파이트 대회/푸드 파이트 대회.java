class Solution {
    public String solution(int[] food) {
        String answer = "";
        for(int i = 1; i < food.length; i++){
            int cnt = food[i]/2;
            if(cnt >= 1) answer += Integer.toString(i).repeat(cnt);
        }
        StringBuffer sb = new StringBuffer(answer);
        String reverse = sb.reverse().toString();
        answer += "0"+reverse;
        
        return answer;
    }
}