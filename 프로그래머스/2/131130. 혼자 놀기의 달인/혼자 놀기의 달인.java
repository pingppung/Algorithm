import java.util.*;
class Solution {
    public int solution(int[] cards) {
        ArrayList<Integer> score = new ArrayList<>();
        boolean[] visited = new boolean[cards.length];
        for(int i = 0; i < cards.length; i++){
            if(!visited[i]){
                ArrayList<Integer> box = openBox(cards, visited, i);
                score.add(box.size());
            }
        }
        if(score.size() < 2) return 0;
        Collections.sort(score, Collections.reverseOrder());
        return score.get(0) * score.get(1);
    }
    private ArrayList<Integer> openBox(int[] cards, boolean[] visited, int idx){
        ArrayList<Integer> box = new ArrayList<>();
        while(true){
            if(visited[idx]) break;
            visited[idx] = true;
            box.add(cards[idx]);
            int nextIdx = cards[idx]-1;
            idx = nextIdx;
        }
        return box;
    }
}