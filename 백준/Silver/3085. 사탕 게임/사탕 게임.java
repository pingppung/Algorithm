import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
	static int n;
	static char[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];

		int max = 0;
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		//바꾸기 전 사탕 최대 개수
		for(int i = 0; i < n; i++) {
			max = Math.max(max, chkRow(i)); //행
			max = Math.max(max, chkCol(i)); //열
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(j+1 < n) {
					swap(i, j, i, j+1); //행에서 오른쪽 값과 바꾸기
					max = Math.max(max, chkRow(i));
					max = Math.max(max, chkCol(j));
					max = Math.max(max, chkCol(j + 1));
					swap(i, j, i, j + 1); // 다시 원상복귀
				}
				if(i+1 < n) {
					swap(i, j, i+1, j); //열에서 아래쪽 값과 바꾸기
					max = Math.max(max, chkCol(j));
					max = Math.max(max, chkRow(i));
					max = Math.max(max, chkRow(i + 1));
					swap(i, j, i+1, j); // 다시 원상복귀
				}
			}
		}
		System.out.println(max);

	}
	public static void swap(int x1, int y1, int x2, int y2) {
		char c = arr[x1][y1];
		arr[x1][y1] = arr[x2][y2];
		arr[x2][y2] = c;
	}
	public static int chkRow(int x) { // 행 개수 체크
		int max = 1, count = 1;
		char c = arr[x][0];
		for (int i = 1; i < n; i++) {
			if (arr[x][i] != c) {
				c = arr[x][i];
				max = Math.max(max, count);
				count = 1;
			} else
				count++;
		}
		return Math.max(max, count); // 마지막 열일 수도 있기 떄문
	}

	public static int chkCol(int y) { //열 최대 개수 체크
		int max = 1, count = 1;
		char c = arr[0][y];
		for (int i = 1; i < n; i++) {
			if (arr[i][y] != c) {
				c = arr[i][y];
				max = Math.max(max, count);
				count = 1;
			} else
				count++;
		}
		return Math.max(max, count); // 마지막 행이 최대일 수 있기 떄문
	}

}
