class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        long ans = 0;
        HashMap<Integer,Long> map = new HashMap<>();
        map.put(0,1L);
        int prefixCount = 0;
        for(int i=0;i<nums.size();i++){
            if(nums.get(i)%modulo==k){
                prefixCount++;
            }
            int rem = prefixCount%modulo;
            int tar = (rem-k+modulo)%modulo;
            if(map.containsKey(tar)){
                ans+=map.get(tar);
            }
            map.put(rem,map.getOrDefault(rem,0L)+1);
        }
        return ans;
    }
}