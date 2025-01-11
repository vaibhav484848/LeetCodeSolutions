class Solution {
    int noOfPalindrome(String s1,String s2){
        HashMap<Character,Integer> map1=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();

        int permu1=0,permu2=0;

        for(int i=0;i<s1.length();i++){
            char ch=s1.charAt(i);
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }

        for(int i=0;i<s2.length();i++){
            char ch=s2.charAt(i);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }

        if(map1.size()==1){
            permu1=1;    
        }
        else{
            int even=0;
            int odd=0;
            for(char ch:map1.keySet()){
                if(map1.get(ch)%2==0) even++;
                else odd++;

            }

            if(odd>1) permu1=0;
            else permu1=even;
        }

        int even=0;
        int odd=0;

        if(map2.size()==1){
            permu2=1;    
        }
        else{
            // int even=0;
            // int odd=0;
            for(char ch:map2.keySet()){
                if(map2.get(ch)%2==0) even++;
                else odd++;

            }

            // if(odd>1) {
            //     // permu2=0;
            //     permu2=odd
            // }
            // else permu2=even;
        }

        return odd;

        // return permu1*permu2;


    }
    public boolean canConstruct(String s, int k) {

        int n=s.length();
        if(k>n) return false;
        if(k==n) return true;

        int sum=0;

        // for(int i=0;i<n;i++){
        //     sum+=noOfPalindrome(s.substring(0,i+1),s.substring(i+1));

        // }

         sum+=noOfPalindrome("a",s.substring(0));

        return sum<=k?true:false;



    }
}