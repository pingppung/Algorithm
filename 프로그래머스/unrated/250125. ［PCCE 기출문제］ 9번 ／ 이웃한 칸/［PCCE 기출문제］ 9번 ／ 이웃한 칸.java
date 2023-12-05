class Solution {
    public int solution(String[][] board, int h, int w) {
        int board_height = board.length;
        int board_weight = board[0].length;
        
        int answer = 0;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,1,-1};
        for(int i = 0; i < 4; i++){
            int xx = h+dx[i];
            int yy = w+dy[i];
            if(xx < 0 || yy < 0 || xx >= board_height || yy >= board_weight) continue;
            if(board[xx][yy].equals(board[h][w])){
                answer++;
            }
        }
        return answer;
    }
}