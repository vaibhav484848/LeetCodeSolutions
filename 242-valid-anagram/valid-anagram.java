class Solution {
    public boolean isAnagram(String s, String t) {

        // if(s.length()!=t.length()) return false;
        // HashMap<Character,Integer> map1=new HashMap<>();

        // HashMap<Character,Integer> map2=new HashMap<>();

        // for(int i=0;i<s.length();i++){
        //     char ch=s.charAt(i);
        //     if(map1.containsKey(ch)){
        //         map1.put(ch,map1.get(ch)+1);
        //     }
        //     else{
        //         map1.put(ch,1);
        //     }
        // }

        // for(int i=0;i<t.length();i++){
        //     char ch=t.charAt(i);
        //     if(map2.containsKey(ch)){
        //         map2.put(ch,map2.get(ch)+1);
        //     }
        //     else{
        //         map2.put(ch,1);
        //     }
        // }
       

        // for(Character key:map1.keySet()){
        //     int val=map1.get(key);
        //     if(map2.containsKey(key)){
        //         if(map2.get(key)!=val) return false;
        //     }
        //     else return false;
        // }

        // return true;

        if(s.length()!=t.length()) return false;


        Map<Character,Integer> map1=new HashMap<>();
         Map<Character,Integer> map2=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }

        for(int i=0;i<t.length();i++){

            char ch=t.charAt(i);
            map2.put(ch,map2.getOrDefault(ch,0)+1);

        }

        for(Character ch:map2.keySet()){
            if(!(map1.containsKey(ch) && map1.get(ch).equals(map2.get(ch)))){
                return false;
            }
        }

        return true;
        
    }
}