class Solution {
public:
    int countCollisions(string s) {
        int n=s.size();

        stack<int>st;

        int count=0;

        for(int i=0;i<n;i++){
            char ch=s[i];
            if(st.size()==0 || ch=='R')st.push(ch);
            else if(ch=='S'){
                while(st.size()>0 && st.top()=='R'){
                    count++;
                    st.pop();
                    
                }
                st.push('S');
            }
            else{
                if(st.top()!='L'){
                    if(st.top()=='R') {
                        count+=2;
                        st.pop();

                        while(st.size()>0 && st.top()=='R'){
                            count++;
                            st.pop();
                        }
                    }
                    
                    
                    else if(st.size()>0 && st.top()=='S')
                    count++;
                    
                    st.push('S');
                }
                
            }
        }

        return count;
    }
};
