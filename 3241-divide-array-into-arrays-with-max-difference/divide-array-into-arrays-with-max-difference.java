class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int [][]ans = new int[nums.length/3][3];
        Arrays.sort(nums);
        int idx = 0;
        for(int i=0;i<nums.length;i+=3){
            if(nums[i+2]-nums[i]<=k){
                ans[idx][0] = nums[i];
                ans[idx][1] = nums[i+1];
                ans[idx][2] = nums[i+2];
                idx++;
            }else{
                return new int[][]{};
            }
        }
        return ans;
    }
}