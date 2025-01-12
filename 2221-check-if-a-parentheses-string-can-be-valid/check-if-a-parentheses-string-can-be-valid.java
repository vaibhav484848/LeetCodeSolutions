class Solution {
    public boolean canBeValid(String s, String locked) {

        int n=s.length();

        if(n%2!=0) return false;

        Stack<Integer> op=new Stack<>();
        Stack<Integer> lock=new Stack<>();


        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            
            if(locked.charAt(i)=='0') lock.push(i);

            else if(ch=='('){
                op.push(i);
            }
            else if(ch==')'){
                
                if(op.size()>0){
                    
                    op.pop();
                }
                else if(lock.size()>0){
                    lock.pop();
                    
                }
                else return false;
            }
            
        }

        if(op.size()==0) return true;

       
        while(op.size()>0 && lock.size()>0 ){
            if(op.peek()<lock.peek()){
                op.pop();
                lock.pop();
            }
            else {
               
                return false;
            }
            // op.pop();
            // lock.pop();
        }
        
        return op.size()==0;

       
        
    }
}