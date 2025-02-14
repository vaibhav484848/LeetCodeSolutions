class ProductOfNumbers {

    List<Integer> pre;
    int zeroIdx;

    public ProductOfNumbers() {
        pre=new ArrayList<>();
        zeroIdx=-1;
        
    }
    
    public void add(int num) {
        int size=pre.size();
        if(num==0) {
            zeroIdx=size;
            pre.add(1);
        }
        else{
            pre.add((size>0)?pre.get(size-1)*num:num);
        }
        
        
    }
    
    public int getProduct(int k) {

        int size=pre.size();
        int kStart=size-k;

        if(zeroIdx>=kStart) return 0;
        else{

            return pre.get(size-1)/(kStart>=1?pre.get(kStart-1):1);
        }
        

        
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */