class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {

        List<Integer> gaps=new ArrayList<>();
        gaps.add(startTime[0]);

        int n=startTime.length;

        for(int i=1;i<n;i++){
            gaps.add(startTime[i]-endTime[i-1]);
        }
        gaps.add(eventTime-endTime[n-1]);

        int max=0;


        List<Integer> lGap=new ArrayList<>(Collections.nCopies(gaps.size(), 0));
        List<Integer> rGap = new ArrayList<>(Collections.nCopies(gaps.size(), 0));


        for(int i=2;i<n+1;i++){
            lGap.set(i,Math.max(gaps.get(i-2),lGap.get(i-1)));
        }

        for(int i=gaps.size()-2;i>=0;i--){
            rGap.set(i,Math.max(gaps.get(i+1),rGap.get(i+1)));
        }

        for(int i=1;i<gaps.size();i++){
            int diff=endTime[i-1]-startTime[i-1];
            if(lGap.get(i)>=diff || rGap.get(i)>=diff){
                max=Math.max(diff+gaps.get(i-1)+gaps.get(i),max);
            }
            max=Math.max(max,gaps.get(i-1)+gaps.get(i));
        }

        return max;



        
        
    }
}