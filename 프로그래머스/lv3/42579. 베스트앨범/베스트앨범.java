import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        HashMap<String, Integer> genrePlay = new HashMap<>();
        HashMap<Integer, Integer> playIdx = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
    		genrePlay.put(genres[i], genrePlay.getOrDefault(genres[i], 0) +plays[i]);
            playIdx.put(i, plays[i]);
        }
        ArrayList<String> genrePlaySort = new ArrayList<>(genrePlay.keySet());
        Collections.sort(genrePlaySort, (e1, e2) -> genrePlay.get(e2).compareTo(genrePlay.get(e1)));
        
        ArrayList<Integer> PlayIdxSort = new ArrayList<>(playIdx.keySet());
        Collections.sort(PlayIdxSort, (e1, e2) -> playIdx.get(e2).compareTo(playIdx.get(e1)));
        
        ArrayList<Integer> bestAlbum = new ArrayList<>();
        for(String s : genrePlaySort) {
            int count = 1;
            for(int idx : PlayIdxSort){
                if(genres[idx].equals(s) && count < 3){
                    count++;
                    bestAlbum.add(idx);
                }
            }
    	}
    	return bestAlbum.stream().mapToInt(Integer::intValue).toArray();

    }
}