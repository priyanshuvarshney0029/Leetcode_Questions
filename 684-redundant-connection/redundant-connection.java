class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int arr[]=new int[2];
        Dsu obj=new Dsu(n);
        for(int edge[]:edges){
            if(obj.find(edge[0]) == obj.find(edge[1])){
                arr[0]=edge[0];
                arr[1]=edge[1];
            }
            else{
                obj.Union(edge[0],edge[1]);
            }
        }
        return arr;
    }
}
class Dsu{
    int parent[];
    int rank[];

    public Dsu(int n){
        parent=new int[n+1];
        rank=new int[n+1];
        for(int i=1;i<=n;i++){
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
        else if(rank[parent1] > rank[parent2]){
            parent[parent2]=parent1;
        }
        else{
             parent[parent2]=parent1;
             rank[parent1]++;
        }
    }
}