import java.io.*;
import java.util.*;
public class Main {
	static boolean[] visited;
	static int[][] arr;
	static int n, k;
	static int[] count;
	static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	k = Integer.parseInt(st.nextToken());
    	
    	visited = new boolean[100001];
    	count = new int[100001];

		visited[n] = true;
		bfs(n);
    	System.out.println(count[k]);
    }
	static void bfs(int start){
		q.add(start);
		while(!q.isEmpty()) {
			int num = q.poll();
			int[] moves = { num + 1, num - 1, num*2};
			for(int i : moves) {
				if(i < 0 || i >= 100001) continue;
				if(visited[i] == true) continue;
				visited[i] = true;
				count[i] = count[num]+1;
				if(i == k) break;
				q.add(i);
			}
		}
	}
}  