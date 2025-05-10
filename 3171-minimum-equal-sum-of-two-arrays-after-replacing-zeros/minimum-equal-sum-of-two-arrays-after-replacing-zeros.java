class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        int zero_count1=0;
        int zero_count2=0;
        long sum=0;
        long sum1=0;
        for(int i=0;i<nums1.length;i++){
            if(nums1[i]==0){
                zero_count1++;
                sum+=1;
            }
            sum+=nums1[i];
        }
        for(int i=0;i<nums2.length;i++){
            if(nums2[i]==0){
                zero_count2++;
                sum1+=1;
            }
            sum1+=nums2[i];
        }
        if(sum<sum1 && zero_count1==0){
             return -1;
        }
        if(sum1<sum && zero_count2==0){
            return -1;
        }
        return Math.max(sum1,sum);

    }
}