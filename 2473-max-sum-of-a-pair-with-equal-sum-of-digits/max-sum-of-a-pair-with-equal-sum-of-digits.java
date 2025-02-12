class Solution {
    int digSum(int n){

        int sum=0;

        while(n>0){
            sum+=(n%10);
            n/=10;
        }

        return sum;
    }
    public int maximumSum(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<>();

        int n=nums.length;
        int maxm=-1;

        for(int i=0;i<n;i++){
            int ele=nums[i];
            int currSum=digSum(ele);

            if(map.containsKey(currSum)){
                int val=map.get(currSum);
                maxm=Math.max(val+ele,maxm);
                map.put(currSum,Math.max(val,ele));
            }
            else map.put(currSum,ele);

        }

        return maxm;
        
    }
}