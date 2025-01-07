class Solution {
    int[] kmp(String s){
        int n=s.length();
        int[] lps=new int[n];

        for(int i=1;i<n;i++){
            int prevIdx=lps[i-1];

            while(prevIdx>0 && s.charAt(i)!=s.charAt(prevIdx)){
                prevIdx=lps[prevIdx-1];
            }

            lps[i]=prevIdx + ((s.charAt(i)==s.charAt(prevIdx))?1:0);
        }

        return lps;
    }


    boolean bs(int ele,List<Integer> list,int k){
        int ans=-1;

        int lo=0,hi=list.size()-1;

        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(list.get(mid)>=ele){
                if(list.get(mid)-ele<=k){
                    return true;

                }
                hi=mid-1;
            }
            else{
                if(ele-list.get(mid)<=k){
                    return true;

                }
                lo=mid+1;

            }
        }

        return false;
    }
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {

        int[] kmp1=kmp(a+"#"+s);
        int[] kmp2=kmp(b+"#"+s);

        int aL=a.length();
        int bL=b.length();

        List<Integer> list=new ArrayList<>();

        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();

        for(int i=0;i<kmp1.length;i++){
            if(kmp1[i]==aL){
                list1.add(i-(2*aL));
            }
        }

        for(int i=0;i<kmp2.length;i++){
            if(kmp2[i]==bL){
                list2.add(i-(2*bL));
            }
        }

        // System.out.println(list1+"  "+list2);

        for(int ele:list1){
            if(bs(ele,list2,k)) list.add(ele);
        }

        

        return list;


        
    }
}