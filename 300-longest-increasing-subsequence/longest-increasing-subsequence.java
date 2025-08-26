class Solution {
    public int lengthOfLIS(int[] nums) {
         ArrayList<Integer> ll=new ArrayList<>();
         ll.add(nums[0]);
         for(int i=1;i<nums.length;i++){
              if(nums[i] > ll.get(ll.size()-1)){
                  ll.add(nums[i]);
              }
              else{
                 int idx=Bs(nums[i],ll);
                 ll.set(idx,nums[i]);
              }
         }
         return ll.size();
    }
    public static int Bs(int target,ArrayList<Integer> ll){
         int low=0;
         int high=ll.size()-1;
         int idx=0;

         while(low<=high){
             int mid=(low+high)/2;

             if(ll.get(mid) >= target){
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