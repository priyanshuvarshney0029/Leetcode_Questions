/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var sortColors = function(nums) {
    var left=0;
    for(var i=0;i<nums.length;i++){
        if(nums[i]==0){
            var temp=nums[i];
            nums[i]=nums[left];
            nums[left]=temp;
            left++;
        }
    }
    var right=left;
    for(var i=0;i<nums.length;i++){
        if(nums[i]==1){
        var temp=nums[i];
        nums[i]=nums[right];
        nums[right]=temp;
        right++;
    }
    }

};