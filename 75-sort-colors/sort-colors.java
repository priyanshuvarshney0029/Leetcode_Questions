class Solution {
    public void sortColors(int[] nums) {
         int left=0;
         for(int i=0;i<nums.length;i++){
             if(nums[i]==0){
                int temp=nums[i];
                nums[i]=nums[left];
                nums[left]=temp;
                left++;
             }
         }
         int right=left;
         for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                int temp=nums[i];
                nums[i]=nums[right];
                nums[right]=temp;
                right++;
            }
         }
    }
}