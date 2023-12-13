import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		
		char[][] map = new char[n][m];
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		int row = 0, col = 0;
		for(int i = 0; i < n; i++) {
			boolean guard = false;
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 'X') {
					guard = true;
					break;
				}
			}
			if(!guard) row++;
		}
		
		for(int i = 0; i < m; i++) {
			boolean guard = false;
			for(int j = 0; j < n; j++) {
				if(map[j][i] == 'X') {
					guard = true;
					break;
				}
			}
			if(!guard) col++;
		}
		
		System.out.println(Math.max(row, col));
	}
}