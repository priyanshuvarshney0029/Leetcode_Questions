class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int diff = Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++){
            diff = Math.min(diff,arr[i]-arr[i-1]);
        }
        for(int i=1;i<arr.length;i++){
            List<Integer> temp = new ArrayList<>();
            if(arr[i]-arr[i-1]==diff){
                temp.add(arr[i-1]);
                temp.add(arr[i]);
                ans.add(temp);
            }
        }
        return ans;
    }
}