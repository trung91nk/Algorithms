class Solution {
    public int maxSubarraySumCircular(int[] arr) {
        int sum = arr[0], curMax = arr[0], globalMax= arr[0], curMin = arr[0] ,globalMin = arr[0];
        for(int i=1;i<arr.length;i++){
            sum+=arr[i];
            curMax = Math.max(arr[i],arr[i]+curMax);
            globalMax = Math.max(globalMax,curMax);
            curMin = Math.min(arr[i],arr[i]+curMin);
            globalMin = Math.min(globalMin,curMin);
        }
        // in case all elements are negative
        if(sum==globalMin){
            return globalMax;
        }
        return Math.max(globalMax,sum-globalMin);
    }
}
