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
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int[][] degree90 = rotate(map, N);
			int[][] degree180 = rotate(degree90, N);
			int[][] degree270 = rotate(degree180, N);
			
			System.out.println("#"+ idx++);
			for(int i = 0; i < N; i++) {
				StringBuilder sb = new StringBuilder();
				appendRow(sb, degree90[i]);
	            appendRow(sb, degree180[i]);
	            appendRow(sb, degree270[i]);
				System.out.printf("%s\n", sb.toString());
			}
		}
	}
	private static int[][] rotate(int[][] map, int N) {
		int[][] temp = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				temp[j][N-i-1] = map[i][j]; 
			}
		}
		return temp;
	}
	private static void appendRow(StringBuilder sb, int[] arr) {
		for (int j = 0; j < arr.length; j++) {
			sb.append(arr[j]);
        }
		sb.append(" ");
	}

}