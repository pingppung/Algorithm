import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int idx = 1;
		while(idx <= 10) {
			int N = Integer.parseInt(br.readLine());
			int[] building = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

			int view = 0;
			for(int i = 2; i < building.length-2; i++) {
				int l_max = Math.max(building[i-1], building[i-2]);
				int r_max = Math.max(building[i+1], building[i+2]);
				if(building[i] > l_max && building[i] > r_max) {
					view += building[i] - Math.max(l_max, r_max);
				}
			}
			System.out.printf("#%d %d\n", idx++, view);
		}
		
	}
	

}