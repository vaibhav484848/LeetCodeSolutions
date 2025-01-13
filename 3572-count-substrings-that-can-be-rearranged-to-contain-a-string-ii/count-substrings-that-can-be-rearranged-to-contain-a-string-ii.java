class Solution {
    public long validSubstringCount(String word1, String word2) {

        HashMap<Character,Integer> map1=new HashMap<>();

        int n1=word1.length();
        int n2=word2.length();

        for(int i=0;i<n2;i++){
            char ch=word2.charAt(i);
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }

        int l=0,r=0,count=0;
        long len=0;

        while(r<n1){
            char ch=word1.charAt(r);

            if(map1.containsKey(ch)){
                if(map1.get(ch)>0){
                    count++;
                }
                map1.put(ch,map1.get(ch)-1);
            }
            else{
                map1.put(ch,-1);
            }

            while(count==n2){
                char chh=word1.charAt(l);
                len+=(long)(n1-r);
                if(map1.get(chh)>=0) {
                    count--;
                }
                map1.put(chh,map1.get(chh)+1);
                l++;
            }
            r++;
            
            
        }

        return len;

        
    }
}