class Solution {
    public long countOfSubstrings(String word, int k) {
        int n=word.length();
        int[] suff=new int[n];
        suff[n-1]=n;
        for(int i=n-2;i>=0;i--){
            char ch=word.charAt(i+1);
            if(ch!='a' && ch!='e' && ch!='i' && ch!='o' && ch!='u'){
                suff[i]=i+1;
            }
            else suff[i]=suff[i+1];
        }
        // System.out.println(Arrays.toString(suff));

        int l=0,r=0;
        long countValidSub=0;
        int conso=0;
        Map<Character,Integer>map=new HashMap<>();

        while(r<n){
            char ch=word.charAt(r);
            if(ch!='a' && ch!='e' && ch!='i' && ch!='o' && ch!='u'){
                conso++;
            }
            else{
                map.put(ch,map.getOrDefault(ch,0)+1);
            }

            while(map.size()==5 && conso==k){
                int nextConsoIdx=suff[r];
                countValidSub+=(nextConsoIdx-r);
                char chL=word.charAt(l);
                if(chL!='a' && chL!='e' && chL!='i' && chL!='o' && chL!='u'){
                    conso--;
                }
                else{
                    if(map.get(chL)==1) map.remove(chL);
                    else map.put(chL,map.get(chL)-1);
                }
                
                l++;
            }

            while(conso>k){
                char chL=word.charAt(l);
                if(chL!='a' && chL!='e' && chL!='i' && chL!='o' && chL!='u'){
                    conso--;
                }
                else{
                    if(map.get(chL)==1) map.remove(chL);
                    else map.put(chL,map.get(chL)-1);
                }
                
                l++;
            }

            r++;
        }

        return countValidSub;
        
    }
}