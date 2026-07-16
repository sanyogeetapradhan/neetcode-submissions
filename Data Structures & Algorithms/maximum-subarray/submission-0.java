class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum = Integer.MIN_VALUE;
        int thissum =0;
        for(int  i =0;i<nums.length;i++){
            thissum += nums[i];
            if(thissum > maxsum){
                maxsum = thissum;
            }
            if(thissum<0){
                thissum =0;
            }
        }
        return maxsum;
    }
}
