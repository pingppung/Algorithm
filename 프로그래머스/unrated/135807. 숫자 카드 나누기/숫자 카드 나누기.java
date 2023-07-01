class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        for(int i = 1; i < arrayA.length; i++){
            gcdA = gcd(arrayA[i], gcdA);
            gcdB = gcd(arrayB[i], gcdB);
        }
        if(div(arrayA, gcdB)) {
            answer = Math.max(answer, gcdB);
        }
        if(div(arrayB, gcdA)){
            answer = Math.max(answer, gcdA);
        }
        return answer;
    }
    public static int gcd(int a, int b){
        while(b!=0){
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
    public boolean div(int[] arr, int num){
        for(int i : arr){
            if(i%num == 0) return false;
        }
        return true;
    }
}