class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // in dsu we make two array one is of parent 
        // 2nd is of rank//
        // initially every element is a parent of itself..
        Dsu obj=new Dsu(n);
        for(int edge[]:edges){
            obj.Union(edge[0],edge[1]);
        }
        if(obj.find(source)==obj.find(destination)){
            return true;
        }
        return false;
    }
    
}
class Dsu{
    int parent[];
    int rank[];

    public Dsu(int n){
        rank=new int[n];
        parent=new int[n];

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
    public void Union(int vtx1 ,int vtx2){
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