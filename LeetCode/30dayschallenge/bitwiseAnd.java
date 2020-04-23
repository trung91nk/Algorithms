class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if(m==n){
            return m;
        }else if(m==n-1){
            return m&n;
        }else if(m==n-2){
            return m&(m+1)&n;
        }else{
            int power = (int)Math.floor(Math.log((double)(m))/Math.log(2.0));
            if(n<(int)Math.pow(2.0,(double)(power+1))){
                int mid = m/2+n/2;
                if(rangeBitwiseAnd(m,mid) == 0 || rangeBitwiseAnd(mid,n)==0){
                    return 0;
                }else{
                    return rangeBitwiseAnd(m,mid)&rangeBitwiseAnd(mid,n);
                }
            }else{
                return 0;
            }
        }
    }
}
