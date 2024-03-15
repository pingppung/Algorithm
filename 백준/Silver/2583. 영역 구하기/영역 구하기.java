import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
public class Main {
	static boolean[][] visited;
	static int[][] arr;
	static int n, m;
	static int area = 0;
	static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	m = Integer.parseInt(st.nextToken());
    	n = Integer.parseInt(st.nextToken());
    	int k = Integer.parseInt(st.nextToken());
    	
    	visited = new boolean[m][n];
    	arr = new int[m][n];

		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for(int a = y; a < y2; a++) {
				for(int b = x; b < x2; b++) {
					arr[a][b] = 1;
				}
			}
		}
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(visited[i][j] == false && arr[i][j] == 0) {
					area = 0;
					dfs(i, j);
					list.add(area);
				}
			}
		}
		System.out.println(list.size());
		Collections.sort(list);
		for(Integer i : list) System.out.print(i + " ");
    }
	static void dfs(int x, int y){
		visited[x][y] = true;
		arr[x][y] = 1;
		area++;
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		for(int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if(xx >= 0 && yy >= 0 && xx < m && yy < n) {
				if(arr[xx][yy] == 0) dfs(xx, yy);
			}
		}
	}
}  