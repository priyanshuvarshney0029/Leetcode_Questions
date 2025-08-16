class Solution {
    public int firstMissingPositive(int[] nums) {
        TreeMap<Integer,Boolean> map=new TreeMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],true);
            if(map.containsKey(nums[i]+1)){
                map.put(nums[i]+1,false);
            }
            if(map.containsKey(nums[i]-1)){
                map.put(nums[i],false);
            }
        }
        int count=1;
        for(int key:map.keySet()){
            int i=key;
            if(!map.get(key)){
                continue;
            }
            while(map.containsKey(i)){
                if(i==count){
                    count++;
                }
                i++;
            }
        }
        return count;

    }
}