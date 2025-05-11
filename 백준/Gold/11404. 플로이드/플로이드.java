import java.util.*;
import java.io.*;

public class Main {
	static final int INF = 1_000_000_000;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[][] buses = new int[n+1][n+1];
		
		for(int i = 0; i<= n; i++) {
			Arrays.fill(buses[i], INF);
			buses[i][i] = 0;
		}
		
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			buses[a][b] = Math.min(buses[a][b], c);
		}
		for(int k = 1; k <= n; k++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if(buses[i][k] + buses[k][j] < buses[i][j]) {
						buses[i][j] = buses[i][k] + buses[k][j];
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<= n; i++) {
			for(int j = 1; j <= n; j++) {
				sb.append(buses[i][j] == INF ? "0 " : buses[i][j] + " ");
			}
			sb.append("\n");
			
		}
		System.out.print(sb);
	}
}
