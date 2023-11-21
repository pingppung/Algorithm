class Solution {
    private char[][] map;
    private int w, h;
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        w = wallpaper[0].length();
        h = wallpaper.length;
        map = new char[h][w];
        for(int i = 0; i < h; i++){
            map[i] = wallpaper[i].toCharArray();
        }
        answer = findLuRdXY();
        return answer;
    }
    private int[] findLuRdXY(){
        int lux = h, luy = w;
        int rdx = 0, rdy = 0;
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(map[i][j] == '#') {
                    lux = Math.min(lux, i);
                    luy = Math.min(luy, j);
                    rdx = Math.max(rdx, i+1);
                    rdy = Math.max(rdy, j+1);
                }
                
            }
        }
        return new int[]{lux, luy, rdx, rdy};
    }
}