class Solution {
    public int maxEnvelopes(int[][] arr) {
        Arrays.sort(arr,(a,b)-> a[0]==b[0] ? b[1]-a[1] : a[0]-b[0]);
        ArrayList<Integer> ll=new ArrayList<>();
        // apply lis on heights
        ll.add(arr[0][1]);
        for(int i=1;i<arr.length;i++){
            if(arr[i][1] > ll.get(ll.size()-1)){
                ll.add(arr[i][1]);
            }
            else{
                int cp=bs(ll,arr[i][1]);
                ll.set(cp,arr[i][1]);
            }
        }
        return ll.size();
    }
    public static int bs(ArrayList<Integer> ll,int target){
        int ans=0;
        int low=0;
        int high=ll.size()-1;
        while(low <= high){
            int mid=low+(high-low)/2;
            if(ll.get(mid) >= target){
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