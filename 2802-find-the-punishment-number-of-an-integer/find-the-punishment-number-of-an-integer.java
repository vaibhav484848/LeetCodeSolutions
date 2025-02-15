class Solution {

    boolean possible(String n,int sum,int i){
        if(n.length()==0) {
            if(sum==i) return true;
            return false;
        }
        if(sum>i) return false;

        boolean ans=false;

        for(int j=0;j<n.length();j++){
            
            int increment=Integer.parseInt(n.substring(0,j+1));
            
            ans= possible(n.substring(j+1),sum+increment,i);
            if(ans) return true;
        }
        return ans;

    }
    public int punishmentNumber(int n) {
        int count=1;

       
        for(int i=2;i<=n;i++){
            int sq=i*i;
            
            String str=""+sq;
            if(possible(str,0,i)){
                count+=sq;
            }
            
        }

        return count;
        
    }
}