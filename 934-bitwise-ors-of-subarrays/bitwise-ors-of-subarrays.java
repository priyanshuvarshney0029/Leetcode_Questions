class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        HashSet<Integer> ans = new HashSet<>();
        HashSet<Integer> curr = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            HashSet<Integer> temp = new HashSet<>();
            temp.add(arr[i]);
            for(int j:curr){
                temp.add(j|arr[i]);
            }
            curr = temp;
            for(int j:temp){
                ans.add(j);
            }
        }
        return ans.size();
    }
}