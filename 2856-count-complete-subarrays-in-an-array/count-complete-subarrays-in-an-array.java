class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int count=set.size();
        HashMap<Integer,Integer> map=new HashMap<>();
        int si=0;
        int ei=0;
        int result=0;
        int n=nums.length;
        while(ei < nums.length){
            map.put(nums[ei],map.getOrDefault(nums[ei],0)+1);

            while(map.size()==count){
               result+=(n-ei);
               map.put(nums[si],map.get(nums[si])-1);
               if(map.get(nums[si])==0){
                  map.remove(nums[si]);
               }
               si++;
            }
            ei++;
        }
        return result;
    }
}