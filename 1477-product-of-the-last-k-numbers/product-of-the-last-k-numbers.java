class ProductOfNumbers {

    List<Integer> pre;

    public ProductOfNumbers() {
        pre=new ArrayList<>();
        
    }
    
    public void add(int num) {
        
        pre.add(num);
        
    }
    
    public int getProduct(int k) {
        int i=0;
        int j=pre.size()-1;
        int pro=1;
        while(i<k){
            pro*=pre.get(j--);
            i++;
        }
        return pro;

        
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */