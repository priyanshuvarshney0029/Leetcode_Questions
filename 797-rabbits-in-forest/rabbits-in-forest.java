class Solution {
    public int numRabbits(int[] nums) {
       HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int count = 0;
        for (int key : map.keySet()) {
            int groupSize = key + 1;
            int freq = map.get(key);
            int groups = (freq + groupSize - 1) / groupSize;
            count += groups * groupSize;
        }
        return count;
    }
}