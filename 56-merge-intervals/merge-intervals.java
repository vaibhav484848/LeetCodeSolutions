class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;

        List<int[]> list=new ArrayList<>();

        Arrays.sort(intervals,(a,b)->{
            return a[0]-b[0];
        });
        list.add(intervals[0]);
        int end=intervals[0][1];
        for(int i=1;i<n;i++){
            int a=intervals[i][0];
            int b=intervals[i][1];

            if(end>=a){
                int maxm=Math.max(end,b);
                int[] arr=list.get(list.size()-1);
                int st=arr[0];
                list.set(list.size()-1,new int[]{st,maxm});
                end=maxm;
            }
            else{
                list.add(intervals[i]);
                 end=b;
            }
           
        }
        int[][] ans=new int[list.size()][2];
        int idx=0;
        for(int[] ele:list){
            ans[idx++]=ele;
        }

        return ans;
        
    }
}