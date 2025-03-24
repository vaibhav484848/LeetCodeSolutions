class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->{
            return a[0]-b[0];
        });
        
        int count=0;

        int n= meetings.length;
        int prevEnd=0;
        for(int i=0;i<n;i++){
            int a=meetings[i][0];
            int b=meetings[i][1];
            
            if(a>prevEnd){
                count+=(a-prevEnd-1);
            }
            prevEnd=Math.max(prevEnd,b);
        }
        count+=(days-prevEnd);

        return count;
    }
}