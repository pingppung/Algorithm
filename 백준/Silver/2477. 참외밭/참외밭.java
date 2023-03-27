import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int k = Integer.parseInt(br.readLine());
    	int maxW = 0, maxH = 0, wIdx = 0, hIdx = 0;
    	int[] arr = new int[6];
    	for(int i = 0; i < 6; i++) {
        	st = new StringTokenizer(br.readLine());
        	int direction = Integer.parseInt(st.nextToken());
        	int len = Integer.parseInt(st.nextToken());
        	arr[i] = len;
        	if((direction == 1 || direction == 2) && maxW < arr[i]) {
        		maxW = arr[i];
        		wIdx = i;
        	} else if((direction == 3 || direction == 4) && maxH < arr[i]){
        		maxH = arr[i];
        		hIdx = i;
        	}
    	}
    	int area = maxW * maxH - arr[(wIdx+3)%6] * arr[(hIdx + 3)%6];
    	System.out.println(area*k);
    }
   
}
