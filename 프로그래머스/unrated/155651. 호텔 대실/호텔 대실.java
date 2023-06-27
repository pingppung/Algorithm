import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] room = new int[book_time.length][2];
        for(int i = 0; i < book_time.length; i++){
            int in = Integer.parseInt(book_time[i][0].replace(":",""));
            int out = Integer.parseInt(book_time[i][1].replace(":",""));
            
            out += 10; //청소 시간 10분 추가
            if(out%100 >= 60) out += 40;
            room[i][0] = in;
            room[i][1] = out;
        }
        
        
        
        Arrays.sort(room, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]; 
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] time : room){
            
            //System.out.println(time[0] + " "+ time[1]);
            if(pq.size() == 0){
                pq.add(time[1]);
                continue;
            }
            if((pq.peek())<= time[0]){
                pq.poll();
                pq.add(time[1]);
            }else pq.add(time[1]);
        }
        return pq.size();
    
    }
}