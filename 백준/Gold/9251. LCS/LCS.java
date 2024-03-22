import java.io.*;
import java.util.*;
public class Main {
	static Integer[][] dp;
	static char[] s1;
	static char[] s2;

    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	s1 = br.readLine().toCharArray();
    	s2 = br.readLine().toCharArray();
    	dp = new Integer[s1.length][s2.length];
    	System.out.println(LCS(s1.length-1, s2.length-1));
    }
    public static int LCS(int a, int b) {
    	if(a<0||b<0) return 0;
    	if(dp[a][b] ==null) {
    		dp[a][b] = 0;
    		if(s1[a] == s2[b])
    			dp[a][b] = LCS(a-1,b-1)+1;
    		else 
    			dp[a][b] = Math.max(LCS(a-1,b), LCS(a, b-1));
    		
    	}
    	return dp[a][b];
    }

} 