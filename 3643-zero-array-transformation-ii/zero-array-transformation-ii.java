class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n=nums.length;
        int qL=queries.length;

        int sum=0;
        int k=0;

        int[] diffArr=new int[n];

        for(int i=0;i<n;i++){
            int ele=nums[i];

            while(sum+diffArr[i]<ele){
                if(k>=qL) return -1;
                int a=queries[k][0];
                int b=queries[k][1];
                int c=queries[k][2];
                
                if(b>=i){
                    diffArr[Math.max(a,i)]+=c;
                    if(b+1<n) diffArr[b+1]-=c;
                }
                
                // else{
                //     diffArr[a]+=c;
                // }
                
                

                // System.out.println(Arrays.toString(diffArr)+" "+i);
                
                k++;
            }
            sum+=diffArr[i];
        }
        return k;
    }
}