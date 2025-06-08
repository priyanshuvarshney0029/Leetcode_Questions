class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ll=new ArrayList<>();
        Printcounting(0,n,ll);
        return ll;
    }
    public static void Printcounting(int curr,int n,List<Integer>ll){
        if(curr>n){
            return;
        }
        if(curr!=0){
            ll.add(curr);
        }
        int i=0;
        if(curr==0){
            i=1;
        }
        for(;i<=9;i++){
            Printcounting(curr*10+i,n,ll);
        }
    }
}