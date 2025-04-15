class Solution {
    public int lengthOfLIS(int[] nums) {
       ArrayList<Integer> ll=new ArrayList<>();
       if(nums.length==1){
           return 1;
       }
       ll.add(nums[0]);
       for(int i=1;i<nums.length;i++){
          if(ll.get(ll.size()-1) < nums[i]){
               ll.add(nums[i]);
          }
          else{
             int idx=Binary_search(nums[i],ll);
             ll.set(idx,nums[i]);
          }
       }
       return ll.size();
    }
    public int Binary_search(int tar,ArrayList<Integer> ll){
        int low=0;
        int high=ll.size()-1;
        int idx=0;
        while(low <= high){
            int mid=low+(high-low)/2;

            if(ll.get(mid) >=tar){
                idx=mid;
                high=mid-1;
            }
            else{
               low=mid+1;
            }
        }
        return idx;
    }
}