import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[] houses = new int[N];
		for(int i = 0; i < N; i++) {
			houses[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(houses);
		
		int min_dist = 1; 
		int max_dist = houses[N-1] - houses[0];
		while(min_dist <= max_dist) {
			int count = 1;
			int install_pos = houses[0];
			int mid = (min_dist + max_dist) / 2;
			
			for(int house : houses) {
				if(house - install_pos >= mid) {
					count++;
					install_pos = house;
				}
			}
			if(count >= C) min_dist = mid + 1;
			else max_dist = mid - 1;
		}
		
		System.out.println(max_dist);
	}
	
}
