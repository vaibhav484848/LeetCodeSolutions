class Solution {

    boolean possible(int idx,String n,int target){
        if(idx==n.length()) return target==0;
        

        boolean ans=false;
        int sum=0;

        for(int j=idx;j<n.length();j++){
            
            sum=sum*10 +(n.charAt(j)-'0');
            if(sum>target) return false;
            
            ans= possible(j+1,n,target-sum);
            if(ans) return true;
        }
        return ans;

    }
    public int punishmentNumber(int n) {
        int count=1;

       
        for(int i=2;i<=n;i++){
            int sq=i*i;
            
            String str=""+sq;
            if(possible(0,str,i)){
                count+=sq;
            }
            
        }

        return count;
        
    }
}