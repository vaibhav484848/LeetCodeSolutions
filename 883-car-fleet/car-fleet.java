class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        List<double[]> list = new ArrayList<>();

        int n=position.length;

        for(int i=0;i<n;i++){
            list.add(new double[]{position[i],(double)(target-position[i])/speed[i]*1.0});

        }

         Collections.sort(list, (a, b) -> Double.compare(a[0], b[0]));

        int size=list.size();

        Stack<Double> st=new Stack<>();

       
        

        for(int i=0;i<size;i++){
            double ele=list.get(i)[1];

            boolean flag=false;
            
            while(st.size()>0 && st.peek()<=ele){
                flag=true;
                st.pop();
                
            }
            
            st.push(ele);
           
        }

        // for(int i=n-1;i>=0;i--){
        //     double ele=list.get(i)[1];

        //     if(st.size()>0 && st.peek()<=ele) continue;
        //     st.push(ele);
        // }

        return st.size();
    }
}