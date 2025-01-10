class Solution {
    boolean comparision(HashMap<Character,Integer> map1,HashMap<Character,Integer> map2){
        
        for(char ch:map2.keySet()){
            if(map1.containsKey(ch)){
                if(map1.get(ch)<map2.get(ch)){
                    return false;
                }

            }
            else{
                return false;
            }
        }

        return true;
    }
    public List<String> wordSubsets(String[] words1, String[] words2) {

        HashMap<Character,Integer> map2=new HashMap<>();

        

        List<String> ans=new ArrayList<>();


        for(int i=0;i<words2.length;i++){
            String s=words2[i];
            HashMap<Character,Integer> map22=new HashMap<>();
            for(int j=0;j<s.length();j++){
                char ch=s.charAt(j);
                map22.put(ch,map22.getOrDefault(ch,0)+1);
            }

            for(char ch:map22.keySet()){
                int freqCh=map22.get(ch);
                if(map2.containsKey(ch) ){
                    if(map2.get(ch)<freqCh)
                    map2.put(ch,freqCh);
                }
                else{
                    map2.put(ch,freqCh);
                }
            }

        }

        System.out.println(map2);

        for(int i=0;i<words1.length;i++){
            HashMap<Character,Integer> map1=new HashMap<>();
            String s=words1[i];
            for(int j=0;j<s.length();j++){
                char ch=s.charAt(j);
                map1.put(ch,map1.getOrDefault(ch,0)+1);
            }

            if(comparision(map1,map2)) ans.add(s);
        }


        return ans;
    }
}