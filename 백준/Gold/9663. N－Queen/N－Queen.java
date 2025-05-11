import java.util.*;
import java.io.*;

public class Main {
	static int n, count = 0;
	static int[] board;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		board = new int[n];
		queen(0);
		System.out.println(count);
	}
	private static void queen(int row) {
		if(row == n) {
			count++;
			return;
		}
		
		for(int i = 0; i < n; i++) {
			board[row] = i;
			if(isSafe(row)) {
				queen(row+1);
			}
		}
	}
	private static boolean isSafe(int row) {
		for(int i = 0; i < row; i++) {
			if(board[i] == board[row] || Math.abs(board[row] - board[i]) == row -i) {
				return false;
			}
		}
		return true;
	}
}
