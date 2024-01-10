import java.io.*;
import java.util.*;
public class Main {
	static int[] ladder_snake = new int[101];
	static boolean[] visited = new boolean[101];
	static int[] count = new int[101];
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	for(int i = 0; i < N+M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		ladder_snake[a] = b;
    	}
    	System.out.println(bfs(1));
    }
    private static int bfs(int start) {
    	Queue<Integer> q = new LinkedList<>();
    	q.add(start);
    	visited[start] = true;
    	count[start] = 0;
    	while(!q.isEmpty()) {
    		int num = q.poll();
    		for(int i = 1; i <= 6; i++) {
    			int x = num + i;
        		if(x == 100) return count[num] + 1;
    			if(x > 100 || visited[x]) continue;
    			visited[x] = true;
    			if(ladder_snake[x] != 0) {
    				if(!visited[ladder_snake[x]]) {
    					q.add(ladder_snake[x]);
    					visited[ladder_snake[x]] = true;
    					count[ladder_snake[x]] = count[num] + 1;
    				}
    			}else {
    				q.add(x);
    				count[x] = count[num] + 1;
    			}
    			
    		}
    	}
    	return -1;
    	
    }
}  