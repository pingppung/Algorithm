class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ", -1);
        String answer = "";
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length(); j++){
                if(j%2 == 0)
                    answer += Character.toUpperCase(arr[i].charAt(j));
                else answer += Character.toLowerCase(arr[i].charAt(j));
            }
            if(i!=arr.length-1) answer+=" ";
        }
        return answer;
    }
}