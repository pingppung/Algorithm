import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	while(T-- > 0) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		int dis = y-x;
    		int disSqrt = (int)Math.sqrt(dis);
    		if(disSqrt == Math.sqrt(dis)) sb.append(disSqrt * 2 - 1).append("\n");
    		else if(disSqrt * disSqrt + disSqrt >= dis) sb.append(disSqrt * 2).append("\n");
    		else sb.append(disSqrt * 2 +1).append("\n");
    	}
    	System.out.println(sb.toString());
    }
}