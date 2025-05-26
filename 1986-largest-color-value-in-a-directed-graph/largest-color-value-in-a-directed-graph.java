class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        // build graph
        int n = colors.length();
        List<List<Integer>> adj = new ArrayList<>();
        int []inDegree = new int[n];
        makeGraph(n,edges,adj,inDegree);

        // apply khans algo with keep tracking of colors
        Queue<Integer> q = new LinkedList<>();
        int [][]dp = new int[n][26];
        for(int i=0;i<n;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
            dp[i][colors.charAt(i)-'a']++;
        }

        int nodeCount = 0;
        int maxColor = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            nodeCount++;

            List<Integer> ll = adj.get(node);
            for(int i=0;i<ll.size();i++){
                int destNode = ll.get(i);
                int col = colors.charAt(destNode)-'a';
                for(int k=0;k<26;k++){
                    if(col==k){
                        dp[destNode][k] = Math.max(dp[destNode][k],dp[node][k]+1);
                    }else{
                        dp[destNode][k] = Math.max(dp[destNode][k],dp[node][k]);
                    }
                }
                inDegree[destNode]--;
                if(inDegree[destNode]==0){
                    q.add(destNode);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<26;j++){
                maxColor = Math.max(maxColor,dp[i][j]);
            }
        }
        return nodeCount==n?maxColor:-1;
    }
    public void makeGraph(int n,int [][]edges,List<List<Integer>> adj,int []inDegree){
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            inDegree[v]++;
        }
    }
}