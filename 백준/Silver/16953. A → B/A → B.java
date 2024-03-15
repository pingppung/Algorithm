import java.io.*;
import java.util.*;
public class Main {
	static Queue<Long> q = new LinkedList<>();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());

    	long a = Long.parseLong(st.nextToken());
    	long b = Long.parseLong(st.nextToken());
    	System.out.println(bfs(a, b));
    	
    }
	static int bfs(long a, long b) {
		int count = 0;
		q.add(a);
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				long k = q.poll();
				if(k==b) return count+1;
				if(k*2<=b) q.add(k*2);
				if(k*10+1<=b)q.add(k*10+1);
			}
			count++;
		}
		return -1;
	}
}  