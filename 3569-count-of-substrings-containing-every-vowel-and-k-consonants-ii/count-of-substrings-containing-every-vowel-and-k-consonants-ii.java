class Solution {
    
    Set<Character> set =new HashSet<>();
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
            
            if(!set.contains(ch)) conso++;
            else map.put(ch,map.getOrDefault(ch,0)+1);

            while(vowels(map) && conso>=k){
                count+=(n-r);
                char chL=word.charAt(l);
                // if(chL!='a' && chL!='e' && chL!='i' && chL!='o' && chL!='u') conso--;
                if(!set.contains(chL))conso--;
                else{
                    if(map.get(chL)==1) map.remove(chL);
                    else map.put(chL,map.get(chL)-1);
                }
                l++;
                
            }
            r++;
        }
        return count;
    }
    public long countOfSubstrings(String word, int k) {

        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        long ans1=ans(word,k);
        long ans2=ans(word,k+1);

        // System.out.println(ans1+" "+ans2);

        

        return ans1-ans2;
        
        
    }
}