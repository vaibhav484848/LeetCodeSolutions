class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                list.add(grid[i][j]);
            }
        }
        if(list.size()==1) return 0;
        Collections.sort(list);
        

        
        
            int count2=0;

            int secondmidVal=list.get(list.size()/2);

            for(int ele:list){
                if(Math.abs(secondmidVal-ele)%x==0){
                    count2+=(Math.abs(secondmidVal-ele)/x);
                }
                else return -1;
            }
            return count2;
            
    }
}