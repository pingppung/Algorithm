import java.util.*;
class Solution {
    int[] info;
    int[][] edges;
    int max = Integer.MIN_VALUE;
    List<Integer>[] graph;

    public int solution(int[] info, int[][] edges) {
        this.info = info;
        this.edges = edges;
        int n = info.length;
        
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }
        
        boolean[] visited = new boolean[n];
        List<Integer> currentPath = new ArrayList<>();
        currentPath.add(0);
        countSheep(0, 0, 0, visited, currentPath);
        
        return max;
    }

    private void countSheep(int node, int sheep, int wolf, boolean[] visited, List<Integer> path) {
        visited[node] = true;
        if (info[node] == 0) sheep += 1;
        else wolf += 1;
        if (sheep <= wolf) {
            visited[node] = false;
            return;
        }
        max = Math.max(sheep, max);

        for (int next : path) {
            for (int child : graph[next]) {
                if (!visited[child]) {
                    List<Integer> newPath = new ArrayList<>(path);
                    newPath.add(child);
                    countSheep(child, sheep, wolf, visited, newPath);
                }
            }
        }

        visited[node] = false;
    }
}
