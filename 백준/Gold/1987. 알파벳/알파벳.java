import java.util.*;
import java.io.*;

public class Main {
	private static char[][] board;
	private static int R, C, max_Dis = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char[R+1][C+1];
		for(int i = 1; i <= R; i++) {
			String alph = br.readLine();
			for(int j = 1; j <= C; j++) {
				board[i][j] = alph.charAt(j-1);
			}
		}

		Set<Character> path = new HashSet<>();
		path.add(board[1][1]);
		
		movePiece(1, 1, path, 1);
		System.out.println(max_Dis);
		
	}
	private static void movePiece(int x, int y, Set<Character> path, int dis) {
		max_Dis = Math.max(max_Dis, dis);
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		for(int i = 0; i < 4; i++) {
			int xx = dx[i] + x;
			int yy = dy[i] + y;
			
			if(xx < 1 || yy < 1 || xx > R || yy > C) continue;
			
			char next = board[xx][yy];
			if (!path.contains(next)) {
	            path.add(next);
	            movePiece(xx, yy, path, dis + 1);
	            path.remove(next);
	        }
			
		}
	}
	

}
