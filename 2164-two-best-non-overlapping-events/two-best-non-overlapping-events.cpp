class Solution {
public:
    int maxTwoEvents(vector<vector<int>>& events) {
        // sort(events.begin(),events.end());
        sort(events.begin(), events.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[1] < b[1];
        });


        int n=events.size();

        vector<int>prevMax(n,0);
        prevMax[0]=events[0][2];
        
        for(int i=1;i<n;i++){
            prevMax[i]=max(prevMax[i-1],events[i][2]);
        }

        int fScore=0;

        

        for(int idx=0;idx<n;idx++){
            int ans=-1;
            
            if(idx>0){
                int st=events[idx][0];
                int lo=0,hi=idx-1;

                while(lo<=hi){
                    int mid=lo+(hi-lo)/2;

                    if(events[mid][1]<st){
                        ans=mid;
                        lo=mid+1;
                    }
                    else hi=mid-1;

                }
                if(ans!=-1){
                    int score=prevMax[ans];
                    fScore=max(fScore,score+events[idx][2]);
                }
                
            }
        }

        return max(prevMax[n-1],fScore);

    }
};

/*

*/