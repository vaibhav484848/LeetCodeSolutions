class Solution {
public:
    int check(vector<int> nums1,vector<int> nums2,int x,int k){
        int count1=(upper_bound(nums1.begin(),nums1.end(),x)-nums1.begin());
        int count2=(upper_bound(nums2.begin(),nums2.end(),x)-nums2.begin());
        

        return (count1+count2)>=k;
        
    }   

    int findKth(vector<int>& nums1, vector<int>& nums2,int k){

        int lo=min((nums1.size()>0)?nums1[0]:nums2[0],(nums2.size()>0)?nums2[0]:nums1[0]);
        int hi=max((nums1.size()>0)?nums1[nums1.size()-1]:nums2[nums2.size()-1],(nums2.size()>0)?nums2[nums2.size()-1]:nums1[nums1.size()-1]);

        int ans=-1;

        while(lo<=hi){
            int mid=lo+(hi-lo)/2;

            if(check(nums1,nums2,mid,k)==0){
                lo=mid+1;
            }
            else{
                ans=mid;
                hi=mid-1;
            }
            
        }

        return ans;


    
    }
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int total=nums1.size()+nums2.size();


        if(total%2!=0){
            return findKth(nums1,nums2,((total/2)+1))/1.0;
        }
        else{
            int a= findKth(nums1,nums2,(total/2));
            int b= findKth(nums1,nums2,(total/2)+1);
            return (a+b)/2.0;
        }
    }
};