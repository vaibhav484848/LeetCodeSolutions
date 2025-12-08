class Solution {
public:
    long long minOperations(vector<int>& nums1, vector<int>& nums2) {
        int n1=nums1.size();
        int n2=nums2.size();

        
        long long ans=0;

        bool flag=false;

        int lastEle=nums2[n2-1];

        for(int i=0;i<n1;i++){
            int ele1=nums1[i];
            int ele2=nums2[i];
            int a=min(ele1,ele2);
            int b=max(ele1,ele2);
            if(lastEle>=a && lastEle<=b && (!flag)) {
                
                flag=true;
                ans++;
                // cout<<"hell\n";
            }
            int diff=abs(nums1[i]-nums2[i]);
            ans+=diff;
        }
        // cout<<ans<<'\n';

        if(!flag){
            vector<int>v;
            set<int>s;

            for(int i=0;i<n1;i++){
                int ele=nums1[i];
                s.insert(ele);
            }
            for(int i=0;i<n2-1;i++){
                int ele=nums2[i];
                s.insert(ele);
            }

            while(s.size()>0){
                int ele=*s.begin();
                v.push_back(ele);
                s.erase(ele);
            }
            // for(int ele:v){
            //     cout<<ele<<" ";
            // }
            // cout<<endl;
            int diff=INT_MAX;
            int lastEle=nums2[n2-1];
            int idx=lower_bound(v.begin(),v.end(),lastEle)-v.begin();
            // cout<<v.size()<<" this isidx "<<idx<<endl;
            if(idx!=v.size()){
                diff=min(diff,abs(v[idx]-lastEle));
            }
            if(idx>0){
                diff=min(diff,abs(lastEle-v[idx-1]));
            }
            // cout<<diff<<" this is diff\n";

            ans+=diff;
            ans++;
        }




        return ans;
    }
};