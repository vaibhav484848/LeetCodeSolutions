class Solution {
    int noOfPalindrome(String s2){
        
        HashMap<Character,Integer> map2=new HashMap<>();

        
        int even=0;
        int odd=0;

        for(int i=0;i<s2.length();i++){
            char ch=s2.charAt(i);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }
            
            for(char ch:map2.keySet()){
                if(map2.get(ch)%2==0) even++;
                else odd++;

            }

        return odd;

        


    }
    public boolean canConstruct(String s, int k) {

        int n=s.length();
        if(k>n) return false;
        if(k==n) return true;

        int sum=0;

        sum+=noOfPalindrome(s);

        return sum<=k?true:false;



    }
}