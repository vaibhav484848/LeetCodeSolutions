class Solution {

    boolean satisfied(HashMap<Character,Integer> map1,HashMap<Character,Integer> map2){
        if(map2.size()>map1.size()) return false;

        for(char ch:map2.keySet()){
            if(!map1.containsKey(ch) || map1.get(ch)<map2.get(ch))  return false;
        }
        return true;
    }

    public long validSubstringCount(String word1, String word2) {

        HashMap<Character,Integer> map1=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();

        int n1=word1.length();
        int n2=word2.length();

        if(n2>n1) return 0;


        for(int i=0;i<n2;i++){
            char ch=word2.charAt(i);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }

        int l=0,r=0;
        long len=0;

        while(r<n1){
            char ch=word1.charAt(r);
            map1.put(ch,map1.getOrDefault(ch,0)+1);

            while(satisfied(map1,map2)){
                char chh=word1.charAt(l);
                
                len+=(long)(n1-r);
                if(map1.get(chh)==1) map1.remove(chh);
                else map1.put(chh,map1.get(chh)-1);
                l++;
            }
            r++;
            
        }

        return len;
        

        
    }
}