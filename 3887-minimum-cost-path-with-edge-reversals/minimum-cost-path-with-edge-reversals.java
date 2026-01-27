class Solution {
    public int minCost(int n, int[][] edges) {
        // make adjacency list
        List<List<int []>> adj = new ArrayList<>();
        makeGraph(n,edges,adj);

        // apply dijkstras algo.
        int []dis = new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        // (node,dis)
        pq.add(new int[]{0,0});
        dis[0] = 0;

        while(!pq.isEmpty()){
            int node = pq.peek()[0];
            int w = pq.peek()[1];
            pq.poll();

            List<int []> ll = adj.get(node);
            for(int i=0;i<ll.size();i++){
                if(w+ll.get(i)[1]<dis[ll.get(i)[0]]){
                    dis[ll.get(i)[0]] = w + ll.get(i)[1];
                    pq.add(new int[]{ll.get(i)[0], w + ll.get(i)[1]});
                }
            }
        }
        return dis[n-1]==Integer.MAX_VALUE?-1:dis[n-1];
    }
    public void makeGraph(int n,int [][]edges,List<List<int []>> adj){
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<int []>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,2*w});
        }
    }
}