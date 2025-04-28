class Solution {
    public int longestOnes(int[] nums, int k) {
         int si=0;
         int ei=0;
         int ans=0;
         int flip=0; 
         while(ei < nums.length){
            if(nums[ei]==0){
                flip++;
            }
            while(flip > k){
                if(nums[si]==0){
                    flip--;
                }
                si++;
            }
            ans=Math.max(ans,ei-si+1);
            ei++;
         }
         return ans;
    }
}