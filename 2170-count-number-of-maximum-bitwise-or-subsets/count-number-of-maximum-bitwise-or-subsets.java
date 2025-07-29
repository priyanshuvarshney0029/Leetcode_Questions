class Solution {
    public int countMaxOrSubsets(int[] nums) {
        // int maxOR = findMaxOR(nums,nums.length-1);
        int []count = new int[1]; 
        int maxOR=0;
        for(int i=0;i<nums.length;i++){
             maxOR|=nums[i];
        }
        // for avoding static variable........
        countArr(nums,nums.length-1,0,count,maxOR);
        return count[0];
    }
    public void countArr(int []nums,int idx,int OR,int []count,int maxOR){
        if(idx<0 && maxOR==OR){
            count[0]++;
        }
        if(idx<0){
            return;
        }
        countArr(nums,idx-1,OR,count,maxOR);
        countArr(nums,idx-1,OR|nums[idx],count,maxOR);
    }
    // public int findMaxOR(int []nums,int idx){
    //     if(idx<0){
    //         return 0;
    //     }
    //     int not_pick = findMaxOR(nums,idx-1);
    //     int pick = (nums[idx] | findMaxOR(nums,idx-1));
    //     return Math.max(pick,not_pick);
    // }
}