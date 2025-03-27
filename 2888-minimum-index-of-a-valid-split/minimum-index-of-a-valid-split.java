class Solution {
    class Pair{
        int ele;
        int freq;
        Pair(int ele,int freq){
            this.ele=ele;
            this.freq=freq;
        }
    }
    boolean check2(int ele,int fDom,int map1ele,int map2ele,Map<Integer,Integer> map2){
        // System.out.println()
        if(map2.containsKey(ele)){
            if(fDom>map1ele/2 &&map2.get(ele)>map2ele/2) return true;
        }
        return false;
    }
    // boolean check(Map<Integer,Integer> map1,Map<Integer,Integer> map2,int map1ele,int map2ele){

    //     boolean flag1=false;
    //     boolean flag2=false;

    //     int fDom=0;
    //     int sDom=0;

    //     for(int ele:map1.keySet())
    //     {
    //         if(map1.get(ele)>map1ele/2) {
    //             flag1=true;
    //             fDom=ele;
    //             break;
    //         }
    //     }
    //     if(!flag1) return false;

    //     for(int ele:map2.keySet())
    //     {
    //         if(map2.get(ele)>map2ele/2) {
    //             flag2=true;
    //             sDom=ele;
    //             break;
    //         }
    //     }
    //     if(!flag2) return false;

    //     return fDom==sDom;

        

        

    // }
    public int minimumIndex(List<Integer> nums) {
        int n=nums.size();

        if(n==1) return -1;
        

        // int lo=0;
        // int hi=n-1;

        // int ans=-1;

        // while(lo<=hi){
        //     int mid=lo+(hi-lo)/2;
        //     if(check(mid,nums)){
        //         ans=mid;
        //         hi=mid-1;
        //     }
        //     else{
        //         lo=mid+1;
        //     }
        // }

        // return ans;




        Map<Integer,Integer> map1=new TreeMap<>();
        Map<Integer,Integer> map2=new TreeMap<>();
        
        int map2ele=0;
        int map1ele=0;
        for(int i=0;i<n;i++){
            int ele=nums.get(i);
            map2ele++;
            map2.put(ele,map2.getOrDefault(ele,0)+1);
        }
        PriorityQueue<Pair> pq =new PriorityQueue<>((a,b)->{
            return b.freq-a.freq;
        });

        for(int i=0;i<n-1;i++){
            int ele=nums.get(i);
            map1ele++;
            map1.put(ele,map1.getOrDefault(ele,0)+1);
            pq.add(new Pair(ele,map1.get(ele)));

            if(map2.get(ele)==0) map2.remove(ele);
            else{
                map2.put(ele,map2.get(ele)-1);
            }
            map2ele--;

            if(check2(pq.peek().ele,pq.peek().freq,map1ele,map2ele,map2)) return i;

            // if(check(map1,map2,map1ele,map2ele)) return i;
        }
        return -1;
    }
}