class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int l = 0;
        int h = nums[nums.length-1]-nums[0];
        int ans = 0;
        while(l<=h){
            int m = l+(h-l)/2;
            if(isPossible(nums,m,p)){
                h = m-1;
                ans = m;
            }else{
                l = m+1;
            }
        }
        return ans;
    }
    public boolean isPossible(int []nums,int m,int p){
        int count = 0;
        int i = 0;
        while(i<nums.length-1){
            if(nums[i+1]-nums[i]<=m){
                i+=2;
                count++;
            }else{
                i++;
            }

            if(count>=p){
                return true;
            }
        }
        return false;
    }
}