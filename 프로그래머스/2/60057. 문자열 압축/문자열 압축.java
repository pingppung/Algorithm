class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        if(s.length() == 1) return 1;
        for(int i = 1; i <= s.length()/2; i++){
            StringBuilder sb = new StringBuilder();
            String pattern = s.substring(0, i);
            int count = 1;
            for(int j = i; j <= s.length(); j+=i){
                int endIdx = j+i;
                if(endIdx > s.length()) endIdx = s.length();
                String word = s.substring(j, endIdx);
                
                if(pattern.equals(word)) {
                    count++;
                    continue;
                }
                if(count > 1) sb.append(count);
                sb.append(pattern);
                pattern = word;
                count = 1;
            }
            sb.append(pattern);
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}