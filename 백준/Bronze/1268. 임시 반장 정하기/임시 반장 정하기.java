import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] student = new int[n][5];
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				student[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int leader = 1;
		int maxCount = 0;
		for(int i = 0; i < n; i++) {
			Set<Integer> set = new HashSet<>();
			for(int j = 0; j < 5; j++) {
				for(int k = 0; k < n; k++) {
					if(i == k) continue;
					if(student[i][j] == student[k][j]) {
						set.add(k);
					}
				}
			}
			if(maxCount < set.size()) {
				leader = i+1;
				maxCount = set.size();
			}
		}

		System.out.println(leader);
	}
}