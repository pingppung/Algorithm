import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] n = br.readLine().split("");
    	int[] arr = new int[10];
    	int count = 0;
    	for(int i = 0; i < n.length; i++) {
    		int num = Integer.parseInt(n[i]);
    		if(num == 9) num = 6;
    		arr[num]++;
    	}
    	arr[6] = (arr[6]/2) + (arr[6]%2);
    	Arrays.sort(arr);
    	System.out.println(arr[9]);
    }

}  
