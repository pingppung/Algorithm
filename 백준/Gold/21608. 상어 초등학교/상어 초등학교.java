import java.io.*;
import java.util.*;
public class Main {
	static int n;
	static int[][] room;
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, -1, 1, 0};
	static HashMap<Integer, ArrayList<Integer>> students = new HashMap<>();
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
    	room = new int[n][n];
    	for(int i = 0; i < n * n; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int num = Integer.parseInt(st.nextToken());
    		ArrayList<Integer> like = new ArrayList<>();
    		for(int j = 0; j < 4; j++) {
    			like.add(Integer.parseInt(st.nextToken()));
    		}
    		students.put(num, like);
    		chooseSeat(num);
    	}
    	System.out.println(calScore());
    	
    }
    private static void chooseSeat(int student) {
    	ArrayList<Integer> friends = students.get(student);
    	ArrayList<Seat> seats = new ArrayList<>();
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n; j++) {
    			if(room[i][j] != 0) continue;
    			int friendCnt = 0;
    			int emptyCnt = 0;
        		for(int k = 0; k < 4; k++) {
        			int xx = i + dx[k];
        			int yy = j + dy[k];
        			if(xx < 0 || yy < 0 || xx >= n || yy >= n) continue;
        			
        			int around = room[xx][yy];
        			if(friends.contains(around)) friendCnt++;
        			if(around == 0) emptyCnt++;
        		}
        		seats.add(new Seat(friendCnt, emptyCnt, i, j));
        	}
    	}
    	Collections.sort(seats);
        for(Seat seat : seats) {
            if(room[seat.x][seat.y] != 0) continue;
            room[seat.x][seat.y] = student;
            return;
        }
    }
    private static int calScore() {
    	
    	int sum = 0;
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n; j++) {
    			int count = 0;
				ArrayList<Integer> friends = students.get(room[i][j]);
    			for(int k = 0; k < 4; k++) {
    				int xx = i + dx[k];
    				int yy = j + dy[k];
    				if(xx < 0 || yy < 0 || xx >= n || yy >= n) continue;
    				if(friends.contains(room[xx][yy])) count++;
    			}
    			if(count == 1) sum += 1;
    			else if(count == 2) sum += 10;
    			else if(count == 3) sum += 100;
    			else if(count == 4) sum += 1000;
    		}
    	}
    	return sum;
    }
    static class Seat implements Comparable<Seat>{
    	int friendCnt, emptyCnt, x, y;
    	Seat(int friendCnt, int emptyCnt, int x, int y){
    		this.friendCnt = friendCnt;
    		this.emptyCnt = emptyCnt;
    		this.x = x;
    		this.y = y;
    	}
    	@Override
    	public int compareTo(Seat o) {
    		if (o.friendCnt == this.friendCnt) {     
               if (o.emptyCnt == this.emptyCnt) {  
                   if (o.x == this.x) {          
                       return this.y - o.y; 
                   }
                   return this.x - o.x;
               }
               return o.emptyCnt - this.emptyCnt;
           }
           return o.friendCnt - this.friendCnt;
    	}
    }
}

