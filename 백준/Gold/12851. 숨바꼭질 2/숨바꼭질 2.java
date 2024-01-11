import java.io.*;
import java.util.*;
public class Main {
	static int count = 0, min = Integer.MAX_VALUE;
	static int[] time = new int[100001];
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	if(N >= K) {
    		System.out.println(N-K);
    		System.out.println(1);
    		return;
    	}
    	bfs(N, K);
    	System.out.println(time[K]);
    	System.out.println(count);
    }
    private static void bfs(int start, int target) {
    	Queue<Integer> q = new LinkedList<>();
    	q.add(start);
    	time[start] = 0;
    	while(!q.isEmpty()) {
    		int num = q.poll();
    		if(min < time[num]) return;
    		int[] moves = {num-1, num+1, 2*num};
    		for(int move : moves) {
    			if(move == target) {
        			count++;
        			min = time[num];
        		}
    			if(move > 100000 || move < 0) continue;
    			if(time[move] == 0 || time[move] == time[num] + 1) {
        			time[move] = time[num] + 1;
        			q.add(move);
    			}
    		}
    	}
    }
}  