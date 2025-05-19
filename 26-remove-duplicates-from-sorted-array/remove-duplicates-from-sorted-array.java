class Solution {
    public int removeDuplicates(int[] nums) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        int size=map.size();
        int k=0;
        for(int key:map.keySet()){
           nums[k++]=key;
        }
        return size;
    }
}