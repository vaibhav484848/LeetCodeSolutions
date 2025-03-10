class Solution {
    int[] lastPos=new int[5];
    boolean vowels(Map<Character,Integer> map){
        if(map.containsKey('a') && map.containsKey('e') && map.containsKey('i') && map.containsKey('o') && map.containsKey('u') ) return true;
        return false;
    }
    long ans(String word,int k){
        int n=word.length();

        Map<Character,Integer> map=new HashMap<>();

        int l=0;
        int r=0;

        long count=0;

        int conso=0;

        

        while(r<n){
            char ch=word.charAt(r);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(ch!='a' && ch!='e' && ch!='i' && ch!='o' && ch!='u') conso++;
            else{
                // lastPos[ch-'a']=r;
                if(ch=='a') lastPos[0]=r;
                if(ch=='e') lastPos[1]=r;
                if(ch=='i') lastPos[2]=r;
                if(ch=='o') lastPos[3]=r;
                if(ch=='u') lastPos[4]=r;

            }
            // System.out.println(conso);

            
           
            while(conso>k){
                char chL=word.charAt(l);
                if(map.get(chL)==1) map.remove(chL);
                else map.put(chL,map.get(chL)-1);

                if(chL!='a' && chL!='e' && chL!='i' && chL!='o' && chL!='u') conso--;
                l++;
                
            }
            int minPos = Integer.MAX_VALUE;
            for (int pos : lastPos) {
                minPos = Math.min(minPos, pos);
            }
             if(vowels(map) && conso<=k) {
                count+=(minPos-l+1);
                
                // count+=(r-l+1);   
            }
                
            
            r++;
        }
        return count;
    }
    public long countOfSubstrings(String word, int k) {

        // long fans=ans(word,k)-ans(word,k-1);
        long ans1=ans(word,k);
        long ans2=((k>=1)?ans(word,k-1):0);

        // System.out.println(ans1+" "+ans2);

        return ans1-ans2;
        
        // return fans;
    }
}