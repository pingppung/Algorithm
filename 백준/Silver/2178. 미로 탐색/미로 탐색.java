import java.io.*;
import java.util.*;
public class Main {
	static boolean[][] visited;
	static int[][] arr;
	static int n, m;
	static class Node {
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static Queue<Node> q = new LinkedList<>();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());

    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	arr = new int[n][m];
    	visited = new boolean[n][m];
    	for(int i = 0; i < n; i++) {
    		String s = br.readLine();
    		for(int j = 0; j < m; j++) {
        		arr[i][j] = Character.getNumericValue(s.charAt(j));
    		}
    	}
    	bfs(0,0);
    	System.out.println(arr[n-1][m-1]);
    	
    }
    public static void bfs(int x, int y) {
    	q.offer(new Node(x,y));
    	visited[y][x] = true;

    	int[] dx = {0, 0, -1, 1};
    	int[] dy = {-1, 1, 0, 0};
    	
    	while(!q.isEmpty()) {
    		Node node = q.poll();
	    	for(int i = 0; i < 4; i++) {
	    		int xx = dx[i] + node.x;
	    		int yy = dy[i] + node.y;
	    		
	    		if(xx >= 0 && xx < m && yy>=0 && yy<n && visited[yy][xx] == false && arr[yy][xx] == 1) {
	    			q.offer(new Node(xx, yy));
	    			visited[yy][xx] = true;
	    			arr[yy][xx] = arr[node.y][node.x]+1;
	    			if(visited[n-1][m-1] == true) return;
	    	
	    		}
	    		
	    	}
    	}
    	
    }
    	
} 