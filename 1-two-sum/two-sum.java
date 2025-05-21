class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int arr[]=new int[2];
        for(int i=0;i<nums.length;i++){
            int com=target-nums[i];
            if(map.containsKey(com)){
              arr[0]=map.get(com);
              arr[1]=i;
              return arr;
            }
            map.put(nums[i],i);
        }
        return arr;
    }
}