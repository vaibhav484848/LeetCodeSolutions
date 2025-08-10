class Solution {
    class Pair{
        int limit;
        int value;
        Pair(int limit,int value){
            this.limit=limit;
            this.value=value;
        }
    }
    public long maxTotal(int[] value, int[] limit) {
        Map<Integer,Integer> map=new HashMap<>();
        List<Pair> list=new ArrayList<>();

        int n=value.length;
        for(int i=0;i<n;i++){
            list.add(new Pair(limit[i],value[i]));
        }

        Collections.sort(list,(a,b)->{
            if(a.limit==b.limit) return b.value-a.value;
            return a.limit-b.limit;
        });
        // sort(limit.begin(),limit.end());

        long ans=0;

        int actLimit=0;
        int active=0;
        for(Pair p:list){
            int l=p.limit;
            int val=p.value;
            if(active<l && actLimit<l){
                // System.out.println(val);
                ans+=val;
                active++;
                // System.out.println(active+" active ");
                map.put(l,map.getOrDefault(l,0)+1);
                // upper_bound(limit.begin(),limit.end(),active);
                int inactive=map.getOrDefault(active,0);
                // System.out.println(inactive+" inactive ");
                actLimit=active;
                // System.out.println(actLimit+" actLimit: ");
                map.put(active,0);
                active-=inactive;
                

            }
        }

        return ans;
    }
}