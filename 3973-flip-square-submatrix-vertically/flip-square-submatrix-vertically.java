class Solution {

    void swapping(int [][] grid,int i,int j,int y,int k){
        while(i<j){
            for(int r=y;r<y+k;r++){
                // swap(grid[i][r],grid[j][r]);
                int temp=grid[i][r];
                grid[i][r]=grid[j][r];
                grid[j][r]=temp;
            }
            i++;j--;
        }
    }
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        
        swapping(grid,x,x+k-1,y,k);
        return grid;
    }
}