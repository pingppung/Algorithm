import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int a = Integer.parseInt(st.nextToken());
    	int b = Integer.parseInt(st.nextToken());
    	int n = Integer.parseInt(st.nextToken());
    	int result = a%b;
    	for(int i = 1; i < n; i++){ 
            result *= 10;
            result %= b;
        }
        result *= 10;
        System.out.println(result/b);
    }
}
