import java.util.*;
class Solution {
    static boolean[] visited;
    static ArrayList<String> arr = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        visited = new boolean[tickets.length];
        dfs("ICN", "ICN", tickets, 0);
        Collections.sort(arr);
        answer = arr.get(0).split(" ");
        return answer;

    }
    static void dfs(String start, String destination,String[][] tickets, int cnt){
        if(cnt == tickets.length){
            arr.add(destination);
            return;
        }
        for(int i = 0; i < tickets.length; i++){
            if(start.equals(tickets[i][0]) && !visited[i]){
                visited[i] = true;
                dfs(tickets[i][1], destination +" "+ tickets[i][1], tickets, cnt+1);
                visited[i] = false;
            }
        }

    }
}