class Solution {
    public boolean checkValidCuts(int nn, int[][] rectangles) {
        int n=rectangles.length;

        List<int[]> list=new ArrayList<>();

        Arrays.sort(rectangles,(a,b)->{
            return a[1]-b[1];
        });
        int end=0;
        for(int [] interval:rectangles){

            int a=interval[1];
            int b=interval[3];

            if(list.size()==0 || end<=a){
                list.add(interval);
                end=b;
            }
            else{
                int maxm=Math.max(end,b);
                int[] arr=list.get(list.size()-1);
                int st=arr[0];
                list.set(list.size()-1,new int[]{st,maxm});
                end=maxm;
            }

        }
        if(list.size()>=3)return true;
        else{
            list.clear();
                Arrays.sort(rectangles,(a,b)->{
                return a[0]-b[0];
                });
                end=0;
                for(int [] interval:rectangles){

                    int a=interval[0];
                    int b=interval[2];

                    if(list.size()==0 || end<=a){
                        list.add(interval);
                        end=b;
                    }
                    else{
                        int maxm=Math.max(end,b);
                        int[] arr=list.get(list.size()-1);
                        int st=arr[0];
                        list.set(list.size()-1,new int[]{st,maxm});
                        end=maxm;
                    }

                }
        }
        return list.size()>=3;

        
    }
}