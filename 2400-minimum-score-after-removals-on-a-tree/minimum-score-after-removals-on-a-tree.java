class Solution {
    public int minimumScore(int[] nums, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        makeGraph(nums.length,edges,adj);

        int []xorArr = new int[nums.length];
        int []inTime = new int[nums.length];
        int []outTime = new int[nums.length];
        int []timer = new int[1];
        findXor(adj,nums,xorArr,0,-1,inTime,outTime,timer);

        int ans = Integer.MAX_VALUE;
        for(int i=1;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int xor1,xor2,xor3;
                if(isAncestor(i,j,inTime,outTime)){
                    xor1 = xorArr[j];
                    xor2 = xorArr[i]^xor1;
                    xor3 = xorArr[0]^xor1^xor2;
                }else if(isAncestor(j,i,inTime,outTime)){
                    xor1 = xorArr[i];
                    xor2 = xorArr[j]^xor1;
                    xor3 = xorArr[0]^xor1^xor2;
                }else{
                    xor1 = xorArr[i];
                    xor2 = xorArr[j];
                    xor3 = xorArr[0]^xor1^xor2;
                }
                int temp = Math.max(xor1,Math.max(xor2,xor3))-Math.min(xor1,Math.min(xor2,xor3));
                ans = Math.min(temp,ans);
            }
        }
        return ans;
    }
    public boolean isAncestor(int u,int v,int []inTime,int []outTime){
        return inTime[v]>inTime[u] && outTime[v]<outTime[u];
    }
    public void findXor(List<List<Integer>> adj,int []nums,int []xorArr,int node,int par,int []inTime,int []outTime,int []timer){
        xorArr[node] = nums[node];
        inTime[node] = timer[0];
        timer[0]++;
        List<Integer> ll = adj.get(node);
        for(int i=0;i<ll.size();i++){
            if(ll.get(i)!=par){
                findXor(adj,nums,xorArr,ll.get(i),node,inTime,outTime,timer);
                xorArr[node]^=xorArr[ll.get(i)];
            }
        }
        outTime[node] = timer[0];
        timer[0]++;
    }
    public void makeGraph(int n,int [][]edges,List<List<Integer>> adj){
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    }
}