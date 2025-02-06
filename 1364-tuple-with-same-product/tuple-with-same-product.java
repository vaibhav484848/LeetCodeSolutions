class Solution {
    public int tupleSameProduct(int[] nums) {

        HashMap<Integer,Integer> map =new HashMap<>();

        int n=nums.length;

        int count=0;
         

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int pro=nums[i]*nums[j];
                
                if(map.containsKey(pro)){
                    count+=map.get(pro);
                   
                }
                
                map.put(pro,map.getOrDefault(pro,0)+1);
            }
        }

        return count*8;
        
    }
}