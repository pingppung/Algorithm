import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int idx = 1;
		while(T-- > 0) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sum = 0;
			for(int i = 0; i < 10; i++) {
				int num = Integer.parseInt(st.nextToken());
				if(num % 2 == 1) {
					sum += num;
				}
			}
			System.out.println("#"+ idx++ + " " + sum);
		}
	}
}