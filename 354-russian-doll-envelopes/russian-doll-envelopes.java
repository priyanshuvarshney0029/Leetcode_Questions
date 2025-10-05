class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // first sort the width..
        // lambda function...
        // if width equal sort them on the basis of hegiht in des order // otherwise simple sort width..
        Arrays.sort(envelopes,(a,b) -> a[0]==b[0] ? b[1]-a[1] : a[0]-b[0]);
        ArrayList<Integer> ll=new ArrayList<>();
        // applying lis on height.....
        ll.add(envelopes[0][1]);
        for(int i=1;i<envelopes.length;i++){
            if(envelopes[i][1] > ll.get(ll.size()-1)){
                ll.add(envelopes[i][1]);
            }
            else{
                int cp=binarysearch(ll,envelopes[i][1]);
                ll.set(cp,envelopes[i][1]);

            }
    }
     return ll.size();
}
    public int binarysearch(ArrayList<Integer> ll,int target){
        int ans=0;
        int lo=0;
        int high=ll.size()-1;

        while(lo<=high){
            int mid=lo+(high-lo)/2;
            if(ll.get(mid)>=target){
                ans=mid;
                high=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return ans;
    }
        
}