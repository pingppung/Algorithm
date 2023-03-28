import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int n = Integer.parseInt(br.readLine());
        long[] x = new long[n+1];
        long[] y = new long[n+1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }
        x[n] = x[0];
        y[n] = y[0];
        long a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            a += x[i] * y[i + 1];
            b += x[i + 1] * y[i];
        }

        System.out.println(String.format("%.1f", (Math.abs(a - b) / 2.0)));
    	
    }
   
}
