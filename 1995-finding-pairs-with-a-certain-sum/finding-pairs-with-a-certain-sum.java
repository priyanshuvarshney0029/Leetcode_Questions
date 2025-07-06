class FindSumPairs {
    HashMap<Integer,Integer> map;
    int []nums1;
    int []nums2;

    public FindSumPairs(int[] nums1, int[] nums2) {    
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.map = new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],map.getOrDefault(nums2[i],0)+1);
        }
    }
    
    public void add(int index, int val) {
        int value = nums2[index];
        map.put(value,map.get(value)-1);
        if(map.get(value)==0){
            map.remove(value);
        }
        map.put(value+val,map.getOrDefault(value+val,0)+1);
        nums2[index]+=val;
    }
    
    public int count(int tot) {
        int cnt = 0;
        for(int i=0;i<nums1.length;i++){
            int rem = tot-nums1[i];
            cnt+=map.getOrDefault(rem,0);
        }
        return cnt;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */