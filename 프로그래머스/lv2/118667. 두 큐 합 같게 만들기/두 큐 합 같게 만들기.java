import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long s1 =0, s2 = 0;
        for (int i : queue1) { q1.add(i); s1+=i; }
        for (int i : queue2) { q2.add(i); s2+=i; }
        long sum = s1+s2;
        if(sum%2 == 1) return -1; //sum이 홀수이면 합을 맞출 수가 없음
        sum /= 2;
        int count1 = 0, count2 = 0;
        while(true){
            if(count1 > queue1.length*2 && count2 > queue1.length*2) break;
            if(s1 == sum) return count1+count2;
            if(s1 > sum){
                s1 -= q1.peek();
                s2 += q1.peek();
                q2.add(q1.poll());
                count1++;
            } else{
                s1 += q2.peek();
                s2 -= q2.peek();
                q1.add(q2.poll());
                count2++;
            }
        }
        return -1;
    }
}