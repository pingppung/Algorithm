import java.io.*;
import java.util.*;

public class Main {
	static int n, m, x, y;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] dice = {0 ,0 ,0 ,0 ,0 ,0}; 
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < k; i++) {
			int dir = Integer.parseInt(st.nextToken());
			if(dir == 1) { //동
				if(y+1 >= m) continue;
				y++;

				int temp = dice[0];
				int temp2 = dice[2];
				
				dice[0] = dice[4];//4->0 
				dice[2] = dice[5];//5->2
				dice[5] = temp;//0->5
				dice[4] = temp2; //2->4
			} else if(dir == 2) {//서
				if(y-1 < 0) continue;
				y--;
				int temp = dice[0];
				int temp2 = dice[2];
				
				dice[0] = dice[5];//5->0
				dice[2] = dice[4];//4->2
				dice[4] = temp;//0->4
				dice[5] = temp2;//2->5
			} else if(dir == 3) {//북
				if(x-1 < 0) continue;
				x--;

				int temp = dice[3];
				for(int j = 3; j > 0; j--) {
					dice[j] = dice[j-1];
				}
				dice[0] = temp;
			} else {//남
				if(x+1 >= n) continue;
				x++;
				int temp = dice[0];
				for(int j = 0; j < 3; j++) {
					dice[j] = dice[j+1];
				}
				dice[3] = temp;
				
			}
			
			
			
			if(map[x][y] == 0) { //이동한 칸이 0일때 ( 주사위의 바닥면에 쓰여 있는 수가 칸에 복사)
				map[x][y] = dice[2];
			}else { //이동한 칸 - 0이 아닌 경우(칸에 쓰여 있는 수가 주사위 바닥면으로 복사, 칸 수는 0)
				dice[2] = map[x][y];
				map[x][y] = 0;
			}
			
			//System.out.println(Arrays.toString(dice));
			System.out.println(dice[0]);
		}
		
		
	}
	

}
