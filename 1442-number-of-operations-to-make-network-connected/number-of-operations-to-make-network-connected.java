class Solution {
    public int makeConnected(int n, int[][] connections) {
        Dsu obj=new Dsu(n);
        int count_component=n;
        if(connections.length < n-1){
            return -1;
        }
        for(int arr[]:connections){
            int u=arr[0];
            int v=arr[1];

            if(obj.find(u)!=obj.find(v)){
                 obj.Union(u,v);
                 count_component--;
            }
            
        }
        return count_component-1;

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
        public void Union(int vtx1,int vtx2){
              int parent1=find(vtx1);
              int parent2=find(vtx2);

              if(parent1==parent2){
                return; // connection alreasy built
              }
              if(rank[parent1] < rank[parent2]){
                 parent[parent1]=parent2;
              }
              else if(rank[parent1] > rank[parent2]){
                parent[parent2]=parent1;
              }
              else{
                parent[parent1]=parent2;
                rank[parent2]++;
              }
        }
    }
}