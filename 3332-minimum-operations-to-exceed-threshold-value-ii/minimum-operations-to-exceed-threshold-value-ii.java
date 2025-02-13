class Solution {
    public int minOperations(int[] nums, int k) {

        PriorityQueue<Long> pq= new PriorityQueue<>();

        int n=nums.length;

        for(int i=0;i<n;i++){
            pq.add((long)nums[i]);
        }

        int count=0;

        while(pq.size()>0){
            long a=pq.remove();
            count++;
            if(a>=(long)k) return count-1;
            long b=pq.remove();
            pq.add((a*2+b));
        }

        return count;
        
    }
}