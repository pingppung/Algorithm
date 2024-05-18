import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int idx = 1;
		
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			int x = 0, y = 0;
			map[x][y] = 1;
			int num = 2;
			while(num <= N * N) { //right -> down -> left -> up 반복
				while(y+1 < N && map[x][y+1] == 0) {
					y++;
					map[x][y] = num++;
				}
				while(x+1 < N && map[x+1][y] == 0) {
					x++;
					map[x][y] = num++;
				}
				while(y-1 >= 0 && map[x][y-1] == 0) {
					y--;
					map[x][y] = num++;
				}
				while(x-1 >= 0 && map[x-1][y] == 0) {
					x--;
					map[x][y] = num++;
				}
			}
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.printf("#%d\n%s", idx++, sb.toString());
		}
	}

}