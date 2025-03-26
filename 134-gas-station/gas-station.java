class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int n=gas.length;
        int idx=-1;
        int curr=0;
        int total=0;

        for(int i=0;i<n;i++){
            int dif=gas[i]-cost[i];
            curr+=dif;
            total+=dif;
            if(curr<0){
                curr=0;
                idx=i;
            }

        }
        if(total>=0) return idx+1;
        return -1;
        
    }
}