import java.io.*;
import java.util.*;
public class Main {
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int n = Integer.parseInt(br.readLine());
    	st = new StringTokenizer(br.readLine());
    	int[][] a = new int[n][2];
    	for(int i = 0; i < n; i++) {
    		a[i][0] = Integer.parseInt(st.nextToken());
    		a[i][1] = i;
    	}
    	Arrays.sort(a, new Comparator<int[]>(){
    		public int compare(int[] o1, int[] o2) {
				if(o1[0] > o2[0]) return 1;
				else if(o1[0] < o2[0]) return -1;
				else return Integer.compare(o1[1], o2[1]);
    			
    		}
    	});
    	int[] p = new int[n];
    	for(int i = 0; i < n; i++) {
    		p[a[i][1]] = i;
    	}
    	for(int i = 0; i <n; i++) sb.append(p[i]).append(" ");
    	System.out.println(sb);
    }
}
