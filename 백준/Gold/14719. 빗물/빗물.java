import java.io.*;
import java.util.*;
public class Main {
	static int h, w, count = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		
		int[] height = new int[w];
		int[] water = new int[w];
		st = new StringTokenizer(br.readLine());
		
		int max = 0;
		for(int i = 0; i < w; i++) {
			height[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, height[i]); //왼쪽 벽에 맞춘 빗물 최대 높이
			water[i] = max;
		}
		
		max = 0;
		for(int i = w-1; i >= 0; i--) {
			max = Math.max(max, height[i]); //오른쪽 벽에 맞춘 빗물 최대 높이
			//빗물 높이가 더 낮은 쪽을 저장 -> 높으면 넘침
			water[i] = Math.min(water[i], max); 
			count += water[i]-height[i];
		}
		System.out.println(count);
		

	}
}
