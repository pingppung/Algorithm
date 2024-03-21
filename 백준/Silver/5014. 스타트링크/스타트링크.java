import java.io.*;
import java.util.*;
public class Main {
	static int[] visited;
	static int f, s, g, u, d;
	static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	f = Integer.parseInt(st.nextToken());
    	s = Integer.parseInt(st.nextToken());
    	g = Integer.parseInt(st.nextToken());
    	u = Integer.parseInt(st.nextToken());
    	d = Integer.parseInt(st.nextToken());
    	
    	visited = new int[f+1];
    	bfs();

    }
	static void bfs(){
		q.add(s);
		visited[s] = 1;
		while(!q.isEmpty()) {
			int n = q.poll();
			if(n == g) {
				System.out.println(visited[n] - 1);
				break;
			}
			if(n+u <= f && visited[n+u] == 0) {
				visited[n+u] = visited[n]+1;
				q.add(n+u);
			}
			if(n-d > 0 && visited[n-d] == 0) {
				visited[n-d] = visited[n]+1;
				q.add(n-d);
			}
		}
		if(visited[g] == 0) System.out.println("use the stairs");
	}
}  