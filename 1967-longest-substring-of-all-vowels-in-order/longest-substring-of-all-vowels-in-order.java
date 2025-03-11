class Solution {
    public int longestBeautifulSubstring(String word) {

        

        int l=0,r=1,n=word.length();
        int ans=0;
        

        int count=1;

        while(r<n){
            char present=word.charAt(r);
            char previous=word.charAt(r-1);
            if(present<previous){
                l=r;
                count=1;
                
            }
            else{
                if(present>previous) count++;
                if(count==5){
                    ans=Math.max(r-l+1,ans);
                }
            }
            r++;
        }

        return ans;
        
    }
}