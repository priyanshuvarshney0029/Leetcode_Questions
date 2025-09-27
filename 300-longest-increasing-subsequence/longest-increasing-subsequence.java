class Solution {
    public int lengthOfLIS(int[] nums) {
        int []lis=new int[nums.length];
        Arrays.fill(lis,1);
        for(int i=1;i<lis.length;i++){
            for(int j=0; j < i;j++){
                if(nums[j] < nums[i]){
                    int ll=lis[j];
                    lis[i]=Math.max(lis[i],ll+1);
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<lis.length;i++){
            max=Math.max(max,lis[i]);
        }
        return max;
        
    }
}