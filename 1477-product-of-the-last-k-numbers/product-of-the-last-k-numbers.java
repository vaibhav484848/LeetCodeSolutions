class ProductOfNumbers {

    List<Integer> pre;
    int zeroIdx;

    public ProductOfNumbers() {
        pre=new ArrayList<>();
        zeroIdx=-1;
        
    }
    
    public void add(int num) {
        int size=pre.size();
        if(num==0) zeroIdx=size;
       
        if(size==0) pre.add(num);
        
        else{
            int prev=pre.get(size-1);
            if(prev==0)prev=1;
            pre.add(prev*num);
        }
        
        
    }
    
    public int getProduct(int k) {

        int size=pre.size();
        int kStart=size-k;

        if(zeroIdx>=kStart) return 0;
        else{

            int nemo=pre.get(size-1);
            int deno=1;
            if(kStart>=1){
                deno=pre.get(kStart-1);
                
                if(deno==0) deno=1;
                
            }
            return nemo/deno;
        }
        

        
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */