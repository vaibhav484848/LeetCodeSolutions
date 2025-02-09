class Solution {
    public long countBadPairs(int[] nums) {
        int n=nums.length;
        
        long count=0;

        long total=(long)(n-1)*(n)/2;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            int key=nums[i]-i;
            
            count+=(long)map.getOrDefault(key,0);

            map.put(key,map.getOrDefault(key,0)+1);

        }

        return total-count;


        
    }
}