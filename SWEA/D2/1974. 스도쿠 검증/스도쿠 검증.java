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
			int[][] puzzle = new int[9][9];
			for(int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 9; j++) {
					puzzle[i][j] = Integer.parseInt(st.nextToken());
					
				}
			}
			int result = 1;
			if(grid3(puzzle)) {
				for(int i = 0; i < 9; i++) {
					if(!rowCol(puzzle, i)) {
						result = 0;
						break;
					}
				}
			}
			else result = 0;
			System.out.printf("#%d %d\n", idx++, result);
		}
	}
	private static boolean grid3(int[][] puzzle) {
		for(int i = 0; i < 3; i++) {
			int[] nums = new int[10];
			for(int k = 3*i; k < 3*i+3; k++) {
				for(int l = 3*i; l < 3*i+3; l++) {
					int num = puzzle[k][l];
					nums[num]++;
					if(nums[num] > 1) return false;
				}
			}
		}
		return true;
	}
	
	private static boolean rowCol(int[][] puzzle, int idx) {
		int[] row = new int[10];
		int[] col = new int[10];
		for(int i = 0; i < 9; i++) {
			int row_num = puzzle[idx][i];
			int col_num = puzzle[i][idx];
			row[row_num]++;
			col[col_num]++;
			if(row[row_num] > 1 || col[col_num] > 1) return false;
					
		}
		return true;
	}

}