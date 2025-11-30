class Solution {
public:
    int rev(int num){
        // if(num%10==0) return INT_MIN;
        int temp=num;
        int r=0;
        
        while(temp>0){
            int p=temp%10;
            r=r*10+p;

            temp/=10;
        }

        return r;
    }
    int minMirrorPairDistance(vector<int>& nums) {
        map<int,vector<int>>mp;

        int overMinm=INT_MAX;

        int n=nums.size();

        for(int i=0;i<n;i++){
            int ele=nums[i];
            mp[ele].push_back(i);
        }

        for(int i=0;i<n;i++){
            int ele=nums[i];
            int re=rev(ele);

            // cout<<re<<'\n';

            if(mp.find(re)!=mp.end()){
                vector<int>&temp=mp[re];
                int size=temp.size();
                int idx=upper_bound(temp.begin(),temp.end(),i)-temp.begin();

                

                int minm=INT_MAX;

                if(size==idx) continue;

                if(size!=idx){
                   
                    if(temp[idx]!=i) minm=min(minm,abs(temp[idx]-i));
                }
                if(idx>0) {
                    if(temp[idx-1]!=i) minm=min(minm,abs(temp[idx-1]-i));
                }


                overMinm=min(overMinm,minm);

                // cout<<overMinm<<" this is overM"<<'\n';
            }

            
        }

        return (overMinm==INT_MAX?-1:overMinm);
    }
};

// 2 