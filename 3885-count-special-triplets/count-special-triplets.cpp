class Solution {
public:
    int specialTriplets(vector<int>& nums) {
        
        int n=nums.size();

        // vector<map<int,int>>v(n);

        // map<int,int>temp;
        // for(int i=n-1;i>=0;i--){
        //     int ele=nums[i];
        //     temp[ele]++;
        //     v[i]=temp;
        // }

        map<int,int>freq;
        for(int i=0;i<n;i++){
            int ele=nums[i];
            freq[ele]++;
        }
        

        int mod=1e9+7;

        map<int,int>prev;

        long long ans=0;

        for(int i=0;i<n-1;i++){
            int ele=nums[i];
            long long countPrev=0,countAfter=0;

            freq[ele]--;
            
            countPrev+=prev[2*ele];
            
            countAfter+=freq[2*ele];

            ans=(ans+(countPrev*countAfter)%mod)%mod;

            prev[ele]++;

        }

        return (int)(ans);

        // for(int i=0;i<n;i++){
        //     int ele=nums[i];

        //     if(ele%2==0){
        //         if(mp.find(ele/2)!=mp.end() && mp.find(ele)!=mp.end()){
        //             count+=(mp[ele/2]*mp[ele]);
        //         }
        //     }
        // }
    }
};