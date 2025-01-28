class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {

        int n=nums.length;
       
        List<int[]> arr=new ArrayList<>();

         for(int i=0;i<n;i++){
            arr.add(new int[]{nums[i],i});
        }
       Collections.sort(arr,(a,b)->{
        return a[0]-b[0];
       });

        List<List<Integer>> groups=new ArrayList<>();

        // groups.add(arr.get(0)[1]);
        groups.add(new ArrayList<>(List.of(arr.get(0)[1])));

        for(int i=1;i<n;i++){
            if(Math.abs(arr.get(i)[0]-arr.get(i-1)[0])<=limit){
                groups.get(groups.size()-1).add(arr.get(i)[1]);
            }
            else{
                groups.add(new ArrayList<>(List.of(arr.get(i)[1])));
            }

        }

        for(List<Integer> group:groups){
            List<Integer> values=new ArrayList<>();
            for(int ele:group){
                values.add(nums[ele]);
            }

            Collections.sort(group);

            for(int i=0;i<group.size();i++){
                nums[group.get(i)]=values.get(i);
            }
        }

        return nums;
        
    }

    
}