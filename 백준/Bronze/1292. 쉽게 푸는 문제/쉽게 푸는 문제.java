import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());

    	int a = Integer.parseInt(st.nextToken());
    	int b = Integer.parseInt(st.nextToken());
    	
    	int[] arr = new int[1001];
    	
    	int num = 1;
    	int cnt = 0;
    	for(int i = 1; i < 1001; i++) {
    		arr[i] = num;
    		cnt++;
    		if(cnt == num) {
    			num++;
    			cnt = 0;
    		}
    	}
    	int sum = 0;
    	
    	for(int i = a; i <= b; i++){
    		sum += arr[i];
    	}
    	System.out.println(sum);
    }
}
