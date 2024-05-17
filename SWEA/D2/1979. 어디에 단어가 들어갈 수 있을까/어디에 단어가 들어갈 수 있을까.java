import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int idx = 1;
		while(T-- > 0) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] map = new int[N+2][N+2];
			
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int result = 0;
			for(int i = 0; i <= N + 1; i++) {
				int count = 0;
				for(int j = 0; j <= N + 1; j++) {
					if(map[i][j] == 1) {
						count++;
					} else {
						if(count == K)  {
							result++;	
						}
						count = 0;
					}
				}
			}
			for(int i = 0; i <= N + 1; i++) {
				int count = 0;
				for(int j = 0; j <= N + 1; j++) {
					if(map[j][i] == 1) {
						count++;
					} else {
						if(count == K)  {
							result++;	
						}
						count = 0;
					}
				}
			}
			System.out.printf("#%d %d\n", idx++, result);
		}
	}

}