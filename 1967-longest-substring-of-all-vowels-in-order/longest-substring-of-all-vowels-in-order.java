class Solution {
    public int longestBeautifulSubstring(String word) {

        Map<Character,Integer> map=new HashMap<>();

        int l=0,r=0;
        int n=word.length();
        int count=0;

        while(r<n){
            char ch=word.charAt(r);
            if(ch=='a'){
                if((map.containsKey('a') && map.size()==1) || map.size()==0){
                    map.put(ch,map.getOrDefault(ch,0)+1);
                }
                else{
                    l=r;
                    map.clear();
                    map.put(ch,map.getOrDefault(ch,0)+1);
                    r++;
                    continue;
                }
                
            }
            else if(ch=='e' ) {
                if(!map.containsKey('a')) {
                    l=r+1;
                    map.clear();
                    r++;
                    continue;
                }
                if(map.containsKey('e')&& map.size()==2){
                    map.put(ch,map.getOrDefault(ch,0)+1);
                }
                else if(map.size()==1) map.put(ch,1);
                else{
                    l=r+1;
                    map.clear();
                    r++;
                    continue;
                }
            }
            else if(ch=='i'){
                if(!map.containsKey('a') || !map.containsKey('e')){
                    l=r+1;
                    map.clear();
                    r++;
                    continue;
                }
                if(map.containsKey('i')&& map.size()==3){
                    map.put(ch,map.getOrDefault(ch,0)+1);
                }
                else if(map.size()==2) map.put(ch,1);
                else{
                    l=r+1;
                    map.clear();
                    r++;
                    continue;
                }

            }
            else if(ch=='o'){
                if(!map.containsKey('a') || !map.containsKey('e') || !map.containsKey('i')){
                    l=r+1;
                    map.clear();
                    r++;
                    continue;
                }
                if(map.containsKey('o')&& map.size()==4){
                    map.put(ch,map.getOrDefault(ch,0)+1);
                }
                else if(map.size()==3) map.put(ch,1);
                else{
                    l=r+1;
                    map.clear();
                    r++;
                    continue;
                }

            }
            else{

                if(map.containsKey('u')&& map.size()==5){
                    map.put(ch,map.getOrDefault(ch,0)+1);
                    count=Math.max(count,r-l+1);
                    // System.out.println(r+" "+l);
                   
                }
                else if(map.size()==4) {
                    map.put(ch,1);
                    count=Math.max(count,r-l+1);
                    // System.out.println(r+" "+l);
                    
                }
                else{
                    l=r+1;
                    map.clear();
                    r++;
                    continue;
                }


            }
            r++;
            
            
        }

        return count;
        
    }
}