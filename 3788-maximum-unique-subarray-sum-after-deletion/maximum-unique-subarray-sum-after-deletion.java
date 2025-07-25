class Solution {
    public int maxSum(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int sum1 = 0;
        int sum2 = Integer.MIN_VALUE;
        for(int key:map.keySet()){
            if(key>0){
                sum1+=key;
            }else{
                sum2 = Math.max(sum2,key);
            }
        }
        return sum1==0?sum2:sum1;
    }
}