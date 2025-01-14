class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {

        HashMap<Integer,Integer> map=new HashMap<>();


        int n=A.length;
        int[] ans=new int[n];

        int count=0;

        for(int i=0;i<n;i++){
            int ele1=A[i];
            int ele2=B[i];

            if(map.containsKey(ele1)) count++;
            map.put(ele1,map.getOrDefault(ele1,0)+1);

            if(map.containsKey(ele2)) count++;
            map.put(ele2,map.getOrDefault(ele2,0)+1);

           
            ans[i]=count;

            
        }


        return ans;
        
    }
}