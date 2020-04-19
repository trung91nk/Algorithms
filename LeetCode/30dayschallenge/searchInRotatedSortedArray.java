class Solution {
    public int search(int[] nums, int target) {
        if(nums.length>=1){
            int start = 0;
            int end = nums.length-1;
            while(start<end){
                int mid = (start+end)/2;
                if(nums[mid]==target){
                    return mid;
                }
                if(nums[start]<=nums[mid]){
                    //verify if target is in the chosen subarray, chose the rest if not.
                    if(target>=nums[start] && target<nums[mid]){
                        end = mid-1;
                    }else{
                        start = mid+1;
                    }
                }
                if(nums[mid]<=nums[end]){
                    if(target>nums[mid] && target<=nums[end]){
                        start = mid+1;
                    }else{
                        end = mid-1;
                    }
                }
            }
            return nums[start]==target?start:-1;
        }else{
            return -1;
        }
    }
}
