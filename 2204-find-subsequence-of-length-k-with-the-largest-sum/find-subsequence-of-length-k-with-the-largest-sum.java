class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int [][]temp = new int[nums.length][2];
        for(int i=0;i<nums.length;i++){
            temp[i][0] = nums[i];
            temp[i][1] = i;
        }
        Arrays.sort(temp,(a,b)->a[0]-b[0]);
        int [][]arr = new int[k][2];
        int idx = 0;
        for(int i=nums.length-k;i<nums.length;i++){
            arr[idx][0] = temp[i][0];
            arr[idx++][1] = temp[i][1];
        }
        Arrays.sort(arr,(a,b)->a[1]-b[1]);
        int []ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = arr[i][0];
        }
        return ans;
    }
}