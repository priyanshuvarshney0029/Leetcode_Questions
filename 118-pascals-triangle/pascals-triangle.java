class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>(){{add(1);}});
        if(numRows==1){
            return ans;
        }
        ans.add(new ArrayList<>(){{add(1);add(1);}});
        for(int i=2;i<numRows;i++){
            List<Integer> ll = new ArrayList<>();
            ll.add(1);
            for(int j=1;j<ans.get(i-1).size();j++){
                ll.add(ans.get(i-1).get(j)+ans.get(i-1).get(j-1));
            }
            ll.add(1);
            ans.add(ll);
        }
        return ans;
    }
}