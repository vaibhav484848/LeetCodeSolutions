class Solution {
    public boolean divideArray(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int ele:nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        for(int ele:map.keySet()){
            if(map.get(ele)%2!=0)return false;
        }
        return true;
    }
}