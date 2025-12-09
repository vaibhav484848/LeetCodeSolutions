class Solution {
public:
    int specialTriplets(vector<int>& nums) {
        
        int n=nums.size();
      
        int freq[100001]={0};

        for(int i=0;i<n;i++){
            int ele=nums[i];
            freq[ele]++;
        }

        int mod=1e9+7;

        int prev[100001]={0};

        long long ans=0;

        for(int i=0;i<n-1;i++){
            int ele=nums[i];
            long long countPrev=0,countAfter=0;

            freq[ele]--;
            
            if(2*ele<=(1e5))
            countPrev+=prev[2*ele];
            
            if(2*ele<=(1e5))
            countAfter+=freq[2*ele];

            ans=(ans+(countPrev*countAfter)%mod)%mod;

            prev[ele]++;

        }

        return (int)(ans);

    
    }
};