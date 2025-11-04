class Solution {
public:
    vector<double> medianSlidingWindow(vector<int>& nums, int k) {
        multiset<int>m1,m2;

        vector<double>ans;

        int n=nums.size();

        for(int i=0;i<n;i++){
            int ele=nums[i];
            if(m1.size()==0 && m2.size()==0)m1.insert(ele);

            else if(*(prev(m1.end()))<ele){
                m2.insert(ele);

                if(m2.size()>m1.size()){
                    int toRemove=*(m2.begin());
                    m2.erase(m2.begin());
                    m1.insert(toRemove);
                }
            }
            else{
                m1.insert(ele);
                if(m1.size()-m2.size()>1){
                    m2.insert(*(prev(m1.end())));
                    m1.erase(prev(m1.end()));
                }
            }

            if(i>=k){
                int toErase=nums[i-k];
                auto it1=m1.find(toErase);
                if(it1!=m1.end()){
                    m1.erase(it1);
                    if(m2.size()>m1.size()){
                        int toRemove=*(m2.begin());
                        m2.erase(m2.begin());
                        m1.insert(toRemove);
                    }
                }
                else{
                    int toErase=nums[i-k];
                    auto it2=m2.find(toErase);
                    m2.erase(it2);
                    if(m1.size()-m2.size()>1){
                        m2.insert(*(prev(m1.end())));
                        m1.erase(prev(m1.end()));
                    }
                }
            }

            if(i>=k-1){
                if(m1.size()==m2.size()){
                    double med=((1ll)*(*(prev(m1.end())))+*(m2.begin()))/2.000000;
                    ans.push_back(med);
                }
                else{
                    ans.push_back(*(prev(m1.end())));
                }
            }
        }

        return ans;
    }
};