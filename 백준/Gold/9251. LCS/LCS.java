import java.io.*;
import java.util.*;
public class Main {
	static char[] s1, s2;
	static Integer[][] dp;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	s1 = br.readLine().toCharArray();
    	s2 = br.readLine().toCharArray();
    	dp = new Integer[s1.length][s2.length];
    	System.out.println(lcs(s1.length-1, s2.length-1));
    }
    private static int lcs(int a, int b) {
    	if(a < 0 || b < 0 ) return 0;
    	if(dp[a][b] == null) {
    		dp[a][b] = 0;
    		if(s1[a] == s2[b]) dp[a][b] = lcs(a-1, b-1)+1;
    		else dp[a][b] = Math.max(lcs(a-1,b), lcs(a,b-1));
    	}
    	return dp[a][b];
    }
}