class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b) -> a[0]==b[0] ? b[1]-a[1] : a[0]-b[0]);
        ArrayList<Integer> ll=new ArrayList<>();
        ll.add(envelopes[0][1]);

        for(int i=1;i<envelopes.length;i++){
            if(envelopes[i][1] > ll.get(ll.size()-1)){
                ll.add(envelopes[i][1]);
            }
            else{
                int cp=bs(ll,envelopes[i][1]);
                ll.set(cp,envelopes[i][1]);
            }
        }
        return ll.size();
    }
    public static int bs(ArrayList<Integer> ll,int target){
        int ans=ll.size();
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