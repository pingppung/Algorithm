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
                // System.out.println(s_x+","+s_y +" -> "+ e_x+","+ e_y);
                seq = findRoutes(s_x, s_y, e_x, e_y, seq);
            }
            // System.out.println("-------------------------------");
        }
        answer = countCollisions();
        
        return answer;
    }
    private int findRoutes(int x, int y, int end_x, int end_y, int seq){
        if(seq == 1) {
            paths.put(seq, paths.getOrDefault(seq, new ArrayList<>()));
            paths.get(seq).add(new int[]{x, y});
            seq++;
        }
        int step = (x > end_x) ? -1 : 1;
        for(int i = x+step; (step > 0 ? i <= end_x : i >= end_x); i += step){
            paths.put(seq, paths.getOrDefault(seq, new ArrayList<>()));
            paths.get(seq).add(new int[]{i, y});
            seq++;
        }
        
        step = (y > end_y) ? -1 : 1;
        for(int i = y+step; (step > 0 ? i <= end_y : i >= end_y); i += step){
            paths.put(seq, paths.getOrDefault(seq, new ArrayList<>()));
            paths.get(seq).add(new int[]{end_x, i});
            seq++;
        }
       // for (Map.Entry<Integer, List<int[]>> path : paths.entrySet()) {
       //      System.out.print("Key: " + path.getKey() + " -> ");
       //      for (int[] p : path.getValue()) {
       //          System.out.print(Arrays.toString(p));
       //      }
       //      System.out.println();
       //  }
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