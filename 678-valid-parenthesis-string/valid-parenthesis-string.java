class Solution {
    public boolean checkValidString(String s) {

        int n=s.length();

        Stack<Integer> op=new Stack<>();
        Stack<Integer> star=new Stack<>();

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);

            if(ch=='('){
                op.push(i);
            }
            else if(ch==')'){
                if(op.size()>0){
                    op.pop();
                }
                else{
                    if(star.size()>0){
                        star.pop();
                    }
                    else return false;
                }
            }
            else{
                star.push(i);
            }
        }

        if(op.size()==0) return true;

        while(op.size()>0 && star.size()>0){
            if(op.peek()<star.peek()){
                op.pop();
                star.pop();
            }
            else{
                return false;
            }
        }
        return op.size()==0;
        
        
    }
}