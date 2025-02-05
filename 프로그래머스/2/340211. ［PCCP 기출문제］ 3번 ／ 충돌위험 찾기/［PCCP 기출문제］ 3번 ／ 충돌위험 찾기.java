import java.util.*;

class Solution {
    Map<Integer, List<int[]>> paths = new HashMap<>();
    int[] dup = new int[200];
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int x = routes.length;
        int n = points.length;
        for(int[] route : routes){
            int seq = 1;
            for(int i = 0; i <route.length-1; i++){
                int s_x = points[route[i]-1][0];
                int s_y = points[route[i]-1][1];
                int e_x = points[route[i+1]-1][0];
                int e_y = points[route[i+1]-1][1];
                seq = findRoutes(s_x, s_y, e_x, e_y, seq);
            }
        }
        return countCollisions();
    }
    
    private int findRoutes(int x, int y, int end_x, int end_y, int seq){
        if(seq == 1) { //시작 지점 추가
            paths.put(seq, paths.getOrDefault(seq, new ArrayList<>()));
            paths.get(seq).add(new int[]{x, y});
            seq++;
        }
        seq = addPath(x, end_x, y, true, seq);
        seq = addPath(y, end_y, end_x, false, seq);
        return seq;
    }
    
    private int addPath(int start, int end, int constant, boolean isX, int seq) {
        // x축 또는 y축 방향으로 경로 추가
        int step = (start > end) ? -1 : 1;
        for (int i = start + step; (step > 0 ? i <= end : i >= end); i += step) {
            paths.put(seq, paths.getOrDefault(seq, new ArrayList<>()));
            if (isX) {
                paths.get(seq).add(new int[]{i, constant});
            } else {
                paths.get(seq).add(new int[]{constant, i});
            }
            seq++;
        }
        return seq;
    }
    
    private int countCollisions(){
        
        int uqCount = 0; 
        for (Map.Entry<Integer, List<int[]>> path : paths.entrySet()) {
            Map<String, Integer> dup = new HashMap<>();
            for (int[] p : path.getValue()) {
                String ps = Arrays.toString(p);
                dup.put(ps, dup.getOrDefault(ps, 0)+1);
            }
            
            for(int count : dup.values()){
                if(count > 1) uqCount++;
            }
        }
        return uqCount;
    }
}