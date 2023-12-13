import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int count = Integer.parseInt(br.readLine());
    	st = new StringTokenizer(br.readLine());
    	int[] nums = new int[count];
    	for(int i = 0; i < count; i++)
    		nums[i] = Integer.parseInt(st.nextToken());
    	Arrays.sort(nums);
    	
    	System.out.println(nums[0]*nums[count-1]);
    }

}
