import java.io.*;
import java.util.*;
public class Main {
	static int n, k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		int total = 0;
		int digit = 1; //0자리(1~9-1자리 9개,  10~99- 2자리 90개, 100~999- 3자리 900개....)
		for(int i = 1; i <= 8; i++,digit *=10) { //9자리인 경우는 100000000밖에 없기 때문
			int count = 9*digit;
			if(total + count*i < k) { //k번째보다 작을경우 계속
				total += count*i;
				continue;
			}
			int num = (k-total-1)/i + digit; //몇자리수 이상 이하
			if(num > n) System.out.println(-1);
			else System.out.println(String.valueOf(num).charAt((k-total-1)%i));
			return;
			
		}
		if(k - total <= 9) { // 9자리 중 하나
			if(k - total == 0) System.out.println(1);
			else System.out.println(0);
		}
		else System.out.println(-1);
	}
}
