class Solution {
    public int tupleSameProduct(int[] nums) {

        HashMap<Integer,List<String>> map =new HashMap<>();

        int n=nums.length;

        int count=0;
         

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int pro=nums[i]*nums[j];
                String notMatch=nums[i]+","+nums[j];

                if(map.containsKey(pro)){
                    count+=map.get(pro).size();
                    // for(int ele:map.keySet()){
                    //     // if(!(map.get(ele).equals(notMatch))) {
                    //     //     count++;
                    //     //     System.out.println(pro);
                    //     // }

                    // }
                    
                }
                // System.out.println(map);
                map.putIfAbsent(pro,new ArrayList<>());
                map.get(pro).add(notMatch);


            }
        }

        return count*8;
        
    }
}