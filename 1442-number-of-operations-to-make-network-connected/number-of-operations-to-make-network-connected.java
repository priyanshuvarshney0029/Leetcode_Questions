class Solution {
    public int makeConnected(int n, int[][] connections) {
         if (connections.length < n - 1) return -1; // not enough cables
        Dsu obj=new Dsu(n);
        for(int edge[]:connections){
            obj.union(edge[0],edge[1]);
        }
        // int count=0;
         int components = 0;
        for (int i = 0; i < n; i++) {
            if (obj.find(i) == i) components++;
        }

        // return components - 1;
      return components - 1;
}
class Dsu{
    int parent[];
    int rank[];

    public Dsu(int n){
        parent=new int[n];
        rank=new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }
    public int find(int nn){
        if(parent[nn]==nn){
            return nn;
        }
        return parent[nn]=find(parent[nn]);
    }
    public void union(int vtx1,int vtx2){
       int parent1=find(vtx1);
       int parent2=find(vtx2);


       if(parent1==parent2){
           return;
       }
       if(rank[parent1] < rank[parent2]){
          parent[parent1]=parent2;
       }
       else if(rank[parent2] < rank[parent1]){
           parent[parent2]=parent1;
       }
       else{
           parent[parent2]=parent1;
           rank[parent1]++;
       }
    }

}
}