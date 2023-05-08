import java.io.*;
import java.util.*;
public class Main {
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int w = Integer.parseInt(st.nextToken());
    	int h = Integer.parseInt(st.nextToken());
    	st = new StringTokenizer(br.readLine());
    	int p = Integer.parseInt(st.nextToken());
    	int q = Integer.parseInt(st.nextToken());
    	int t = Integer.parseInt(br.readLine());
    	if(((int)(p+t)/w)%2 == 0) p = (p+t)%w;
    	else p = w - (p+t)%w;
    	
    	if(((int)(q+t)/h)%2 == 0) q = (q+t)%h;
    	else q = h - (q+t)%h;
    	
    	sb.append(p).append(" ").append(q);
    	System.out.println(sb);
    	
    }
}
