class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> ll=new ArrayList<>();
        ll.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(ll.get(ll.size()-1) < nums[i]){
                ll.add(nums[i]);
            }
            else{
                int idx=Bs(ll,nums[i]);
                ll.set(idx,nums[i]);
            }
        }
        return ll.size();
    }
    public static int Bs(List<Integer> ll,int tar){
        int low=0;
        int high=ll.size()-1;
        int ans=0;
        
        while(low<=high){
            int mid=low+(high-low)/2;

            if(ll.get(mid) >= tar){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}