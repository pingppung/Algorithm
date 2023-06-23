import java.util.*;
class Solution {
    static Set<Integer> set = new HashSet<>();
    static char[] arr;
    static boolean[] visited;
    public int solution(String numbers) {
        int answer = 0;
        arr = numbers.toCharArray();
        visited = new boolean[numbers.length()];
        
        combin("",0);
        System.out.println(set);
        return set.size();
    }
    public void combin(String str, int idx){
        int num;
        if(!str.equals("")){
            num = Integer.parseInt(str);
            if(isPrime(num)) set.add(num);
        }
        if(idx == arr.length) return;
        for(int i = 0; i < arr.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            combin(str+arr[i], idx+1);
            visited[i] = false;
        }
    }
    public boolean isPrime(int num){
        if(num == 0 || num == 1) return false;
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}