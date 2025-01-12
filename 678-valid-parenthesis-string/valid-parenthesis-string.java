class Solution {

    HashMap<String,Boolean> map;
    // boolean check(String s){
        
    //      Stack<Character> st= new Stack<>();
    //     for(int i=0;i<s.length();i++){
    //         char ch=s.charAt(i);
    //         if(ch=='(' ) st.push(ch);
    //         else if(ch==')'){
    //             if(st.size()==0 || st.peek()!='(') return false;
    //             st.pop();
    //         }
           
    //     }
    //     if(st.size()==0) return true;
    //     return false;

    // }
    boolean valid(int idx,int balance,String s){
        if(idx>=s.length()){
           
            if(balance==0) return true;
            return false;      
            
        }
        String key=idx+","+balance;

        if(map.containsKey(key)) return map.get(key);

        char ch=s.charAt(idx);

        boolean poss1=false;
        boolean poss2=false;
        boolean poss3=false;
        boolean poss4=false;
        if(ch=='*'){

            poss1=valid(idx+1,balance+1,s);
            
            poss2=(balance>0)?valid(idx+1,balance-1,s):false;

            poss3=valid(idx+1,balance,s);
            
        }
        else{
            if(ch=='(') poss4=valid(idx+1,balance+1,s);
            else{
                poss4=(balance>0)?valid(idx+1,balance-1,s):false;
            }
            
        }

        boolean ans=poss1 || poss2 || poss3 || poss4;
        map.put(key,ans);
        return ans;
    }

    public boolean checkValidString(String s) {

        map=new HashMap<>();

        return valid(0,0,s);
        
    }
}