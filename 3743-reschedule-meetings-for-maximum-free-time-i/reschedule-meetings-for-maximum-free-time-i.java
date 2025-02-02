class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {

        List<Integer> gaps=new ArrayList<>();
        gaps.add(startTime[0]);

        int n=startTime.length;

        for(int i=1;i<n;i++){
            gaps.add(startTime[i]-endTime[i-1]);
        }
        gaps.add(eventTime-endTime[n-1]);

        int max=0;
        int curr=0;

        for(int i=0;i<gaps.size();i++){
            curr+=gaps.get(i)- ((i>k)?gaps.get(i-k-1):0);
            max=Math.max(max,curr);
            
        }

        return max;
        
    }
}