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
        

        if(list.size()%2!=0){
            int count=0;

            int mid=list.size()/2;
            int midVal=list.get(mid);
            
            for(int ele:list){
                if(Math.abs(midVal-ele)%x==0){
                    count+=Math.abs(midVal-ele)/x;
                }
                else return -1;
            }
            return count;
        }
        else{
            int count1=0;
            int count2=0;

            int firstmidVal=list.get(list.size()/2-1);
            int secondmidVal=list.get(list.size()/2);

            for(int ele:list){
                if(Math.abs(firstmidVal-ele)%x==0){
                    count1+=(Math.abs(firstmidVal-ele)/x);
                }
                else return -1;
            }

            for(int ele:list){
                if(Math.abs(secondmidVal-ele)%x==0){
                    count2+=(Math.abs(secondmidVal-ele)/x);
                }
                else return -1;
            }
            return Math.min(count1,count2);
        }
    }
}