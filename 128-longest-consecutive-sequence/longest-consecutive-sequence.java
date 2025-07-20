class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],true);
            if(map.containsKey(nums[i]+1)){
                map.put(nums[i]+1,false);
            }
            if(map.containsKey(nums[i]-1)){
                map.put(nums[i],false);
            }
        }
        int max_count=0;
        for(int key:map.keySet()){
            if(!map.get(key)){
                continue;
            }
            int i=key;
            int count=0;
            while(map.containsKey(i)){
                count++;
                i++;
            }
            max_count=Math.max(max_count,count);
        }
        return max_count;
    }
}