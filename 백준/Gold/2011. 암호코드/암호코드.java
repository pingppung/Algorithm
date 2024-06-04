import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	 String n = br.readLine();
    	 int MOD = 1000000;
         if (n.startsWith("0")) {
             System.out.println(0);
             return;
         }
         
         int[] dp = new int[n.length() + 1];
         dp[0] = 1;
         dp[1] = 1;

         for (int i = 2; i <= n.length(); i++) {
             int oneDigit = Integer.parseInt(n.substring(i - 1, i));
             int twoDigits = Integer.parseInt(n.substring(i - 2, i));
             
             if (oneDigit >= 1 && oneDigit <= 9) {
                 dp[i] = (dp[i] + dp[i - 1]) % MOD;
             }
             if (twoDigits >= 10 && twoDigits <= 26) {
                 dp[i] = (dp[i] + dp[i - 2]) % MOD;
             }
         }

         System.out.println(dp[n.length()]);
    }
}