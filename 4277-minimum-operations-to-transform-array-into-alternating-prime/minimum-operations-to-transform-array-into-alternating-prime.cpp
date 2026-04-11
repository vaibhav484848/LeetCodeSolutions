class Solution {
public:
    vector<int>primes;
    vector<bool> is_prime;
    void sieve(int limit) {
        is_prime.assign(limit + 1, true);
        
        is_prime[0] = is_prime[1] = false;

        for (int p = 2; p * p <= limit; p++) {
           
            if (is_prime[p]) {
               
                for (int i = p * p; i <= limit; i += p)
                    is_prime[i] = false;
            }
        }

        for (int p = 2; p <= limit; p++) {
            if (is_prime[p]) {
                primes.push_back(p);
            }
        }

    }   
    int minOperations(vector<int>& nums) {
        sieve(1e5+4);
        int count=0;
        int n=nums.size();

        for(int i=0;i<n;i++){
            if(i%2==0){
                if(is_prime[nums[i]])continue;
                else{
                    int ele=0;
                    auto it = lower_bound(primes.begin(), primes.end(), nums[i]);
                    if (it != primes.end()) {
                        ele = *it;
                        // use val
                    }
                    count+=(ele-nums[i]);
                }
            }
            else{
                if(is_prime[nums[i]]){
                    if(is_prime[nums[i]+1]){
                        count+=2;
                    }
                    else count++;
                }
            }
            // cout<<count<<" ";
            
        }
        return count;
    }
};