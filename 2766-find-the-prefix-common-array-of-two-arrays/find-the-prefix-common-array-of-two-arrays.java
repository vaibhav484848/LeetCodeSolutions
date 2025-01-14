class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {

        HashSet<Integer> set1=new HashSet<>();
        HashSet<Integer> set2=new HashSet<>();
        
        int n=A.length;
        int[] ans=new int[n];

        for(int i=0;i<n;i++){
            int ele1=A[i];
            int ele2=B[i];
        

            set1.add(ele1);
            set2.add(ele2);

            HashSet<Integer> temp=new HashSet<>(set1);

            temp.retainAll(set2);

            ans[i]=temp.size();

            
        }


        return ans;
        
    }
}