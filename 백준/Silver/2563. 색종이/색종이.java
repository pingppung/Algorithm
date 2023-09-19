import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[101][101];
		int area = 0;
		for(int k = 0; k < n; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int i = x; i < x+10; i++) {
				for(int j = y; j < y+10; j++) {
					if(map[i][j] != 1) {
						map[i][j] = 1;
						area++;
					}
				}
			}
		}
		System.out.println(area);
	}
}
