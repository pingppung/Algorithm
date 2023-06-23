class Solution {
    static boolean[] visited;
    static int result = 0;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        changeWord(begin, target, words, 0);
        return result;
        
    }
    static void changeWord(String begin, String target, String[] words, int count){
        if(begin.equals(target)) {
            result = count;
            return;
        }
        for(int i = 0; i < words.length; i++){
            if(visited[i]) continue;
            
            int diff = 0;
            for(int j = 0; j < begin.length(); j++){
                if(begin.charAt(j) != words[i].charAt(j)) diff++;
            }
            if(diff == 1){
                visited[i] = true;
                changeWord(words[i], target, words, count+1);
                visited[i] = false;
            }
        }
    }
}