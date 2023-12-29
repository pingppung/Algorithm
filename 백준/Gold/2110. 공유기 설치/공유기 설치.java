import java.io.*;
import java.util.*;
public class Main {
	static int[] houses;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		houses = new int[n];
		for(int i = 0; i < n; i++) {
			houses[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(houses);
		System.out.println(router(c, houses[n-1]));
	}
		
	private static long router(int c, int max) {
		int min_space = 1;
		int max_space = max;
		int result = 0;
		while(min_space <= max_space) {
			int count = 1;
			int install_pos = houses[0];
			int mid = (min_space + max_space) / 2;
			for(int house : houses) {
				if(house - install_pos >= mid) {
					count++;
					install_pos = house;
				}
			}
			if(count >= c) {
				result = mid;
				min_space = mid + 1;
			}
			else max_space = mid - 1;
		}
		return result;
	}
}