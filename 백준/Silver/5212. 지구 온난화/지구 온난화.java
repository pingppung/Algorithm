import java.io.*;
import java.util.*;

public class Main {
	static int R, C, minR, minC, maxR, maxC;
	static char[][] arr, result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[R][C];
		result = new char[R][C];
		
		minR = R; minC = C; maxR = 0; maxC = 0;
		for(int i = 0; i < R; i++) {
			String s = br.readLine();
			for(int j = 0; j < C; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		for(int i = 0; i < R; i++) {  
			for(int j = 0; j < C; j++) {
				result[i][j] = arr[i][j];
				if(arr[i][j] == 'X') {
					if(chkSea(i, j)) result[i][j] = '.';
				}
			}
		}
		mapSize();
		int count = 0;
		for(int i = minR; i <= maxR; i++) {
			for(int j = minC; j <= maxC; j++) {
				if(result[i][j] == 'X') count++;
				sb.append(result[i][j]);
			}
			sb.append("\n");
		}
		if(count == 0) System.out.println("X");
		else System.out.println(sb);
	}
	public static void mapSize() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(result[i][j] =='X') {
					minR = Math.min(minR, i);
					maxR = Math.max(maxR, i);
					minC = Math.min(minC, j);
					maxC = Math.max(maxC, j);
				}
			}
		}
	}
	public static boolean chkSea(int x, int y) {
		int[] dx = {0,0,-1,1};
		int[] dy = {1,-1,0,0};
		int count = 0;
		for(int i = 0; i < 4; i++) {
			int xx = x+dx[i];
			int yy = y+dy[i];
			if(xx < 0 || xx >= R || yy <0 || yy >= C) {
				count++;
				continue;
			}
			if(arr[xx][yy] == '.') count++;
		}
		if(count >= 3) return true;
		return false;
	}

}
