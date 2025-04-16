class Solution {
    public long countGood(int[] nums, int k) {
        int ei=0;
        int si=0;
        long ans=0;
        long count=0;
        HashMap<Integer,Integer> map =new HashMap<>();
        while(ei < nums.length){
            map.put(nums[ei], map.getOrDefault(nums[ei] , 0) +1);
            count += map.get(nums[ei]) - 1;
            while(count>=k){
                ans += (nums.length - ei);
                int temp = map.get(nums[si]);
                count-=temp-1;

                map.put(nums[si], map.get(nums[si]) - 1);
                if(map.get(nums[si])==0)
                {
                    map.remove(nums[si]); 
                }             
                si++;
            }
            ei++;
        }
        return ans;
    }
}