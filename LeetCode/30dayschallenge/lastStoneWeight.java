class Solution {
    public int lastStoneWeight(int[] stones) {
        int length = stones.length;
        if(length==0){
            return 0;
        }else if(length==1){
            return stones[0];
        }else{
            Arrays.sort(stones);
            if(stones[length-2]==stones[length-1]){
                int[] stonesSmall = new int[length-2];
                for(int i=0;i<stonesSmall.length;i++){
                    stonesSmall[i] = stones[i];
                }
                return lastStoneWeight(stonesSmall);
            }else{
                int[] stonesSmall = new int[length-1];
                for(int i=0;i<stonesSmall.length-1;i++){
                    stonesSmall[i] = stones[i];
                }
                stonesSmall[stonesSmall.length-1] = stones[length-1]-stones[length-2];
                return lastStoneWeight(stonesSmall);
            }
        }
    }
}
