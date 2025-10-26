class Solution {
public:
    
    int check( double mi,vector<vector<int>>& squares){

        double below=0;
        double above=0;

        double mid=mi;

        for(auto &v:squares){
            int y=v[1];
            int l=v[2];

            if(y<mid){
                double side=min(mid,(y+l)/1.0);
                below+=(side-y)*l;
            }
            if(y+l>mid){
                double side=max(mid,y/1.0);
                above+=(y+l-side)*l;
            }
        }

        // cout<<"mid: "<<mid<<" above: "<<above<<" below: "<<below<<'\n';
        
         double diff = above - below;
        

        return (diff<=0);
        

    }
    double separateSquares(vector<vector<int>>& squares) {
         double prec=1e-6;

         double lo=0;
         double hi=1e9;

        double ans=1e9+1;

        for(int i=0;i<52;i++){
             double mid=(lo+hi)/2;
            if(check(mid,squares)){
                ans=mid;
                hi=mid-prec;
            }
            
            else{
                lo=mid+prec;
            }
        }

        return ans;
    }
};