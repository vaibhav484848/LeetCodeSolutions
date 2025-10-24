class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        int n=heights.size();

        vector<int>nSL(n,-1);
        vector<int>nSR(n,n);

        stack<int>st,st2;

        for(int i=0;i<n;i++){
            while(st.size()>0 && heights[st.top()]>heights[i]){
                nSR[st.top()]=i;
                st.pop();
            }
            st.push(i);
        }
        
        for(int i=0;i<n;i++){
            while(st2.size()>0 && heights[st2.top()]>heights[i]){
                st2.pop();
            }
            if(st2.size()!=0) nSL[i]=st2.top();

            st2.push(i);
        }

        int maxArea=INT_MIN;

        for(int i=0;i<n;i++){
            int left=nSL[i];
            int right=nSR[i];

            cout<<right<<" ";

            int width=(i-left-1)+(right-i);
            maxArea=max(maxArea,width*heights[i]);
        }
        return maxArea;
    }
};