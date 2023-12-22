import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> que = new LinkedList<Integer>();
        for(int i = 1; i <= n; i++) {
        	que.add(i);
        }

        sb.append("<");
        while(que.size() != 1) {
        	for(int i = 0; i < k-1; i++) {
        		que.offer(que.poll());
        	}
        	sb.append(que.poll() + ", ");
        }
        sb.append(que.poll()+">");
        System.out.println(sb.toString());
    }
}  
