import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String name = br.readLine();
		int n = Integer.parseInt(br.readLine());
		
		
		String love = "LOVE";

		int max = -1; 
		String WinningTeam = "";
		
		int[] loveCnt = new int[4];
		
		for(int i = 0; i < n; i++) {
			String team = br.readLine();
			for(int j = 0; j < 4; j++) {
				int count = name.length() - name.replace(String.valueOf(love.charAt(j)), "").length();
				count += team.length() - team.replace(String.valueOf(love.charAt(j)), "").length();
				loveCnt[j] = count;
			}
			int total = 1;
			for(int j = 0; j < 4; j++) {
				for(int k = (j + 1); k < 4; k++) {
					total *= (loveCnt[j] + loveCnt[k]);
				}
			}
			if(max < (total % 100)) {
				max = total % 100;
				WinningTeam = team;
			} else if(max == (total % 100)) {
				if (team.compareTo(WinningTeam) < 0) {
	                WinningTeam = team;
	            }
			}
		}
		System.out.println(WinningTeam);
		
	}
}